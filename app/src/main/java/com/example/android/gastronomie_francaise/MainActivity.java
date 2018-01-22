package com.example.android.gastronomie_francaise;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int score = 0;
    private final int amountOfQuestions = 8;
    EditText name, Question5;
    RadioButton frites, milleFeuille, raclette, years8, question8True;
    CheckBox Question4cb1, Question4cb2, Question4cb3, Question4cb4, Question6cb1, Question6cb2, Question6cb3, Question6cb4;
    String textForQuestion5, scoreMessage;
    Button resultsButton, startAgainButton;

    /**
     * Associate layout ID's to variables in onCreate
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nameInput);
        frites = findViewById(R.id.frites);
        milleFeuille = findViewById(R.id.mille_feuille);
        raclette = findViewById(R.id.raclette);
        years8 = findViewById(R.id.years8);
        question8True = findViewById(R.id.question8True);
        Question4cb1 = findViewById(R.id.q4cb1);
        Question4cb2 = findViewById(R.id.q4cb2);
        Question4cb3 = findViewById(R.id.q4cb3);
        Question4cb4 = findViewById(R.id.q4cb4);
        Question5 = findViewById(R.id.question5TextInput);
        Question6cb1 = findViewById(R.id.q6cb1);
        Question6cb2 = findViewById(R.id.q6cb2);
        Question6cb3 = findViewById(R.id.q6cb3);
        Question6cb4 = findViewById(R.id.q6cb4);
        resultsButton = findViewById(R.id.results);
        startAgainButton = findViewById(R.id.reset);

        /**
         * Set listeners
         */
        resultsButton.setOnClickListener(this);
        startAgainButton.setOnClickListener(this);
    }

    /**
     * Calls methods on the click of the results or reset button
     */

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.results:
                score = 0;
                checkAnswers();
                showResults();
                break;
            case R.id.reset:
                restartActivity();
                break;
        }
    }

    /**
     * Perform all scoring logic in here. Updated to one method to prevent errors on duplicate scoring
     * by having different methods. Question 5 uses an 'or' statement to accept an answer in French for the updated version of this app.
     */

    public void checkAnswers() {
        if (frites.isChecked()) {
            score += 1;
        }
        if (milleFeuille.isChecked()) {
            score += 1;
        }
        if (raclette.isChecked()) {
            score += 1;
        }
        if (years8.isChecked()) {
            score += 1;
        }
        if (question8True.isChecked()) {
            score += 1;
        }
        textForQuestion5 = Question5.getText().toString();
        if (textForQuestion5.trim().equalsIgnoreCase("chocolate") || textForQuestion5.trim().equalsIgnoreCase("chocolat")) {
            score += 1;
        } else {
            score += 0;
        }
        if (!Question4cb1.isChecked() && Question4cb2.isChecked() && Question4cb3.isChecked() && !Question4cb4.isChecked()) {
            score += 1;
            Log.i("MainActivity", "score" + score);
        }
        if (!Question6cb1.isChecked() && !Question6cb2.isChecked() && Question6cb3.isChecked() && Question6cb4.isChecked()) {
            score += 1;
            Log.i("MainActivity", "score" + score);
        }
    }

    /**
     * Method called display results.
     */

    public void showResults() {
        String scoreMessage = scoreSummary();
        Toast.makeText(MainActivity.this, scoreMessage, Toast.LENGTH_LONG).show();
    }

    /**
     * Method used to prepare toast message with formatting. Also added a check if the user has scored the max score.
     * This will play an audio sample !
     * Did not want to show incorrect answers to motivate user to try and improve to gain a perfect score!
     */

    private String scoreSummary() {
        String pName = name.getText().toString();
        scoreMessage = getString(R.string.welcomeMessage) + "\t" + pName;
        scoreMessage += "\n" + "\n" + getString(R.string.scoreResults) + "\t" + score + "\t" + getString(R.string.between);
        scoreMessage += "\t" + amountOfQuestions + "!";
        if (score == 8) {
            MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.ohlala);
            mp.start();
        }
        return scoreMessage;
    }

    /**
     * Called to restart the quiz on reset button
     */

    public void restartActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}