package presenter;

import event.*;
import view.LoginViewListener;

public class LoginPresenter implements Subscriber, LoginViewListener {
    private String username;
    private String password;

    @Override
    public void onLoginButtonPressed(String username, String password) {
        //TODO Auto-generated method stub
    }

    @Override
    public void handleEvent(Event event) {
        // TODO Auto-generated method stub
        
    }
}