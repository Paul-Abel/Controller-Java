package com.example.tv_remote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class led_cupboad extends AppCompatActivity {

<<<<<<< HEAD
<<<<<<< HEAD
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led_cupboard);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.led_cupboard);
=======
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led_cupboad);
>>>>>>> 629eb64... LED ansteuern funktioniert
=======
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led_cupboard);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.led_cupboard);
>>>>>>> e4ef53f... bugfix toolbar

        toolbar();
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
<<<<<<< HEAD
            case R.id.toolbar_led_table:
<<<<<<< HEAD
                Intent led = new Intent(this, Led.class);
=======
                Intent led = new Intent(this, Led_table.class);
=======
            case R.id.toolbar_led_tisch:
=======
            case R.id.toolbar_led_table:
<<<<<<< HEAD
>>>>>>> e4ef53f... bugfix toolbar
                Intent led = new Intent(this, Led.class);
>>>>>>> 629eb64... LED ansteuern funktioniert
<<<<<<< HEAD
>>>>>>> 1a5d85a... LED ansteuern funktioniert
=======
=======
                Intent led = new Intent(this, Led_table.class);
>>>>>>> 035903b... LED_table works
>>>>>>> af50cf2... LED_table works
                startActivity(led);
                return true;
            case R.id.toolbar_television:
                Intent television = new Intent(this, MainActivity.class);
                startActivity(television);
                return true;
            case
                R.id.toolbar_reciver:
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
}
