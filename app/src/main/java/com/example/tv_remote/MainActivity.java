package com.example.tv_remote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.MenuItem;

import com.example.tv_remote.alarmClock.AlarmClock;
import com.example.tv_remote.pcRemote.pcRemoteControl;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends ToolbarActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar toolbar;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.television);
        setUpToolbar();

        navigationIntent = 1;

        Button tv_on_off = findViewById(R.id.tv_remote_on_off);
        Button tv_mute = findViewById(R.id.tv_remote_quiet);
        Button tv_0 = findViewById(R.id.tv_remote_0);
        Button tv_1 = findViewById(R.id.tv_remote_1);
        Button tv_2 = findViewById(R.id.tv_remote_2);
        Button tv_3 = findViewById(R.id.tv_remote_3);
        Button tv_4 = findViewById(R.id.tv_remote_4);
        Button tv_5 = findViewById(R.id.tv_remote_5);
        Button tv_6 = findViewById(R.id.tv_remote_6);
        Button tv_7 = findViewById(R.id.tv_remote_7);
        Button tv_8 = findViewById(R.id.tv_remote_8);
        Button tv_9 = findViewById(R.id.tv_remote_9);
        Button tv_turn_up_sound = findViewById(R.id.tv_remote_turn_up_sound);
        Button tv_turn_down_sound = findViewById(R.id.tv_remote_quiet_sound);
        Button tv_up = findViewById(R.id.tv_remote_up);
        Button tv_down = findViewById(R.id.tv_remote_down);
        Button tv_info = findViewById(R.id.tv_remote_info);
        Button tv_next = findViewById(R.id.tv_remote_next);
        Button tv_a = findViewById(R.id.tv_remote_a);
        Button tv_pre_ch = findViewById(R.id.tv_remote_pre_ch);
        Button tv_return = findViewById(R.id.tv_remote_return);

        tv_on_off.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772793023");
            }
        });
        tv_info.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772839943");
            }
        });
        tv_mute.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772837903");
            }
        });
        tv_0.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772811383");
            }
        });
        tv_1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772784863");
            }
        });
        tv_2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772817503");
            }
        });
        tv_3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772801183");
            }
        });
        tv_4.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772780783");
            }
        });
        tv_5.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772813423");
            }
        });
        tv_6.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772797103");
            }
        });
        tv_7.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772788943");
            }
        });
        tv_8.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772821583");
            }
        });
        tv_9.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772805263");
            }
        });
        tv_turn_up_sound.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772833823");
            }
        });
        tv_turn_down_sound.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772829743");
            }
        });
        tv_up.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772795063");
            }
        });
        tv_down.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772778743");
            }
        });
        tv_a.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772790473");
            }
        });
        tv_pre_ch.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772827703");
            }
        });
        tv_return.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772783333");
            }
        });
        tv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tv_remote2 = new Intent(MainActivity.this, TVRemote2.class);
                startActivity(tv_remote2);
                overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
            }
        });

        toolbar();

        navigationView = findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_television:
                        Intent intent0 = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent0);
                        break;
                    case R.id.nav_led_table:
                        Intent intent1 = new Intent(MainActivity.this, LedTable.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_led_cupboard:
                        Intent intent2 = new Intent(MainActivity.this, LedCupboard.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_pc:
                        Intent intent3 = new Intent(MainActivity.this, pcRemoteControl.class);
                        startActivity(intent3);
                        break;
                    case R.id.nav_alarm:
                        Intent intent4 = new Intent(MainActivity.this, AlarmClock.class);
                        startActivity(intent4);
                        break;
                    case R.id.nav_receiver:
                        Intent intent5 = new Intent(MainActivity.this, Receiver.class);
                        startActivity(intent5);
                        break;
                    case R.id.nav_room_light:
                        Intent intent6 = new Intent(MainActivity.this, RoomLightSeekerBar.class);
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

    private void toolbar(){  //Insert Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void showButtonClicked() {
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500); //You can manage the blinking time with this parameter
        Button tv_on_off = findViewById(R.id.tv_remote_quiet);
        tv_on_off.startAnimation(anim);
    }

    private void sendInfrared(String infrared){
        new InternetConnection().execute(infrared + "X", "192.168.2.102");    //"X" used as ending signal by esp ,102
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
