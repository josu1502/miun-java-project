package com.miun.schemaapplikation.josu1502.schemaapplikation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static com.miun.schemaapplikation.josu1502.schemaapplikation.MainActivity.*;

public class AddNewDate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_date);

        final TextView nameTextView = (TextView) findViewById(R.id.nameText);
        final TextView dateTextView = (TextView) findViewById(R.id.dateText);
        final RadioGroup passRadioGroup = (RadioGroup) findViewById(R.id.passRadio);
        Button scheduleButton = (Button) findViewById(R.id.addButton);

        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = dateTextView.getText().toString();
                String name = nameTextView.getText().toString();

                int selectedRadioButtonID = passRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = (RadioButton) findViewById(selectedRadioButtonID);
                String pass = selectedRadioButton.getText().toString();


                addNewSchedule(date, pass, name);
                finish();
            }
        });

    }
}