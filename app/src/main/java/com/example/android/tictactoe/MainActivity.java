package com.example.android.tictactoe;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView chc;
    Button cnf, ext;
    RadioGroup rdg;
    RadioButton one, two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chc = findViewById(R.id.choice); // choice
        cnf = findViewById(R.id.confirm); // confirm
        ext = findViewById(R.id.exit); // exit
        rdg = findViewById(R.id.ox); // RadioGroup
        one = findViewById(R.id.one); // RadioButton one
        two = findViewById(R.id.two); // RadioButton two

        cnf.setEnabled(false);

        // custom toast
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_intro,
                (ViewGroup) findViewById(R.id.toast_intro));
        Toast toast = new Toast(MainActivity.this);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

        rdg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                cnf.setEnabled(true);
                switch (i) {
                    case R.id.one:
                        chc.setText("You've chosen 'One Player'");
                        pressConfirm();
                        break;
                    case R.id.two:
                        chc.setText("You've chosen 'Two Players'");
                        pressConfirm();
                        break;
                }
            }
        });

        // An alert dialog box appears when the player presses the exit button.
        ext.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder a = new AlertDialog.Builder(MainActivity.this);
                a.setCancelable(false);
                a.setTitle("Exit?");
                a.setMessage("Are you sure you want to exit?");
                a.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();
            }
        });
    }

    protected void pressConfirm() {
        Toast toast = Toast.makeText(MainActivity.this, "Press CONFIRM", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }
}
