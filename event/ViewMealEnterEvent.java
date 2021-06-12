package event;

public class ViewMealEnterEvent implements Event {

    public enum Mode {
        ADD,
        EDIT,
        VIEW
    }

    private Mode mode;
    private int mealId;

    public ViewMealEnterEvent(Mode mode, int mealId) {
        this.mode = mode;
        this.mealId = mealId;   
    }

    public Mode getMode() {
        return mode;
    }

    public int getMealId() {
        return mealId;
    }

    @Override
    public String getEventName() {
        return "Enter Meal View";
    }
    
}
