package com.example.tv_remote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FireTvStick extends AppCompatActivity {

    Button test = findViewById(R.id.button2);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_tv_stick);

        test.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new FireTvStickConnection().execute();
            }
        });


    }
}
