package com.example.and12edi.kitchenaplication.rest;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "orderEntities")
public class OrderEntities {
    @ElementList(entry="orderEntity", inline=true)
    public List<OrderEntity> orderEntity;
}
