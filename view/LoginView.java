package view;

import javax.swing.*;
import java.awt.event.*;

public class LoginView extends JFrame {

    private LoginViewListener loginViewListener;

    private JLabel usernameLabel;
    private JLabel passLabel;
    private JLabel loginLabel;
    private JTextField username;
    private JTextField password;
    private JButton login;
      
    public LoginView() {
        
    }

    public void initUI() {

        // Label
        loginLabel = new JLabel();
        usernameLabel = new JLabel();
        passLabel = new JLabel();

        // TextField
        username = new JTextField();
        password = new JTextField();

        // Button
        login = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Set Text (Label)
        loginLabel.setText("Login to Meal Diary");
        usernameLabel.setText("Username");
        passLabel.setText("Password");

        // Login Button
        login.setText("Login");
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {               
                // Call method in LoginViewListener
                loginViewListener.onLoginButtonPressed();
            }
        });

        // Ui Swing Stuff
        // TODO: Possible untuk kemaskan? hmm...
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(username)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(loginLabel, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
                                .addComponent(usernameLabel)
                                .addComponent(passLabel))
                            .addGap(0, 10, Short.MAX_VALUE))
                        .addComponent(password))
                    .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                    .addGap(136, 136, 136)
                    .addComponent(login, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(loginLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addGap(90, 90, 90)
                    .addComponent(usernameLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(username, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(passLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(password, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(login, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
        setVisible(true);
    }

    public void addListener(LoginViewListener loginViewListener) {
        this.loginViewListener = loginViewListener;
    }
}