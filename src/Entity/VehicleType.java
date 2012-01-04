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
    @Column(unique=true,name="Name",nullable=false,length=25)
    private String name;
    @Column (name="places")
    private double places;

    public String getCodification() {
        return codification;
    }

    public double getPlaces() {
        return places;
    }

    public void setPlaces(double places) {
        this.places = places;
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
