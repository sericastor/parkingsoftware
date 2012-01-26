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
import javax.persistence.ManyToOne;

/**
 *
 * @author miguel
 */
@Entity
public class BandsRate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private long id;
    @Column(name="UnitFrom",nullable=false)
    private int fromm;
    @Column(name="UnitTo",nullable=false)
    private int too;
    @Column(name="UnitValue",nullable=false)
    private double unitValue;
    @Column(name="Units",nullable=false)
    private int units;
    @ManyToOne
    VehicleType vehicletype;

    public BandsRate() {
    }

    public int getFromm() {
        return fromm;
    }

    public void setFromm(int fromm) {
        this.fromm = fromm;
    }

    public int getToo() {
        return too;
    }

    public void setToo(int too) {
        this.too = too;
    }

    public double getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(double unitValue) {
        this.unitValue = unitValue;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public VehicleType getVehicletype() {
        return vehicletype;
    }

    public void setVehicletype(VehicleType vehicletype) {
        this.vehicletype = vehicletype;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof BandsRate)) {
            return false;
        }
        BandsRate other = (BandsRate) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.BandsRate[ id=" + id + " ]";
    }
    
}
