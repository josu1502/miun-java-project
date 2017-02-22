package com.example.matti.schemaapplikation;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static Integer weekNumber, yearNumber;
    public static Calendar cal;
    public static TextView weekText, monL, monM, tueL, tueM, wedL, wedM, thuL, thuM, friL, friM, satL, satM, sunL, sunM;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Import textview to display current week*/
        weekText = (TextView)findViewById(R.id.weekText);

        /*Import textviews to add dates to*/
        monL = (TextView) findViewById(R.id.monL);
        monM = (TextView) findViewById(R.id.monM);
        tueL = (TextView) findViewById(R.id.tuesL);
        tueM = (TextView) findViewById(R.id.tuesM);
        wedL = (TextView) findViewById(R.id.wedsL);
        wedM = (TextView) findViewById(R.id.wedsM);
        thuL = (TextView) findViewById(R.id.thursL);
        thuM = (TextView) findViewById(R.id.thursM);
        friL = (TextView) findViewById(R.id.friL);
        friM = (TextView) findViewById(R.id.friM);
        satL = (TextView) findViewById(R.id.satL);
        satM = (TextView) findViewById(R.id.satM);
        sunL = (TextView) findViewById(R.id.sunL);
        sunM = (TextView) findViewById(R.id.sunM);

        /*Import views to add onclick listeners to*/
        View monLView = (View) findViewById(R.id.monLView);
        View monMView = (View) findViewById(R.id.monMView);
        View tueLView = (View) findViewById(R.id.tuesLView);
        View tueMView = (View) findViewById(R.id.tuesMView);
        View wedLView = (View) findViewById(R.id.wedsLView);
        View wedMView = (View) findViewById(R.id.wedsMView);
        View thuLView = (View) findViewById(R.id.thursLView);
        View thuMView = (View) findViewById(R.id.thursMView);
        View friLView = (View) findViewById(R.id.friLView);
        View friMView = (View) findViewById(R.id.friMView);
        View satLView = (View) findViewById(R.id.satLView);
        View satMView = (View) findViewById(R.id.satMView);
        View sunLView = (View) findViewById(R.id.sunLView);
        View sunMView = (View) findViewById(R.id.sunMView);

        /*Set current week and year*/
        weekText = (TextView) findViewById(R.id.weekText);
        cal = Calendar.getInstance(Locale.GERMAN);
        weekNumber = cal.get(Calendar.WEEK_OF_YEAR);
        yearNumber = cal.get(Calendar.YEAR);

        /*Update view dates first time*/
        final UpdateDateByWeek ud = new UpdateDateByWeek();
        ud.run();

        /*Buttons to change week*/
        Button weekMinus = (Button) findViewById(R.id.weekMinus);
        Button weekPlus = (Button) findViewById(R.id.weekPlus);
        weekMinus.setOnClickListener(new DecreaseWeek());
        weekPlus.setOnClickListener(new IncreaseWeek());

        /*Set on click listeners for views*/
        monLView.setOnClickListener(new AddWork("monday", "lunch"));
        monMView.setOnClickListener(new AddWork("monday", "middag"));
        tueLView.setOnClickListener(new AddWork("thuesday", "lunch"));
        tueMView.setOnClickListener(new AddWork("thuesday", "middag"));
        wedLView.setOnClickListener(new AddWork("wednesday", "lunch"));
        wedMView.setOnClickListener(new AddWork("wednesday", "middag"));
        thuLView.setOnClickListener(new AddWork("thursday", "lunch"));
        thuMView.setOnClickListener(new AddWork("thursday", "middag"));
        friLView.setOnClickListener(new AddWork("friday", "lunch"));
        friMView.setOnClickListener(new AddWork("friday", "middag"));
        satLView.setOnClickListener(new AddWork("saturday", "lunch"));
        satMView.setOnClickListener(new AddWork("saturday", "middag"));
        sunLView.setOnClickListener(new AddWork("sunday", "lunch"));
        sunMView.setOnClickListener(new AddWork("sunday", "middag"));


    }

}
