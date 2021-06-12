package presenter;

import event.*;
import event.ViewMealEnterEvent.Mode;
import model.Repository;
import model.Meal.Day;
import model.Meal.FoodGroup;
import model.Meal;
import view.MealView;
import view.MealViewListener;

public class MealPresenter implements Subscriber, MealViewListener {
    private int currentMealId;

    private Repository<Integer, Meal> mealRepository;
    private MealView mealView;
    private EventBus eventBus;

    public MealPresenter(Repository<Integer, Meal> mealRepository, EventBus eventBus) {
        this.currentMealId = -1; // Assuming ADD mode
        this.mealRepository = mealRepository;

        this.eventBus = eventBus;
        this.eventBus.register(this);
    }

    @Override
    public void onSaveButtonPressed() {
        Meal meal = new Meal();
        meal.setMealId(currentMealId);
        meal.setName(mealView.name.getText());
        meal.setFoodGroup(FoodGroup.valueOf(mealView.foodGroup.getText()));
        meal.setImagePath(""); // Hmm macam mana ni
        meal.setDate(mealView.date.getText());
        meal.setDay(Day.valueOf(mealView.day.getText()));
        meal.setDrink(mealView.drink.getText());

        if (currentMealId > 0) {
            mealRepository.update(meal);
        }
        else {
            mealRepository.add(meal);
        }

        eventBus.dispatch(new ViewMealLeaveEvent());
        mealView.dispose();
    }

    @Override
    public void onDeleteButtonPressed() {
        if (currentMealId > 0) {
            mealRepository.delete(currentMealId);
        }

        eventBus.dispatch(new ViewMealLeaveEvent());
        mealView.dispose();
    }

    @Override
    public void onCancelButtonPressed() {
        eventBus.dispatch(new ViewMealLeaveEvent());
        mealView.dispose();
    }

    @Override
    public void handleEvent(Event event) {
        switch (event.getEventName()) {
            case "Enter Meal View": handleViewMealEnterEvent((ViewMealEnterEvent)event); break;
        }
    }

    public void handleViewMealEnterEvent(ViewMealEnterEvent viewMealEnterEvent) {
        mealView = new MealView();
        mealView.addListener(this);
        mealView.initUI();
        mealView.setAlwaysOnTop(true);

        if (viewMealEnterEvent.getMode() == Mode.ADD) {
            currentMealId = -1;
            return;
        }

        // Assign meal id
        currentMealId = viewMealEnterEvent.getMealId();

        Meal meal = mealRepository.getById(currentMealId);
        mealView.date.setText(meal.getDate());
        mealView.day.setText(meal.getDay().toString()); // Drop down?
        mealView.drink.setText(meal.getDrink());
        mealView.foodGroup.setText(meal.getFoodGroup().toString());
        mealView.name.setText(meal.getName());
        
        if (viewMealEnterEvent.getMode() == Mode.VIEW) {
            // Disable text fields
            mealView.date.setEditable(false);
            mealView.day.setEditable(false);
            mealView.drink.setEditable(false);
            mealView.foodGroup.setEditable(false);
            mealView.name.setEditable(false);

            // Disable buttons
            mealView.name.setEnabled(false);
            mealView.save.setEnabled(false);
        }
    }
}