package presenter;

import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import event.*;
import model.*;
import view.LoginView;
import view.LoginViewListener;

public class LoginPresenter implements Subscriber, LoginViewListener {
    private Repository<String, User> userRepository;
    private LoginView loginView;
    private EventBus eventBus;

    public LoginPresenter(Repository<String, User> userRepository, EventBus eventBus) {
        this.userRepository = userRepository;
        this.eventBus = eventBus;
        this.eventBus.register(this); // !!!

        // Create view
        loginView = new LoginView();
        loginView.addListener(this); // !!!
        loginView.initUI();
    }

    @Override
    public void onLoginButtonPressed() {
        String userId = loginView.userId.getText();
        char[] password = loginView.password.getPassword();

        List<User> users = userRepository.getAll();

        for (User user : users) {
            if (user.getUserId().equals(userId) && Arrays.equals(user.getPassword().toCharArray(), password)) {
                System.out.println("Verified!");
                eventBus.dispatch(new LoginEvent(userId, user.getFullname()));
                loginView.dispose();
                return;
            }
        }

        // If not verified
        JOptionPane.showMessageDialog(loginView, "Wrong User ID or Password!", "Unauthorized!", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void handleEvent(Event event) {
        switch (event.getEventName()) {
            case "Logout": handleLogoutEvent((LogoutEvent)event); break;
        }
    }

    public void handleLogoutEvent(LogoutEvent logoutEvent) {
        // Need to reinitialize again
        loginView = new LoginView();
        loginView.addListener(this);
        loginView.initUI();
    }
}