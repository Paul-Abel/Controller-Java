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

public class TVRemote2 extends AppCompatActivity {

    private Toolbar toolbar;
    private float x1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_remote2);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.tv_remote2);

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
        Button tv_record = findViewById(R.id.tv_record);
        Button tv_stop = findViewById(R.id.tv_stop);
        Button tv_right = findViewById(R.id.tv_right);
        Button tv_left = findViewById(R.id.tv_left);
        Button tv_up = findViewById(R.id.tv_up);
        Button tv_down = findViewById(R.id.tv_down);
        Button tv_ok = findViewById(R.id.tv_ok);
        Button tv_next = findViewById(R.id.tv_remote_next);

        tv_menu.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772799143X");
            }
        });
        tv_guide.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772838413X");
            }
        });
        tv_source.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772809343X");
            }
        });
        tv_tools.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772830253X");
            }
        });
        tv_return.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772783333X");
            }
        });
        tv_forward.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772781293X");
            }
        });
        tv_backward.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772818013X");
            }
        });
        tv_exit.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772822603X");
            }
        });
        tv_break.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772797613X");
            }
        });
        tv_play.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772834333X");
            }
        });
        tv_record.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772813933X");
            }
        });
        tv_stop.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772801693X");
            }
        });
        tv_right.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772794553X");
            }
        });
        tv_left.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772819033X");
            }
        });
        tv_down.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772810873X");
            }
        });
        tv_up.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772778233X");
            }
        });
        tv_ok.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("3772782313X");
            }
        });
        tv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextPage();
            }
        });

        toolbar();
    }

    private void nextPage(){
        Intent television = new Intent(this, MainActivity.class);
        startActivity(television);
    }

    private void showButtonClicked() {
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500); //You can manage the blinking time with this parameter
        Button tv_on_off = findViewById(R.id.tv_menu);
        tv_on_off.startAnimation(anim);
    }

    public boolean onTouchEvent(MotionEvent touchEvent){
        float x2;
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                if(x1 < x2){
                    nextPage();
                }
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
            case R.id.toolbar_television:
                Intent television = new Intent(this, MainActivity.class);
                startActivity(television);
                return true;
            case R.id.toolbar_receiver:
                Intent receiver = new Intent(this, Receiver.class);
                startActivity(receiver);
                return true;
            case R.id.toolbar_led_cupboard:
                Intent Led_cupboard = new Intent(this, LedCupboard.class);
                startActivity(Led_cupboard);
                return true;
            case R.id.toolbar_led_table:
                Intent LED_table = new Intent(this, LedTable.class);
                startActivity(LED_table);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void toolbar(){  //Insert toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    private void sendInfrared(String infrared){
        InternetConnection b = new InternetConnection();
        b.execute(infrared, "192.168.2.132");
    }
}
