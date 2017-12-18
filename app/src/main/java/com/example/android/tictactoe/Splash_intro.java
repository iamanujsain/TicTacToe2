package com.example.android.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

public class Splash_intro extends Activity {

    Intent mainActivity;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toast_intro);

        Toast toast = Toast.makeText(this, "Made by Anuj", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0,50);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();

        Board.flag = false;

        thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
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
