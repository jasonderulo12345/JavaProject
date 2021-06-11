package model;

import java.util.List;

public interface MealRepository extends Repository<Integer, Meal> {
    List<Meal> getAllByUserId(String userId);
    List<Meal> getByFilter(Meal filterMeal);
}