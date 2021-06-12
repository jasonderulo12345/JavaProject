package event;

public class ViewMealLeaveEvent implements Event {

    @Override
    public String getEventName() {
        return "Leave Meal View";
    }
    
}
