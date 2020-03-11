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
<<<<<<< HEAD
            MainActivity.
            message.writeUTF("16769565X");
=======
            message.writeUTF(frequenz);
<<<<<<< HEAD
            TimeUnit.MILLISECONDS.sleep(10);
=======
>>>>>>> bd487ea... Led an und Aus
            message.flush();
            message.close();
            s.close();
>>>>>>> c36bcfa... Led an und Aus
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
