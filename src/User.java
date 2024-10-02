public class User {
    private String fname;
    private String lname;
    private String username;
    private String email;
    private String pwd;
    User(String f, String l, String u, String e, String p) {
        fname = f;
        lname = l;
        username = u;
        email = e;
        pwd = p;
    }

    public String getFirstName() {
        return fname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return pwd;
    }
}
