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
                int guess = Integer.parseInt(guessString);
                Random random = new Random();
                int randomNum =  random.nextInt(5)+1;
                if(randomNum == guess){
                    resultTextView.setTextColor(getResources().getColor(R.color.teal_200));
                    resultTextView.setText(getResources().getString(R.string.won_text));
                }else {
                    resultTextView.setTextColor(getResources().getColor(R.color.purple_200));
                    resultTextView.setText("Sorry ! You have loss. The number was "+randomNum);
                }
            }
        });
    }
}