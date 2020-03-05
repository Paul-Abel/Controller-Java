package com.example.tv_remote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button testButton;
    private TextView testText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testButton = (Button) findViewById(R.id.Main_LedButton);
        testText = (TextView) findViewById(R.id.MainHeader);

        testButton.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    openled();
                }
        });


    }
    public void openled(){
        Intent led = new Intent(this, Led.class);
        startActivity(led);
    }
}
