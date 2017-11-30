package com.example.android.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Board extends Activity {

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, reset, mainMenu;
    int counter;
    boolean gameActive;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);

        gameActive = true;
        counter = 0;

        tv = findViewById(R.id.declaration);

        reset = findViewById(R.id.reset);
        mainMenu = findViewById(R.id.mainMenu);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);

        reset();

        buttonClick();
    }

    // Sets the text on the button to X.
    public void setX(Button b) {
        b.setText("X");
    }

    // Sets the text on the button to O.
    public void setO(Button b) {
        b.setText("O");
    }

    public void enableButtons(boolean b) {
        b1.setEnabled(b);
        b2.setEnabled(b);
        b3.setEnabled(b);
        b4.setEnabled(b);
        b5.setEnabled(b);
        b6.setEnabled(b);
        b7.setEnabled(b);
        b8.setEnabled(b);
        b9.setEnabled(b);
    }

    // Checks if the text in the button is empty or not.
    public boolean isEmpty(Button b) {
        if (b.getText().toString() == "") {
            return true;
        } else {
            return false;
        }
    }

    // Resets the game.
    public void reset() {
        counter = 0;
        gameActive = true;

        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");

        enableButtons(true);
    }

    // handles each button click.
    public void buttonClick() {

        reset.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
                Toast.makeText(Board.this,"Game has been reset",
                        Toast.LENGTH_SHORT).show();
            }
        });

        mainMenu.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mm = new Intent(Board.this, MainActivity.class);
                startActivity(mm);
                finish();
            }
        });

        while(gameActive) {
            b1.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (counter % 2 == 0) {
                        setX(b1);
                    } else {
                        setO(b1);
                    }
                    checkForWinner();
                }
            });

            b2.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (counter % 2 == 0) {
                        setX(b2);
                    } else {
                        setO(b2);
                    }
                    checkForWinner();
                }
            });

            b3.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (counter % 2 == 0) {
                        setX(b3);
                    } else {
                        setO(b3);
                    }
                    checkForWinner();
                }
            });

            b4.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (counter % 2 == 0) {
                        setX(b4);
                    } else {
                        setO(b4);
                    }
                    checkForWinner();
                }
            });

            b5.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (counter % 2 == 0) {
                        setX(b5);
                    } else {
                        setO(b5);
                    }
                    checkForWinner();
                }
            });

            b6.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (counter % 2 == 0) {
                        setX(b6);
                    } else {
                        setO(b6);
                    }
                    checkForWinner();
                }
            });

            b7.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (counter % 2 == 0) {
                        setX(b7);
                    } else {
                        setO(b7);
                    }
                    checkForWinner();
                }
            });

            b8.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (counter % 2 == 0) {
                        setX(b8);
                    } else {
                        setO(b8);
                    }
                    checkForWinner();
                }
            });

            b9.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (counter % 2 == 0) {
                        setX(b9);
                    } else {
                        setO(b9);
                    }
                    checkForWinner();
                }
            });
        }
    }

    public void checkForWinner() {
        if (gameActive && !isEmpty(b1) && b1.getText().toString() == b2.getText().toString() &&
                b1.getText().toString() == b3.getText().toString()) {
            tv.setText("The winner is player: " + b1.getText().toString());
            gameActive = false;
            enableButtons(false);
        }

        if (gameActive && !isEmpty(b4) && b4.getText().toString() == b5.getText().toString() &&
                b4.getText().toString() == b6.getText().toString()) {
            tv.setText("The winner is player: " + b4.getText().toString());
            gameActive = false;
            enableButtons(false);
        }

        if (gameActive && !isEmpty(b7) && b7.getText().toString() == b8.getText().toString() &&
                b7.getText().toString() == b9.getText().toString()) {
            tv.setText("The winner is player: " + b7.getText().toString());
            gameActive = false;
            enableButtons(false);
        }

        if (gameActive && !isEmpty(b1) && b1.getText().toString() == b4.getText().toString() &&
                b1.getText().toString() == b7.getText().toString()) {
            tv.setText("The winner is player: " + b1.getText().toString());
            gameActive = false;
            enableButtons(false);
        }

        if (gameActive && !isEmpty(b2) && b2.getText().toString() == b5.getText().toString() &&
                b2.getText().toString() == b8.getText().toString()) {
            tv.setText("The winner is player: " + b2.getText().toString());
            gameActive = false;
            enableButtons(false);
        }

        if (gameActive && !isEmpty(b3) && b3.getText().toString() == b6.getText().toString() &&
                b3.getText().toString() == b9.getText().toString()) {
            tv.setText("The winner is player: " + b3.getText().toString());
            gameActive = false;
            enableButtons(false);
        }

        if (gameActive && !isEmpty(b1) && b1.getText().toString() == b5.getText().toString() &&
                b1.getText().toString() == b9.getText().toString()) {
            tv.setText("The winner is player: " + b1.getText().toString());
            gameActive = false;
            enableButtons(false);
        }

        if (gameActive && !isEmpty(b3) && b3.getText().toString() == b5.getText().toString() &&
                b3.getText().toString() == b7.getText().toString()) {
            tv.setText("The winner is player: " + b3.getText().toString());
            gameActive = false;
            enableButtons(false);
        }

        if (counter == 9 && gameActive) {
            tv.setText("The match is a tie. Press RESET or go to the main menu.");
            gameActive = false;
            enableButtons(false);
        }
    }
}
