package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText inputEditText;
    private TextView resultTextView;
    private Button checkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputEditText = findViewById(R.id.editTextId);
        resultTextView = findViewById(R.id.textViewId);
        checkButton = findViewById(R.id.checkButtonId);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String guessString = inputEditText.getText().toString();
                if(guessString.equals("")){
                    guessString = "0";
                }

                int guess = Integer.parseInt(guessString);
                if(guess == 0 || guess>5){
                    errorMessage();
                }else {
                    Random random = new Random();
                    int randomNum =  random.nextInt(5)+1;
                    if(randomNum == guess){
                        resultTextView.setTextColor(getResources().getColor(R.color.teal_200));
                        resultTextView.setText(getResources().getString(R.string.won_text));
                    }else {
                        resultTextView.setTextColor(getResources().getColor(R.color.purple_200));
                        resultTextView.setText(String.format("%s %d", getResources().getString(R.string.loss_statement), randomNum));
                    }
                }

            }
        });
    }
    private void errorMessage(){
        resultTextView.setTextColor(getResources().getColor(R.color.red));
        resultTextView.setText(R.string.error_statement);
    }
}