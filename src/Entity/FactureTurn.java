/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author miguel
 */
@Entity
public class FactureTurn implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="FactureTurn_ID")
    private long id;
    @Column(name="ActualDate",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualDate;
    @Column(name="Subtotal",nullable=false)
    private double subtotal;
    @Column(name="IVA",nullable=false)
    private double IVA;
    @Column(name="Total",nullable=false)
    private double total;
    @Column(name="fExit")
    @ManyToOne
    private Exits exit;
    
    //@OneToMany
    //private List<Exits> exits = new ArrayList();

    public double getIVA() {
        return IVA;
    }

    public Exits getExit() {
        return exit;
    }

    public void setExit(Exits exit) {
        this.exit = exit;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public Date getActualDate() {
        return actualDate;
    }

    public void setActualDate(Date actualDate) {
        this.actualDate = actualDate;
    }

    public Exits getExits() {
        return exit;
    }

    public void setExits(Exits exit) {
        this.exit = exit;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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

        if (!(object instanceof FactureTurn)) {
            return false;
        }
        FactureTurn other = (FactureTurn) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.FactureTurn[ id=" + id + " ]";
    }
    
}
