/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Joakim
 */
@NamedQueries ({
    @NamedQuery(name = "getAll", query = "SELECT Object(o) FROM LunchEntity o"),
    @NamedQuery(name = "getDay", query = "SELECT e FROM LunchEntity e WHERE e.lunchday = :weekday")
 })
@Entity
@XmlRootElement
public class LunchEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lunchday; //Inte "day" då det krockar med SQL
    private String name;
    private String description;
    private Integer price;
    private Integer dayNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getLunchday() {
        return lunchday;
    }

    public void setLunchday(String lunch_day) {
        this.lunchday = lunch_day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    public Integer getDayNo() {
        return dayNo;
    }

    public void setDayNo(Integer dayNo) {
        
            this.dayNo = dayNo;
        
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
        if (!(object instanceof LunchEntity)) {
            return false;
        }
        LunchEntity other = (LunchEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.entities.LunchEntity[ id=" + id + " ]";
    }
}
