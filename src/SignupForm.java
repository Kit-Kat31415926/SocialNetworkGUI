import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.util.Random;

/**
 * Creates new ButtonListener
 */
class SubmitButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        // Tells user to fill all fields if they have not done so
        if (!SignupForm.allFieldsFilled()) {
            SignupForm.showPopup("All fields must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                // Verifies user password is correct
                SignupForm.validatePassword();
                // Creates new user if all info is OK
                User newUser = SignupForm.createNewUser();
                UserDatabase.addUser(newUser);
                SignupForm.showPopup("Signup Successful! Your username is: " + newUser.getUsername(), "Success", JOptionPane.INFORMATION_MESSAGE);
                SignupForm.disposeFrame();
            } catch (PasswordException ex) {
                SignupForm.showPopup(ex.getMessage(), "Signup Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

/**
 * Create new Signup Form for user to enter information
 * Will check if pasword meets requirements
 * Will generate a new username and password for user if everything is OK
 */
public class SignupForm {
    private static JFrame frame;
    private static JTextField firstNameField;
    private static JTextField lastNameField;
    private static JTextField emailField;
    private static JPasswordField passwordField;

    /**
     * Creates new signup form
     */
    public static void displaySignupForm() {
        // Creates new JFrame for signing up
        frame = new JFrame("Signup");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Set layout
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 30, 10, 30);

        // Create text fields for inputting information
        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);

        // Create submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setForeground(new Color(255, 65, 121));
        submitButton.setBackground(new Color(255, 204, 217));
        submitButton.addActionListener(new SubmitButtonListener());

        // Set fonts for all components
        Font fieldFont = new Font("Arial", Font.PLAIN, 24);
        firstNameField.setFont(fieldFont);
        lastNameField.setFont(fieldFont);
        emailField.setFont(fieldFont);
        passwordField.setFont(fieldFont);
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));

        // Add all components
        frame.add(new JLabel("First Name:"), gbc);
        frame.add(firstNameField, gbc);
        frame.add(new JLabel("Last Name:"), gbc);
        frame.add(lastNameField, gbc);
        frame.add(new JLabel("Email:"), gbc);
        frame.add(emailField, gbc);
        frame.add(new JLabel("Password:"), gbc);
        frame.add(passwordField, gbc);
        frame.add(submitButton, gbc);

        frame.setVisible(true);
    }

    /**
     * Checks if all fields in signup form are filled
     * @return - true if all fields are filled and false otherwise
     */
    public static boolean allFieldsFilled() {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());
        return !(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty());
    }

    /**
     * Creates new popup window to inform user
     */
    public static void showPopup(String message, String title, int type) {
        JOptionPane.showMessageDialog(frame, message, title, type);
    }

    /**
     * Generates username for user based on their first and last name
     * Creates new User to be added to database
     * @return User - object representing all user info
     */
    public static User createNewUser() {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());

        // Generate username
        Random random = new Random();
        int randomNumber = 1000 + random.nextInt(9000);  // Generates a number from 1000 to 9999
        String username = "" + firstName.charAt(0) + lastName.charAt(0) + "-" + randomNumber;

        // Create User
        return new User(firstName, lastName, email, username, password);
    }

    /**
     * Validates user password
     * Throws exception if password does not meet requirements
     */
    public static void validatePassword() throws PasswordException {
        String password = new String(passwordField.getPassword());
        if (password.length() < 8) throw new Minimum8CharactersRequired();
        if (!password.matches(".*\\d.*")) throw new NumberCharacterMissing();
        if (!password.matches(".*[a-z].*")) throw new LowerCaseCharacterMissing();
        if (!password.matches(".*[A-Z].*")) throw new UpperCaseCharacterMissing();
        if (!password.matches(".*[!@#$%^&*()].*")) throw new SpecialCharacterMissing();
    }

    /**
     * Exits frame after user has successfully created an account
     */
    public static void disposeFrame() {
        frame.dispose();
    }
}