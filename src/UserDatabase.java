import java.util.HashMap;

/**
 * Stores all users in database hashed by username
 */
public class UserDatabase {
    private final static HashMap<String, User> users = new HashMap<>();

    /**
     * Adds new user to database
     * @param user - user to be added
     */
    public static void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    /**
     * Fetches user from database
     * @param username - username to search for user with
     * @return User - user information
     */
    public static User getUser(String username) {
        return users.get(username);
    }
}
