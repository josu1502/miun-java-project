package com.example.matti.schemaapplikation;

import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.matti.schemaapplikation.rest.SchemaEntity;

import java.util.ArrayList;
import java.util.List;

import static com.example.matti.schemaapplikation.MainActivity.*;

public class AddShiftActivity extends AppCompatActivity implements Runnable{
    //SchemaClient schemaClient;
    public EditText namnEditText;
    public ListView displayDayWorkList;
    public List<String> dayWorkList;
    public ArrayAdapter adapter;

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
        displayDayWorkList = (ListView) findViewById(R.id.workList);
        dayWorkList = schemaList.getListByDay(day, pass, weekNumber, yearNumber);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dayWorkList);
        displayDayWorkList.setAdapter(adapter);

        (new Thread(new AddShiftActivity())).start();


        /*List Item click listener*/
        displayDayWorkList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Ta index från ListView Item. Jämför med index i dayWorkIDList. Ta int från detta
                index. Denna int representerar databaens index som skall ändras. Ändra detta objekt
                till false/true på "Booked" */

                /*Bygg en lista med index so m speglar index i ListView*/
                List<Integer> dayWorkIDList = schemaList.getListByDayID(day, pass, weekNumber, yearNumber);

                Integer changeThisPos = dayWorkIDList.get(position);

                SchemaEntity se = schemaList.getSchemaList().get(changeThisPos);
                se.setBooked(!se.getBooked());

                schemaClient.updateSchema(se);

            }
        });


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

    @Override
    public void run() {
        while(true) {
        /*Bygg en ny lista utifrån datum*/
            //displayDayWorkList = (ListView) findViewById(R.id.workList);
            dayWorkList = schemaList.getListByDay(day, pass, weekNumber, yearNumber);
            //adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dayWorkList);
            //displayDayWorkList.setAdapter(adapter);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
