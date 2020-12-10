package com.example.tv_remote;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;

public class TVRemote2 extends ToolbarActivity {

    private Toolbar toolbar;
    private float x1, y1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_remote2);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.tv_remote2);

        Button tv_menu = findViewById(R.id.tv_menu);
        Button tv_guide = findViewById(R.id.tv_guide);
        Button tv_source = findViewById(R.id.source);
        Button tv_tools = findViewById(R.id.tv_tools);
        Button tv_return = findViewById(R.id.tv_return);
        Button tv_exit = findViewById(R.id.tv_exit);
        Button tv_forward = findViewById(R.id.tv_forward);
        Button tv_backward = findViewById(R.id.tv_backward);
        Button tv_break = findViewById(R.id.tv_break);
        Button tv_play = findViewById(R.id.tv_play);
        Button tv_stop = findViewById(R.id.tv_stop);
        Button tv_right = findViewById(R.id.tv_right);
        Button tv_left = findViewById(R.id.tv_left);
        Button tv_up = findViewById(R.id.tv_up);
        Button tv_down = findViewById(R.id.tv_down);
        Button tv_ok = findViewById(R.id.tv_ok);
        Button tv_HDMI = findViewById(R.id.tv_HDMI);
        Button tv_record = findViewById(R.id.tv_record);

        tv_menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772799143");
            }
        });
        tv_guide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772838413");
            }
        });
        tv_source.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772809343");
            }
        });
        tv_tools.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772830253");
            }
        });
        tv_return.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772783333");
            }
        });
        tv_forward.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772781293");
            }
        });
        tv_backward.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772818013");
            }
        });
        tv_exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772822603");
            }
        });
        tv_break.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772797613");
            }
        });
        tv_play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772834333");
            }
        });
        tv_stop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772801693");
            }
        });
        tv_right.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772794553");
            }
        });
        tv_left.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772819033");
            }
        });
        tv_down.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772810873");
            }
        });
        tv_up.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772778233");
            }
        });
        tv_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772782313");
            }
        });
        tv_HDMI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772829998");
            }
        });
        tv_record.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showButtonClicked();
                sendInfrared("3772813933");
            }
        });
        toolbar();
    }

    public boolean onTouchEvent(MotionEvent touchEvent) {
        float x2, y2;
        switch (touchEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if (x1 < x2 && (y2 - y1) * 4 < (x2 - x1) && (-4 * (y1 - y2) < (x2 - x1))) {
                    Intent led = new Intent(this, LedTable.class);
                    startActivity(led);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                } else if (x1 > x2 && (y2 - y1) * 4 < (x1 - x2) && (-4 * (y2 - y1) < (x1 - x2))) {
                    Intent receiver = new Intent(this, LedCupboard.class);
                    startActivity(receiver);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                } else if (y1 < y2) {
                    Intent television = new Intent(this, MainActivity.class);
                    startActivity(television);
                    overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);
                } else if (y1 > y2) {
                    Intent television = new Intent(this, MainActivity.class);
                    startActivity(television);
                    overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
                }
                break;
        }
        return false;
    }

    private void toolbar() {  //Insert toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void showButtonClicked() {
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500); //You can manage the blinking time with this parameter
        Button tv_on_off = findViewById(R.id.tv_HDMI);
        tv_on_off.startAnimation(anim);
    }

    private void sendInfrared(String infrared) {
        new InternetConnection().execute(infrared + "X", "192.168.2.102");    //"X" used as ending signal by esp ,102
    }
}


