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
import android.widget.Button;
import android.widget.Toast;

public class TVRemote3 extends AppCompatActivity {

    private Toolbar toolbar;
    private float x1,y1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_remote3);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.tv_fire_tv);

        Button test = findViewById(R.id.button);

        test.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                sendInfrared("");
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
                if(x1 < x2 && (y1-y2) < (x2-x1)){
                    ledTable();
                }
                else if(x1 > x2 && (y1-y2) < (x1-x2)){
                    receiver();
                }
                else if(y1 > y2){
                    firstPage();
                }
                break;
        }
        return false;
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

    private void firstPage(){
        Intent television = new Intent(this, MainActivity.class);
        startActivity(television);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
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
                firstPage();
                return true;
            case R.id.toolbar_receiver:
                receiver();
                return true;
            case R.id.toolbar_led_cupboard:
                Intent Led_cupboard = new Intent(this, LedCupboard.class);
                startActivity(Led_cupboard);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                return true;
            case R.id.toolbar_led_table:
                ledTable();
                return true;
            case R.id.toolbar_room_light:
                Toast.makeText(getApplicationContext(), "Button not at work", Toast.LENGTH_SHORT).show();
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
        b.execute(infrared, "192.168.2.136");
    }
}
