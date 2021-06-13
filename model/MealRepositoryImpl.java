package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import model.Meal.Day;
import model.Meal.FoodGroup;

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
    public Meal getById(Integer mealId) {
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
    public void delete(Integer mealId) {
        List<Meal> meals = readAllMeal();
        meals.removeIf(e -> { return e.getMealId() == mealId; });
        writeAllMeal(meals);
    }

    @Override
    public List<Meal> getAllByUserId(String userId) {
        List<Meal> meals = readAllMeal();
        List<Meal> filteredMeals = new ArrayList<>();

        for (Meal meal : meals) {
            if (meal.getUserId().equals(userId)) {
                filteredMeals.add(meal);
            }
        }

        return filteredMeals;
    }

    @Override
    public List<Meal> getByFilter(Meal filterMeal) {
        List<Meal> filteredMeals = readAllMeal();

        // Filter one by one with criteria given in argument
        // Need to do null checking
        filteredMeals.removeIf(e -> !e.getUserId().equals(filterMeal.getUserId()));

        if (!filterMeal.getName().isBlank() && !filterMeal.getName().isEmpty()) {
            filteredMeals.removeIf(e -> !e.getName().equalsIgnoreCase(filterMeal.getName()));
        }
        if (filterMeal.getFoodGroup() != null) {
            filteredMeals.removeIf(e -> e.getFoodGroup() != filterMeal.getFoodGroup());
        }
        if (!filterMeal.getDate().isBlank() && !filterMeal.getDate().isEmpty()) {
            filteredMeals.removeIf(e -> !e.getDate().equalsIgnoreCase(filterMeal.getDate()));
        }
        if (filterMeal.getDay() != null) {
            filteredMeals.removeIf(e -> e.getDay() != filterMeal.getDay());
        }
        if (!filterMeal.getDrink().isBlank() && !filterMeal.getDrink().isEmpty()) {
            filteredMeals.removeIf(e -> !e.getDrink().equalsIgnoreCase(filterMeal.getDrink()));
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

        // For aesthetic purposes, show most recent
        Collections.sort(meals);
        Collections.reverse(meals);
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
        try (FileWriter fileWriter = new FileWriter(databasePath, false)) {
            fileWriter.write(stringBuilder.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(0); // Immediately shutdown
        }
    }
}