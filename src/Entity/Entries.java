/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author miguel
 */
@Entity
public class Entries implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="EntryOrder")
    private Long entryOrder;
    @Column(name="Ticket",nullable=false)
    private int ticket;
    @Column(name="EntryDate",nullable=false)
    private Date entryDate;
    @Column(name="Plate",nullable=false)
    private String plate;
    
    @ManyToOne
    @Column(name="Rate",nullable=false)
    private ParkingRate rate;
    
    @ManyToOne
    @Column(name="VehicleType",nullable=false)
    private VehicleType vehicleType;
    
    @ManyToOne
    @Column(name="Employee",nullable=false)
    private Employee employee;
    
    @OneToOne
    private Exits exit;
    
    public Entries() {
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
    
    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public ParkingRate getRate() {
        return rate;
    }

    public void setRate(ParkingRate rate) {
        this.rate = rate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getEntryOrder() {
        return entryOrder;
    }

    public void setEntryOrder(Long entryOrder) {
        this.entryOrder = entryOrder;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entryOrder != null ? entryOrder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the ticket fields are not set
        if (!(object instanceof Entries)) {
            return false;
        }
        Entries other = (Entries) object;
        if ((this.entryOrder == null && other.entryOrder != null) || (this.entryOrder != null && !this.entryOrder.equals(other.ticket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Entries[ id=" + entryOrder + " ]";
    }
    
}
