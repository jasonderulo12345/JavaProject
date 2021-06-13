package model;

import java.lang.Comparable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Meal implements Comparable<Meal> {
    public enum Day {
        BREAKFAST,
        LUNCH,
        DINNER
    }

    public enum FoodGroup {
        FRUIT,
        VEGETABLE,
        GRAIN,
        PROTEIN,
        DAIRY
    }

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

    public static class SortByDate implements Comparator<Meal> {
        @Override
        public int compare(Meal meal1, Meal meal2) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            Date date1 = new Date();
            Date date2 = new Date();
            try {
                date1 = simpleDateFormat.parse(meal1.getDate());
                date2 = simpleDateFormat.parse(meal2.getDate());
            }
            catch (ParseException e) {
                e.printStackTrace();
                System.exit(0);
            }

            return date1.compareTo(date2);
        }
    }
}
