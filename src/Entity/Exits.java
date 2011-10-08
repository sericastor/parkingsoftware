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
 * @author Grupo E
 */
@Entity
public class Exits implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="Plate",nullable=false)
    private String plate; // No necesario
    @Column(name="Ticket",nullable=false)
    private int ticket; // No necesario
    @Column(name="EntryDate",nullable=false) 
    private Date entryDate; // No necesario
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
    @Column(name="Subtotal",nullable=false)
    private double IVA;
    @Column(name="Subtotal",nullable=false)
    private double total;
    
    @OneToOne(mappedBy="exit")
    private Entries entry;
    
    @ManyToOne
    private FactureTurn turn;
    
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

    public FactureTurn getTurn() {
        return turn;
    }

    public void setTurn(FactureTurn turn) {
        this.turn = turn;
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
