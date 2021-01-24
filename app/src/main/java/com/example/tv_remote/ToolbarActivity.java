package com.example.tv_remote;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ToolbarActivity extends AppCompatActivity{
    public char navigationIntent = 0;

    @Override   //insert toolbar layout
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override   //Navigation
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.toolbar_left_page:
                switch (navigationIntent){
                    case 1:     //if current activity equals MainActivity
                        Intent intent0 = new Intent(this, LedTable.class);
                        startActivity(intent0);
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                        break;
                    case 2:     //if current activity equals LedTable
                        Intent intent1 = new Intent(this, LedCupboard.class);
                        startActivity(intent1);
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                        break;
                    /*case 3:     //if current activity equals LedCupboard
                        Intent intent2 = new Intent(this, MainActivity.class);
                        startActivity(intent2);
                        break;*/
                    default:    //for the rest activity's
                        Intent intent3 = new Intent(this, MainActivity.class);
                        startActivity(intent3);
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                        break;
                }
                return true;
            case R.id.toolbar_right_page:
                switch (navigationIntent){
                    case 1:     //if current activity equals MainActivity
                        Intent intent0 = new Intent(this, LedCupboard.class);
                        startActivity(intent0);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    /*case 2:     //if current activity equals LedTable
                        Intent intent1 = new Intent(this, MainActivity.class);
                        startActivity(intent1);
                        break;*/
                    case 3:     //if current activity equals LedCupboard
                        Intent intent2 = new Intent(this, LedTable.class);
                        startActivity(intent2);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    default:    //for the rest activity's
                        Intent intent3 = new Intent(this, MainActivity.class);
                        startActivity(intent3);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                }
                return true;
            case R.id.toolbar_room_light:
                Toast.makeText(getApplicationContext(), "'Room_Light' turn ON/OFF!", Toast.LENGTH_SHORT).show();
                InternetConnection.changeBooleanFalse();
                InternetConnection a = new InternetConnection();
                a.execute("-555X","192.168.2.154");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
