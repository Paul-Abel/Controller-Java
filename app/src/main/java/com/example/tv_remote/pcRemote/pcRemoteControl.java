package com.example.tv_remote.pcRemote;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.tv_remote.InternetConnection;
import com.example.tv_remote.R;
import com.example.tv_remote.ToolbarActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class pcRemoteControl extends ToolbarActivity implements View.OnTouchListener, GestureDetector.OnGestureListener, AlertDialog.AlertDialogListener, AlertPasswordDialog.AlertPasswordDialogListener {
    private GestureDetector mGestureDetector;
    private int initX, initY;
    boolean mouseMoved = false, multiTouch = false;

    @Override
    protected void onPause() {
        InternetConnection.changeBooleanFalse();
        super.onPause();
    }

    @SuppressLint({"CutPasteId", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar toolbar;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pc_remote_control);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.pcRemoteControl);

        final Dialog musicControlDialog = new Dialog(this);

        ImageView imageOnCreate = findViewById(R.id.mousePad);
        imageOnCreate.setOnTouchListener(this);
        mGestureDetector = new GestureDetector(this, this);

        final Button shutdown = findViewById(R.id.shutdown);
        Button powerSavingMode = findViewById(R.id.powerSavingMode);
        Button lockScreen = findViewById(R.id.lockScreen);
        Button rightClick = findViewById(R.id.rightClick);
        Button leftClick = findViewById(R.id.leftClick);
        //Button menu = findViewById(R.id.menu);
        Button musicControl = findViewById(R.id.musicControl);
        Button keyboard = findViewById(R.id.keyboard);
        //Button volume = findViewById(R.id.volume);

        shutdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPasswordDialog();
            }
        });

        powerSavingMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putSendJSON("CMD","lockScreen");
            }
        });

        lockScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAlertDialog();
            }
        });

        rightClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putSendJSON("RIGHT_CLICK");
            }
        });

        leftClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putSendJSON("LEFT_CLICK");
            }
        });

        keyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startKeyboardActivity();
            }
        });

        musicControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicControlDialog.setContentView(R.layout.dialog_musiccontrol);
                Objects.requireNonNull(musicControlDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                musicControlDialog.show();

                Button goBack = musicControlDialog.findViewById(R.id.goBack);
                Button goForward = musicControlDialog.findViewById(R.id.goForward);
                Button startStop = musicControlDialog.findViewById(R.id.startStop);

                goBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        putSendJSON("MUSIC_CONTROL","back");
                    }
                });
                goForward.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        putSendJSON("MUSIC_CONTROL","forward");
                    }
                });
                startStop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        putSendJSON("MUSIC_CONTROL","playStop");
                    }
                });
            }
        });


        toolbar();
    }

    public void startKeyboardActivity(){
        Intent keyboard = new Intent(this, Keyboard.class);
        startActivity(keyboard);
    }

    public void putSendJSON(String action){
        JSONObject computerMessage = new JSONObject();
        try {
            computerMessage.put("action", action);
            sendInfrared(computerMessage.toString());
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }

    public void putSendJSON(String action, String message){
        JSONObject computerMessage = new JSONObject();
        try {
            computerMessage.put("action", action);
            computerMessage.put("message", message);
            sendInfrared(computerMessage.toString());
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }

    private void toolbar(){  //Insert Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void sendInfrared(String textString){
        InternetConnection.changeBooleanTrue();
        new InternetConnection().execute(textString, "192.168.2.149");  //149 when  lan connected, 118 when w-lan
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        putSendJSON("LEFT_CLICK");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        putSendJSON("LONG_PRESS");
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent motionEvent) {
        mGestureDetector.onTouchEvent(motionEvent);
        int xPosition, yPosition, sendX, sendY;

        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                //save X and Y positions when user on touch
                initX = (int) motionEvent.getX();
                initY = (int) motionEvent.getY();
                mouseMoved = false;
                break;
            case MotionEvent.ACTION_MOVE:
                if(!multiTouch) {
                    xPosition = (int) motionEvent.getX() - initX;   //Mouse movement in x direction
                    yPosition = (int) motionEvent.getY() - initY;   //Mouse movement in y direction
                    //set init to new position so that continuous mouse movement is captured
                    sendX = (int) motionEvent.getX();
                    sendY = (int) motionEvent.getY();
                    if (sendX != 0 || sendY != 0) {
                        //send mouse movement to server
                        JSONObject computerMessage = new JSONObject();
                        try {
                            computerMessage.put("action","MOUSE_MOVE");
                            computerMessage.put("xPosition", Integer.toString(xPosition));
                            computerMessage.put("yPosition", Integer.toString(yPosition));
                            sendInfrared(computerMessage.toString());
                            mouseMoved=true;
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
                else{
                    yPosition = (int) motionEvent.getY() - initY;   //Mouse movement in y direction
                    yPosition = yPosition / 2;                      //to scroll by less amount
                    initY = (int) motionEvent.getY();
                    if(yPosition != 0) {
                        JSONObject computerMessage = new JSONObject();
                        try {
                            computerMessage.put("action","MOUSE_WHEEL");
                            computerMessage.put("yPosition", Integer.toString(yPosition));
                            sendInfrared(computerMessage.toString());
                            mouseMoved=true;
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                //consider a tap only if user did not move mouse after ACTION_DOWN
                if(!mouseMoved){
                    putSendJSON("LEFT_CLICK");
                }
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                initY = (int) motionEvent.getY();
                mouseMoved = false;
                multiTouch = true;
                break;
            case MotionEvent.ACTION_POINTER_UP:
                if(!mouseMoved) {
                    putSendJSON("LEFT_CLICK");
                }
                multiTouch = false;
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }
    @Override
    public void onShowPress(MotionEvent e) {

    }
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    public void openPasswordDialog(){
        AlertPasswordDialog dialog = new AlertPasswordDialog();
        dialog.show(getSupportFragmentManager(),"alert password dialog");
    }

    public void openAlertDialog() {
        AlertDialog dialog = new AlertDialog();
        dialog.show(getSupportFragmentManager(), "alert dialog");
    }

    @Override
    public void onYesClicked() {
        putSendJSON("CMD","powerSavingMode");
    }

    public void applyTexts(String password) {
        if(password.equals("shutdownMyPC")){
            putSendJSON("CMD","shutdown");
            Toast.makeText(getApplicationContext(), "password was written down", Toast.LENGTH_SHORT).show();
        }
    }
}