package com.example.matti.schemaapplikation;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.matti.schemaapplikation.rest.SchemaClient;
import com.example.matti.schemaapplikation.rest.SchemaEntities;
import com.example.matti.schemaapplikation.rest.SchemaStatusListener;

import java.util.Calendar;
import java.util.Locale;

import static com.example.matti.schemaapplikation.AddShiftActivity.adapter;

public class MainActivity extends AppCompatActivity  implements SchemaStatusListener, Runnable {

    public static SchemaClient schemaClient;
    public static String day, pass;
    public static Integer weekNumber, yearNumber;
    public static Calendar cal;
    public static TextView weekText, monDate, tuesDate, wedsDate, thursDate, friDate, satDate, sunDate; /*Date text*/
    public static TextView monLunch, tuesLunch, wedsLunch, thursLunch, friLunch, satLunch, sunLunch; /*Lunch text*/
    public static TextView monDinner, tuesDinner, wedsDinner, thursDinner, friDinner, satDinner, sunDinner; /*Dinner text*/
    public static SchemaList schemaList;

    public static Boolean addShiftActivityRunning = false;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //schemaClient = new SchemaClient("http://192.168.43.80:8080/AntonsHemsida/webresources/"); /* Jocke mobil IP: */
        //schemaClient = new SchemaClient("http://10.250.115.39:8080/AntonsHemsida/webresources/"); /* Jocke skola IP: */
        schemaClient = new SchemaClient("http://192.168.43.80:8080/AntonsHemsida/webresources/"); /* Jocke hemma IP: */
        schemaClient.setStatusListener(this);
        schemaClient.fetchSchemaList();
        (new Thread(new MainActivity())).start();

        /*Import textview to display current week*/
        weekText = (TextView)findViewById(R.id.weekText);

        /*Import textviews to add dates to*/
        monDate = (TextView) findViewById(R.id.monDate);
        tuesDate = (TextView) findViewById(R.id.tuesDate);
        wedsDate = (TextView) findViewById(R.id.wedsDate);
        thursDate = (TextView) findViewById(R.id.thursDate);
        friDate = (TextView) findViewById(R.id.friDate);
        satDate = (TextView) findViewById(R.id.satDate);
        sunDate = (TextView) findViewById(R.id.sunDate);

        /*Import textviews to add lunch pass to*/
        monLunch = (TextView) findViewById(R.id.monLunchText);
        tuesLunch = (TextView) findViewById(R.id.tuesLunchText);
        wedsLunch = (TextView) findViewById(R.id.wedsLunchText);
        thursLunch = (TextView) findViewById(R.id.thursLunchText);
        friLunch = (TextView) findViewById(R.id.friLunchText);
        satLunch = (TextView) findViewById(R.id.satLunchText);
        sunLunch = (TextView) findViewById(R.id.sunLunchText);

        /*Import textviews to add dinner pass to*/
        monDinner = (TextView) findViewById(R.id.monDinnerText);
        tuesDinner = (TextView) findViewById(R.id.tuesDinnerText);
        wedsDinner = (TextView) findViewById(R.id.wedsDinnerText);
        thursDinner = (TextView) findViewById(R.id.thursDinnerText);
        friDinner = (TextView) findViewById(R.id.friDinnerText);
        satDinner = (TextView) findViewById(R.id.satDinnerText);
        sunDinner = (TextView) findViewById(R.id.sunDinnerText);

        /*Import views to add onclick listeners to*/
        View monAddLunch = (View) findViewById(R.id.monLunchView);
        View tuesAddLunch = (View) findViewById(R.id.tuesLunchView);
        View wedsAddLunch = (View) findViewById(R.id.wedsLunchView);
        View thursAddLunch = (View) findViewById(R.id.thursLunchView);
        View friAddLunch = (View) findViewById(R.id.friLunchView);
        View satAddLunch = (View) findViewById(R.id.satLunchView);
        View sunAddLunch = (View) findViewById(R.id.sunLunchView);

        View monAddDinner = (View) findViewById(R.id.monDinnerView);
        View tuesAddDinner = (View) findViewById(R.id.tuesDinnerView);
        View wedsAddDinner = (View) findViewById(R.id.wedsDinnerView);
        View thursAddDinner = (View) findViewById(R.id.thursDinnerView);
        View friAddDinner = (View) findViewById(R.id.friDinnerView);
        View satAddDinner = (View) findViewById(R.id.satDinnerView);
        View sunAddDinner = (View) findViewById(R.id.sunDinnerView);

        /*Set on click listeners for views*/
        monAddLunch.setOnClickListener(new AddShift("Måndag", "Lunch"));
        tuesAddLunch.setOnClickListener(new AddShift("Tisdag", "Lunch"));
        wedsAddLunch.setOnClickListener(new AddShift("Onsdag", "Lunch"));
        thursAddLunch.setOnClickListener(new AddShift("Torsdag", "Lunch"));
        friAddLunch.setOnClickListener(new AddShift("Fredag", "Lunch"));
        satAddLunch.setOnClickListener(new AddShift("Lördag", "Lunch"));
        sunAddLunch.setOnClickListener(new AddShift("Söndag", "Lunch"));

        monAddDinner.setOnClickListener(new AddShift("Måndag", "Middag"));
        tuesAddDinner.setOnClickListener(new AddShift("Tisdag", "Middag"));
        wedsAddDinner.setOnClickListener(new AddShift("Onsdag", "Middag"));
        thursAddDinner.setOnClickListener(new AddShift("Torsdag", "Middag"));
        friAddDinner.setOnClickListener(new AddShift("Fredag", "Middag"));
        satAddDinner.setOnClickListener(new AddShift("Lördag", "Middag"));
        sunAddDinner.setOnClickListener(new AddShift("Söndag", "Middag"));

        /*Set current week and year*/
        weekText = (TextView) findViewById(R.id.weekText);
        cal = Calendar.getInstance(Locale.GERMAN); /*Set it the german to get sunday as last day*/
        weekNumber = cal.get(Calendar.WEEK_OF_YEAR);
        yearNumber = cal.get(Calendar.YEAR);

        /*Update view dates first time*/
        final UpdateDateByWeek ud = new UpdateDateByWeek();
        ud.run();

        /*Buttons to change week*/
        ImageButton weekMinus = (ImageButton) findViewById(R.id.weekMinus);
        ImageButton weekPlus = (ImageButton) findViewById(R.id.weekPlus);
        weekMinus.setOnClickListener(new DecreaseWeek());
        weekPlus.setOnClickListener(new IncreaseWeek());
    }

    @Override
    public void schemaListRecived(SchemaEntities se)  {
        System.out.println("Uppkoppling/Updatering till databasen lyckad.");

        schemaList = new SchemaList(se.schemaEntity);
        if (addShiftActivityRunning) {
            schemaList.getTables(day, pass, weekNumber, yearNumber);
        }

        /*Fyller lista med allt från databasen*/
        monLunch.setText(schemaList.getDay("Måndag", "Lunch", weekNumber, yearNumber));
        tuesLunch.setText(schemaList.getDay("Tisdag", "Lunch", weekNumber, yearNumber));
        wedsLunch.setText(schemaList.getDay("Onsdag", "Lunch", weekNumber, yearNumber));
        thursLunch.setText(schemaList.getDay("Torsdag", "Lunch", weekNumber, yearNumber));
        friLunch.setText(schemaList.getDay("Fredag", "Lunch", weekNumber, yearNumber));
        satLunch.setText(schemaList.getDay("Lördag", "Lunch", weekNumber, yearNumber));
        sunLunch.setText(schemaList.getDay("Söndag", "Lunch", weekNumber, yearNumber));

        monDinner.setText(schemaList.getDay("Måndag", "Middag", weekNumber, yearNumber));
        tuesDinner.setText(schemaList.getDay("Tisdag", "Middag", weekNumber, yearNumber));
        wedsDinner.setText(schemaList.getDay("Onsdag", "Middag", weekNumber, yearNumber));
        thursDinner.setText(schemaList.getDay("Torsdag", "Middag", weekNumber, yearNumber));
        friDinner.setText(schemaList.getDay("Fredag", "Middag", weekNumber, yearNumber));
        satDinner.setText(schemaList.getDay("Lördag", "Middag", weekNumber, yearNumber));
        sunDinner.setText(schemaList.getDay("Söndag", "Middag", weekNumber, yearNumber));
    }

    @Override
    public void schemaUpdated() {

    }

    @Override
    public void run() {
        while(true) {
            //android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
            schemaClient.fetchSchemaList();

            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class AddShift implements View.OnClickListener {
        private String shiftDay, shiftPass;

        public AddShift(String d, String p) {
            this.shiftDay = d;
            this.shiftPass = p;
        }

        @Override
        public void onClick(View v) {
            day = this.shiftDay;
            pass = this.shiftPass;

            /*Updaterar dagen som skall visas i nästa activity*/
            switch(day) {
                case "Måndag":
                    cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                    break;
                case "Tisdag":
                    cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                    break;
                case "Onsdag":
                    cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                    break;
                case "Torsdag":
                    cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                    break;
                case "Fredag":
                    cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                    break;
                case "Lördag":
                    cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
                    break;
                case "Söndag":
                    cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                    break;
            }

            startActivity(new Intent(MainActivity.this, AddShiftActivity.class));
        }
    }
}
