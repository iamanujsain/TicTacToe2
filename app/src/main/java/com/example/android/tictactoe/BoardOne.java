package com.example.android.tictactoe;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BoardOne extends Activity {

    public static boolean flag;

    private RadioButton x, o;
    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, reset, mainMenu;
    private int counter;
    private boolean gameActive, x_chosen;
    private TextView tv;
    private List l;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);

        /**
         * Dialog box for choosing character
         */
        final Dialog dialog = new Dialog(BoardOne.this);
        dialog.setContentView(R.layout.choose_player);
        dialog.setCancelable(false);
        dialog.setTitle("Choose a character...");
        x = (RadioButton) dialog.findViewById(R.id.x);
        o = (RadioButton) dialog.findViewById(R.id.o);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x_chosen = true;
                Toast toast = Toast.makeText(BoardOne.this,
                        "You're 'X'.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();
                dialog.dismiss();
            }
        });
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x_chosen = false;
                Toast toast = Toast.makeText(BoardOne.this,
                        "You're 'O'.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();
                dialog.dismiss();
            }
        });
        dialog.show();

        BoardTwo.flag = true;
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

        l = new ArrayList<Button>();

        l.add(b1);
        l.add(b2);
        l.add(b3);
        l.add(b4);
        l.add(b5);
        l.add(b6);
        l.add(b7);
        l.add(b8);
        l.add(b9);

        reset();

        /**
         * If the human player chooses player 'O', the computer will make the first
         * move as player 'X' and this move will be generated randomly. After making
         * the move the button will be disabled and 1 will be added to the global
         * variable counter.
         */
        if (!x_chosen && gameActive) {
            Random r = new Random();
            int m = r.nextInt(10);;
            ((Button) l.get(m)).setText("X");
            counter++;
            ((Button) l.get(m)).setEnabled(false);
        }

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

    // Enables or disables buttons in the game board.
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

    // Tells player X to make a move.
    public void dec_X() {
        if (gameActive) {
            tv.setText("Player X, make you move!");
        }
    }

    // Tells player O to make a move.
    public void dec_O() {
        if (gameActive) {
            tv.setText("Player O, make your move!");
        }
    }

    // Makes a random move and disables the button.
    public void randomMove() {
        if (x_chosen) {
            text = "O";
        } else {
            text = "X";
        }

        Random r = new Random();
        int rand = r.nextInt(10);
        if (gameActive) {
            if (!isEmpty((Button) l.get(rand))) {
                ((Button) l.get(rand)).setText(text);
                ((Button) l.get(rand)).setEnabled(false);
                counter++;
            } else {
                randomMove();
            }
        }
    }

    public void buttonClick1() {
         if (gameActive) {
             b1.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     if (counter % 2 == 0) {
                         if (x_chosen) {
                             setX(b1);
                             dec_O();
                         }
                     } else {
                         if (!x_chosen) {
                             setO(b1);
                         }
                     }
                     b1.setEnabled(false);
                     counter++;
                     checkForWinner();
                     randomMove();
                 }
             });

             b2.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     if (counter % 2 == 0) {
                         if (x_chosen) {
                             setX(b2);
                             dec_O();
                         }
                     } else {
                         if (!x_chosen) {
                             setO(b2);
                             dec_X();
                         }
                     }
                     b2.setEnabled(false);
                     counter++;
                     checkForWinner();
                     randomMove();
                 }
             });

             b3.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     if (counter % 2 == 0) {
                         if (x_chosen) {
                             setX(b3);
                             dec_O();
                         }
                     } else {
                         if (!x_chosen) {
                             setO(b3);
                             dec_X();
                         }
                     }
                     b3.setEnabled(false);
                     counter++;
                     checkForWinner();
                     randomMove();
                 }
             });

             b4.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     if (counter % 2 == 0) {
                         if (x_chosen) {
                             setX(b4);
                             dec_O();
                         }
                     } else {
                         if (!x_chosen) {
                             setO(b4);
                             dec_X();
                         }
                     }
                     b4.setEnabled(false);
                     counter++;
                     checkForWinner();
                     randomMove();
                 }
             });

             b5.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     if (counter % 2 == 0) {
                         if (x_chosen) {
                             setX(b5);
                             dec_O();
                         }
                     } else {
                         if (!x_chosen) {
                             setO(b5);
                             dec_X();
                         }
                     }
                     b5.setEnabled(false);
                     counter++;
                     checkForWinner();
                     randomMove();
                 }
             });

             b6.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     if (counter % 2 == 0) {
                         if (x_chosen) {
                             setX(b6);
                             dec_O();
                         }
                     } else {
                         if (!x_chosen) {
                             setO(b6);
                             dec_X();
                         }
                     }
                     b6.setEnabled(false);
                     counter++;
                     checkForWinner();
                     randomMove();
                 }
             });

             b7.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     if (counter % 2 == 0) {
                         if (x_chosen) {
                             setX(b7);
                             dec_O();
                         }
                     } else {
                         if (!x_chosen) {
                             setO(b7);
                             dec_X();
                         }
                     }
                     b1.setEnabled(false);
                     counter++;
                     checkForWinner();
                     randomMove();
                 }
             });

             b8.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     if (counter % 2 == 0) {
                         if (x_chosen) {
                             setX(b8);
                             dec_O();
                         }
                     } else {
                         if (!x_chosen) {
                             setO(b8);
                             dec_X();
                         }
                     }
                     b1.setEnabled(false);
                     counter++;
                     checkForWinner();
                     randomMove();
                 }
             });

             b9.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     if (counter % 2 == 0) {
                         if (x_chosen) {
                             setX(b9);
                             dec_O();
                         }
                     } else {
                         if (!x_chosen) {
                             setO(b9);
                             dec_X();
                         }
                     }
                     b1.setEnabled(false);
                     counter++;
                     checkForWinner();
                     randomMove();
                 }
             });
         }
    }

    // handles each button click.
    public void buttonClick() {

        reset.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
                Toast toast = Toast.makeText(BoardOne.this,"Game has been reset",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
                toast.show();
                tv.setText("Player X makes the first move!");
            }
        });

        mainMenu.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mm = new Intent(BoardOne.this, MainActivity.class);
                startActivity(mm);
                finish();
            }
        });

        buttonClick1();

        /*if (gameActive) {
            b1.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (counter % 2 == 0) {
                        setX(b1);
                        dec_O();
                    } else {
                        setO(b1);
                        dec_X();
                    }
                    b1.setEnabled(false);
                    checkForWinner();
                    counter++;
                }
            });

            b2.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (counter % 2 == 0) {
                        setX(b2);
                        dec_O();
                    } else {
                        setO(b2);
                        dec_X();
                    }
                    b2.setEnabled(false);
                    checkForWinner();
                    counter++;
                }
            });

            b3.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (counter % 2 == 0) {
                        setX(b3);
                        dec_O();
                    } else {
                        setO(b3);
                        dec_X();
                    }
                    b3.setEnabled(false);
                    checkForWinner();
                    counter++;
                }
            });

            b4.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (counter % 2 == 0) {
                        setX(b4);
                        dec_O();
                    } else {
                        setO(b4);
                        dec_X();
                    }
                    b4.setEnabled(false);
                    checkForWinner();
                    counter++;
                }
            });

            b5.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (counter % 2 == 0) {
                        setX(b5);
                        dec_O();
                    } else {
                        setO(b5);
                        dec_X();
                    }
                    b5.setEnabled(false);
                    checkForWinner();
                    counter++;
                }
            });

            b6.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (counter % 2 == 0) {
                        setX(b6);
                        dec_O();
                    } else {
                        setO(b6);
                        dec_X();
                    }
                    b6.setEnabled(false);
                    checkForWinner();
                    counter++;
                }
            });

            b7.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (counter % 2 == 0) {
                        setX(b7);
                        dec_O();
                    } else {
                        setO(b7);
                        dec_X();
                    }
                    b7.setEnabled(false);
                    checkForWinner();
                    counter++;
                }
            });

            b8.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (counter % 2 == 0) {
                        setX(b8);
                        dec_O();
                    } else {
                        setO(b8);
                        dec_X();
                    }
                    b8.setEnabled(false);
                    checkForWinner();
                    counter++;
                }
            });

            b9.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (counter % 2 == 0) {
                        setX(b9);
                        dec_O();
                    } else {
                        setO(b9);
                        dec_X();
                    }
                    b9.setEnabled(false);
                    checkForWinner();
                    counter++;
                }
            });
        }*/
    }

    // The following function checks whether anyone has won or now and ends the game.
    public void checkForWinner() {
        if (gameActive && !isEmpty(b1) && b1.getText().toString() == b2.getText().toString() &&
                b1.getText().toString() == b3.getText().toString()) {
            tv.setText("The winner is player: " + b1.getText().toString());
            winToast(b1.getText().toString());
            gameActive = false;
            enableButtons(false);
        }

        if (gameActive && !isEmpty(b4) && b4.getText().toString() == b5.getText().toString() &&
                b4.getText().toString() == b6.getText().toString()) {
            tv.setText("The winner is player: " + b4.getText().toString());
            gameActive = false;
            enableButtons(false);
            winToast(b4.getText().toString());
        }

        if (gameActive && !isEmpty(b7) && b7.getText().toString() == b8.getText().toString() &&
                b7.getText().toString() == b9.getText().toString()) {
            tv.setText("The winner is player: " + b7.getText().toString());
            gameActive = false;
            enableButtons(false);
            winToast(b7.getText().toString());
        }

        if (gameActive && !isEmpty(b1) && b1.getText().toString() == b4.getText().toString() &&
                b1.getText().toString() == b7.getText().toString()) {
            tv.setText("The winner is player: " + b1.getText().toString());
            gameActive = false;
            enableButtons(false);
            winToast(b1.getText().toString());
        }

        if (gameActive && !isEmpty(b2) && b2.getText().toString() == b5.getText().toString() &&
                b2.getText().toString() == b8.getText().toString()) {
            tv.setText("The winner is player: " + b2.getText().toString());
            gameActive = false;
            enableButtons(false);
            winToast(b2.getText().toString());
        }

        if (gameActive && !isEmpty(b3) && b3.getText().toString() == b6.getText().toString() &&
                b3.getText().toString() == b9.getText().toString()) {
            tv.setText("The winner is player: " + b3.getText().toString());
            gameActive = false;
            enableButtons(false);
            winToast(b3.getText().toString());
        }

        if (gameActive && !isEmpty(b1) && b1.getText().toString() == b5.getText().toString() &&
                b1.getText().toString() == b9.getText().toString()) {
            tv.setText("The winner is player: " + b1.getText().toString());
            gameActive = false;
            enableButtons(false);
            winToast(b1.getText().toString());
        }

        if (gameActive && !isEmpty(b3) && b3.getText().toString() == b5.getText().toString() &&
                b3.getText().toString() == b7.getText().toString()) {
            tv.setText("The winner is player: " + b3.getText().toString());
            gameActive = false;
            enableButtons(false);
            winToast(b3.getText().toString());
        }

        if (counter == 8 && gameActive) {
            tv.setText("The match is a tie. Press RESET or go to the main menu.");
            gameActive = false;
            enableButtons(false);
            // Toast
            Toast toast = Toast.makeText(this, "It's a tie!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
            toast.show();
        }
    }

    public void winToast(String s) {
        Toast toast = Toast.makeText(this, "The winner is " + s, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        toast.show();
    }
}
