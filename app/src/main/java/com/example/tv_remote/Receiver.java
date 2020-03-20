package com.example.tv_remote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;

public class Receiver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar toolbar;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciver);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.receiver);

        Button receiver_on_off = findViewById(R.id.receiver_on_off);
        Button receiver_menu = findViewById(R.id.receiver_menu);
        Button receiver_open = findViewById(R.id.receiver_open);
        Button receiver_up = findViewById(R.id.receiver_up);
        Button receiver_left = findViewById(R.id.receiver_left);
        Button receiver_ok = findViewById(R.id.receiver_ok);
        Button receiver_right = findViewById(R.id.receiver_right);
        Button receiver_down = findViewById(R.id.receiver_down);
        Button receiver_setup = findViewById(R.id.receiver_setup);
        Button receiver_back = findViewById(R.id.receiver_back);
        Button receiver_backward = findViewById(R.id.receiver_backward);
        Button receiver_play_pause = findViewById(R.id.receiver_play_pause);
        Button receiver_forward = findViewById(R.id.receiver_forward);
        Button receiver_previous = findViewById(R.id.receiver_previous);
        Button receiver_stop = findViewById(R.id.receiver_stop);
        Button receiver_next = findViewById(R.id.receiver_next);

        receiver_on_off.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("2724022455X");
            }
        });
        receiver_menu.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("2724012510X");
            }
        });
        receiver_open.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("2724048720X");
            }
        });
        receiver_up.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("2724004350X");
            }
        });
        receiver_left.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("2724039285X");
            }
        });
        receiver_ok.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("2724037755X");
            }
        });
        receiver_right.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("2724049485X");
            }
        });
        receiver_down.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("2724036990X");
            }
        });
        receiver_setup.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("2724005115X");
            }
        });
        receiver_back.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("2724021435X");
            }
        });
        receiver_backward.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("2724042855X");
            }
        });
        receiver_play_pause.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("2724046935X");
            }
        });
        receiver_forward.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("2724055095X");
            }
        });
        receiver_previous.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("2724054075X");
            }
        });
        receiver_stop.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("2724014295X");
            }
        });
        receiver_next.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("2724013275X");
            }
        });

        toolbar();
    }

    @Override   //Insert toolbar layout
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override   //Navigation
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.toolbar_led_table:
                Intent led = new Intent(this, LedTable.class);
                startActivity(led);
                return true;
            case R.id.toolbar_television:
                Intent television = new Intent(this, MainActivity.class);
                startActivity(television);
                return true;
            case R.id.toolbar_led_cupboard:
                Intent Led_cupboard = new Intent(this, LedCupboard.class);
                startActivity(Led_cupboard);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void toolbar(){  //Insert toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void showButtonClicked() {
        Button receiver_on_off = findViewById(R.id.receiver_on_off);
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500); //You can manage the blinking time with this parameter
        receiver_on_off.startAnimation(anim);
    }

    private void sendInfrared(String infrared){
        InternetConnection b = new InternetConnection();
        b.execute(infrared);
    }
}
