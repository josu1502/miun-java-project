package com.miun.appguestbook.josu1502.appguestbook.rest;

import org.simpleframework.xml.Root;

/**
 * Created by Joakim on 17-02-16.
 */

public class LunchEntity {
    private Long id;
    private String lunchday;
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

    public void setLunchday(String lunchday) {
        this.lunchday = lunchday;
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
}
