import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Frame for users to sign up
 */
public class SignupFrame extends JFrame {
    // Declare components
    JLabel fnameLabel;
    JTextField fnameInput;
    JLabel lnameLabel;
    JTextField lnameInput;
    JLabel emailLabel;
    JTextField emailInput;
    JLabel pwdLabel;
    JTextField pwdInput;
    JLabel pwdErrorMsg;

    /*
     * Creates new instance of SignUpFrame with all labels and inputs
     */
    public SignupFrame() {
        super();
        // Create input fields
        fnameLabel = new JLabel("First name:");
        this.add(fnameLabel);
        fnameInput = new JTextField();
        lnameLabel = new JLabel("Last name:");
        lnameInput = new JTextField();
        emailLabel = new JLabel("Email:");
        emailInput = new JTextField();
        pwdLabel = new JLabel("Password:");
        pwdInput = new JTextField();
        pwdErrorMsg = new JLabel();
        JButton submit = new JButton("Submit");
        // Create action listener for submit button
        submit.addActionListener((ActionEvent e) -> {
            try {
                // Checks if password meets requirements
                checkPassword();
                // If no exceptions are caught, display success frame
                JFrame confirmFrame = new JFrame();
                confirmFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                confirmFrame.setTitle("Success");
                confirmFrame.setSize(100, 200);
                confirmFrame.add(new JLabel("Signup successful! Your username is: " + createUser()));
                JButton okButton = new JButton("Ok");
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        confirmFrame.dispose();
                        dispose();
                    }
                });
                confirmFrame.add(okButton);
                confirmFrame.setVisible(true);
            } catch (UpperCaseCharacterMissing upperexception) {
                // TODO: Set JLabel pwdErrMsg to inform user
            } catch (LowerCaseCharacterMissing lowerexception) {
                // TODO: Set JLabel pwdErrMsg to inform user
            } catch (SpecialCharacterMissing specialexception) {
                // TODO: Set JLabel pwdErrMsg to inform user
            } catch (NumberCharacterMissing numberexception) {
                // TODO: Set JLabel pwdErrMsg to inform user
            } catch (Minimum8CharactersRequired min8exception) {
                // TODO: Set JLabel pwdErrMsg to inform user
            } catch (Exception ex) {
                System.out.println("Unexpected error! :(");
            }
        });

        // Add components to frame
        JPanel panel = new JPanel();
        panel.setBackground(new Color(184, 228, 251));
        JPanel form = new JPanel();
        form.setBackground(new Color(184, 228, 251));
        form.setLayout(new GridLayout(15,1));
        form.add(Box.createRigidArea(new Dimension(100, 10)));
        form.add(fnameLabel);
        form.add(fnameInput);
        form.add(Box.createRigidArea(new Dimension(10, 10)));
        form.add(lnameLabel);
        form.add(lnameInput);
        form.add(Box.createRigidArea(new Dimension(10, 10)));
        form.add(emailLabel);
        form.add(emailInput);
        form.add(Box.createRigidArea(new Dimension(10, 10)));
        form.add(pwdLabel);
        form.add(pwdInput);
        form.add(pwdErrorMsg);
        form.add(Box.createRigidArea(new Dimension(10, 10)));
        form.add(submit);
        panel.add(form);
        this.add(panel);
    }

    /*
     * Checks if user-created password meets requirements
     * If not, an exception is raised
     * UpperCaseCharacterMissing - Raised if upper case character is missing in the password.
     * LowerCaseCharacterMissing - Raised if a lower case character is missing in the password.
     * SpecialCharacterMissing - Raised if a special character is missing in the password.
     * NumberCharacterMissing - Raised if the password doesn't have any numbers in it.
     * Minimum8CharactersRequired - Raised if the password is less than 8 characters.
     */
    public void checkPassword() {
        // TODO: Check password
        // Throw user-defined exception if not met
    }

    /*
     * Informs user that their password does not meet requirements
     * @param String - error message to be displayed
     */
    public void displayErrorMsg(String err) {
        pwdErrorMsg.setText(err);
        repaint();
    }

    /*
     * Creates username for user based on inputs
     */
    public String createUser() throws Exception {
        // TODO: Create username and store all inputted information
        return "";
    }
}
