package com.example.and12edi.kitchenaplication;

import com.example.and12edi.kitchenaplication.rest.OrderEntity;

import java.util.Comparator;

/**
 * Created by Mvangman on 2017-03-06.
 */

public class TimeComparator implements Comparator<OrderEntity>{

    @Override
    public int compare(OrderEntity o1, OrderEntity o2) {
        return o1.getOrderTime().compareToIgnoreCase(o2.getOrderTime());
    }
}
