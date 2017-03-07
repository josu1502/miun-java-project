package com.example.matti.schemaapplikation;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.matti.schemaapplikation.rest.SchemaEntity;

import java.util.ArrayList;
import java.util.List;

import static com.example.matti.schemaapplikation.AddShiftActivity.activityContext;
import static com.example.matti.schemaapplikation.AddShiftActivity.table;
import static com.example.matti.schemaapplikation.MainActivity.schemaClient;

/**
 * Created by Joakim on 17-03-01.
 */

public class SchemaList {
    private List<SchemaEntity> schemaList;
    private List<TableRow> tableRowList = new ArrayList<>();

    public SchemaList(List<SchemaEntity> schemaList) {
        this.schemaList = schemaList;
    }

    public List<SchemaEntity> getSchemaList() {
        return this.schemaList;
    }

    public SpannableStringBuilder getDay(String day, String pass, Integer week, Integer year) {
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < schemaList.size(); i++) {

            if (year.equals(schemaList.get(i).getYearNumber())) {
                if (week.equals(schemaList.get(i).getWeekNumber())) {
                    if (pass.equals(schemaList.get(i).getPass())) {
                        if (day.equals(schemaList.get(i).getWeekDay())) {

                            SpannableString spannabelName = new SpannableString(schemaList.get(i).getEmployee() + "\n");
                            if (schemaList.get(i).getBooked()) {
                                spannabelName.setSpan(new ForegroundColorSpan(Color.BLACK), 0, spannabelName.length(), 0);
                            } else {
                                spannabelName.setSpan(new StrikethroughSpan(), 0, spannabelName.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                            }
                            stringBuilder.append(spannabelName);
                        }
                    }
                }
            }
        }
        return stringBuilder;
    }

    public List<String> getListByDay(String day, String pass, Integer week, Integer year) {
        List<String> entityList = new ArrayList<>();
        for (int i = 0; i < schemaList.size(); i++) {

            if (year.equals(schemaList.get(i).getYearNumber())) {
                if (week.equals(schemaList.get(i).getWeekNumber())) {
                    if (pass.equals(schemaList.get(i).getPass())) {
                        if (day.equals(schemaList.get(i).getWeekDay())) {
                            if (schemaList.get(i).getBooked() == true) {
                                entityList.add(schemaList.get(i).getEmployee());
                            } else {
                                entityList.add(schemaList.get(i).getEmployee() + " - Borttaget pass");
                            }
                        }
                    }
                }
            }
        }
        return entityList;
    }

    public List<Integer> getListByDayID(String day, String pass, Integer week, Integer year) {
        List<Integer> entityList = new ArrayList<>();
        for (int i = 0; i < schemaList.size(); i++) {

            if (year.equals(schemaList.get(i).getYearNumber())) {
                if (week.equals(schemaList.get(i).getWeekNumber())) {
                    if (pass.equals(schemaList.get(i).getPass())) {
                        if (day.equals(schemaList.get(i).getWeekDay())) {
                                entityList.add(i);
                        }
                    }
                }
            }
        }
        return entityList;
    }

    public void getTables(String day, String pass, Integer week, Integer year) {
        table.removeAllViews();
        Context context = activityContext.getContext();
        for (int i = 0; i < schemaList.size(); i++) {
            if (year.equals(schemaList.get(i).getYearNumber())) {
                if (week.equals(schemaList.get(i).getWeekNumber())) {
                    if (pass.equals(schemaList.get(i).getPass())) {
                        if (day.equals(schemaList.get(i).getWeekDay())) {
                            TableRow row = new TableRow(context);

                            TextView name = new TextView(context);


                            Button checkButton = new Button(context);

                            if (schemaList.get(i).getBooked() == true) {
                                name.setText(schemaList.get(i).getEmployee());
                                checkButton.setText("Ta bort");

                                checkButton.setBackgroundColor(Color.parseColor("#dfdfdf"));
                            } else {
                                name.setText(schemaList.get(i).getEmployee() + " - Borttagen");
                                checkButton.setText("Lägg till");
                                checkButton.setTextColor(Color.parseColor("#ffffff"));
                                checkButton.setBackgroundColor(Color.parseColor("#31b327"));
                            }

                            checkButton.setOnClickListener(new buttonAction(schemaList.get(i)));

                            row.addView(name);
                            row.addView(checkButton);


                            TableLayout.LayoutParams tableRowParams=
                                    new TableLayout.LayoutParams
                                            (TableLayout.LayoutParams.FILL_PARENT,TableLayout.LayoutParams.WRAP_CONTENT);

                            int leftMargin=0;
                            int topMargin=0;
                            int rightMargin=0;
                            int bottomMargin=8;

                            tableRowParams.setMargins(leftMargin, topMargin, rightMargin, bottomMargin);

                            row.setLayoutParams(tableRowParams);
                            //tableRowList.add(row);
                            table.addView(row);
                        }
                    }
                }
            }
        }

        //return tableRowList;
    }

    private class buttonAction implements View.OnClickListener {
        SchemaEntity schemaEntity;

        public buttonAction(SchemaEntity se) {
            this.schemaEntity = se;
        }

        @Override
        public void onClick(View v) {
            this.schemaEntity.setBooked(!(this.schemaEntity.getBooked()));
            schemaClient.updateSchema(this.schemaEntity);
            //schemaClient.fetchSchemaList();

        }
    }
}
