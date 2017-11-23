package com.example.android.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class Board extends Activity {

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);
    }
}
