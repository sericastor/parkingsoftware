/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author miguel
 */
@Entity
public class BandsRate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;// no aparece en en el modelo, pero es necesario para hacer el 
                    //mapeo a la base de datos
    private int rate;
    private int fromm;//si se deja "from" genera conflictos por sentencias DB
    private int too;//si se deja "from" genera conflictos por sentencias DB
    private double unitValue;
    private int units;

    public int getFromm() {
        return fromm;
    }

    public void setFromm(int fromm) {
        this.fromm = fromm;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
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
