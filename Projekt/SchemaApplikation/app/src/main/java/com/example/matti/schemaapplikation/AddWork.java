package com.example.matti.schemaapplikation;

import android.view.View;

import static com.example.matti.schemaapplikation.MainActivity.*;

/**
 * Created by Joakim on 17-02-22.
 */

public class AddWork implements View.OnClickListener {
    private String day, pass;

    public AddWork(String day, String pass) {
        this.day = day;
        this.pass = pass;
    }

    @Override
    public void onClick(View v) {
        System.out.println("Dag: " + day + " Pass: " + pass + " Vecka: " + weekNumber + " År: " + yearNumber);
        /*Go to new activity to add work pass*/
    }
}
