package com.example.a1.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button[] buttonsArray = new Button[9];
    Button buttonReset;

    String winner;
    boolean isXTurn = true;
    int counter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textLable);
        textView.setText("First player turn");

        buttonReset = (Button) findViewById(R.id.buttonReset);
        buttonsArray[0] = (Button)findViewById(R.id.button1);
        buttonsArray[1] = (Button)findViewById(R.id.button2);
        buttonsArray[2] = (Button)findViewById(R.id.button3);
        buttonsArray[3] = (Button)findViewById(R.id.button4);
        buttonsArray[4] = (Button)findViewById(R.id.button5);
        buttonsArray[5] = (Button)findViewById(R.id.button6);
        buttonsArray[6] = (Button)findViewById(R.id.button7);
        buttonsArray[7] = (Button)findViewById(R.id.button8);
        buttonsArray[8] = (Button)findViewById(R.id.button9);

        for (Button button: buttonsArray) {
            button.setText("");
            button.setOnClickListener(this);
        }

        buttonReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;

        if(view.getId() == R.id.buttonReset) {
            for (Button b: buttonsArray) {
                b.setText("");
                b.setEnabled(true);
            }

            counter = 0;
            isXTurn = true;
            setTextForLabel();
        } else {
            if (isXTurn) {
                button.setText("X");
                counter++;
                isXTurn = false;
            } else {
                button.setText("0");
                counter++;
                isXTurn = true;
            }

            button.setEnabled(false);

            if(isGameFinished()) {
                if(isXTurn) {
                    winner = "0";
                } else {
                    winner = "X";
                }

                textView.setText("Game finished! " + winner + " is win!");

                for (Button b: buttonsArray) {
                    b.setEnabled(false);
                }

            } else {
                if (isDraw(counter)) {
                    textView.setText("Draw!");
                } else {
                    setTextForLabel();
                }
            }
        }
    }

    public boolean isGameFinished() {
        if(buttonsArray[0].getText() == buttonsArray[1].getText() && buttonsArray[1].getText() == buttonsArray[2].getText() && buttonsArray[0].getText() != "")
            return true;
        else if(buttonsArray[3].getText() == buttonsArray[4].getText() && buttonsArray[4].getText() == buttonsArray[5].getText() && buttonsArray[3].getText() != "")
            return true;
        else if(buttonsArray[6].getText() == buttonsArray[7].getText() && buttonsArray[7].getText() == buttonsArray[8].getText() && buttonsArray[6].getText() != "")
            return true;
        else if(buttonsArray[0].getText() == buttonsArray[3].getText() && buttonsArray[3].getText() == buttonsArray[6].getText() && buttonsArray[0].getText() != "")
            return true;
        else if(buttonsArray[1].getText() == buttonsArray[4].getText() && buttonsArray[4].getText() == buttonsArray[7].getText() && buttonsArray[1].getText() != "")
            return true;
        else if(buttonsArray[2].getText() == buttonsArray[5].getText() && buttonsArray[5].getText() == buttonsArray[8].getText() && buttonsArray[2].getText() != "")
            return true;
        else if(buttonsArray[0].getText() == buttonsArray[4].getText() && buttonsArray[4].getText() == buttonsArray[8].getText() && buttonsArray[0].getText() != "")
            return true;
        else if(buttonsArray[2].getText() == buttonsArray[4].getText() && buttonsArray[4].getText() == buttonsArray[6].getText() && buttonsArray[2].getText() != "")
            return true;
        else
            return false;
    }

    public boolean isDraw(int counter) {
        if(counter == 9) {
            return true;
        } else {
            return false;
        }
    }

    public void setTextForLabel() {
        if(isXTurn) {
            textView.setText("First player turn");
        } else {
            textView.setText("Second player turn");
        }
    }
}
