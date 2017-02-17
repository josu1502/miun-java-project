package com.miun.appguestbook.josu1502.appguestbook.rest;

import org.simpleframework.xml.Root;

/**
 * Created by Joakim on 17-02-16.
 */

public class LunchEntity {
    Long id;
    String lunchday;
    String name;
    String description;
    Integer price;

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
}
