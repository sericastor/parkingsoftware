/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author DiegoAl
 */
@Entity
public class CustomTicket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="CustomID")
    private Long id;
    @Column(name="Tittle",length=25)
    private String tittle;
    @Column(name="EntryDate")
    private boolean entryDate;
    @Column(name="EntryEmployee")
    private boolean entryEmployee;
    @Column(name="Barcode")
    private boolean barcode;
    @Column(name="FootPage",length=100)
    private String footPage;

    public CustomTicket() {
    }

    public boolean isBarcode() {
        return barcode;
    }

    public void setBarcode(boolean barcode) {
        this.barcode = barcode;
    }

    public boolean isEntryDate() {
        return entryDate;
    }

    public void setEntryDate(boolean entryDate) {
        this.entryDate = entryDate;
    }

    public boolean isEntryEmployee() {
        return entryEmployee;
    }

    public void setEntryEmployee(boolean entryEmployee) {
        this.entryEmployee = entryEmployee;
    }

    public String getFootPage() {
        return footPage;
    }

    public void setFootPage(String footPage) {
        this.footPage = footPage;
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
        if (!(object instanceof CustomTicket)) {
            return false;
        }
        CustomTicket other = (CustomTicket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.CustomTicket[ id=" + id + " ]";
    }
    
}
