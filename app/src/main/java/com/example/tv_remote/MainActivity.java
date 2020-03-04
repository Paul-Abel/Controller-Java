package com.example.tv_remote;

import androidx.appcompat.app.AppCompatActivity;

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

        testButton = (Button) findViewById(R.id.TestButton);
        testText = (TextView) findViewById(R.id.TestText);

        testButton.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    testText.setText("Es hat funktioniert");
                }
        });
    }
}
