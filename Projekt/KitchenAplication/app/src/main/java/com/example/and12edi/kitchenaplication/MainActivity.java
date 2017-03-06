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

import java.util.Collections;
import java.util.List;

import layout.done.DeliveredMeals;
import layout.recived.Orders;

import static layout.done.DeliveredMeals.deliveredView;
import static layout.recived.Orders.fragView;

public class MainActivity extends AppCompatActivity implements OrderStatusListener, Runnable {
    Toolbar toolbar;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    public static OrderClient orderClient;
    List<OrderEntity> orderList;
    TabLayout tabLayout;

    public static TableLayout unFinishedTable;
    public static TableLayout finishedTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
        orderClient = new OrderClient("http://10.250.111.51:8080/AntonsHemsida/webresources/");
        orderClient.setStatusListener(this);
        (new Thread(MainActivity.this)).start();

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.view);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new Orders(),"Beställningar");
        viewPagerAdapter.addFragments(new DeliveredMeals(),"Färdiga");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(Color.WHITE, Color.WHITE);
        tabLayout.setSelectedTabIndicatorHeight(10);
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);
   }

    @Override
    public void orderListRecived(OrderEntities oe) {
        orderList = oe.orderEntities;
        unFinishedTable = (TableLayout) fragView.findViewById(R.id.tableLayout2);
        finishedTable = (TableLayout) deliveredView.findViewById(R.id.tableLayout);
        unFinishedTable.removeAllViews();
        finishedTable.removeAllViews();

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
        unFinishedTable.addView(tableRowTitle);

        DataBaseConverter dbConverter = new DataBaseConverter(oe.orderEntities);
        List<OrderEntity> unfinishedOrders = dbConverter.getUnfinishedOrders();

        /*skapar tabell för ej färdiga ordrar*/
        for(int i = 0; i <unfinishedOrders.size(); i++) {
            /*skapar en ny tablerow för att lägga in en tupel från databasen*/
            TableRow tableRow = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            tableRow.setLayoutParams(lp);

            /*skapar nya textviews och en knapp för att dela upp attributen från tupeln*/
            TextView tableNumber = new TextView(this);
            tableNumber.setText(unfinishedOrders.get(i).getTableNr().toString());
            tableNumber.setTextSize(20);
            TextView courseType = new TextView(this);
            courseType.setText(unfinishedOrders.get(i).getCourseType());
            courseType.setTextSize(20);
            TextView courseName = new TextView(this);
            courseName.setText(unfinishedOrders.get(i).getCourseName());
            courseName.setTextSize(20);
            TextView amount = new TextView(this);
            amount.setText(unfinishedOrders.get(i).getAmount().toString());
            TextView time = new TextView(this);
            time.setText(unfinishedOrders.get(i).getOrderTime().toString());
            amount.setTextSize(20);

            Button done = new Button(this);
            done.setText("klar");
            done.setOnClickListener(new EditRow(unfinishedOrders.get(i)));

            /*Lägger in textviews och knappen i en tablerow som sedan stoppas in i tablelayouten*/
            tableRow.addView(tableNumber);
            tableRow.addView(courseType);
            tableRow.addView(courseName);
            tableRow.addView(amount);
            tableRow.addView(time);
            tableRow.addView(done);
            unFinishedTable.addView(tableRow);
        }


        List<OrderEntity> finishedOrders = dbConverter.getFinishedOrders();

        TableRow rowTitle = new TableRow(this);
        TextView table = new TextView(this);
        table.setText("Bord");
        table.setTypeface(null, Typeface.BOLD);
        table.setTextSize(32);
        TextView type = new TextView(this);
        type.setText("Förrätt/Varmrätt");
        type.setTextSize(32);
        type.setTypeface(null, Typeface.BOLD);
        TextView meals = new TextView(this);
        meals.setText("Maträtt");
        meals.setTextSize(32);
        meals.setTypeface(null, Typeface.BOLD);
        TextView summa = new TextView(this);
        summa.setText("Antal");
        summa.setTextSize(32);
        summa.setTypeface(null, Typeface.BOLD);
        TextView tiden = new TextView(this);
        tiden.setText("Tid");
        tiden.setTextSize(32);
        tiden.setTypeface(null, Typeface.BOLD);
        rowTitle.addView(table);
        rowTitle.addView(type);
        rowTitle.addView(meals);
        rowTitle.addView(summa);
        rowTitle.addView(tiden);
        finishedTable.addView(rowTitle);

        /*skapar tabell för ej färdiga ordrar*/
        for(int i = 0; i <finishedOrders.size(); i++) {
            /*skapar en ny tablerow för att lägga in en tupel från databasen*/
            TableRow tableRow = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            tableRow.setLayoutParams(lp);

            /*skapar nya textviews och en knapp för att dela upp attributen från tupeln*/
            TextView tableNumber = new TextView(this);
            tableNumber.setText(finishedOrders.get(i).getTableNr().toString());
            tableNumber.setTextSize(20);
            TextView courseType = new TextView(this);
            courseType.setText(finishedOrders.get(i).getCourseType());
            courseType.setTextSize(20);
            TextView courseName = new TextView(this);
            courseName.setText(finishedOrders.get(i).getCourseName());
            courseName.setTextSize(20);
            TextView amount = new TextView(this);
            amount.setText(finishedOrders.get(i).getAmount().toString());
            TextView time = new TextView(this);
            time.setText(finishedOrders.get(i).getOrderTime().toString());
            amount.setTextSize(20);

            /*Lägger in textviews och knappen i en tablerow som sedan stoppas in i tablelayouten*/
            tableRow.addView(tableNumber);
            tableRow.addView(courseType);
            tableRow.addView(courseName);
            tableRow.addView(amount);
            tableRow.addView(time);
            finishedTable.addView(tableRow);
        }
    }

    @Override
    public void orderUpdated() {

    }

    @Override
    public void run() {
        while(true){
            orderClient.fetchOrderList();
            
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}