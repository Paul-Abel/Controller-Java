package com.example.tv_remote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TimePicker;

import androidx.appcompat.widget.Toolbar;

public class AlarmClock extends ToolbarActivity {
    private static String time;
    char dayType = 1;
    String[] textViewList = {"Mo","Tu","We","Th","Fr","Sa","Su"};
    boolean[] checkBoxList = new boolean[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar toolbar;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_clock);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.alarm);

        final TimePicker tp = findViewById(R.id.timePicker);
        Button alarmList = findViewById(R.id.alarms);
        Button addTime = findViewById(R.id.saveAlarm);
        final CheckBox moToFr = findViewById(R.id.checkBoxMoToFr);
        final CheckBox everyDay = findViewById(R.id.checkBoxEveryDay);
        final CheckBox userFrame = findViewById(R.id.checkBoxUserFrame);
        final CheckBox monday = findViewById(R.id.checkBoxMo);
        final CheckBox tuesday = findViewById(R.id.checkBoxTu);
        final CheckBox wednesday = findViewById(R.id.checkBoxWe);
        final CheckBox thursday = findViewById(R.id.checkBoxTh);
        final CheckBox friday = findViewById(R.id.checkBoxFr);
        final CheckBox saturday = findViewById(R.id.checkBoxSa);
        final CheckBox sunday = findViewById(R.id.checkBoxSu);
        final TableLayout hideTable = findViewById(R.id.xmlHideTable);

        tp.setIs24HourView(true);
        tp.setEnabled(true);

        moToFr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox)v).isChecked();
                if(checked){
                    everyDay.setChecked(false);
                    userFrame.setChecked(false);
                    hideTable.setVisibility(View.INVISIBLE);
                    dayType = 0;
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
                    dayType = 1;
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
                    dayType = 2;
                }
            }
        });

        monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox)v).isChecked();
                checkBoxList[0] = checked;
            }
        });
        tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox)v).isChecked();
                checkBoxList[1] = checked;
            }
        });
        wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox)v).isChecked();
                checkBoxList[2] = checked;
            }
        });
        thursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox)v).isChecked();
                checkBoxList[3] = checked;
            }
        });
        friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox)v).isChecked();
                checkBoxList[4] = checked;
            }
        });
        saturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox)v).isChecked();
                checkBoxList[5] = checked;
            }
        });
        sunday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox)v).isChecked();
                checkBoxList[6] = checked;
            }
        });

        alarmList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAlarmListActivity();
            }
        });

        addTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(String.valueOf(tp.getCurrentMinute()).length() == 2) {
                    time = tp.getCurrentHour() + ":" + tp.getCurrentMinute();
                }else{
                    time = tp.getCurrentHour() + ":0" + tp.getCurrentMinute();
                }

                if(dayType == 0){
                    time = time + ":M-F";
                }else if(dayType == 1){
                    time = time + ":everyDay";
                }else{
                    time = time + ":";
                    for(char i = 0; i < 7; i++){
                        if(checkBoxList[i]){
                            time += textViewList[i];
                        }
                    }
                }
                AddNewTask.newInstance().show(getSupportFragmentManager(), AddNewTask.TAG);
            }
        });

        toolbar();
    }

    public static String getTime(){
        return time;
    }

    private void startAlarmListActivity() {
        Intent alarmList = new Intent(this, AlarmClockList.class);
        startActivity(alarmList);
    }

    private void toolbar(){  //Insert Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public static void sendInfrared(String infrared){
        InternetConnection.changeBooleanTrue();
        new InternetConnection().execute(infrared + "X", "192.168.2.118");    //"X" used as ending signal by esp ,118pc for testing
        InternetConnection.changeBooleanFalse();
    }
}