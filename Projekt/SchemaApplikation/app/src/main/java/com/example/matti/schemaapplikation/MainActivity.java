package com.example.matti.schemaapplikation;

import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button button3;
    Button button4;
    Integer weekNumber;
    TextView weekText;
    View mondayview;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            /*Sätter in nuvarande vecka*/
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
        weekText = (TextView) findViewById(R.id.weekText);
        Calendar cal = Calendar.getInstance();
        weekNumber = cal.get(Calendar.WEEK_OF_YEAR);
        String week = "Vecka " + weekNumber.toString();
        weekText.setText(week);


        button3 = (Button) findViewById(R.id.button3);
        button3.setText("<");
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(weekNumber != 1) {
                    weekNumber = weekNumber - 1;
                    weekText.setText("Vecka " + weekNumber);
                }
                else {
                    weekNumber = 52;
                    weekText.setText("Vecka " + weekNumber);
                }
            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setText(">");
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(weekNumber != 52) {
                    weekNumber = weekNumber + 1;
                    weekText.setText("Vecka " + weekNumber);
                }
                else {
                    weekNumber = 1;
                    weekText.setText("Vecka " + weekNumber);
                }
            }
        });

        mondayview = (View) findViewById(R.id.monday);
        mondayview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        /*Bestämma Måndag*/
        cal.set(Calendar.WEEK_OF_YEAR, weekNumber);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        String monDate = "Mån\n"+ (sdf.format(cal.getTime()));
        TextView monLunch = (TextView) findViewById(R.id.lunchMon);
        TextView monMiddag = (TextView) findViewById(R.id.middagMon);
        monLunch.setText(monDate);
        monMiddag.setText(monDate);

        /*Bestämma Tisdag*/
        cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        String tueDate = "Tis\n"+ (sdf.format(cal.getTime()));
        TextView tisLunch = (TextView) findViewById(R.id.tisFm);
        TextView tisMiddag = (TextView) findViewById(R.id.tisEM);
        tisLunch.setText(tueDate);
        tisMiddag.setText(tueDate);

        /*Bestämma onsdag*/
        cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        String wedDate = "Ons\n"+ (sdf.format(cal.getTime()));
        TextView wedLunch = (TextView) findViewById(R.id.onsFM);
        TextView wedMiddag = (TextView) findViewById(R.id.onsEM);
        wedLunch.setText(wedDate);
        wedMiddag.setText(wedDate);

        /*Bestämma Torsdag*/
        cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
        String thuDate = "Tor\n"+ (sdf.format(cal.getTime()));
        TextView thuLunch = (TextView) findViewById(R.id.torsFM);
        TextView thuMiddag = (TextView) findViewById(R.id.torsEM);
        thuLunch.setText(thuDate);
        thuMiddag.setText(thuDate);

        /*Bestämma Fredag*/
        cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        String friDate = "Fre\n"+ (sdf.format(cal.getTime()));
        TextView friLunch = (TextView) findViewById(R.id.freFM);
        TextView friMiddag = (TextView) findViewById(R.id.freEM);
        friLunch.setText(friDate);
        friMiddag.setText(friDate);

        /*Bestämma Lördag*/
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        String SatDate = "Lör\n"+ (sdf.format(cal.getTime()));
        TextView SatLunch = (TextView) findViewById(R.id.lörFM);
        TextView SatMiddag = (TextView) findViewById(R.id.lörEM);
        SatLunch.setText(SatDate);
        SatMiddag.setText(SatDate);

        /*Bestämma Söndag*/
        cal.set(Calendar.WEEK_OF_YEAR, weekNumber+1);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        String SunDate = "Sön\n"+ (sdf.format(cal.getTime()));
        TextView sunLunch = (TextView) findViewById(R.id.sönFM);
        TextView sunMiddag = (TextView) findViewById(R.id.sönEM);
        sunLunch.setText(SunDate);
        sunMiddag.setText(SunDate);

    }

}
