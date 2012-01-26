/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author DiegoAl
 */
@Entity
public class CustomExitTicket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    @Column(name="Tittle",length=25)
    private String tittle;
    @Column(name="ParkwayName")
    private boolean parkwayName;
    @Column(name="ParkwayAddress")
    private boolean parkwayAddress;
    @Column(name="ParkwayNit")
    private boolean parkwayNit;
    @Column(name="ExitEmployee")
    private boolean exitEmployee;
    @Column(name="FootPage",length=100)
    private String footPage;

    public CustomExitTicket() {
    }
    
    public boolean isExitEmployee() {
        return exitEmployee;
    }

    public void setExitEmployee(boolean exitEmployee) {
        this.exitEmployee = exitEmployee;
    }

    public String getFootPage() {
        return footPage;
    }

    public void setFootPage(String footPage) {
        this.footPage = footPage;
    }

    public boolean isParkwayAddress() {
        return parkwayAddress;
    }

    public void setParkwayAddress(boolean parkwayAddress) {
        this.parkwayAddress = parkwayAddress;
    }

    public boolean isParkwayName() {
        return parkwayName;
    }

    public void setParkwayName(boolean parkwayName) {
        this.parkwayName = parkwayName;
    }

    public boolean isParkwayNit() {
        return parkwayNit;
    }

    public void setParkwayNit(boolean parkwayNit) {
        this.parkwayNit = parkwayNit;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
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
        if (!(object instanceof CustomExitTicket)) {
            return false;
        }
        CustomExitTicket other = (CustomExitTicket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.CustomExitTicket[ id=" + id + " ]";
    }
    
}
