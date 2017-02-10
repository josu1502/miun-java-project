package com.miun.schemaapplikation.josu1502.schemaapplikation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView sList = (ListView) findViewById(R.id.sList);

        String[] names = new String[] { "17-02-10\tLunch\nJoakim",
                "17-02-10\tLunch\nMatiias",
                "17-02-10\tMiddag\nThomas",
                "17-02-11\tLunch\nGabriel",
                "17-02-11\tLunch\nAlex",
                "17-02-11\tMiddag\nAndreas",
                "17-02-11\tMiddag\nAdam",
                "17-02-10\tLunch\nMatiias",
                "17-02-10\tMiddag\nThomas",
                "17-02-11\tLunch\nGabriel",
                "17-02-11\tLunch\nAlex",
                "17-02-11\tMiddag\nAndreas",
                "17-02-11\tMiddag\nAdam"};

        final ArrayList<String> nameList = new ArrayList<String>();
        for (int i = 0; i < names.length; ++i) {
            nameList.add(names[i]);
        }

        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, nameList);
        sList.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageResource(R.drawable.plus);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
}
