package model;

import java.util.ArrayList;

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
    
    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String user;

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    

    public ArrayList<Entries> getEntries() {
        return entries;
    }

    public void setEntries(ArrayList<Entries> entries) {
        this.entries = entries;
    }
    
    private String document;
    private String password;    
    private long id;
    private String lastName;
    private String name; 
    private boolean admin;
    private ArrayList<Entries> entries = new ArrayList<Entries>();
}
