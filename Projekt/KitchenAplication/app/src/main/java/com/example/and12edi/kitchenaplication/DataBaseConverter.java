package com.example.and12edi.kitchenaplication;

import com.example.and12edi.kitchenaplication.rest.OrderEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mvangman on 2017-03-04.
 */

public class DataBaseConverter {
    private List<OrderEntity> orderList;
    private List<OrderEntity> finishedOrders;
    private List<OrderEntity> unfinishedOrders;


    DataBaseConverter(List<OrderEntity> oe){
        this.orderList = oe;
        finishedOrders = new ArrayList<>();
        unfinishedOrders = new ArrayList<>();

        for(int i = 0; i < oe.size(); i++){
            if(oe.get(i).getFinished()){
                finishedOrders.add(oe.get(i));
            } else{
                unfinishedOrders.add(oe.get(i));
            }
        }
    }

    public List<OrderEntity> getOrderList() {
        return orderList;
    }

    public List<OrderEntity> getFinishedOrders() {
        return finishedOrders;
    }

    public List<OrderEntity> getUnfinishedOrders() {
        return unfinishedOrders;
    }
}
