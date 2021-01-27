package com.example.tv_remote;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.tv_remote.alarmClock.AlarmClock;
import com.example.tv_remote.pcRemote.pcRemoteControl;
import com.google.android.material.navigation.NavigationView;

import java.util.concurrent.TimeUnit;

public class RoomLightSeekerBar extends ToolbarActivity {

    private static final String TAG = ".RoomLightSeekerBar";
    public static String sensorData;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    private TextView percentageLook;
    @SuppressLint("StaticFieldLeak")
    private static TextView tempView;
    @SuppressLint("StaticFieldLeak")
    private static TextView humidityView;
    private int currentPercentage;

    @SuppressLint("SetTextI18n")
    protected void onStart() {
        InternetConnection.changeCallbackBooleanTrue();
        sendInfrared("800");    //signal to get temperature and humidity
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setTempHumanityText();
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar toolbar;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_light_seeker_bar);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.light_dimming);
        setUpToolbar();

        percentageLook = findViewById(R.id.textLightPercentage);
        SeekBar seekBar = findViewById(R.id.seekBar);
        tempView = findViewById(R.id.textTempView);
        humidityView = findViewById(R.id.textHumidityView);
        Button refreshTempHum = findViewById(R.id.refresh);
        Button onOff = findViewById(R.id.on_off);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percentageLook.setText("" + progress + "%");
                currentPercentage = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                String sendString = String.valueOf(currentPercentage);
                sendInfrared(sendString);
            }
        });

        refreshTempHum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showButtonClicked();
                InternetConnection.changeCallbackBooleanTrue();
                sendInfrared("800");    //signal to get temperature and humidity
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setTempHumanityText();
            }
        });
        onOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendInfrared("1001");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendInfrared("2001");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendInfrared("3001");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendInfrared("4001");
            }
        });

        toolbar();

        navigationView = findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_television:
                        Intent intent0 = new Intent(RoomLightSeekerBar.this, MainActivity.class);
                        startActivity(intent0);
                        break;
                    case R.id.nav_led_table:
                        Intent intent1 = new Intent(RoomLightSeekerBar.this, LedTable.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_led_cupboard:
                        Intent intent2 = new Intent(RoomLightSeekerBar.this, LedCupboard.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_pc:
                        Intent intent3 = new Intent(RoomLightSeekerBar.this, pcRemoteControl.class);
                        startActivity(intent3);
                        break;
                    case R.id.nav_alarm:
                        Intent intent4 = new Intent(RoomLightSeekerBar.this, AlarmClock.class);
                        startActivity(intent4);
                        break;
                    case R.id.nav_receiver:
                        Intent intent5 = new Intent(RoomLightSeekerBar.this, Receiver.class);
                        startActivity(intent5);
                        break;
                    case R.id.nav_room_light:
                        Intent intent6 = new Intent(RoomLightSeekerBar.this, RoomLightSeekerBar.class);
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

    @SuppressLint("SetTextI18n")
    public static void setTempHumanityText(){
        if(sensorData != null) {
            Log.d(TAG,"setTempHum" + sensorData);
            String[] splitData = sensorData.split(":");
            tempView.setText(splitData[0] + "°C");
            humidityView.setText(splitData[1] + "%");
        }else{
            tempView.setText("not");
            humidityView.setText("reachable");
        }
        InternetConnection.changeCallbackBooleanFalse();
    }

    private void sendInfrared(String infrared){
        new InternetConnection().execute(infrared + "X", "192.168.2.174");    //change id to the used esp 174
    }

    private void showButtonClicked() {
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500); //You can manage the blinking time with this parameter
        Button showButton = findViewById(R.id.refresh);
        showButton.startAnimation(anim);
    }

    private void toolbar(){  //Insert toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void setUpToolbar() {
        drawerLayout = findViewById(R.id.drawerLayout);
        Toolbar secToolbar = findViewById(R.id.drawer);
        setSupportActionBar(secToolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, secToolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.black));
        actionBarDrawerToggle.syncState();
    }
}