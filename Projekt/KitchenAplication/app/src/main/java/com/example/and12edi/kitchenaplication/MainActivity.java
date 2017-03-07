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
    public static List<OrderEntity> orderList;
    TabLayout tabLayout;



    public static TableLayout unFinishedTable;
    public static TableLayout finishedTable;
    public static DataBaseConverter dbConverter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
        orderClient = new OrderClient("http://10.250.111.29:8080/AntonsHemsida/webresources/");
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
        TextView antal = new TextView(this);
        antal.setText("Antal");
        antal.setTextSize(18);
        antal.setTypeface(null, Typeface.BOLD);
        tableRowTitle.addView(antal);

        TextView meal = new TextView(this);
        meal.setText("Maträtt");
        meal.setTextSize(18);
        meal.setTypeface(null, Typeface.BOLD);
        tableRowTitle.addView(meal);

        TextView course = new TextView(this);
        course.setText("Måltid");
        course.setTextSize(18);
        course.setTypeface(null, Typeface.BOLD);
        tableRowTitle.addView(course);

        TextView tid = new TextView(this);
        tid.setText("Tid");
        tid.setTextSize(18);
        tid.setTypeface(null, Typeface.BOLD);
        tableRowTitle.addView(tid);

        TextView bord = new TextView(this);
        bord.setText("Bord");
        bord.setTypeface(null, Typeface.BOLD);
        bord.setTextSize(18);
        tableRowTitle.addView(bord);


        TextView status = new TextView(this);
        status.setText("Status");
        status.setTextSize(18);
        status.setTypeface(null, Typeface.BOLD);
        tableRowTitle.addView(status);

        unFinishedTable.addView(tableRowTitle);

        dbConverter = new DataBaseConverter(oe.orderEntities);
        List<OrderEntity> unfinishedOrders = dbConverter.getUnfinishedOrders();

        /*skapar tabell för ej färdiga ordrar*/
        for (int i = 0; i < unfinishedOrders.size(); i++) {
            /*skapar en ny tablerow för att lägga in en tupel från databasen*/
            TableRow tableRow = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            tableRow.setLayoutParams(lp);

            /*skapar nya textviews och en knapp för att dela upp attributen från tupeln som sedan läggs in i en ny tablerow*/
            TextView amount = new TextView(this);
            amount.setText(unfinishedOrders.get(i).getAmount().toString() + "st");
            amount.setTextSize(16);
            tableRow.addView(amount);

            TextView courseName = new TextView(this);
            courseName.setText(unfinishedOrders.get(i).getCourseName());
            courseName.setTextSize(16);
            tableRow.addView(courseName);

            TextView courseType = new TextView(this);
            courseType.setText(unfinishedOrders.get(i).getCourseType());
            courseType.setTextSize(16);
            tableRow.addView(courseType);

            TextView time = new TextView(this);
            time.setText(unfinishedOrders.get(i).getOrderTime().toString());
            time.setTextSize(16);
            tableRow.addView(time);

            TextView tableNumber = new TextView(this);
            tableNumber.setText("Bord " + unfinishedOrders.get(i).getTableNr().toString());
            tableNumber.setTextSize(16);
            tableRow.addView(tableNumber);

            Button done = new Button(this);
            done.setText("klar");
            done.setOnClickListener(new EditRow(unfinishedOrders.get(i)));
            done.setBackgroundColor(Color.parseColor("#31b327"));
            done.setTextColor(Color.WHITE);
            tableRow.addView(done);

            /*Lägger in en tablerow som sedan stoppas in i tablelayouten*/
            unFinishedTable.addView(tableRow);
        }


        List<OrderEntity> finishedOrders = dbConverter.getFinishedOrders();
        TableRow rowTitle = new TableRow(this);

        TextView mealAmount = new TextView(this);
        mealAmount.setText("Antal");
        mealAmount.setTextSize(18);
        mealAmount.setTypeface(null, Typeface.BOLD);
        rowTitle.addView(mealAmount);

        TextView mealType = new TextView(this);
        mealType.setText("Maträtt");
        mealType.setTextSize(18);
        mealType.setTypeface(null, Typeface.BOLD);
        rowTitle.addView(mealType);

        TextView type = new TextView(this);
        type.setText("Måltid");
        type.setTextSize(18);
        type.setTypeface(null, Typeface.BOLD);
        rowTitle.addView(type);

        TextView orderTime = new TextView(this);
        orderTime.setText("Tid");
        orderTime.setTextSize(18);
        orderTime.setTypeface(null, Typeface.BOLD);
        rowTitle.addView(orderTime);

        TextView table = new TextView(this);
        table.setText("Bord");
        table.setTextSize(18);
        table.setTypeface(null, Typeface.BOLD);
        rowTitle.addView(table);

        finishedTable.addView(rowTitle);

        /*skapar tabell för ej färdiga ordrar*/
        for (int i = 0; i < finishedOrders.size(); i++) {
            /*skapar en ny tablerow för att lägga in en tupel från databasen*/
            TableRow tableRow = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            tableRow.setLayoutParams(lp);

            /*skapar nya textviews och en knapp för att dela upp attributen från tupeln som sedan läggs in i en ny tablerow*/
            TextView tableNumber = new TextView(this);

            TextView amount = new TextView(this);
            amount.setText(finishedOrders.get(i).getAmount().toString() + "st");
            amount.setTextSize(16);
            tableRow.addView(amount);

            TextView courseName = new TextView(this);
            courseName.setText(finishedOrders.get(i).getCourseName());
            courseName.setTextSize(16);
            tableRow.addView(courseName);

            TextView courseType = new TextView(this);
            courseType.setText(finishedOrders.get(i).getCourseType());
            courseType.setTextSize(16);
            tableRow.addView(courseType);

            TextView time = new TextView(this);
            time.setText(finishedOrders.get(i).getOrderTime().toString());
            time.setTextSize(16);
            tableRow.addView(time);

            tableNumber.setText("Bord " + finishedOrders.get(i).getTableNr().toString());
            tableNumber.setTextSize(16);
            tableRow.addView(tableNumber);

            /*Lägger in en tablerow som sedan stoppas in i tablelayouten*/
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
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}