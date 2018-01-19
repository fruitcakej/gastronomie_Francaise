package com.example.android.gastronomie_francaise;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Visibility;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    int score = 0;
    private final int amountOfQuestions = 8;
    EditText name;
    RadioGroup rgQ1;
    RadioGroup rgQ2;
    RadioGroup rgQ3;
    RadioGroup rgQ7;
    RadioGroup rgQ8;
    CheckBox Question4cb1;
    CheckBox Question4cb2;
    CheckBox Question4cb3;
    CheckBox Question4cb4;
    EditText Question5;
    CheckBox Question6cb1;
    CheckBox Question6cb2;
    CheckBox Question6cb3;
    CheckBox Question6cb4;
    String scoreMessage;
    Button resultsButton;
    Button startAgainButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nameInput);
        rgQ1 = findViewById(R.id.rg1);
        rgQ2 = findViewById(R.id.rg2);
        rgQ3 = findViewById(R.id.rg3);
        rgQ7 = findViewById(R.id.rg7);
        rgQ8 = findViewById(R.id.rg8);
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

        Question4cb1.setOnCheckedChangeListener(this);
        Question4cb2.setOnCheckedChangeListener(this);
        Question4cb3.setOnCheckedChangeListener(this);
        Question4cb4.setOnCheckedChangeListener(this);
        Question6cb1.setOnCheckedChangeListener(this);
        Question6cb2.setOnCheckedChangeListener(this);
        Question6cb3.setOnCheckedChangeListener(this);
        Question6cb4.setOnCheckedChangeListener(this);
        resultsButton.setOnClickListener(this);
        startAgainButton.setOnClickListener(this);
    }


// do a savedInstance state around here for score, rest is user input so should be OK


    /**
     * This method checks radio buttons for only the correct answers and applies a score increment.
     * Also checks that a radio group has a response and once received, disables the group
     * to prevent further increments in scoring.
     *
     * @param view get id's from layout
     */

    public void onRadioButtonClicked(View view) {

        switch (view.getId()) {
            case R.id.frites:
            case R.id.mille_feuille:
            case R.id.raclette:
            case R.id.years8:
            case R.id.question8True:
                score += 1;
                break;
        }
        if (rgQ1.getCheckedRadioButtonId() != -1) {
            for (int i = 0; i < rgQ1.getChildCount(); i++) {
                (rgQ1.getChildAt(i)).setEnabled(false);
            }
        }

        if (rgQ2.getCheckedRadioButtonId() != -1) {
            for (int i = 0; i < rgQ2.getChildCount(); i++) {
                (rgQ2.getChildAt(i)).setEnabled(false);
            }
        }

        if (rgQ3.getCheckedRadioButtonId() != -1) {
            for (int i = 0; i < rgQ3.getChildCount(); i++) {
                (rgQ3.getChildAt(i)).setEnabled(false);
            }
        }

        if (rgQ7.getCheckedRadioButtonId() != -1) {
            for (int i = 0; i < rgQ7.getChildCount(); i++) {
                (rgQ7.getChildAt(i)).setEnabled(false);
            }
        }

        if (rgQ8.getCheckedRadioButtonId() != -1) {
            for (int i = 0; i < rgQ8.getChildCount(); i++) {
                (rgQ8.getChildAt(i)).setEnabled(false);
            }
        }
        Log.i("MainActivity", "score" + score);
    }

    /**
     * This method is for analysing the checkboxes and disabling once checked so inaccurate scoring
     * cannot happen
     */

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (Question4cb1.isChecked()) {
            Question4cb1.setEnabled(false);
        }
        if (Question4cb2.isChecked()) {
            Question4cb2.setEnabled(false);
        }
        if (Question4cb3.isChecked()) {
            Question4cb3.setEnabled(false);
        }
        if (Question4cb4.isChecked()) {
            Question4cb4.setEnabled(false);
        }

        if (!Question4cb1.isChecked() && Question4cb2.isChecked() && Question4cb3.isChecked() && !Question4cb4.isChecked()) {
            score += 1;
            Log.i("MainActivity", "score" + score);
        }

            if (Question6cb1.isChecked()) {
                Question6cb1.setEnabled(false);
            }
            if (Question6cb2.isChecked()) {
                Question6cb2.setEnabled(false);
            }
            if (Question6cb3.isChecked()) {
                Question6cb3.setEnabled(false);
            }
            if (Question6cb4.isChecked()) {
                Question6cb4.setEnabled(false);
            }

            if (!Question6cb1.isChecked() && !Question6cb2.isChecked() && Question6cb3.isChecked() && Question6cb4.isChecked()) {
                score += 1;
                Log.i("MainActivity", "score" + score);
            }
    }

    /**
     * This method listens for the result button and passes in the text entry question to the called
     * showResults method
     */

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.results:
                String question5 = Question5.getText().toString();
                showResults(question5);
                break;
        }
    }

    /**
     * Method called when results button is pressed.
     *
     * @param questionWithTextInput from question 5 passed, as not sure when user has finished typing
     *                              so set to calculate when score button is pressed. Also allowing for
     *                              answer in English and French as app will have a French version.
     */

    public void showResults(String questionWithTextInput) {
        if (questionWithTextInput.trim().equalsIgnoreCase("chocolate")) {
            score += 1;
        } else if (questionWithTextInput.trim().equalsIgnoreCase("chocolat")) {
            score += 1;
        } else {
            score += 0;
        }

        String scoreMessage = scoreSummary();
        Toast.makeText(MainActivity.this, scoreMessage, Toast.LENGTH_LONG).show();
//        MainActivity.this.resultsButton.setVisibility(View.GONE);
//        MainActivity.this.startAgainButton.setVisibility(View.VISIBLE);

    }

    /**
     * Method used to prepare toast message with formatting
     */

    private String scoreSummary() {
        String pName = name.getText().toString();
        scoreMessage = getString(R.string.welcomeMessage) + "\t" + pName;
        scoreMessage += "\n" + "\n" + getString(R.string.scoreResults) + "\t" + score + "\t" + getString(R.string.between);
        scoreMessage += "\t" + amountOfQuestions;


        return scoreMessage;
    }
}
