package com.example.tv_remote;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

@RequiresApi(api = Build.VERSION_CODES.M)
public class Led extends AppCompatActivity {

    private Button main;
    private Button led_anzeige;
    private Button led_red;
    private Button led_blue;
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> 5a61ff9... bugfix toolbar
<<<<<<< HEAD
    private Toolbar toolbar;
=======
>>>>>>> 1a5d85a... LED ansteuern funktioniert
<<<<<<< HEAD
>>>>>>> df504d8... LED ansteuern funktioniert
=======
=======
    private Toolbar toolbar;
>>>>>>> 2fbeac3... bugfix toolbar
>>>>>>> 5a61ff9... bugfix toolbar




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
<<<<<<< HEAD
        setContentView(R.layout.activity_led);
=======
=======
>>>>>>> 5a61ff9... bugfix toolbar
<<<<<<< HEAD
        setContentView(R.layout.activity_led_table);
>>>>>>> df504d8... LED ansteuern funktioniert

        led_red = findViewById(R.id.led_red);
        led_blue = findViewById(R.id.led_blue);
        led_anzeige = findViewById(R.id.led_anzeige);
<<<<<<< HEAD
=======
        toolbar.setTitle(R.string.led_table);
=======
        setContentView(R.layout.activity_led);
=======
        setContentView(R.layout.activity_led_table);
>>>>>>> 2fbeac3... bugfix toolbar

        toolbar = findViewById(R.id.toolbar);
        led_red = findViewById(R.id.led_red);
        led_blue = findViewById(R.id.led_blue);
        led_anzeige = findViewById(R.id.led_anzeige);
<<<<<<< HEAD
>>>>>>> 1a5d85a... LED ansteuern funktioniert
<<<<<<< HEAD
>>>>>>> df504d8... LED ansteuern funktioniert
=======
=======
        toolbar.setTitle(R.string.led_table);
>>>>>>> 2fbeac3... bugfix toolbar
>>>>>>> 5a61ff9... bugfix toolbar

        animatedbackground();
        toolbar();

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

    @Override   //Toolbarsytle wird eingefügt
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_example, menu);
        return true;
    }

    @Override   //Navigation
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.toolbar_television:
                Intent television = new Intent(this, MainActivity.class);
                startActivity(television);
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
<<<<<<< HEAD
<<<<<<< HEAD
        Toolbar toolbar = findViewById(R.id.toolbar);
=======
=======
>>>>>>> 5a61ff9... bugfix toolbar
<<<<<<< HEAD
        toolbar = findViewById(R.id.toolbar);
=======
        Toolbar toolbar = findViewById(R.id.toolbar);
>>>>>>> 1a5d85a... LED ansteuern funktioniert
<<<<<<< HEAD
>>>>>>> df504d8... LED ansteuern funktioniert
=======
=======
        toolbar = findViewById(R.id.toolbar);
>>>>>>> 2fbeac3... bugfix toolbar
>>>>>>> 5a61ff9... bugfix toolbar
        setSupportActionBar(toolbar);
    }

    public void animatedbackground(){
        ConstraintLayout constraintLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }

    public void aktualiesereFarbe(int farbID){
        int Farbe = getColor(farbID);
        led_anzeige.setBackgroundColor(Farbe);
    }
}
