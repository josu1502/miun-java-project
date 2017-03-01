package com.example.matti.schemaapplikation;

import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.matti.schemaapplikation.rest.SchemaEntity;

import java.util.ArrayList;
import java.util.List;

import static com.example.matti.schemaapplikation.MainActivity.*;

public class AddShiftActivity extends AppCompatActivity {
    //SchemaClient schemaClient;
    public EditText namnEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shift);

        /*Set date text on top of activity*/
        TextView weekTextView = (TextView) findViewById(R.id.weekTextView);
        TextView dateTextView = (TextView) findViewById(R.id.dateTextView);
        TextView passTextView = (TextView) findViewById(R.id.passTextView);

        weekTextView.setText("Vecka " + weekNumber + ", " + yearNumber);
        SimpleDateFormat sdf = new SimpleDateFormat("E" + "\n" + "d MMM");
        dateTextView.setText(sdf.format(cal.getTime()));
        passTextView.setText(pass + "pass");

        /*Bygg en ny lista utifrån datum*/
        List<String> dayWorkList = schemaList.getListByDay(day, pass, weekNumber, yearNumber);
        ListView displayDayWorkList = (ListView) findViewById(R.id.workList);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dayWorkList);
        displayDayWorkList.setAdapter(adapter);


        /*Textfältet där vi hämtar namnet ifrån*/
        final TextView nameTextView = (TextView) findViewById(R.id.editText);

        /*En knapp som använder retrofit för att lägga till i databasen*/
        Button button = (Button) findViewById(R.id.postButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String employee = nameTextView.getText().toString();

                if (!employee.equals("") && !employee.equals("Namn")) {
                /*Create entity example*/
                    SchemaEntity se = new SchemaEntity();
                    se.setWeekDay(day);
                    se.setWeekNumber(weekNumber);
                    se.setYearNumber(yearNumber);
                    se.setEmployee(employee);
                    se.setPass(pass);
                    se.setBooked(true);

                    schemaClient.postSchema(se);

                    System.out.println("Försöker skicka");

                    finish();
                }

            }
        });

        /*Rensa text i textfältet när man trycker*/
        namnEditText = (EditText) findViewById(R.id.editText);
        namnEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namnEditText.setText("");
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        //Save Values Here
        schemaClient.fetchSchemaList(); //To update when posting
    }
}
