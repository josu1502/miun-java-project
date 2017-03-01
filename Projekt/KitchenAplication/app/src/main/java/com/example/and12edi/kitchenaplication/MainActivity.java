package com.example.and12edi.kitchenaplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.and12edi.kitchenaplication.rest.OrderClient;
import com.example.and12edi.kitchenaplication.rest.OrderEntities;
import com.example.and12edi.kitchenaplication.rest.OrderEntity;
import com.example.and12edi.kitchenaplication.rest.OrderStatusListener;

public class MainActivity extends AppCompatActivity implements OrderStatusListener{
    OrderClient orderClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String currentURL = "10.250.116.148:8080/AntonsHemsida/webresources/";  //Andreas IP-adress
        orderClient = new OrderClient("currentURL");
        orderClient.setStatusListener(this);
        orderClient.fetchOrderList();
    }

    @Override
    public void orderListRecived(OrderEntities oe) {
        Integer i = 0;
        Integer listlength = oe.orderEntities.size();
        TableRow tableRow = new TableRow(this);

            OrderEntity orderEntity = new OrderEntity();
            orderEntity = oe.orderEntities.get(i);
            TextView textView;
            textView = (TextView) findViewById(R.id.textView15);
            textView.setText(orderEntity.getTableNr());





    }

    @Override
    public void orderUpdated() {

    }
}
