package com.example.matti.schemaapplikation;

import android.view.View;

import java.util.Calendar;
import java.util.Locale;

import static com.example.matti.schemaapplikation.MainActivity.*;

/**
 * Created by Joakim on 17-02-22.
 */
public class DecreaseWeek implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        if (weekNumber <= 1) {
            yearNumber--;
            cal.set(Calendar.YEAR, yearNumber);
            Calendar lastWeek = Calendar.getInstance(Locale.GERMAN);
            lastWeek.set(yearNumber, Calendar.DECEMBER, 31);

            weekNumber=lastWeek.get(Calendar.WEEK_OF_YEAR);
        } else {
            weekNumber--;
        }
        final UpdateDateByWeek ud = new UpdateDateByWeek();
        ud.run();
    }
}
