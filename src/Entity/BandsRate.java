/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Grupo E
 */
@Entity
public class BandsRate implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long id;
    @Column(name="UnitFrom",nullable=false)
    private int fromm;
    @Column(name="UnitTo",nullable=false)
    private int too;
    @Column(name="UnitValue",nullable=false)
    private double unitValue;
    @Column(name="Units",nullable=false)
    private int units;
    
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BandsRate)) {
            return false;
        }
        BandsRate other = (BandsRate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.BandsRate[ id=" + id + " ]";
    }
    
}
