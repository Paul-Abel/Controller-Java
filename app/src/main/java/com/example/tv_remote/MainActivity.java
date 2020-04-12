package com.example.tv_remote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

private float x1,y1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar toolbar;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.television);

        Button tv_on_off = findViewById(R.id.tv_remote_on_off);
        Button tv_silence = findViewById(R.id.tv_remote_quiet);
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
                sendInfrared("3772793023X");
            }
        });
        tv_info.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772839943X");
            }
        });
        tv_silence.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772837903X");
            }
        });
        tv_0.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772811383X");
            }
        });
        tv_1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772784863X");
            }
        });
        tv_2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772817503X");
            }
        });
        tv_3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772801183X");
            }
        });
        tv_4.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772780783X");
            }
        });
        tv_5.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772813423X");
            }
        });
        tv_6.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772797103X");
            }
        });
        tv_7.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772788943X");
            }
        });
        tv_8.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772821583X");
            }
        });
        tv_9.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772805263X");
            }
        });
        tv_turn_up_sound.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772833823X");
            }
        });
        tv_turn_down_sound.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772829743X");
            }
        });
        tv_up.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772795063X");
            }
        });
        tv_down.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772778743X");
            }
        });
        tv_a.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772790473X");
            }
        });
        tv_pre_ch.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772827703X");
            }
        });
        tv_return.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772783333X");
            }
        });
        tv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thirdPage();
            }
        });


        toolbar();
    }

    public boolean onTouchEvent(MotionEvent touchEvent){
        float x2,y2;
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if(x1 < x2 && (y1-y2)<(x2-x1)){
                    ledTable();
                }
                else if(x1 > x2 && (y1-y2)<(x1-x2)){
                    receiver();
                }
                else if(y1 > y2){
                    secondPage();
                }
                /*else if(y1 < y2){
                    thirdPage();
                }*/
                break;
        }
        return false;
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
                ledTable();
                return true;
            case R.id.toolbar_receiver:
                receiver();
                return true;
            case R.id.toolbar_led_cupboard:
                Intent Led_cupboard = new Intent(this, LedCupboard.class);
                startActivity(Led_cupboard);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                return true;
            case R.id.toolbar_room_light:
                Toast.makeText(getApplicationContext(), "Button not at work", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void thirdPage(){
        Intent thirdPage = new Intent(this,TVRemote3.class);
        startActivity(thirdPage);
        overridePendingTransition(R.anim.slide_in_top,R.anim.slide_out_bottom);
    }

    private void receiver(){
        Intent receiver = new Intent(this, Receiver.class);
        startActivity(receiver);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    private void ledTable(){
        Intent led = new Intent(this, LedTable.class);
        startActivity(led);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
    private void secondPage(){
        Intent tv_remote2 = new Intent(this, TVRemote2.class);
        startActivity(tv_remote2);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
    }

    private void toolbar(){  //Insert Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void sendInfrared(String infrared){
        InternetConnection b = new InternetConnection();
        b.execute(infrared, "192.168.2.132");
    }

    private void showButtonClicked() {
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500); //You can manage the blinking time with this parameter
        Button tv_on_off = findViewById(R.id.tv_remote_quiet);
        tv_on_off.startAnimation(anim);
    }

}
