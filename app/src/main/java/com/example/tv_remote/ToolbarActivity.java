package com.example.tv_remote;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ToolbarActivity extends AppCompatActivity{

    @Override   //insert toolbar layout
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override   //Navigation
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.toolbar_led_table:
                Intent led = new Intent(this, LedTable.class);
                startActivity(led);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                return true;
            case R.id.toolbar_television:
                Intent television = new Intent(this, MainActivity.class);
                startActivity(television);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                return true;
            case R.id.toolbar_receiver:
                Intent receiver = new Intent(this, Receiver.class);
                startActivity(receiver);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                return true;
            case R.id.toolbar_led_cupboard:
                Intent Led_cupboard = new Intent(this, LedCupboard.class);
                startActivity(Led_cupboard);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                return true;
            case R.id.toolbar_room_light:
                Toast.makeText(getApplicationContext(), "light on/off", Toast.LENGTH_SHORT).show();
                InternetConnection a = new InternetConnection();
                a.execute("-555X","192.168.2.154");
                return true;
            case R.id.toolbar_table_ventilator:
                Toast.makeText(getApplicationContext(), "Ventilator on/off", Toast.LENGTH_SHORT).show();
                InternetConnection b = new InternetConnection();
                b.execute("300X","192.168.2.101");  //normaly 300X 192.168.2.101 just testing partyCube with 16753245
                return true;
            case R.id.toolbar_pc_energyConservation:
                Toast.makeText(getApplicationContext(), "PC get in power saving  mode.", Toast.LENGTH_SHORT).show();
                InternetConnection c = new InternetConnection();
                c.execute("powerSavingModeX","192.168.2.102");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
