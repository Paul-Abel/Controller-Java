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

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciver);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.reciver);

        toolbar();
    }

    @Override   //Toolbarsytle wird eingefügt
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override   //Navigation
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.toolbar_led_table:
                Intent led = new Intent(this, Led_table.class);
                startActivity(led);
                return true;
            case R.id.toolbar_television:
                Intent television = new Intent(this, MainActivity.class);
                startActivity(television);
                return true;
            case R.id.toolbar_led_cupboard:
                Intent Led_cupboad = new Intent(this, led_cupboad.class);
                startActivity(Led_cupboad);
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
