package com.example.tv_remote;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class InternetConnection extends AsyncTask<String, Void, Void> {
    private Socket s = null;
    private DataOutputStream message = null;
    @Override
    protected Void doInBackground(String... strings) {
        String frequenz = strings[0];
        try {

            s = new Socket("192.168.2.122", 80);
            message = new DataOutputStream(s.getOutputStream());
            message.writeUTF(frequenz);
            message.flush();
            message.close();
            s.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void test(String frequenz){
         Socket t = null;
         DataOutputStream messages = null;
        try {
            t = new Socket("192.168.2.122", 80);
            messages = new DataOutputStream(t.getOutputStream());
            messages.writeUTF(frequenz);
            messages.close();
            t.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    };
}
