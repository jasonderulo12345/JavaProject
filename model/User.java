package model;

public class User implements Comparable<User> {
    private String userId;
    private String password;
    private String fullname;

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }

    @Override
    public int compareTo(User user) {
        return userId.compareTo(user.getUserId());
    }
}