import javax.swing.*;
import java.awt.*;

/**
 * Creates new login form
 * Validates username and password to log someone in
 */
public class LoginForm {
    public static void displayLoginForm() {
        // Create new login frame
        JFrame frame = new JFrame("Login");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());

        // Set layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 30, 10, 30);

        // Create components
        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");

        // Set fonts
        Font fieldFont = new Font("Arial", Font.PLAIN, 24);
        usernameField.setFont(fieldFont);
        passwordField.setFont(fieldFont);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));

        // Style login button
        loginButton.setForeground(new Color(255, 65, 121));
        loginButton.setBackground(new Color(255, 204, 217));
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());

            // Checks if username or password fields are empty
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Both username and password fields must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Fetches user from database
                User user = UserDatabase.getUser(username);
                // Checks if user exists
                if (user == null) {
                    JOptionPane.showMessageDialog(frame, "Username does not exist.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
                // Checks if password matches
                else if (!user.getPassword().equals(password)) {
                    JOptionPane.showMessageDialog(frame, "Invalid password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
                // Displays success message if everything is OK
                else {
                    JOptionPane.showMessageDialog(frame, "Login Successful! Welcome, " + user.getFirstName() + "!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    displayUserProfile(user);
                    frame.dispose();
                }
            }
        });

        // Add components
        frame.add(new JLabel("Username:"), gbc);
        frame.add(usernameField, gbc);
        frame.add(new JLabel("Password:"), gbc);
        frame.add(passwordField, gbc);
        frame.add(loginButton, gbc);

        frame.setVisible(true);
    }

    /**
     * Displays user profile upon successful login
     * @param user - user information to be displayed
     */
    private static void displayUserProfile(User user) {
        // Create new frame
        JFrame profileFrame = new JFrame("User Profile");
        profileFrame.setSize(400, 300);
        profileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        profileFrame.setLocationRelativeTo(null);

        // Set layout
        profileFrame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Create components
        JLabel firstNameLabel = new JLabel("First Name: " + user.getFirstName());
        JLabel lastNameLabel = new JLabel("Last Name: " + user.getLastName());
        JLabel emailLabel = new JLabel("Email: " + user.getEmail());
        JLabel passwordLabel = new JLabel("Password: " + user.getPassword());

        // Set fonts
        firstNameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        lastNameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        // Add components
        profileFrame.add(firstNameLabel, gbc);
        profileFrame.add(lastNameLabel, gbc);
        profileFrame.add(emailLabel, gbc);
        profileFrame.add(passwordLabel, gbc);

        profileFrame.setVisible(true);
    }
}
