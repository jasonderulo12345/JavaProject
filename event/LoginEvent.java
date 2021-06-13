package event;

public class LoginEvent implements Event {
    private String userId;
    private String fullname;

    public LoginEvent(String userId, String fullname) {
        this.userId = userId;
        this.fullname = fullname;
    }

    public String getUserId() {
        return userId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    @Override
    public String getEventName() {
        return "Login";
    }
}