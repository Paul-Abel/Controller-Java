package com.example.tv_remote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.DataOutput;

public class MainActivity extends AppCompatActivity {

    private Button led_Aus;
    private Button led_An;
    private TextView testText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        led_Aus = findViewById(R.id.button);
        led_An.findViewById(R.id.button2);

        led_Aus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendeInfrarot("16769565X");
            }
        });

        led_An.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendeInfrarot("16753245");
            }
        });
        toolbar();
        animatedbackground();
    }
    @Override   //Toolbarsytle wird eingefügt
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_example, menu);
        return true;
    }

    @Override   //Navigation
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.toolbar_led:
                Intent led = new Intent(this, Led.class);
                startActivity(led);
                return true;
            case R.id.toolbar_reciver:
                Intent reciver = new Intent(this, Reciver.class);
                startActivity(reciver);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void toolbar(){  //Navigation wird eingefügt
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void animatedbackground(){
        ConstraintLayout constraintLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }

    public void sendeInfrarot(String infratrot){
        InternetConnection b = new InternetConnection();
        b.execute(infratrot);
    }

}
