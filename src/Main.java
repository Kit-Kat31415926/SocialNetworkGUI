import javax.swing.JFrame;
public class Main {
    private static SocialNetworkFrame frame;
    public static void main(String[] args) {
        frame = new SocialNetworkFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My Social Network - Kaitlyn Chiu (016967652)");
        frame.setSize(600,400);
        frame.setVisible(true);
    }
}