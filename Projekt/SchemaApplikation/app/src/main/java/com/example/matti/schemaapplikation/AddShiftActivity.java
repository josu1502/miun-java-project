package com.example.matti.schemaapplikation;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.matti.schemaapplikation.rest.SchemaEntity;

import java.util.ArrayList;
import java.util.List;

import static com.example.matti.schemaapplikation.MainActivity.*;

public class AddShiftActivity extends AppCompatActivity {
    //SchemaClient schemaClient;
    public EditText namnEditText;
    public static ArrayAdapter adapter;
    public boolean mustStop;
    public static TableLayout table;
    private List<TableRow> tables;
    public static AddShiftActivityContext activityContext;

    @Override
    public void onStart(){
        super.onStart();
        table = (TableLayout) findViewById(R.id.passTable);
        activityContext = new AddShiftActivityContext(this);
        addShiftActivityRunning = true;
        schemaClient.fetchSchemaList();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shift);



        mustStop=false;

        /*Set date text on top of activity*/
        TextView weekTextView = (TextView) findViewById(R.id.weekTextView);
        TextView dateTextView = (TextView) findViewById(R.id.dateTextView);
        TextView passTextView = (TextView) findViewById(R.id.passTextView);

        weekTextView.setText("Vecka " + weekNumber + ", " + yearNumber);
        SimpleDateFormat sdf = new SimpleDateFormat("E" + "\n" + "d MMM");
        dateTextView.setText(sdf.format(cal.getTime()));
        passTextView.setText(pass + "pass");

        /*Textfältet där vi hämtar namnet ifrån*/
        final TextView nameTextView = (TextView) findViewById(R.id.editText);

        /*En knapp som använder retrofit för att lägga till i databasen*/
        Button button = (Button) findViewById(R.id.postButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String employee = nameTextView.getText().toString();
                InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

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


                }

                in.hideSoftInputFromWindow(namnEditText
                                .getApplicationWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);

                nameTextView.setText("Namn");

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
        /*Om man klickar på bocken/enter på det virituella tangentborder*/
        namnEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction()!=KeyEvent.ACTION_DOWN)
                    return false;
                if(keyCode == KeyEvent.KEYCODE_ENTER ){
                    InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

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
                    }

                    in.hideSoftInputFromWindow(namnEditText
                                    .getApplicationWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);

                    nameTextView.setText("Namn");

                    return true;
                }
                return false;
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        //Save Values Here

        addShiftActivityRunning = false;
        schemaClient.fetchSchemaList(); //To update when posting
    }
}
