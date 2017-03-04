package com.example.and12edi.kitchenaplication;

import android.view.View;

import com.example.and12edi.kitchenaplication.rest.OrderEntity;


import static com.example.and12edi.kitchenaplication.MainActivity.finishedTable;
import static com.example.and12edi.kitchenaplication.MainActivity.orderClient;
import static com.example.and12edi.kitchenaplication.MainActivity.unFinishedTable;


/**
 * Created by Mvangman on 2017-03-02.
 */
public class EditRow implements View.OnClickListener {

    OrderEntity editThis;

    public EditRow(OrderEntity orderEntity) {

        editThis = orderEntity;
    }

    @Override
    public void onClick(View v) {
        editThis.setFinished(true);
        orderClient.updateOrder(editThis);
        unFinishedTable.removeAllViews();
        finishedTable.removeAllViews();
        orderClient.fetchOrderList();
    }
}
