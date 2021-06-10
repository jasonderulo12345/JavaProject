package model;

// saya tukar username ke userId jadi consistent sikit 🐱
public class User {
    private String userId;
    private String password;
    private String fullname;
    private int age;

    public void setUsername(String userId) { this.userId = userId; }
    public void setPassword(String password) { this.password = password; }
    public void setFullname(String fullname) { this.fullname = fullname; }
    public void setAge(int age) { this.age = age; }
    public String getUsername() { return userId; }
    public String getPassword() { return password; }
    public String getFullname() { return fullname; }
    public int getAge() { return age; }
}