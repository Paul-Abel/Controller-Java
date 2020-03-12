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

    public static DataOutput message;
    private Button testButton;
    private TextView testText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testButton = findViewById(R.id.button);
        testText = findViewById(R.id.textView2);

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InternetConnection b = new InternetConnection();
                b.execute();
                testText.setText("sollte funktioniert haben");
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
<<<<<<< HEAD
            case R.id.toolbar_led:
=======
<<<<<<< HEAD
            case R.id.toolbar_led_table:
<<<<<<< HEAD
>>>>>>> df504d8... LED ansteuern funktioniert
                Intent led = new Intent(this, Led.class);
=======
                Intent led = new Intent(this, Led_table.class);
=======
            case R.id.toolbar_led_tisch:
                Intent led = new Intent(this, Led.class);
>>>>>>> 629eb64... LED ansteuern funktioniert
>>>>>>> 1a5d85a... LED ansteuern funktioniert
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

<<<<<<< HEAD
=======
    public void sendeInfrarot(String infrarot){
        InternetConnection b = new InternetConnection();
<<<<<<< HEAD
<<<<<<< HEAD
        b.execute(infrarot);
=======
        //b.execute(infrarot);
        b.test(infrarot);
>>>>>>> 629eb64... LED ansteuern funktioniert
=======
        b.execute(infrarot);
>>>>>>> ce959a9... Erster funktionierender test mit LED
    }

>>>>>>> df504d8... LED ansteuern funktioniert
}
