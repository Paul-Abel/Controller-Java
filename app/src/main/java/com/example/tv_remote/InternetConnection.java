package com.example.tv_remote;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class InternetConnection extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... voids) {
        Socket s = null;
        DataOutputStream message = null;

        try {
            s = new Socket("192.168.2.122", 80);
            message = new DataOutputStream(s.getOutputStream());
            MainActivity.
            message.writeUTF("16769565X");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try{
            assert s != null;
            s.close();
            assert message != null;
            message.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
