package com.example.tv_remote;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

class InternetConnection extends AsyncTask<String, Void, Void> {

    @Override
    protected Void doInBackground(String... strings) {
        Socket s;
        DataOutputStream message;
        String frequency = strings[0];
        try {

            s = new Socket("192.168.2.122", 80);
            message = new DataOutputStream(s.getOutputStream());
            message.writeUTF(frequency);
            TimeUnit.MILLISECONDS.sleep(10);
            message.flush();
            message.close();
            s.close();
        }
        catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
