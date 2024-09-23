import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupFrame extends JFrame {
    class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
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

    public SignupFrame() {
        super();

        // Create input fields
        fnameLabel = new JLabel("First name:");
        fnameInput = new JTextField();
        lnameLabel = new JLabel("Last name:");
        lnameInput = new JTextField();
        emailLabel = new JLabel("Email:");
        emailInput = new JTextField();
        pwdLabel = new JLabel("Password:");
        pwdInput = new JTextField();
        pwdErrorMsg = new JLabel();
        JButton submit = new JButton("Submit");
        submit.addActionListener((ActionEvent e) -> {
            if (conditionsMet()) {
                this.dispose();
            } else {
                displayErrorMsg();
            }
        });

        // Add to frame
        JPanel panel = new JPanel();
        panel.setBackground(new Color(184, 228, 251));
        JPanel form = new JPanel();
        form.setBackground(new Color(184, 228, 251));
        form.setLayout(new GridLayout(9,1));
        form.add(fnameLabel);
        form.add(fnameInput);
        form.add(lnameLabel);
        form.add(lnameInput);
        form.add(emailLabel);
        form.add(emailInput);
        form.add(pwdLabel);
        form.add(pwdLabel);
        panel.add(form);
        this.add(panel);
    }

    public boolean conditionsMet() {
        // Check password
        // Throw user-defined exception if not met
        return true;
    }

    public void displayErrorMsg() {
        // Tell user what went wrong
    }
}
