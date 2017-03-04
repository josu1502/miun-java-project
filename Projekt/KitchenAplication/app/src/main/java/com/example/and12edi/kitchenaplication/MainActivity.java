package com.example.and12edi.kitchenaplication;


import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.and12edi.kitchenaplication.rest.OrderClient;
import com.example.and12edi.kitchenaplication.rest.OrderEntities;
import com.example.and12edi.kitchenaplication.rest.OrderEntity;
import com.example.and12edi.kitchenaplication.rest.OrderStatusListener;

import java.util.List;

import layout.done.Delivered_Meals;
import layout.recived.Orders;
import layout.recived.Read_Orders;

import static layout.recived.Orders.fragView;

public class MainActivity extends AppCompatActivity implements OrderStatusListener {
    Toolbar toolbar;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    public static OrderClient orderClient;
    List<OrderEntity> orderList;
    TabLayout tabLayout;

    public static TableLayout tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);


        orderClient = new OrderClient("http://10.250.111.2:8080/AntonsHemsida/webresources/");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        orderClient.setStatusListener(this);
        orderClient.fetchOrderList();

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.view);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new Orders(),"Beställningar");
        viewPagerAdapter.addFragments(new Delivered_Meals(),"Färdiga");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(Color.WHITE, Color.WHITE);
        tabLayout.setSelectedTabIndicatorHeight(10);
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);
   }

    @Override
    public void orderListRecived(OrderEntities oe) {
        orderList = oe.orderEntities;
        System.out.println(orderList.size());
        tl = (TableLayout) fragView.findViewById(R.id.tableLayout2);

        TableRow tableRowTitle = new TableRow(this);
        TextView bord = new TextView(this);
        bord.setText("Bord");
        bord.setTypeface(null, Typeface.BOLD);
        bord.setTextSize(32);
        TextView course = new TextView(this);
        course.setText("Förrätt/Varmrätt");
        course.setTextSize(32);
        course.setTypeface(null, Typeface.BOLD);
        TextView meal = new TextView(this);
        meal.setText("Maträtt");
        meal.setTextSize(32);
        meal.setTypeface(null, Typeface.BOLD);
        TextView antal = new TextView(this);
        antal.setText("Antal");
        antal.setTextSize(32);
        antal.setTypeface(null, Typeface.BOLD);
        TextView tid = new TextView(this);
        tid.setText("Tid");
        tid.setTextSize(32);
        tid.setTypeface(null, Typeface.BOLD);
        TextView status = new TextView(this);
        status.setText("Status");
        status.setTextSize(32);
        status.setTypeface(null, Typeface.BOLD);
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
            tableNumber.setTextSize(20);
            TextView courseType = new TextView(this);
            courseType.setText(oe.orderEntities.get(i).getCourseType());
            courseType.setTextSize(20);
            TextView courseName = new TextView(this);
            courseName.setText(oe.orderEntities.get(i).getCourseName());
            courseName.setTextSize(20);
            TextView amount = new TextView(this);
            amount.setText(oe.orderEntities.get(i).getAmount().toString());
            TextView time = new TextView(this);
            time.setText(oe.orderEntities.get(i).getOrderTime().toString());
            amount.setTextSize(20);

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
