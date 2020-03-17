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

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    float x1,x2,y1,y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.television);

        Button tv_on_off = findViewById(R.id.tv_remote_on_off);
        Button tv_hdmi = findViewById(R.id.tv_remote_hdmi);
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
        Button tv_louder = findViewById(R.id.tv_remote_louder);
        Button tv_quiter = findViewById(R.id.tv_remote_quiter);
        Button tv_up = findViewById(R.id.tv_remote_up);
        Button tv_down = findViewById(R.id.tv_remote_down);

        tv_on_off.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("3772793023X");
            }
        });
        tv_hdmi.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("3772829998X");
            }
        });
        tv_silence.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("3772837903X");
            }
        });
        tv_0.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("3772811383X");
            }
        });
        tv_1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("3772784863X");
            }
        });
        tv_2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("3772817503X");
            }
        });
        tv_3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("3772801183X");
            }
        });
        tv_4.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("3772780783X");
            }
        });
        tv_5.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("3772813423X");
            }
        });
        tv_6.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("3772797103X");
            }
        });
        tv_7.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("3772788943X");
            }
        });
        tv_8.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("3772821583X");
            }
        });
        tv_9.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("3772805263X");
            }
        });
        tv_louder.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("3772833823X");
            }
        });
        tv_quiter.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("3772829743X");
            }
        });
        tv_up.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("3772795063X");
            }
        });
        tv_down.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonclicked();
                sendInfrarot("3772778743X");
            }
        });


        toolbar();
    }

    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if(x1 > x2){
                    Intent tv_remote2 = new Intent(this, tv_remote2.class);
                    startActivity(tv_remote2);
                }
                break;
        }
        return false;
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
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void sendInfrarot(String infrarot){
        InternetConnection b = new InternetConnection();
        b.execute(infrarot);
    }

    public void showButtonclicked() {
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500); //You can manage the blinking time with this parameter
        Button tv_on_off = findViewById(R.id.tv_remote_quiet);
        tv_on_off.startAnimation(anim);
    }

}
