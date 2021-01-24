package com.example.tv_remote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tv_remote.alarmClock.AlarmClock;
import com.example.tv_remote.pcRemote.pcRemoteControl;
import com.google.android.material.navigation.NavigationView;

public class LedCupboard extends ToolbarActivity {

    private ImageView colour_pick;
    private Bitmap bitmap;
    private String currentID = "192.168.2.125";
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar toolbar;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led_cupboard);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.led_cupboard);
        setUpToolbar();

        navigationIntent = 3;

        colour_pick = findViewById(R.id.colour_pick);
        colour_pick.setDrawingCacheEnabled(true);
        colour_pick.buildDrawingCache(true);

        Button cupboard_on = findViewById(R.id.cupboard_on);
        Button cupboard_off = findViewById(R.id.cupboard_off);
        Button switchToLED = findViewById(R.id.switchToLEDString);
        Button switchToCupboard = findViewById(R.id.switchToLEDCupboard);

        colour_pick.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE){
                    bitmap = colour_pick.getDrawingCache();
                    int pixel = bitmap.getPixel((int)event.getX(), (int)event.getY());
                    if(pixel != 0) {
                        showButtonClicked();
                        String html = Integer.toHexString(pixel);
                        sendInfrared(html);
                    }
                }
                return false;
            }
        });

        cupboard_on.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("ffa700ff");   //start code blue: ff057cb9 purple: ffa700ff
            }
        });
        cupboard_off.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("00000000");
            }
        });
        switchToCupboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showButtonClicked();
                currentID = "192.168.2.125";
            }
        });
        switchToLED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showButtonClicked();
                currentID = "192.168.2.143";    //161
            }
        });

        toolbar();

        navigationView = findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_television:
                        Intent intent0 = new Intent(LedCupboard.this, MainActivity.class);
                        startActivity(intent0);
                        break;
                    case R.id.nav_led_table:
                        Intent intent1 = new Intent(LedCupboard.this, LedTable.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_led_cupboard:
                        Intent intent2 = new Intent(LedCupboard.this, LedCupboard.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_pc:
                        Intent intent3 = new Intent(LedCupboard.this, pcRemoteControl.class);
                        startActivity(intent3);
                        break;
                    case R.id.nav_alarm:
                        Intent intent4 = new Intent(LedCupboard.this, AlarmClock.class);
                        startActivity(intent4);
                        break;
                    case R.id.nav_receiver:
                        Intent intent5 = new Intent(LedCupboard.this, Receiver.class);
                        startActivity(intent5);
                        break;
                    case R.id.nav_room_light:
                        Intent intent6 = new Intent(LedCupboard.this, RoomLightSeekerBar.class);
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

    private void toolbar(){  //Insert toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void showButtonClicked() {
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500); //You can manage the blinking time with this parameter
        Button cupboard_on = findViewById(R.id.cupboard_on);
        cupboard_on.startAnimation(anim);
    }

    private void sendInfrared(String infrared) {
        new InternetConnection().execute(infrared + "X", currentID);    //"X" used as ending signal by esp
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
