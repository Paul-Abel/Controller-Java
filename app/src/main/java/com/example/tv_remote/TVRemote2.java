package com.example.tv_remote;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.tv_remote.alarmClock.AlarmClock;
import com.example.tv_remote.pcRemote.pcRemoteControl;
import com.google.android.material.navigation.NavigationView;

public class TVRemote2 extends ToolbarActivity {

    private Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_remote2);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.tv_remote2);
        setUpToolbar();

        Button tv_menu = findViewById(R.id.tv_menu);
        Button tv_guide = findViewById(R.id.tv_guide);
        Button tv_source = findViewById(R.id.source);
        Button tv_tools = findViewById(R.id.tv_tools);
        Button tv_return = findViewById(R.id.tv_return);
        Button tv_exit = findViewById(R.id.tv_exit);
        Button tv_forward = findViewById(R.id.tv_forward);
        Button tv_backward = findViewById(R.id.tv_backward);
        Button tv_break = findViewById(R.id.tv_break);
        Button tv_play = findViewById(R.id.tv_play);
        Button tv_stop = findViewById(R.id.tv_stop);
        Button tv_right = findViewById(R.id.tv_right);
        Button tv_left = findViewById(R.id.tv_left);
        Button tv_up = findViewById(R.id.tv_up);
        Button tv_down = findViewById(R.id.tv_down);
        Button tv_ok = findViewById(R.id.tv_ok);
        Button tv_HDMI = findViewById(R.id.tv_HDMI);
        Button tv_back_page = findViewById(R.id.back_page);

        tv_menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772799143");
            }
        });
        tv_guide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772838413");
            }
        });
        tv_source.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772809343");
            }
        });
        tv_tools.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772830253");
            }
        });
        tv_return.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772783333");
            }
        });
        tv_forward.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772781293");
            }
        });
        tv_backward.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772818013");
            }
        });
        tv_exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772822603");
            }
        });
        tv_break.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772797613");
            }
        });
        tv_play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772834333");
            }
        });
        tv_stop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772801693");
            }
        });
        tv_right.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772794553");
            }
        });
        tv_left.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772819033");
            }
        });
        tv_down.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772810873");
            }
        });
        tv_up.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772778233");
            }
        });
        tv_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772782313");
            }
        });
        tv_HDMI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772829998");
            }
        });
        tv_back_page.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent television = new Intent(TVRemote2.this, MainActivity.class);
                startActivity(television);
                overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);
            }
        });

        toolbar();

        navigationView = findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_television:
                        Intent intent0 = new Intent(TVRemote2.this, MainActivity.class);
                        startActivity(intent0);
                        break;
                    case R.id.nav_led_table:
                        Intent intent1 = new Intent(TVRemote2.this, LedTable.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_led_cupboard:
                        Intent intent2 = new Intent(TVRemote2.this, LedCupboard.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_pc:
                        Intent intent3 = new Intent(TVRemote2.this, pcRemoteControl.class);
                        startActivity(intent3);
                        break;
                    case R.id.nav_alarm:
                        Intent intent4 = new Intent(TVRemote2.this, AlarmClock.class);
                        startActivity(intent4);
                        break;
                    case R.id.nav_receiver:
                        Intent intent5 = new Intent(TVRemote2.this, Receiver.class);
                        startActivity(intent5);
                        break;
                    case R.id.nav_room_light:
                        Intent intent6 = new Intent(TVRemote2.this, RoomLightSeekerBar.class);
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

    private void toolbar() {  //Insert toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void showButtonClicked() {
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500); //You can manage the blinking time with this parameter
        Button tv_on_off = findViewById(R.id.tv_HDMI);
        tv_on_off.startAnimation(anim);
    }

    private void sendInfrared(String infrared) {
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


