package event;

public class LoginEvent implements Event {
    private String userId;

    public LoginEvent(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    @Override
    public String getEventName() {
        return "Login";
    }
}