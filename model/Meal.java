package model;

import java.lang.Comparable;

enum Day {
    BREAKFAST,
    LUNCH,
    DINNER
}

enum FoodGroup{
    FRUIT,
    VEGETABLE,
    GRAIN,
    PROTEIN,
    DAIRY
}

public class Meal implements Comparable<Meal> {
    private int mealId;
    private String userId;
    private String imagePath;
    private String name;
    private FoodGroup foodGroup;
    private String date;
    private Day day; 
    private String drink;
    
    public int getMealId() { return mealId; }
    public void setMealId(int mealId) { this.mealId = mealId; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath){ this.imagePath = imagePath; }
    public String getName(){ return name; }
    public void setName(String name) { this.name = name; }
    public FoodGroup getFoodGroup() { return foodGroup; }
    public void setFoodGroup(FoodGroup foodGroup) { this.foodGroup = foodGroup; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public Day getDay(){ return day; }
    public void setDay(Day day){ this.day = day; }
    public String getDrink(){ return drink; }
    public void setDrink(String drink){ this.drink = drink; }

    // Sort based on mealId
    @Override
    public int compareTo(Meal meal) {
        if (mealId == meal.mealId) {
            return 0;
        }
        else if (mealId > meal.mealId) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
