package model;

/**
 *
 * @author Martin Kanayet
 */
public class Employee {

    public Employee() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
private String user;
private String password;
}
