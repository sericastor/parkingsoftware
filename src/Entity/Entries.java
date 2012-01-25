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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author miguel
 */
@Entity
public class Entries implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="Ticket",nullable=false)
    private String ticket;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EntryDate",nullable=false)
    private Date entryDate;
    @Column(name="Plate",nullable=false)
    private String plate;  
    @ManyToOne
    @JoinColumn(name="VehicleType")
    private VehicleType vehicleType;
    @ManyToOne
    private Employee employee;
    @Column(name="Comentary",nullable=true)
    private String comentary;
    @Column(name="TicketCodification")
    private String ticketCodification;

    public Entries() {
    }
    
    public String getTicketCodification() {
        return ticketCodification;
    }

    public void setTicketCodification(String ticketCodification) {
        this.ticketCodification = ticketCodification;
    }
    public String getComentary() {
        return comentary;
    }

    public void setComentary(String comentary) {
        this.comentary = comentary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
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

        if (!(object instanceof Entries)) {
            return false;
        }
        Entries other = (Entries) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Entries[ id=" + id + " ]";
    }
    
}
