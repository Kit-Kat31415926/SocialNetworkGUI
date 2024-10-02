import javax.swing.JFrame;
import java.util.ArrayList;

/*
 * Description: Creates social networking login
 * Authors: Kaitlyn Chiu, Arianna Gonzalez
 * Date: 1 October 2024
 */
public class Main {
    public static ArrayList<User> users = new ArrayList<User>();
    public static void main(String[] args) {
        // Create main frame for signup, login, and exit
        JFrame frame = new SocialNetworkFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My Social Network - Kaitlyn Chiu (016967652)");
        frame.setSize(600,400);
        frame.setVisible(true);
    }
    public static void addUser(User u) {
        users.add(u);
    }

    public static User getUser(String username, String pwd) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(pwd)) {
                return u;
            }
        }
        return null;
    }
}