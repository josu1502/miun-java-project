package com.example.and12edi.kitchenaplication.rest;

import java.sql.Time;

/**
 * Created by Mvangman on 2017-03-01.
 */

public class OrderEntity {
    private long id;
    private Integer tableNr;
    private String orderTime;
    private String courseName;
    private String courseType;
    private Integer amount;
    private Boolean finished;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getTableNr() {
        return tableNr;
    }

    public void setTableNr(Integer tableNr) {
        this.tableNr = tableNr;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }
}
