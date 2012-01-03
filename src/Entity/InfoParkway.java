/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Grupo E
 */
@Entity
public class InfoParkway implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    @Column(name="ParkingName",nullable=true)
    private String name;
    @Column(name="Address",nullable=true)
    private String address;
    @Column(name="NIT",nullable=true)
    private String nit;
    @Column(name="Telephone",nullable=true)
    private String telephone;
    @Column(name="Register",nullable=true)
    private int register;
    @Column(name="MaxCapacity",nullable=false)
    private int maxCapacity;
    @Column(name="IvaPercent",nullable=false)
    private double IVAPercent;
    

    public InfoParkway() {
    }

    public double getIVAPercent() {
        return IVAPercent;
    }

    public void setIVAPercent(double IVAPercent) {
        this.IVAPercent = IVAPercent;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public int getRegister() {
        return register;
    }

    public void setRegister(int register) {
        this.register = register;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
  
        if (!(object instanceof InfoParkway)) {
            return false;
        }
        InfoParkway other = (InfoParkway) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.InfoParkway[ id=" + id + " ]";
    }
    
}
