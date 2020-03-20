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

public class LedCupboard extends AppCompatActivity {

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

    @Override   //insert toolbar layout
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
            case
                R.id.toolbar_receiver:
                Intent receiver = new Intent(this, Receiver.class);
                startActivity(receiver);
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
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500); //You can manage the blinking time with this parameter
        Button cupboard_on = findViewById(R.id.cupboard_on);
        cupboard_on.startAnimation(anim);
    }

    private void sendInfrared(String infrared){
        InternetConnection b = new InternetConnection();
        b.execute(infrared);
    }
}
