package com.example.and12edi.kitchenaplication;

import com.example.and12edi.kitchenaplication.rest.OrderEntity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static com.example.and12edi.kitchenaplication.MainActivity.orderClient;

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
        Collections.sort(orderList, new TimeComparator());
        Collections.sort(finishedOrders, new TimeComparator());
        Collections.sort(unfinishedOrders, new TimeComparator());
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
