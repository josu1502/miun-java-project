package com.example.and12edi.kitchenaplication;

import android.view.View;

import com.example.and12edi.kitchenaplication.rest.OrderEntity;

import static com.example.and12edi.kitchenaplication.MainActivity.orderClient;
import static com.example.and12edi.kitchenaplication.MainActivity.tl;

/**
 * Created by Mvangman on 2017-03-02.
 */
public class deleteRow implements View.OnClickListener {
    OrderEntity deleteThis;

    public deleteRow(OrderEntity orderEntity) {
        deleteThis = orderEntity;
    }

    @Override
    public void onClick(View v) {
        orderClient.deleteOrder(deleteThis);
        tl.removeAllViews();
        orderClient.fetchOrderList();
    }
}
