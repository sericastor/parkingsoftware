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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ExitDate",nullable=false)
    private Date exitDate;
    @Column(name="Plate",nullable=false)
    private String plate; 
    @Column(name="Ticket",nullable=false)
    private int ticket; 
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EntryDate",nullable=false)
    private Date entryDate;
    @ManyToOne
    @JoinColumn(name="EmployeeExit")
    private Employee employeeExit; 
    @ManyToOne
    @JoinColumn(name="EmployeeEntry")
    private Employee employeeEntry; 
    @ManyToOne
    @JoinColumn(name="VehicleType")
    private VehicleType vehicleType;
    @Column(name="Subtotal",nullable=false)
    private double subtotal;
    @Column(name="IVA",nullable=false)
    private double IVA;
    @Column(name="Total",nullable=false)
    private double total;
    @OneToOne
    private Entries entry;

    public Employee getEmployeeEntry() {
        return employeeEntry;
    }

    public void setEmployeeEntry(Employee employeeEntry) {
        this.employeeEntry = employeeEntry;
    }

    public Employee getEmployeeExit() {
        return employeeExit;
    }

    public void setEmployeeExit(Employee employeeExit) {
        this.employeeExit = employeeExit;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

 

  

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
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



    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

   
    public long getId() {
        return id;
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
