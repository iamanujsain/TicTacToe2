package com.example.android.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash_intro extends Activity {

    Intent mainActivity;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toast_intro);

        BoardTwo.flag = false;

        thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mainActivity = new Intent(Splash_intro.this, MainActivity.class);
                    startActivity(mainActivity);
                    finish();
                }
            }
        };

        thread.start();
    }
}
