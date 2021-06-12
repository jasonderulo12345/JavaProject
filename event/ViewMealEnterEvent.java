package event;

public class ViewMealEnterEvent implements Event {

    public enum Mode {
        ADD,
        EDIT,
        VIEW
    }

    private Mode mode;
    private int mealId;
    private String userId;

    public ViewMealEnterEvent(Mode mode, int mealId, String userId) {
        this.mode = mode;
        this.mealId = mealId;
        this.userId = userId;
    }

    public Mode getMode() {
        return mode;
    }

    public int getMealId() {
        return mealId;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String getEventName() {
        return "Enter Meal View";
    }
    
}
