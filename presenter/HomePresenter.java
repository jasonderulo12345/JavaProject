package presenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import event.*;
import event.ViewMealEnterEvent.Mode;
import model.*;
import model.Meal.*;
import view.HomeViewListener;
import view.FilterDialog;
import view.HomeView;

// Setiap presenter mesti ada view dgn repository aka model
public class HomePresenter implements Subscriber, HomeViewListener {
    private String currentUserId;
    private EventBus eventBus;
    private HomeView homeView;
    private MealRepository mealRepository;

    public HomePresenter(MealRepository mealRepository, EventBus eventBus) {
        this.currentUserId = ""; // No user logged in
        this.mealRepository = mealRepository;
        this.eventBus = eventBus;
        this.eventBus.register(this);

        // Create view
        // homeView = new HomeView();
        // homeView.addListener(this);
    }

    @Override
    public void onAddMealPressed() {
        eventBus.dispatch(new ViewMealEnterEvent(Mode.ADD, -1, currentUserId));
    }

    @Override
    public void onEditMealPressed() {
        int selectedRow = homeView.mealTable.getSelectedRow();

        // No row selected
        if (selectedRow < 0) {
            System.out.println("No row selected");
            return;
        }

        String selectedMealIdString = (String)homeView.mealTable.getModel().getValueAt(selectedRow, 0);
        int selectedMealId = Integer.parseInt(selectedMealIdString);

        eventBus.dispatch(new ViewMealEnterEvent(Mode.EDIT, selectedMealId, currentUserId));
    }

    @Override
    public void onViewMealPressed() {
        int selectedRow = homeView.mealTable.getSelectedRow();

        // No row selected
        if (selectedRow < 0) {
            System.out.println("No row selected");
            return;
        }

        String selectedMealIdString = (String)homeView.mealTable.getModel().getValueAt(selectedRow, 0);
        int selectedMealId = Integer.parseInt(selectedMealIdString);

        eventBus.dispatch(new ViewMealEnterEvent(Mode.VIEW, selectedMealId, currentUserId));
    }

    @Override
    public void onDeleteMealPressed() {
        int selectedRow = homeView.mealTable.getSelectedRow();

        // No row selected
        if (selectedRow < 0) {
            System.out.println("No row selected");
            return;
        }

        // Ask for confirmation
        int dialogResult = JOptionPane.showConfirmDialog(
            homeView, 
            "Confirm to Delete This Meal Record?", 
            "Warning", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (dialogResult == JOptionPane.NO_OPTION) {
            return;
        }

        String selectedMealIdString = (String)homeView.mealTable.getModel().getValueAt(selectedRow, 0);
        int selectedMealId = Integer.parseInt(selectedMealIdString);

        // Delete meal
        mealRepository.delete(selectedMealId);
        displayMeals(mealRepository.getAllByUserId(currentUserId));
    }

    @Override
    public void onFilterClicked() {
        FilterDialog filterDialog = homeView.filterDialog;

        Meal filterCriteria = new Meal();
        filterCriteria.setUserId(currentUserId);
        filterCriteria.setName(filterDialog.name.getText());

        Object filterDateObject = filterDialog.date.getModel().getValue();
        filterCriteria.setDate(""); // Default to empty date
        if (filterDateObject != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            filterCriteria.setDate(simpleDateFormat.format(filterDialog.date.getModel().getValue()));
        }

        // If the category is NONE then ignore
        if (!filterDialog.dayComboBox.getSelectedItem().toString().equals("NONE")) {
            filterCriteria.setDay(Day.valueOf(filterDialog.dayComboBox.getSelectedItem().toString()));
        }
        if (!filterDialog.foodgroupComboBox.getSelectedItem().toString().equals("NONE")) {
            filterCriteria.setFoodGroup(FoodGroup.valueOf(filterDialog.foodgroupComboBox.getSelectedItem().toString()));
        }
        filterCriteria.setDrink(filterDialog.drink.getText());

        filterDialog.dispose();
        List<Meal> filteredMeals = mealRepository.getByFilter(filterCriteria);

        // If nothing was filtered
        if (
            (mealRepository.getAllByUserId(currentUserId).size() == filteredMeals.size() && filteredMeals.size() > 0) || 
            filteredMeals.isEmpty()
        ) {
            JOptionPane.showMessageDialog(homeView, "Nothing was filtered!", "Information", JOptionPane.INFORMATION_MESSAGE);
            displayMeals(mealRepository.getAllByUserId(currentUserId));
            return;
        }

        homeView.filterIndicator.setText("Filtered results");
        displayMeals(filteredMeals);
    }

    @Override
    public void onClearClicked() {
        homeView.filterIndicator.setText("");
        displayMeals(mealRepository.getAllByUserId(currentUserId));
    }

    @Override
    public void onLogoutButtonPressed() {
        eventBus.dispatch(new LogoutEvent());
        homeView.dispose();
    }

    @Override
    public void handleEvent(Event event) {
        switch (event.getEventName()) {
            case "Login": handleLoginEvent((LoginEvent)event); break;
            case "Leave Meal View": handleViewMealLeaveEvent((ViewMealLeaveEvent)event); break;
        }
    }

    private void handleLoginEvent(LoginEvent loginEvent) {
        currentUserId = loginEvent.getUserId();
        System.out.println("Logging in with user id: " + currentUserId);

        homeView = new HomeView();
        homeView.addListener(this);
        homeView.initUI();
        homeView.title.setText("Welcome, " + loginEvent.getFullname());
        displayMeals(mealRepository.getAllByUserId(currentUserId));
    }

    public void handleViewMealLeaveEvent(ViewMealLeaveEvent viewMealLeaveEvent) {
        displayMeals(mealRepository.getAllByUserId(currentUserId));
    }

    // NOTE: !!!
    // mealId will not be displayed in the view
    // it is strictly for identifying which row is for which meal
    public void displayMeals(List<Meal> meals) {
        // Sort meals by date
        Collections.sort(meals, new SortByDate());

        String tableHeader[] = { "mealId", "Date", "Day", "Food Group", "Name", "Drink" };
        List<List<String>> tableData = new ArrayList<>();

        // Insert data to table
        for (int i = 0; i < meals.size(); i++) {
            tableData.add(new ArrayList<>());
            tableData.get(i).add(Integer.toString(meals.get(i).getMealId()));
            tableData.get(i).add(meals.get(i).getDate());
            tableData.get(i).add(meals.get(i).getDay().toString());
            tableData.get(i).add(meals.get(i).getFoodGroup().toString());
            tableData.get(i).add(meals.get(i).getName());
            tableData.get(i).add(meals.get(i).getDrink());
        }

        // Convert list to normal 2d array
        String[][] tableDataArray = new String[tableData.size()][tableHeader.length];
        for (int i = 0; i < tableData.size(); i++) {
            List<String> row = tableData.get(i);
            tableDataArray[i] = row.toArray(new String[tableHeader.length]);
        }

        homeView.mealTable.setModel(
            new DefaultTableModel(tableDataArray, tableHeader) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Don't make cell editable
                }
            }
        );

        // Hide the id
        homeView.mealTable.removeColumn(homeView.mealTable.getColumnModel().getColumn(0));
    }
}