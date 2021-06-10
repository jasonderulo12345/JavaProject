package event;

public class LogoutEvent implements Event {
    @Override
    public String getEventName() {
        return "Logout";
    }
}