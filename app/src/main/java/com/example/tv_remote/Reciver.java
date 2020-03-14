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

public class Reciver extends AppCompatActivity {

    private Toolbar toolbar;
    Button reciver_on_off;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciver);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.reciver);

        reciver_on_off = findViewById(R.id.reciver_on_off);
        Button reciver_menu = findViewById(R.id.reciver_menu);
        Button reciver_open = findViewById(R.id.reciver_open);
        Button reciver_up = findViewById(R.id.reciver_up);
        Button reciver_left = findViewById(R.id.reciver_left);
        Button reciver_ok = findViewById(R.id.reciver_ok);
        Button reciver_right = findViewById(R.id.reciver_right);
        Button reciver_down = findViewById(R.id.reciver_down);
        Button reciver_setup = findViewById(R.id.reciver_setup);
        Button reciver_back = findViewById(R.id.reciver_back);
        Button reciver_backward = findViewById(R.id.reciver_backward);
        Button reciver_play_pause = findViewById(R.id.reciver_play_pause);
        Button reciver_forward = findViewById(R.id.reciver_forward);
        Button reciver_previous = findViewById(R.id.reciver_previous);
        Button reciver_stop = findViewById(R.id.reciver_stop);
        Button reciver_next = findViewById(R.id.reciver_next);

        reciver_on_off.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("2724022455X");
            }
        });
        reciver_menu.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("2724012510X");
            }
        });
        reciver_open.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("2724048720X");
            }
        });
        reciver_up.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("2724004350X");
            }
        });
        reciver_left.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("2724039285X");
            }
        });
        reciver_ok.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("2724037755X");
            }
        });
        reciver_right.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("2724049485X");
            }
        });
        reciver_down.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("2724036990X");
            }
        });
        reciver_setup.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("2724005115X");
            }
        });
        reciver_back.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("2724021435X");
            }
        });
        reciver_backward.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("2724042855X");
            }
        });
        reciver_play_pause.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("2724046935X");
            }
        });
        reciver_forward.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("2724055095X");
            }
        });
        reciver_previous.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("2724054075X");
            }
        });
        reciver_stop.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("2724014295X");
            }
        });
        reciver_next.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("2724013275X");
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
            case R.id.toolbar_led_table:
                Intent led = new Intent(this, Led_table.class);
                startActivity(led);
                return true;
            case R.id.toolbar_television:
                Intent television = new Intent(this, MainActivity.class);
                startActivity(television);
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
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void showButtonclicked() {
        reciver_on_off = findViewById(R.id.reciver_on_off);
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500); //You can manage the blinking time with this parameter
        reciver_on_off.startAnimation(anim);
    }

    public void sendInfrarot(String infrarot){
        InternetConnection b = new InternetConnection();
        b.execute(infrarot);
    }
}
