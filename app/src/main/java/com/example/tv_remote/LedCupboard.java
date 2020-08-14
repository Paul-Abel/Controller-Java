package com.example.tv_remote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class LedCupboard extends ToolbarActivity {

    private float x1;
    private ImageView colour_pick;
    private Bitmap bitmap;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar toolbar;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led_cupboard);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.led_cupboard);

        colour_pick = findViewById(R.id.colour_pick);
        colour_pick.setDrawingCacheEnabled(true);
        colour_pick.buildDrawingCache(true);

        Button cupboard_on = findViewById(R.id.cupboard_on);
        Button cupboard_off = findViewById(R.id.cupboard_off);

        colour_pick.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE){
                    bitmap = colour_pick.getDrawingCache();
                    int pixel = bitmap.getPixel((int)event.getX(), (int)event.getY());
                    if(pixel != 0) {
                        showButtonClicked();
                        String html = Integer.toHexString(pixel) + "X";
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
                sendInfrared("ff057cb9X");
            }
        });
        cupboard_off.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                showButtonClicked();
                sendInfrared("00000000X");
            }
        });

        toolbar();
    }

    public boolean onTouchEvent(MotionEvent touchEvent){
        float x2;
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                if(x1 < x2 && (x2-x1)>100){
                    Intent receiver = new Intent(this, MainActivity.class);
                    startActivity(receiver);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                }
                else if(x1 > x2 && (x1-x2)>100){
                    Intent LedTable = new Intent(this, LedTable.class);
                    startActivity(LedTable);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
                break;
        }
        return false;
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
        new InternetConnection().execute(infrared, "192.168.2.125");    //new one ending 138 old ending 125
    }
}
