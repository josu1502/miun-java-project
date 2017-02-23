package com.example.matti.schemaapplikation;

import android.icu.text.SimpleDateFormat;

import java.util.Calendar;

import static com.example.matti.schemaapplikation.MainActivity.*;

/**
 * Created by Joakim on 17-02-22.
 */

public class UpdateDateByWeek {

    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("E" + "\n" + "d MMM");

        /*Print week*/
        String week = "Vecka " + weekNumber.toString() + ", " + yearNumber;
        weekText.setText(week);

        /*Bestämma Måndag*/
        cal.set(Calendar.WEEK_OF_YEAR, weekNumber);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        String monDate = sdf.format(cal.getTime());

        monL.setText(monDate);
        monM.setText(monDate);

        /*Bestämma Tisdag*/
        cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        String tueDate = sdf.format(cal.getTime());
        tueL.setText(tueDate);
        tueM.setText(tueDate);

        /*Bestämma onsdag*/
        cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        String wedDate = sdf.format(cal.getTime());
        wedL.setText(wedDate);
        wedM.setText(wedDate);

        /*Bestämma Torsdag*/
        cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
        String thuDate = sdf.format(cal.getTime());
        thuL.setText(thuDate);
        thuM.setText(thuDate);

        /*Bestämma Fredag*/
        cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        String friDate = sdf.format(cal.getTime());
        friL.setText(friDate);
        friM.setText(friDate);

        /*Bestämma Lördag*/
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        String SatDate = sdf.format(cal.getTime());
        satL.setText(SatDate);
        satM.setText(SatDate);

        /*Bestämma Söndag*/
        cal.set(Calendar.WEEK_OF_YEAR, weekNumber);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        String SunDate = sdf.format(cal.getTime());
        sunL.setText(SunDate);
        sunM.setText(SunDate);
    }
}
