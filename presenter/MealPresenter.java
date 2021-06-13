package presenter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.ImageIcon;

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
    private String currentUserId;
    private Repository<Integer, Meal> mealRepository;
    private MealView mealView;
    private EventBus eventBus;

    public MealPresenter(Repository<Integer, Meal> mealRepository, EventBus eventBus) {
        this.currentMealId = -1; // Assuming ADD mode
        this.currentUserId = "";
        this.mealRepository = mealRepository;

        this.eventBus = eventBus;
        this.eventBus.register(this);
    }

    @Override
    public void onSaveButtonPressed() {
        Meal meal = new Meal();
        meal.setUserId(currentUserId);
        meal.setMealId(currentMealId);
        meal.setName(mealView.name.getText());
        meal.setFoodGroup(FoodGroup.valueOf(mealView.foodGroup.getSelectedItem().toString()));
        meal.setDate(mealView.date.getText());
        meal.setDay(Day.valueOf(mealView.day.getSelectedItem().toString()));
        meal.setDrink(mealView.drink.getText());

        // Save the image and copy into database
        // Ideally this is implemented inside repository
        try {
            String imageSourcePath = mealView.image.getIcon().toString().replaceFirst("file:/", "");
            String imageDestPath = "./database/image/" + currentUserId + "_" + meal.getName() + "." + getFileExtensionFromPath(imageSourcePath);
            File imageSourceFile = new File(imageSourcePath);
            File imageDestFile = new File(imageDestPath);
            imageDestFile.createNewFile(); // Create new file if doesn't exists
            copyFile(imageSourceFile, imageDestFile);
            meal.setImagePath(imageDestPath);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

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

        currentUserId = viewMealEnterEvent.getUserId();

        if (viewMealEnterEvent.getMode() == Mode.ADD) {
            currentMealId = -1;
            mealView.delete.setEnabled(false);
            return;
        }

        // Assign meal id
        currentMealId = viewMealEnterEvent.getMealId();

        Meal meal = mealRepository.getById(currentMealId);
        mealView.title.setText(meal.getName() + " and " + meal.getDrink());
        mealView.image.setIcon(new ImageIcon(meal.getImagePath()));
        mealView.date.setText(meal.getDate());
        mealView.day.setSelectedItem(meal.getDay().toString());
        mealView.drink.setText(meal.getDrink());
        mealView.foodGroup.setSelectedItem(meal.getFoodGroup().toString());
        mealView.name.setText(meal.getName());
        
        if (viewMealEnterEvent.getMode() == Mode.VIEW) {
            // Disable text fields
            mealView.date.setEditable(false);
            mealView.day.setEditable(false);
            mealView.drink.setEditable(false);
            mealView.foodGroup.setEditable(false);
            mealView.name.setEditable(false);

            // Disable buttons
            mealView.delete.setEnabled(false);
            mealView.save.setEnabled(false);
        }
    }

    private void copyFile(File src, File dest) {
        try (
            InputStream inputStream = new FileInputStream(src);
            OutputStream outputStream = new FileOutputStream(dest);
        ) {
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private String getFileExtensionFromPath(String path) {
        String extension = "";

        int i = path.lastIndexOf('.');
        if (i > 0) {
            extension =  path.substring(i + 1);
        }
        return extension;
    }
}