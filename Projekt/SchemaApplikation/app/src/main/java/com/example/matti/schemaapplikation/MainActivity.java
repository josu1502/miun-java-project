package com.example.matti.schemaapplikation;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static String day, pass;
    public static Integer weekNumber, yearNumber;
    public static Calendar cal;
    public static TextView weekText, monDate, tuesDate, wedsDate, thursDate, friDate, satDate, sunDate;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        View sunAddDinner = (View) findViewById(R.id.satDinnerView);

        /*Set on click listeners for views*/
        monAddLunch.setOnClickListener(new AddLunchShift("Måndag", "Lunch"));
        tuesAddLunch.setOnClickListener(new AddLunchShift("Tisdag", "Lunch"));
        wedsAddLunch.setOnClickListener(new AddLunchShift("Onsdag", "Lunch"));
        thursAddLunch.setOnClickListener(new AddLunchShift("Torsdag", "Lunch"));
        friAddLunch.setOnClickListener(new AddLunchShift("Fredag", "Lunch"));
        satAddLunch.setOnClickListener(new AddLunchShift("Lördag", "Lunch"));
        sunAddLunch.setOnClickListener(new AddLunchShift("Söndag", "Lunch"));

        monAddDinner.setOnClickListener(new AddLunchShift("Måndag", "Middag"));
        tuesAddDinner.setOnClickListener(new AddLunchShift("Tisdag", "Middag"));
        wedsAddDinner.setOnClickListener(new AddLunchShift("Onsdag", "Middag"));
        thursAddDinner.setOnClickListener(new AddLunchShift("Torsdag", "Middag"));
        friAddDinner.setOnClickListener(new AddLunchShift("Fredag", "Middag"));
        satAddDinner.setOnClickListener(new AddLunchShift("Lördag", "Middag"));
        sunAddDinner.setOnClickListener(new AddLunchShift("Söndag", "Middag"));

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

    private class AddLunchShift implements View.OnClickListener {
        public AddLunchShift(String d, String p) {
            day = d;
            pass = p;
        }

        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, AddShiftActivity.class));
        }
    }
}
