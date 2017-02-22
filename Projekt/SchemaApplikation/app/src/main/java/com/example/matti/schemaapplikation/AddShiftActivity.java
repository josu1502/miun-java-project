package com.example.matti.schemaapplikation;

import android.app.ActionBar;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.matti.schemaapplikation.MainActivity.*;

public class AddShiftActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shift);

        /*Set date text on top of activity*/
        TextView dateTextView = (TextView) findViewById(R.id.dateTextView);
        SimpleDateFormat sdf = new SimpleDateFormat("d MMM");
        String date = day + ", " + sdf.format(cal.getTime()) + "\n" + pass;
        dateTextView.setText(date);

    }
}
