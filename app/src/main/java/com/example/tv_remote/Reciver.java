package com.example.tv_remote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Reciver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciver);

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
            case R.id.toolbar_television:
                Intent television = new Intent(this, MainActivity.class);
                startActivity(television);
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
