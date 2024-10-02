import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Frame for users to sign up, login, or exit
 */
public class SocialNetworkFrame extends JFrame {
    /*
     * Class to handle event when user clicks a button
     */
    class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == signup) {
                JFrame signupFrame = new SignupFrame();
                signupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                signupFrame.setTitle("Signup");
                signupFrame.setSize(600,400);
                signupFrame.setVisible(true);
            } else if (e.getSource() == login) {
                JFrame signupFrame = new LoginFrame();
                signupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                signupFrame.setTitle("Signup");
                signupFrame.setSize(600,400);
                signupFrame.setVisible(true);
            } else if (e.getSource() == exit) {
                System.exit(0);
            }
        }
    }

    // Declare components
    private JButton signup;
    private JButton login;
    private JButton exit;

    /*
     * Creates new isntance of SocialNetworkFrame, will all buttons
     */
    public SocialNetworkFrame() {
        super();
        // Create buttons and formatting
        JLabel welcome = new JLabel("WELCOME!");
        welcome.setFont(new Font(null, 0, 25));
        welcome.setForeground(new Color(112, 66, 252));
        ActionListener listener = new ButtonClickListener();
        signup = new JButton("Signup");
        signup.addActionListener(listener);
        signup.setForeground(new Color(255, 65, 121));
        signup.setBackground(new Color(255, 204, 217));
        login = new JButton("Login");
        login.addActionListener(listener);
        login.setForeground(new Color(255, 65, 121));
        login.setBackground(new Color(255, 204, 217));
        exit = new JButton("Exit");
        exit.addActionListener(listener);
        exit.setForeground(new Color(102, 67, 255));
        exit.setBackground(new Color(209, 194, 251));

        // Add to JFrame
        JPanel panel = new JPanel();
        panel.setBackground(new Color(184, 228, 251));
        JPanel buttons = new JPanel();
        buttons.setBackground(new Color(184, 228, 251));
        buttons.setLayout(new GridLayout(8,1));
        buttons.add(Box.createRigidArea(new Dimension(10, 40)));
        buttons.add(welcome);
        buttons.add(Box.createRigidArea(new Dimension(10, 30)));
        buttons.add(signup);
        buttons.add(Box.createRigidArea(new Dimension(10, 30)));
        buttons.add(login);
        buttons.add(Box.createRigidArea(new Dimension(10, 30)));
        buttons.add(exit);
        panel.add(buttons);
        add(panel);
    }
}
