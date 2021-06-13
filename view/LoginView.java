package view;

import javax.swing.*;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {

    private LoginViewListener loginViewListener;

    private JLabel logoLabel;
    private JLabel userIdLabel;
    private JLabel passLabel;
    private JLabel loginLabel;
    public JTextField userId;
    public JPasswordField password;
    private JButton login;
      
    public LoginView() {
        
    }

    public void initUI() {

        // Label
        logoLabel = new JLabel();
        loginLabel = new JLabel();
        userIdLabel = new JLabel();
        passLabel = new JLabel();

        // TextField
        userId = new JTextField();
        password = new JPasswordField();

        // Button
        login = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Set Text (Label)
        loginLabel.setFont(new Font("Tahoma", 1, 14));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setText("Login to Meal Diary");

        userIdLabel.setText("User ID");
        passLabel.setText("Password");

        // Login Button
        login.setText("Login");
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {               
                // Call method in LoginViewListener
                loginViewListener.onLoginButtonPressed();
            }
        });

        // Setup logo
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Image image = new ImageIcon("./resource/logo.png").getImage();
        ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(115, 115, Image.SCALE_SMOOTH));
        logoLabel.setIcon(imageIcon);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(loginLabel, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(login, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(userId, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                                    .addComponent(userIdLabel, GroupLayout.Alignment.LEADING))
                                .addComponent(password, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(passLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 322, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(logoLabel, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoLabel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(userIdLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userId, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passLabel)
                .addGap(4, 4, 4)
                .addComponent(password, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(login, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        // Enable press enter to login
        getRootPane().setDefaultButton(login);

        // Set the icon
        setIconImage(new ImageIcon("./resource/logo.png").getImage());

        pack();
        setTitle("Login");
        setResizable(false);
        setVisible(true);
    }

    public void addListener(LoginViewListener loginViewListener) {
        this.loginViewListener = loginViewListener;
    }
}