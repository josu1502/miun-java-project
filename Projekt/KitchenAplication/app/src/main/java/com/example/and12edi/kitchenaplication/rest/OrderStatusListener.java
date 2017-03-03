package com.example.and12edi.kitchenaplication.rest;

/**
 * Created by Mvangman on 2017-03-01.
 */

public interface OrderStatusListener {
    void orderListRecived(OrderEntities oe);
    void orderUpdated();
}
