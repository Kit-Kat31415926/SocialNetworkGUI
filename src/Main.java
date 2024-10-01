import javax.swing.JFrame;
/*
 * Description: Creates social networking login
 * Authors: Kaitlyn Chiu, Arianna Gonzalez
 * Date: 1 October 2024
 */
public class Main {
    private static SocialNetworkFrame frame;
    public static void main(String[] args) {
        // Create main frame for signup, login, and exit
        frame = new SocialNetworkFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My Social Network - Kaitlyn Chiu (016967652)");
        frame.setSize(600,400);
        frame.setVisible(true);
    }
}