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

/**
 *
 * @author Grupo E
 */
@Entity
public class Exits implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="Plate",nullable=false)
    private String plate;
    @Column(name="Ticket",nullable=false)
    private int ticket;
    @Column(name="EntryDate",nullable=false) 
    private Date entryDate;
    // ^ Si se definen relaciones este atributo sería innecesario
    /*
    private String entryYear;
    private String entryMonth;
    private String entryDay;
    private String entryHour;
    */
    @Column(name="ExitDate",nullable=false)
    private Date exitDate;
    /*
    private String exitYear;
    private String exitMonth;
    private String exitDay;
    private String exitHour;
    Vamos a dejar tipo Date sql?
     */
    @Column(name="Units",nullable=false)
    private int units;
    @Column(name="Rate",nullable=false)
    private int rate;
    @Column(name="Employee",nullable=false)
    private int employee;
    @Column(name="Facture",nullable=false)
    private int facture; // Creo que este dato sobra
    @Column(name="VehicleType",nullable=false)
    private int vehicleType;
    
    // TODO: Reorganizar los atriburos, total, subtotal e IVA deberían ir aquí
    // Relación con Entries 

    public Exits() {
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public int getFacture() {
        return facture;
    }

    public void setFacture(int facture) {
        this.facture = facture;
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

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
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
        if (!(object instanceof Exits)) {
            return false;
        }
        Exits other = (Exits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Exits[ id=" + id + " ]";
    }
    
}
