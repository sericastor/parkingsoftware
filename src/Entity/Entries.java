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

/**
 *
 * @author miguel
 */
@Entity
public class Entries implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticket;
       //TODO: Order debería ser llave primaria, ya que ticket se reinicia cada día
    private int orderr;
    @Column(name="EntryDate",nullable=false)
    private Date entryDate;
    @Column(name="Plate",nullable=false)
    private String plate;
    @Column(name="Employee",nullable=false)
    private Long EmployeeID;
    @Column(name="VehicleType",nullable=false)
    private int vehicleType;
    
    @ManyToOne
    private ParkingRate rate;
    
    public Entries() {
    }
    
    public Long getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(Long EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public Date getDate() {
        return entryDate;
    }

    public void setDate(Date date) {
        this.entryDate = date;
    }

    public int getOrderr() {
        return orderr;
    }

    public void setOrderr(int orderr) {
        this.orderr = orderr;
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
    
    public Long getTicket() {
        return ticket;
    }

    public void setTicket(Long ticket) {
        this.ticket = ticket;
    }

    public int getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticket != null ? ticket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the ticket fields are not set
        if (!(object instanceof Entries)) {
            return false;
        }
        Entries other = (Entries) object;
        if ((this.ticket == null && other.ticket != null) || (this.ticket != null && !this.ticket.equals(other.ticket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Entries[ id=" + ticket + " ]";
    }
    
}
