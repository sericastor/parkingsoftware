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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author miguel
 */
@Entity
public class Facture implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ActualDate",nullable=false)
    private Date actualDate;
    @Column(name="Subtotal",nullable=false)
    private double subtotal; 
    @Column(name="IVA",nullable=false)
    private double iva;
    @Column(name="Total",nullable=false)
    private double total;
    @OneToOne
    private FactureTurn factureTurn;
    @Column(name="Employee")
    @ManyToOne
    private Employee factureEmployee;

    //@OneToMany
    //private List<FactureTurn> facturesTurn = new ArrayList();

    public Employee getFactureEmployee() {
        return factureEmployee;
    }

    public void setFactureEmployee(Employee factureEmployee) {
        this.factureEmployee = factureEmployee;
    }

    public FactureTurn getFactureTurn() {
        return factureTurn;
    }

    public void setFactureTurn(FactureTurn factureTurn) {
        this.factureTurn = factureTurn;
    }
    
    public Date getActualDate() {
        return actualDate;
    }

    public void setActualDate(Date actualDate) {
        this.actualDate = actualDate;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
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

        if (!(object instanceof Facture)) {
            return false;
        }
        Facture other = (Facture) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Facture[ id=" + id + " ]";
    }
    
}
