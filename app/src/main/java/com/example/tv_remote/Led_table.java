package com.example.tv_remote;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

@RequiresApi(api = Build.VERSION_CODES.M)
public class Led_table extends AppCompatActivity {

    private Toolbar toolbar;
    private Button led_panel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led_table);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.led_table);

        led_panel = findViewById(R.id.led_anzeige);
        Button led_on = findViewById(R.id.led_on);
        Button led_off = findViewById(R.id.led_off);
        Button led_red = findViewById(R.id.led_red);
        Button led_blue = findViewById(R.id.led_blue);
        Button led_green = findViewById(R.id.led_green);
        Button led_light_red = findViewById(R.id.led_light_red);
        Button led_light_green = findViewById(R.id.led_light_green);
        Button led_light_blue = findViewById(R.id.led_light_blue);
        Button led_brown = findViewById(R.id.led_brwon);
        Button led_orange = findViewById(R.id.led_orange);
        Button led_light_light_blue = findViewById(R.id.led_light_light_blue);
        Button led_purple = findViewById(R.id.led_purple);
        Button led_yellow = findViewById(R.id.led_yellow);
        Button led_white = findViewById(R.id.led_white);
        Button led_1H24 = findViewById(R.id.led_1H24);
        Button led_1H = findViewById(R.id.led_1H);
        Button led_change = findViewById(R.id.led_change);
        Button led_smooth = findViewById(R.id.led_smooth);
        Button led_up = findViewById(R.id.led_up);
        Button led_down = findViewById(R.id.led_down);

        led_on.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("16753245X");
            }
        });
        led_off.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("16769565X");
            }
        });
        led_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showButtonclicked();
                sendInfrarot("16738455X");
            }
        });
        led_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showButtonclicked();
                sendInfrarot("16750695X");
            }
        });
        led_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showButtonclicked();
                sendInfrarot("16756815X");
            }
        });
        led_light_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showButtonclicked();
                sendInfrarot("16724175X");
            }
        });
        led_light_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showButtonclicked();
                sendInfrarot("16718055X");
            }
        });
        led_light_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showButtonclicked();
                sendInfrarot("16743045X");
            }
        });
        led_brown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showButtonclicked();
                sendInfrarot("16716015X");
            }
        });
        led_orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showButtonclicked();
                sendInfrarot("16726215X");
            }
        });
        led_light_light_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showButtonclicked();
                sendInfrarot("16734885X");
            }
        });
        led_purple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showButtonclicked();
                sendInfrarot("16728765X");
            }
        });
        led_yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showButtonclicked();
                sendInfrarot("16730805X");
            }
        });
        led_white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showButtonclicked();
                sendInfrarot("16732845X");
            }
        });
        led_1H24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showButtonclicked();
                sendInfrarot("16712445X");
            }
        });
        led_1H.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showButtonclicked();
                sendInfrarot("16761405X");
            }
        });
        led_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showButtonclicked();
                sendInfrarot("16720605X");
            }
        });
        led_smooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showButtonclicked();
                sendInfrarot("16769055X");
            }
        });
        led_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showButtonclicked();
                sendInfrarot("16754775X");
            }
        });
        led_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showButtonclicked();
                sendInfrarot("16748655X");
            }
        });

        toolbar();
    }

    @Override   //Toolbarsytle wird eingefügt
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override   //Navigation
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.toolbar_television:
                Intent television = new Intent(this, MainActivity.class);
                startActivity(television);
                return true;
            case R.id.toolbar_reciver:
                Intent reciver = new Intent(this, Reciver.class);
                startActivity(reciver);
                return true;
            case R.id.toolbar_led_cupboard:
                Intent Led_cupboad = new Intent(this, led_cupboad.class);
                startActivity(Led_cupboad);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void toolbar(){  //Navigation wird eingefügt
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void showButtonclicked() {
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500); //You can manage the blinking time with this parameter
        led_panel.startAnimation(anim);
    }

    public void sendInfrarot(String infrarot){
        InternetConnection b = new InternetConnection();
        b.execute(infrarot);
    }


}
