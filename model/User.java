package model;

// saya tukar username ke userId jadi consistent sikit 🐱
public class User {
    private String userId;
    private String password;
    private String fullname;

    public String getUsername() { return userId; }
    public void setUsername(String userId) { this.userId = userId; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }
}