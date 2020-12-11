package com.example.tv_remote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;

import androidx.appcompat.widget.Toolbar;

import com.example.tv_remote.pcRemote.Keyboard;

public class AlarmClock extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar toolbar;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_clock);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.alarm);

        Button alarms = findViewById(R.id.alarms);
        Button addTime = findViewById(R.id.saveAlarm);
        final CheckBox moToFr = findViewById(R.id.checkBoxMoToFr);
        final CheckBox everyDay = findViewById(R.id.checkBoxEveryDay);
        final CheckBox userFrame = findViewById(R.id.checkBoxUserFrame);
        final TableLayout hideTable = findViewById(R.id.xmlHideTable);

        moToFr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox)v).isChecked();
                if(checked){
                    everyDay.setChecked(false);
                    userFrame.setChecked(false);
                    hideTable.setVisibility(View.INVISIBLE);
                }
            }
        });

        everyDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox)v).isChecked();
                if(checked){
                    moToFr.setChecked(false);
                    userFrame.setChecked(false);
                    hideTable.setVisibility(View.INVISIBLE);
                }
            }
        });

        userFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox)v).isChecked();
                if(checked){
                    moToFr.setChecked(false);
                    everyDay.setChecked(false);
                    hideTable.setVisibility(View.VISIBLE);

                }
            }
        });

        alarms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        addTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAlarmTime();
            }
        });

        toolbar();
    }

    public void addAlarmTime(){

    }

    private void toolbar(){  //Insert Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}