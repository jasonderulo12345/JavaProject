package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MealRepositoryImpl implements MealRepository {
    private String databasePath;

    public MealRepositoryImpl(String databasePath) {
        this.databasePath = databasePath;
    }

    @Override
    public List<Meal> getAll() {
        return readAllMeal();
    }

    @Override
    public Meal getById(int mealId) {
        List<Meal> meals = readAllMeal();
        for (Meal meal : meals) {
            if (meal.getMealId() == mealId) {
                return meal;
            }
        }
        
        return null;
    }

    @Override
    public void add(Meal meal) {
        List<Meal> meals = readAllMeal();

        // Autoincrement the id 
        int maxMealId = 0;

        if (meals.isEmpty() == false) {
            Meal maxIdMeal = Collections.max(meals);
            maxMealId = maxIdMeal.getMealId() + 1;
        }
        
        meal.setMealId(maxMealId);
        meals.add(meal);
        writeAllMeal(meals);
    }

    @Override
    public void update(Meal meal) {
        List<Meal> meals = readAllMeal();
        
        meals.removeIf(e -> { return e.getMealId() == meal.getMealId(); });
        meals.add(meal);
        writeAllMeal(meals);
    }

    @Override
    public void delete(int mealId) {
        List<Meal> meals = readAllMeal();
        meals.removeIf(e -> { return e.getMealId() == mealId; });
        writeAllMeal(meals);
    }

    @Override
    public List<Meal> getAllByUserId(String userId) {
        List<Meal> meals = readAllMeal();
        List<Meal> filteredMeals = new ArrayList<>();

        for (Meal meal : meals) {
            if (meal.getUserId() == userId) {
                filteredMeals.add(meal);
            }
        }

        return filteredMeals;
    }

    @Override
    public List<Meal> getByDay(String userId, Day day) {
        List<Meal> userMeals = getAllByUserId(userId);
        List<Meal> filteredMeals = new ArrayList<>();

        for (Meal meal : userMeals) {
            if (meal.getDay() == day) {
                filteredMeals.add(meal);
            }
        }

        return filteredMeals;
    }

    @Override
    public List<Meal> getByName(String userId, String name) {
        List<Meal> userMeals = getAllByUserId(userId);
        List<Meal> filteredMeals = new ArrayList<>();

        for (Meal meal : userMeals) {
            if (meal.getName().equalsIgnoreCase(name)) {
                filteredMeals.add(meal);
            }
        }

        return filteredMeals;
    }

    @Override
    public List<Meal> getByDayAndName(String userId, Day day, String name) {
        List<Meal> userMeals = getAllByUserId(userId);
        List<Meal> filteredMeals = new ArrayList<>();

        for (Meal meal : userMeals) {
            if (meal.getDay() == day && meal.getName().equalsIgnoreCase(name)) {
                filteredMeals.add(meal);
            }
        }

        return filteredMeals;
    }

    private List<Meal> readAllMeal() {
        List<Meal> meals = new ArrayList<Meal>();

        // Read the meals in the databasePath
        try (Scanner sc = new Scanner(new File(databasePath))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                // Ignore empty line
                if (line.isEmpty() || line.trim().equals("") || line.trim().equals("\n")) {
                    continue;
                }

                String[] mealData = line.split(",");

                // Create new meal from the file
                Meal meal = new Meal();
                meal.setMealId(Integer.parseInt(mealData[0]));
                meal.setUserId(mealData[1]);
                meal.setImagePath(mealData[2]);
                meal.setName(mealData[3]);
                meal.setFoodGroup(FoodGroup.valueOf(mealData[4]));
                meal.setDate(mealData[5]);
                meal.setDay(Day.valueOf(mealData[6]));
                meal.setDrink(mealData[7]);

                meals.add(meal);
            }
        }
        catch (NumberFormatException | IOException e) {
            e.printStackTrace();
            System.exit(0); // Immediately shutdown
        }

        return meals;
    }

    private void writeAllMeal(List<Meal> meals) {        
        if (meals.isEmpty()) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (Meal meal : meals) {
            stringBuilder.append(Integer.toString(meal.getMealId()));
            stringBuilder.append(',');
            stringBuilder.append(meal.getUserId());
            stringBuilder.append(',');
            stringBuilder.append(meal.getImagePath());
            stringBuilder.append(',');
            stringBuilder.append(meal.getName());
            stringBuilder.append(',');
            stringBuilder.append(meal.getFoodGroup().toString());
            stringBuilder.append(',');
            stringBuilder.append(meal.getDate().toString());
            stringBuilder.append(',');
            stringBuilder.append(meal.getDay().toString());
            stringBuilder.append(',');
            stringBuilder.append(meal.getDrink());
            stringBuilder.append('\n');
        }

        // Don't append, complete overwrite instead
        // May cause performance issue tho but this is 
        // a small app so it's fine 😩
        try (FileWriter fileWriter = new FileWriter(databasePath, false)) {
            fileWriter.write(stringBuilder.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(0); // Immediately shutdown
        }
    }
}