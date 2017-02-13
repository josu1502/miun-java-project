package com.miun.schemaapplikation.josu1502.schemaapplikation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<String> nameList;
    public static ArrayAdapter adapter;
    public static ListView sList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sList = (ListView) findViewById(R.id.sList);
        nameList = new ArrayList<>();

        nameList.add("17/02/13\tLunch\nJoakim");
        nameList.add("17/02/13\tLunch\nMattias");
        nameList.add("17/02/13\tMiddag\nThomas");
        nameList.add("17/02/13\tMiddag\nAnders");
        nameList.add("17/02/14\tLunch\nThomas");
        nameList.add("17/02/14\tLunch\nThomas");
        Collections.sort(nameList);

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, nameList);
        sList.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageResource(R.drawable.plus);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AddNewDate.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static void addNewSchedule (String date, String pass, String name) {
        nameList.add(date + "\t" + pass + "\n" + name);
        Collections.sort(nameList);
        sList.setAdapter(adapter);
    }
}
