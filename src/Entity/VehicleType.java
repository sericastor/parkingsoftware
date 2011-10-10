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
public class VehicleType implements Serializable {
    private static final long serialVersionUID = 1L;
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long number;
   @Column(name="codification",nullable=false)
    private String codification;
    
    @Column(name="Name",nullable=false,length=15)
    private String name;

    public String getCodification() {
        return codification;
    }

    public void setCodification(String codification) {
        this.codification = codification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) number;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehicleType)) {
            return false;
        }
        VehicleType other = (VehicleType) object;
        if (this.number != other.number) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.VehicleType[ id=" + number + " ]";
    }
    
}
