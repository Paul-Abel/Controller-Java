package com.example.tv_remote;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
@RequiresApi(api = Build.VERSION_CODES.M)
public class Led extends AppCompatActivity {

    private Button main;
    private Button led_anzeige;
    private Button led_red;
    private Button led_blue;
    private TextView headline;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led);

        led_red = findViewById(R.id.led_red);
        led_blue = findViewById(R.id.led_blue);
        led_anzeige = findViewById(R.id.led_anzeige);
        main = findViewById(R.id.LED_ChanceSite);

        headline = findViewById(R.id.LedHeader);



        main.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mainmenu();
            }
        });

        led_red.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                aktualiesereFarbe(R.color.red);
            }
        });

        led_blue.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                aktualiesereFarbe(R.color.blue);
            }
        });

    }

    public void mainmenu(){
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }


    //requires API-Level 23 also mindestens Android 6 Marshmellow
    public void aktualiesereFarbe(int farbID){
        int Farbe = getColor(farbID);
        led_anzeige.setBackgroundColor(Farbe);
    }
}
