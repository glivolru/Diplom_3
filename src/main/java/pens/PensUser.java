package pens;

public class PensUser {

    private String email;
    private String password;
    private String name;


    public PensUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public PensUser(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public PensUser() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
