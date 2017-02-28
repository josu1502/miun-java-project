package com.example.matti.schemaapplikation.rest;

import org.simpleframework.xml.Root;

/**
 * Created by Joakim on 17-02-16.
 */

public class SchemaEntity {
    private Long id;
    private String week_day;
    private Integer week_number;
    private Integer year_number;
    private String employee_name;
    private String pass;
    private Boolean booked;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeek_day() {
        return week_day;
    }

    public void setWeek_day(String week_day) {
        this.week_day = week_day;
    }

    public Integer getWeek_number() {
        return week_number;
    }

    public void setWeek_number(Integer week_number) {
        this.week_number = week_number;
    }

    public Integer getYear_number() {
        return year_number;
    }

    public void setYear_number(Integer year_number) {
        this.year_number = year_number;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
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
}
