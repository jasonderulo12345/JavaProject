package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UserRepositoryImpl implements Repository<String, User> {

    private String databasePath;

    public UserRepositoryImpl(String databasePath) {
        this.databasePath = databasePath;
    }

    @Override
    public List<User> getAll() {
        return readAllUser();
    }

    @Override
    public User getById(String userId) {
        List<User> users = readAllUser();
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        
        return null;
    }

    @Override
    public void add(User user) {
        List<User> users = readAllUser();

        Collections.sort(users);
        int index = Collections.binarySearch(users, user);

        // Ignore if user already exists
        // throw error?
        if (index >= 0) {
            return;
        }

        users.add(user);
        writeAllUser(users);
    }

    @Override
    public void update(User user) {
        List<User> users = readAllUser();
        
        users.removeIf(e -> { return e.getUserId().equals(user.getUserId()); });
        users.add(user);
        writeAllUser(users);
    }

    @Override
    public void delete(String userId) {
        List<User> users = readAllUser();
        users.removeIf(e -> { return e.getUserId().equals(userId); });
        writeAllUser(users);
    }

    private List<User> readAllUser() {
        List<User> users = new ArrayList<>();

        // Read the users in the databasePath
        try (Scanner sc = new Scanner(new File(databasePath))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                // Ignore empty line
                if (line.isEmpty() || line.trim().equals("") || line.trim().equals("\n")) {
                    continue;
                }

                String[] userData = line.split(",");

                // Create new user from the file
                User user = new User();
                user.setUserId(userData[0]);
                user.setPassword(userData[1]);
                user.setFullname(userData[2]);

                users.add(user);
            }
        }
        catch (NumberFormatException | IOException e) {
            e.printStackTrace();
            System.exit(0); // Immediately shutdown
        }

        return users;
    }

    private void writeAllUser(List<User> users) {
        if (users.isEmpty()) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (User user : users) {
            stringBuilder.append(user.getUserId());
            stringBuilder.append(',');
            stringBuilder.append(user.getPassword());
            stringBuilder.append(',');
            stringBuilder.append(user.getFullname());
            stringBuilder.append('\n');
        }

        try (FileWriter fileWriter = new FileWriter(databasePath, false)) {
            fileWriter.write(stringBuilder.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(0); // Immediately shutdown
        }
    }
}