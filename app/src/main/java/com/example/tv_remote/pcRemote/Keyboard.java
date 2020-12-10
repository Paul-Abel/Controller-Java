package com.example.tv_remote.pcRemote;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tv_remote.InternetConnection;
import com.example.tv_remote.R;

import org.json.JSONException;
import org.json.JSONObject;

public class Keyboard extends AppCompatActivity {
    private EditText clearTextFile;
    private EditText inputText;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);

        inputText = findViewById(R.id.editTextInput);
        clearTextFile = findViewById(R.id.editTextInput);
        inputText.setOnEditorActionListener(editorListener);

        final Button backToPcRemoteControl = findViewById(R.id.backToPCRemoteControl);
        Button esc = findViewById(R.id.esc);
        Button tab = findViewById(R.id.tab);
        Button winE = findViewById(R.id.winE);
        Button back = findViewById(R.id.back);
        Button windows = findViewById(R.id.windows);
        Button enter = findViewById(R.id.enter);
        Button leftArrow = findViewById(R.id.leftArrow);
        Button rightArrow = findViewById(R.id.rightArrow);
        Button upArrow = findViewById(R.id.upArrow);
        Button downArrow = findViewById(R.id.downArrow);

        backToPcRemoteControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityPCRemoteControl();
            }
        });

        esc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeKeyboardMessage("ESC");
            }
        });
        tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeKeyboardMessage("TAB");
            }
        });
        winE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeKeyboardMessage("WIN_E");
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeKeyboardMessage("BACK");
            }
        });
        windows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeKeyboardMessage("WINDOWS");
            }
        });
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeKeyboardMessage("ENTER");
            }
        });
        leftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeKeyboardMessage("LEFT_ARROW");
            }
        });
        rightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeKeyboardMessage("RIGHT_ARROW");
            }
        });
        upArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeKeyboardMessage("UP_ARROW");
            }
        });
        downArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeKeyboardMessage("DOWN_ARROW");
            }
        });
    }

    public void startActivityPCRemoteControl(){
        Intent pcRemoteControl = new Intent(this, com.example.tv_remote.pcRemote.pcRemoteControl.class);
        startActivity(pcRemoteControl);
    }

    private TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener(){
        @Override
        public boolean onEditorAction(TextView v, int actionID, KeyEvent event){
            if(actionID == EditorInfo.IME_ACTION_SEND){
                    String sendString = inputText.getText().toString();
                    clearTextFile.setText("");
                    writeKeyboardMessage("MESSAGE", sendString);
            }
            return false;
        }
    };

    public void writeKeyboardMessage(String action, String message){
        JSONObject computerMessage = new JSONObject();
        try {
            computerMessage.put("action", action);
            computerMessage.put("message", message);
            pcRemoteControl.sendInfrared(computerMessage.toString());
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }

    public void writeKeyboardMessage(String action){
        JSONObject computerMessage = new JSONObject();
        try {
            computerMessage.put("action", action);
            pcRemoteControl.sendInfrared(computerMessage.toString());
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
}