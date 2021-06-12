package event;

public class ViewMealEnterEvent implements Event {

    public enum Mode {
        ADD,
        EDIT,
        VIEW
    }

    private Mode mode;

    public ViewMealEnterEvent(Mode mode) {
        this.mode = mode;
    }

    public Mode getMode() {
        return mode;
    }

    @Override
    public String getEventName() {
        return "Enter Meal View";
    }
    
}
