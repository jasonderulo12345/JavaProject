package model;

import java.util.List;

// Saya nak commit war crime
public interface MealRepository extends Repository<Integer, Meal> {
    List<Meal> getAllByUserId(String userId);
    List<Meal> getByDay(String userId, Day day);
    List<Meal> getByName(String userId, String name);
    List<Meal> getByDayAndName(String UserId, Day day, String name);
}