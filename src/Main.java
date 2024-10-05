import javax.swing.*;
import java.awt.*;

/**
 * Creates new Social Networking Login
 * @author Kaitlyn Chiu and Ariana Gonzalez
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create new base Frame
            JFrame frame = new JFrame("My Social Network - Kaitlyn Chiu (016967652), Arianna Gonzalez (017157114)");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Centers the frame on the screen
            frame.setLocationRelativeTo(null);

            // Set layout
            frame.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            // Specify that the component's display area will be from gridx to the last cell in the row
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            // Make the component wide enough to fill its display area horizontally, but do not change its height.
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(10, 50, 10, 50);  // Padding around components

            // Create Components
            JLabel welcomeLabel = new JLabel("WELCOME!");
            welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));  // Larger font size for welcome message
            welcomeLabel.setForeground(new Color(112, 66, 252));
            welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

            JButton signupButton = new JButton("Signup");
            signupButton.setFont(new Font("Arial", Font.BOLD, 14));
            signupButton.setForeground(new Color(255, 65, 121));
            signupButton.setBackground(new Color(255, 204, 217));

            JButton loginButton = new JButton("Login");
            loginButton.setFont(new Font("Arial", Font.BOLD, 14));
            loginButton.setForeground(new Color(255, 65, 121));
            loginButton.setBackground(new Color(255, 204, 217));

            JButton exitButton = new JButton("Exit");
            exitButton.setFont(new Font("Arial", Font.BOLD, 14));
            exitButton.setForeground(new Color(102, 67, 255));
            exitButton.setBackground(new Color(209, 194, 251));

            // Add action listeners to buttons
            signupButton.addActionListener((e) -> SignupForm.displaySignupForm());
            loginButton.addActionListener((e) -> LoginForm.displayLoginForm());
            exitButton.addActionListener((e) -> System.exit(0));

            // Add all components to frame
            frame.add(welcomeLabel, gbc);
            frame.add(signupButton, gbc);
            frame.add(loginButton, gbc);
            frame.add(exitButton, gbc);

            frame.setVisible(true);
        });
    }
}