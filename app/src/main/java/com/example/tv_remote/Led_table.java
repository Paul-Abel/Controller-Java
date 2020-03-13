package com.example.tv_remote;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

@RequiresApi(api = Build.VERSION_CODES.M)
public class Led_table extends AppCompatActivity {

    private Button main;
    private Toolbar toolbar;
    private Button led_anzeige;
    private Button led_on;
    private Button led_off;
    private Button led_red;
    private Button led_blue;
    private Button led_green;
    private Button led_light_red;
    private Button led_light_green;
    private Button led_light_blue;
    private Button led_brown;
    private Button led_orange;
    private Button led_light_light_blue;
    private Button led_purple;
    private Button led_yellow;
    private Button led_white;
    private Button led_1H24;
    private Button led_1H;
    private Button led_change;
    private Button led_smooth;
    private Button led_up;
    private Button led_down;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led_table);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.led_table);
        led_anzeige = findViewById(R.id.led_anzeige);
        led_on = findViewById(R.id.led_on);
        led_off = findViewById(R.id.led_off);
        led_red = findViewById(R.id.led_red);
        led_blue = findViewById(R.id.led_blue);
        led_green = findViewById(R.id.led_green);
        led_light_red = findViewById(R.id.led_light_red);
        led_light_green = findViewById(R.id.led_light_green);
        led_light_blue = findViewById(R.id.led_light_blue);
        led_brown = findViewById(R.id.led_brwon);
        led_orange = findViewById(R.id.led_orange);
        led_light_light_blue = findViewById(R.id.led_light_light_blue);
        led_purple = findViewById(R.id.led_purple);
        led_yellow = findViewById(R.id.led_yellow);
        led_white = findViewById(R.id.led_white);
        led_1H24 = findViewById(R.id.led_1H24);
        led_1H = findViewById(R.id.led_1H);
        led_change = findViewById(R.id.led_change);
        led_smooth = findViewById(R.id.led_smooth);
        led_up = findViewById(R.id.led_up);
        led_down = findViewById(R.id.led_down);

        animatedbackground();
        toolbar();

        led_on.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                aktualiesereFarbe();
                sendeInfrarot("16753245X");
            }
        });
        led_off.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                aktualiesereFarbe();
                sendeInfrarot("16769565X");
            }
        });
        led_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktualiesereFarbe();
                sendeInfrarot("16738455X");

            }
        });
        led_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktualiesereFarbe();
                sendeInfrarot("16750695X");

            }
        });
        led_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktualiesereFarbe();
                sendeInfrarot("16756815X");

            }
        });
        led_light_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktualiesereFarbe();
                sendeInfrarot("16724175X");

            }
        });
        led_light_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktualiesereFarbe();
                sendeInfrarot("16718055X");

            }
        });
        led_light_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktualiesereFarbe();
                sendeInfrarot("16743045X");

            }
        });
        led_brown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktualiesereFarbe();
                sendeInfrarot("16716015X");

            }
        });
        led_orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktualiesereFarbe();
                sendeInfrarot("16726215X");

            }
        });
        led_light_light_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktualiesereFarbe();
                sendeInfrarot("16734885X");

            }
        });
        led_purple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktualiesereFarbe();
                sendeInfrarot("16728765X");

            }
        });
        led_yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktualiesereFarbe();
                sendeInfrarot("16730805X");

            }
        });
        led_white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktualiesereFarbe();
                sendeInfrarot("16732845X");

            }
        });
        led_1H24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktualiesereFarbe();
                sendeInfrarot("16712445X");

            }
        });
        led_1H.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktualiesereFarbe();
                sendeInfrarot("16761405X");

            }
        });
        led_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktualiesereFarbe();
                sendeInfrarot("16720605X");

            }
        });
        led_smooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktualiesereFarbe();
                sendeInfrarot("16769055X");

            }
        });
        led_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktualiesereFarbe();
                sendeInfrarot("16754775X");

            }
        });
        led_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktualiesereFarbe();
                sendeInfrarot("16748655X");

            }
        });
    }

    @Override   //Toolbarsytle wird eingefügt
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_example, menu);
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

    public void animatedbackground(){
        ConstraintLayout constraintLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }

    public void aktualiesereFarbe() {
        int Farbe = getColor(R.color.orange);
        int normal = getColor(R.color.gray);
        led_anzeige.setBackgroundColor(Farbe);
        //TimeUnit.MILLISECONDS.sleep(1000);
        led_anzeige.setBackgroundColor(normal);
    }

    public void sendeInfrarot(String infrarot){
        InternetConnection b = new InternetConnection();
        b.execute(infrarot);
    }
}
