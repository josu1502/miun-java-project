package com.example.matti.schemaapplikation;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static String day, pass;
    public static Integer weekNumber, yearNumber;
    public static Calendar cal;
    public static TextView weekText, monL, monM, tueL, tueM, wedL, wedM, thuL, thuM, friL, friM,
            satL, satM, sunL, sunM;

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
        ImageButton weekMinus = (ImageButton) findViewById(R.id.weekMinus);
        ImageButton weekPlus = (ImageButton) findViewById(R.id.weekPlus);
        weekMinus.setOnClickListener(new DecreaseWeek());
        weekPlus.setOnClickListener(new IncreaseWeek());

        /*Set on click listeners for views*/
        monLView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day = "Måndag";
                pass = "Lunch";
                System.out.println("Dag: " + day + " Pass: " + pass + " Vecka: " + weekNumber + " År: " + yearNumber);
                startActivity(new Intent(MainActivity.this, AddShiftActivity.class));
            }
        });
        monMView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day = "Måndag";
                pass = "Middag";
                System.out.println("Dag: " + day + " Pass: " + pass + " Vecka: " + weekNumber + " År: " + yearNumber);
                startActivity(new Intent(MainActivity.this, AddShiftActivity.class));
            }
        });
        tueLView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day = "Tisdag";
                pass = "Lunch";
                System.out.println("Dag: " + day + " Pass: " + pass + " Vecka: " + weekNumber + " År: " + yearNumber);
                startActivity(new Intent(MainActivity.this, AddShiftActivity.class));
            }
        });
        tueMView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day = "Tisdag";
                pass = "Middag";
                System.out.println("Dag: " + day + " Pass: " + pass + " Vecka: " + weekNumber + " År: " + yearNumber);
                startActivity(new Intent(MainActivity.this, AddShiftActivity.class));
            }
        });
        wedLView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day = "Onsdag";
                pass = "Lunch";
                System.out.println("Dag: " + day + " Pass: " + pass + " Vecka: " + weekNumber + " År: " + yearNumber);
                startActivity(new Intent(MainActivity.this, AddShiftActivity.class));
            }
        });
        wedMView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day = "Onsdag";
                pass = "Middag";
                System.out.println("Dag: " + day + " Pass: " + pass + " Vecka: " + weekNumber + " År: " + yearNumber);
                startActivity(new Intent(MainActivity.this, AddShiftActivity.class));
            }
        });
        thuLView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day = "Torsdag";
                pass = "Lunch";
                System.out.println("Dag: " + day + " Pass: " + pass + " Vecka: " + weekNumber + " År: " + yearNumber);
                startActivity(new Intent(MainActivity.this, AddShiftActivity.class));
            }
        });
        thuMView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day = "Torsdag";
                pass = "Middag";
                System.out.println("Dag: " + day + " Pass: " + pass + " Vecka: " + weekNumber + " År: " + yearNumber);
                startActivity(new Intent(MainActivity.this, AddShiftActivity.class));
            }
        });
        friLView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day = "Fredag";
                pass = "Lunch";
                System.out.println("Dag: " + day + " Pass: " + pass + " Vecka: " + weekNumber + " År: " + yearNumber);
                startActivity(new Intent(MainActivity.this, AddShiftActivity.class));
            }
        });
        friMView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day = "Fredag";
                pass = "Middag";
                System.out.println("Dag: " + day + " Pass: " + pass + " Vecka: " + weekNumber + " År: " + yearNumber);
                startActivity(new Intent(MainActivity.this, AddShiftActivity.class));
            }
        });
        satLView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day = "Lördag";
                pass = "Lunch";
                System.out.println("Dag: " + day + " Pass: " + pass + " Vecka: " + weekNumber + " År: " + yearNumber);
                startActivity(new Intent(MainActivity.this, AddShiftActivity.class));
            }
        });
        satMView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day = "Lördag";
                pass = "Middag";
                System.out.println("Dag: " + day + " Pass: " + pass + " Vecka: " + weekNumber + " År: " + yearNumber);
                startActivity(new Intent(MainActivity.this, AddShiftActivity.class));
            }
        });
        sunLView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day = "Söndag";
                pass = "Lunch";
                System.out.println("Dag: " + day + " Pass: " + pass + " Vecka: " + weekNumber + " År: " + yearNumber);
                startActivity(new Intent(MainActivity.this, AddShiftActivity.class));
            }
        });
        sunMView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day = "Söndag";
                pass = "Middag";
                System.out.println("Dag: " + day + " Pass: " + pass + " Vecka: " + weekNumber + " År: " + yearNumber);
                startActivity(new Intent(MainActivity.this, AddShiftActivity.class));
            }
        });
    }
}
