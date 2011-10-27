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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author miguel
 */
@Entity
public class Exits implements Serializable {
   private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Exits_ID")
    private long id;
    @Column(name="Plate",nullable=false)
    private String plate; // No necesario
    @Column(name="Ticket",nullable=false)
    private int ticket; // No necesario
     @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ExitDate",nullable=false)
    private Date exitDate;
    @Column(name="Units",nullable=false)
    private int units;
    @Column(name="Rate",nullable=false)
    private int rate; // No necesario
    @Column(name="Employee",nullable=false)
    private int employee; // No necesario
    @Column(name="VehicleType",nullable=false)
    private int vehicleType; // No necesario
    @Column(name="Subtotal",nullable=false)
    private double subtotal;
    @Column(name="IVA",nullable=false)
    private double IVA;
    @Column(name="Total",nullable=false)
    private double total;
    

    @OneToOne
    private Entries entry;

    @ManyToOne
    private FactureTurn turn;

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public Entries getEntry() {
        return entry;
    }

    public void setEntry(Entries entry) {
        this.entry = entry;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public FactureTurn getTurn() {
        return turn;
    }

    public void setTurn(FactureTurn turn) {
        this.turn = turn;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public int getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
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
        
        if (!(object instanceof Exits)) {
            return false;
        }
        Exits other = (Exits) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Exits[ id=" + id + " ]";
    }
    
}
