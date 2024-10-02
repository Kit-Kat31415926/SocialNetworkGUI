import javax.swing.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {
    // Declare components
    JLabel usernameLabel;
    JTextField usernameInput;
    JLabel pwdLabel;
    JTextField pwdInput;
    JLabel pwdErrorMsg;

    /*
     * Creates new instance of SignUpFrame with all labels and inputs
     */
    public LoginFrame() {
        super();
        // Create input fields
        usernameLabel = new JLabel("Username:");
        usernameInput = new JTextField();
        pwdLabel = new JLabel("Password:");
        pwdInput = new JTextField();
        pwdErrorMsg = new JLabel();
        JButton login = new JButton("Submit");
        // Create action listener for submit button
        login.addActionListener((ActionEvent e) -> {
            User u = Main.getUser(usernameInput.getText(), pwdInput.getText()); // User trying to log in
            if (u != null) {
                createSuccessScreen(u);
            } else {
                // TODO: Display error msg
            }
        });
    }

    public void createSuccessScreen(User u) {
        JFrame success = new JFrame();
        success.setSize(100, 200);
        success.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        success.setTitle("Success");
        // Add components
        success.add(new JLabel("Login successful! Welcome, " + u.getFirstName()));
        success.setVisible(true);
    }
}