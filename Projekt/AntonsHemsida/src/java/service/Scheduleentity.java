/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author and12edi
 */
@Entity
@Table(name = "SCHEDULEENTITY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Scheduleentity.findAll", query = "SELECT s FROM Scheduleentity s")
    , @NamedQuery(name = "Scheduleentity.findById", query = "SELECT s FROM Scheduleentity s WHERE s.id = :id")
    , @NamedQuery(name = "Scheduleentity.findByWeekDay", query = "SELECT s FROM Scheduleentity s WHERE s.weekDay = :weekDay")
    , @NamedQuery(name = "Scheduleentity.findByWeekNumber", query = "SELECT s FROM Scheduleentity s WHERE s.weekNumber = :weekNumber")
    , @NamedQuery(name = "Scheduleentity.findByYearNumber", query = "SELECT s FROM Scheduleentity s WHERE s.yearNumber = :yearNumber")
    , @NamedQuery(name = "Scheduleentity.findByEmployee", query = "SELECT s FROM Scheduleentity s WHERE s.employee = :employee")
    , @NamedQuery(name = "Scheduleentity.findByPass", query = "SELECT s FROM Scheduleentity s WHERE s.pass = :pass")
    , @NamedQuery(name = "Scheduleentity.findByBooked", query = "SELECT s FROM Scheduleentity s WHERE s.booked = :booked")})
public class Scheduleentity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 10)
    @Column(name = "WEEK_DAY")
    private String weekDay;
    @Column(name = "WEEK_NUMBER")
    private Integer weekNumber;
    @Column(name = "YEAR_NUMBER")
    private Integer yearNumber;
    @Size(max = 50)
    @Column(name = "EMPLOYEE")
    private String employee;
    @Size(max = 10)
    @Column(name = "PASS")
    private String pass;
    @Column(name = "BOOKED")
    private Boolean booked;

    public Scheduleentity() {
    }

    public Scheduleentity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public Integer getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(Integer weekNumber) {
        this.weekNumber = weekNumber;
    }

    public Integer getYearNumber() {
        return yearNumber;
    }

    public void setYearNumber(Integer yearNumber) {
        this.yearNumber = yearNumber;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Boolean getBooked() {
        return booked;
    }

    public void setBooked(Boolean booked) {
        this.booked = booked;
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
        if (!(object instanceof Scheduleentity)) {
            return false;
        }
        Scheduleentity other = (Scheduleentity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "service.Scheduleentity[ id=" + id + " ]";
    }
    
}
