public class User {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String username;
    private final String password;

    /**
     * Create new user
     * @param firstName
     * @param lastName
     * @param email
     * @param username
     * @param password
     */
    public User(String firstName, String lastName, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    // Define getter methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() { return password; }
}
