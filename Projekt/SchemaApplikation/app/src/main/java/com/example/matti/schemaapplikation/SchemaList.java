package com.example.matti.schemaapplikation;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;

import com.example.matti.schemaapplikation.rest.SchemaEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joakim on 17-03-01.
 */

public class SchemaList {
    private List<SchemaEntity> schemaList;

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
}
