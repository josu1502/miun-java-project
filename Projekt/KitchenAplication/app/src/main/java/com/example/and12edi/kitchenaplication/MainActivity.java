package com.example.and12edi.kitchenaplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.and12edi.kitchenaplication.rest.OrderClient;
import com.example.and12edi.kitchenaplication.rest.OrderEntities;
import com.example.and12edi.kitchenaplication.rest.OrderEntity;
import com.example.and12edi.kitchenaplication.rest.OrderStatusListener;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OrderStatusListener{
    public static OrderClient orderClient;
    List<OrderEntity> orderList;
    public static TableLayout tl;

    //private OrderEntities order;
   @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        orderClient = new OrderClient("http://10.250.121.182:8080/AntonsHemsida/webresources/"); //Alex ip
        orderClient.setStatusListener(this);
        orderClient.fetchOrderList();

    }

   @Override
    public void orderListRecived(OrderEntities oe) {

       orderList = oe.orderEntities;
       System.out.println(orderList.size());
       tl = (TableLayout) findViewById(R.id.tableLayout);

       TableRow tableRowTitle = new TableRow(this);
       TextView bord = new TextView(this);
       bord.setText("Bord");
       bord.setTextSize(24);
       TextView course = new TextView(this);
       course.setText("Förrätt/Varmrätt");
       course.setTextSize(24);
       TextView meal = new TextView(this);
       meal.setText("Maträtt");
       meal.setTextSize(24);
       TextView antal = new TextView(this);
       antal.setText("Antal");
       antal.setTextSize(24);
       TextView tid = new TextView(this);
       tid.setText("Tid");
       tid.setTextSize(24);
       TextView status = new TextView(this);
       status.setText("Status");
       status.setTextSize(24);
       tableRowTitle.addView(bord);
       tableRowTitle.addView(course);
       tableRowTitle.addView(meal);
       tableRowTitle.addView(antal);
       tableRowTitle.addView(tid);
       tableRowTitle.addView(status);
       tl.addView(tableRowTitle);

        for(int i = 0; i <orderList.size(); i++) {
            TableRow tableRow = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            tableRow.setLayoutParams(lp);

            TextView tableNumber = new TextView(this);
            tableNumber.setText(oe.orderEntities.get(i).getTableNr().toString());
            TextView courseType = new TextView(this);
            courseType.setText(oe.orderEntities.get(i).getCourseType());
            TextView courseName = new TextView(this);
            courseName.setText(oe.orderEntities.get(i).getCourseName());
            TextView amount = new TextView(this);
            amount.setText(oe.orderEntities.get(i).getAmount().toString());
            TextView time = new TextView(this);
            time.setText(oe.orderEntities.get(i).getOrderTime().toString());

            Button done = new Button(this);
            done.setText("klar");

            done.setOnClickListener(new deleteRow(oe.orderEntities.get(i)));

            tableRow.addView(tableNumber);
            tableRow.addView(courseType);
            tableRow.addView(courseName);
            tableRow.addView(amount);
            tableRow.addView(time);
            tableRow.addView(done);
            tl.addView(tableRow);
        }



    }

    @Override
    public void orderUpdated() {

    }
}
