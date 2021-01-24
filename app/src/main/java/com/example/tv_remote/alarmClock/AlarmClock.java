package com.example.tv_remote.alarmClock;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.tv_remote.InternetConnection;
import com.example.tv_remote.LedCupboard;
import com.example.tv_remote.LedTable;
import com.example.tv_remote.MainActivity;
import com.example.tv_remote.R;
import com.example.tv_remote.Receiver;
import com.example.tv_remote.RoomLightSeekerBar;
import com.example.tv_remote.ToolbarActivity;
import com.example.tv_remote.pcRemote.pcRemoteControl;
import com.google.android.material.navigation.NavigationView;

public class AlarmClock extends ToolbarActivity {
    private static String time;
    char dayType = 1;
    String[] textViewList = {"Mo","Tu","We","Th","Fr","Sa","Su"};
    boolean[] checkBoxList = new boolean[7];
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar toolbar;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_clock);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.alarm);
        setUpToolbar();

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
                            time += textViewList[i];    //ich weiß das es doof ist aber sonst müsste nochmal viel umschreiben und das nicht jetzt
                        }
                    }
                }
                AddNewTask.newInstance().show(getSupportFragmentManager(), AddNewTask.TAG);
            }
        });

        toolbar();

        navigationView = findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_television:
                        Intent intent0 = new Intent(AlarmClock.this, MainActivity.class);
                        startActivity(intent0);
                        break;
                    case R.id.nav_led_table:
                        Intent intent1 = new Intent(AlarmClock.this, LedTable.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_led_cupboard:
                        Intent intent2 = new Intent(AlarmClock.this, LedCupboard.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_pc:
                        Intent intent3 = new Intent(AlarmClock.this, pcRemoteControl.class);
                        startActivity(intent3);
                        break;
                    case R.id.nav_alarm:
                        Intent intent4 = new Intent(AlarmClock.this, AlarmClock.class);
                        startActivity(intent4);
                        break;
                    case R.id.nav_receiver:
                        Intent intent5 = new Intent(AlarmClock.this, Receiver.class);
                        startActivity(intent5);
                        break;
                    case R.id.nav_room_light:
                        Intent intent6 = new Intent(AlarmClock.this, RoomLightSeekerBar.class);
                        startActivity(intent6);
                        break;
                    case R.id.nav_ventilator:
                        Toast.makeText(getApplicationContext(), "'Ventilator' turn ON/OFF!", Toast.LENGTH_SHORT).show();
                        InternetConnection.changeBooleanFalse();
                        InternetConnection b = new InternetConnection();
                        b.execute("300X","192.168.2.101");  //normaly 300X 192.168.2.101 just testing partyCube with 16753245
                        break;
                    case R.id.nav_settings:
                        Toast.makeText(getApplicationContext(), "Button 'Preference' isn't in use!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_aboutus:
                        Toast.makeText(getApplicationContext(), "Button 'About Us' isn't in use!", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
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
        new InternetConnection().execute(infrared + "X", "192.168.2.174");    //"X" used as ending signal by esp ,118pc for testing
        InternetConnection.changeBooleanFalse();
    }

    public void setUpToolbar() {
        drawerLayout = findViewById(R.id.drawerLayout);
        Toolbar stoolbar = findViewById(R.id.drawer);
        setSupportActionBar(stoolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, stoolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.black));
        actionBarDrawerToggle.syncState();
    }
}