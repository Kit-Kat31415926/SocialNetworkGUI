import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SocialNetworkFrame extends JFrame {
    class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == signup) {
                JFrame signupFrame = new JFrame();
                signupFrame.setTitle("Signup");
                signupFrame.setSize(600,400);
                signupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                signupFrame.setVisible(true);
            } else if (e.getSource() == login) {
                // Create login frame
            } else if (e.getSource() == exit) {
                System.exit(0);
            }
        }
    }
    private JButton signup;
    private JButton login;
    private JButton exit;
    public SocialNetworkFrame() {
        super();
        // Create buttons
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
