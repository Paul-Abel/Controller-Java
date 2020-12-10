package com.example.tv_remote;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends ToolbarActivity {

private float x1,y1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar toolbar;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.television);

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
                Toast.makeText(getApplicationContext(), "Buttom 'Next' isn't working!", Toast.LENGTH_SHORT).show();
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
                if(x1 < x2 && (y1-y2)*4 < (x2-x1) && (-4*(y1-y2) < (x2-x1))){
                    Intent led = new Intent(this, LedTable.class);
                    startActivity(led);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                }
                else if(x1 > x2 && (y1-y2)*4 < (x1-x2) && (-4*(y2-y1) < (x1-x2))){
                    Intent receiver = new Intent(this, LedCupboard.class);
                    startActivity(receiver);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
                else if(y1 > y2){
                    Intent tv_remote2 = new Intent(this, TVRemote2.class);
                    startActivity(tv_remote2);
                    overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
                }
                else if(y1 < y2){
                    Intent tv_remote2 = new Intent(this, TVRemote2.class);
                    startActivity(tv_remote2);
                    overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);
                }
                break;
        }
        return false;
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
}
