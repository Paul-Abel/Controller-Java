package com.example.tv_remote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Led extends AppCompatActivity {

    private Button main;
    private TextView headline;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led);

        main = (Button) findViewById(R.id.LED_ChanceSite);
        headline = (TextView) findViewById(R.id.LedHeader);

        main.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mainmenu();
            }
        });
    }

    public void mainmenu(){
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }
}
