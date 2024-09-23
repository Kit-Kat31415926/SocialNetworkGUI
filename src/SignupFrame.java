import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupFrame extends JFrame {
    class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public SignupFrame() {
        super();

        // Create input fields
        JLabel fnameLabel = new JLabel("First name:");
        JTextField fnameInput = new JTextField();
        JLabel lnameLabel = new JLabel("Last name:");
        JTextField lnameInput = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailInput = new JTextField();
        JLabel pwdLabel = new JLabel("Password:");
        JTextField pwdInput = new JTextField();
    }
}
