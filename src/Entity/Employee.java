/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author miguel
 */
@Entity
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="LastName",nullable=false,length=25)
    private String lastName;
    @Column(name="Name",nullable=false,length=25)
    private String name; 
    @Column(name="Document",nullable=false,length=15)
    private String document;
    @Column(name="PUser",nullable=false,length=10)
    private String user;
    @Column(name="Password",nullable=false,length=32)
    private String password;
    @Column(name="Rol",nullable=false)
    private boolean administrator;
    @Column(name="Active",nullable=false)
    private boolean isActive;
    
    //TODO: Relación con Entradas, su getter & setter
   
    public boolean isAdministrator() {
        return administrator;
    }
    
    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }
    
    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Employee[ id=" + id + " ]";
    }
    
}
