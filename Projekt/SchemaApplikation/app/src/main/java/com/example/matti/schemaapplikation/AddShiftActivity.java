package com.example.matti.schemaapplikation;

import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.matti.schemaapplikation.rest.SchemaClient;
import com.example.matti.schemaapplikation.rest.SchemaEntities;
import com.example.matti.schemaapplikation.rest.SchemaEntity;
import com.example.matti.schemaapplikation.rest.SchemaStatusListener;

import static com.example.matti.schemaapplikation.MainActivity.*;

public class AddShiftActivity extends AppCompatActivity implements SchemaStatusListener {
    SchemaClient schemaClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shift);

        /*Set date text on top of activity*/
        TextView dateTextView = (TextView) findViewById(R.id.dateTextView);
        SimpleDateFormat sdf = new SimpleDateFormat("d MMM");
        String date = day + ", " + sdf.format(cal.getTime()) + "\n" + pass;
        dateTextView.setText(date);

        //schemaClient = new SchemaClient("http://10.250.119.143:8080/AntonsHemsida/webresources/"); /* Andreas IP: */
        schemaClient = new SchemaClient("http://192.168.43.80:8080/AntonsHemsida/webresources/"); /* Jockes IP: */
        schemaClient.setStatusListener(this);
        schemaClient.fetchSchemaList();

        /*Textfältet där vi hämtar namnet ifrån*/
        final TextView nameTextView = (TextView) findViewById(R.id.editText);

        /*En knapp som använder retrofit för att lägga till i databasen*/
        Button button = (Button) findViewById(R.id.postButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String employee = nameTextView.getText().toString();

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


                /*Tar bort angiven lunch från listan*/
               // schemaClient.deleteSchema(schema);

            }
        });

    }

    @Override
    public void schemaListRecived(SchemaEntities se) {
        System.out.println("Det funkar!");
    }

    @Override
    public void schemaUpdated() {

    }
}
