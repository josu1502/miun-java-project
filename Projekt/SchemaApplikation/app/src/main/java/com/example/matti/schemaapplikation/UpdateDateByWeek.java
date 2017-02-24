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

        /*Set the week*/
        cal.set(Calendar.WEEK_OF_YEAR, weekNumber);

        /*Bestämma Måndag*/
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        monDate.setText(sdf.format(cal.getTime())); //

        /*Bestämma Tisdag*/
        cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        tuesDate.setText(sdf.format(cal.getTime()));

        /*Bestämma onsdag*/
        cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        wedsDate.setText(sdf.format(cal.getTime()));

        /*Bestämma Torsdag*/
        cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
        thursDate.setText(sdf.format(cal.getTime()));

        /*Bestämma Fredag*/
        cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        friDate.setText(sdf.format(cal.getTime()));

        /*Bestämma Lördag*/
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        satDate.setText(sdf.format(cal.getTime()));

        /*Bestämma Söndag*/
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        sunDate.setText(sdf.format(cal.getTime()));
    }
}
