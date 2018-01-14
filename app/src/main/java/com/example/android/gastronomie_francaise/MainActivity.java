package com.example.android.gastronomie_francaise;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    int score = 0;
    private int numberOfCheckboxesChecked;
    RadioGroup rgQ1;
    RadioGroup rgQ2;
    RadioGroup rgQ3;
    RadioGroup rgQ7;
    RadioGroup rgQ8;
    CheckBox Question4cb1;
    CheckBox Question4cb2;
    CheckBox Question4cb3;
    CheckBox Question4cb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgQ1 = findViewById(R.id.rg1);
        rgQ2 = findViewById(R.id.rg2);
        rgQ3 = findViewById(R.id.rg3);
        rgQ7 = findViewById(R.id.rg7);
        rgQ8 = findViewById(R.id.rg8);
        Question4cb1 = findViewById(R.id.q4cb1);
        Question4cb2 = findViewById(R.id.q4cb2);
        Question4cb3 = findViewById(R.id.q4cb3);
        Question4cb4 = findViewById(R.id.q4cb4);

        /**
         * Set checkbox listeners
         */
        Question4cb1.setOnCheckedChangeListener(this);
        Question4cb2.setOnCheckedChangeListener(this);
        Question4cb3.setOnCheckedChangeListener(this);
        Question4cb4.setOnCheckedChangeListener(this);

    }


// do a savedInstance state around here for score, rest is user input so should be OK


    /**
     * This method checks radio buttons for only the correct answers and applies a score increment.
     * Also checks that a radio group has a response and once received, disables the group
     * to prevent further increments in scoring.
     *
     * @param view
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


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            if (numberOfCheckboxesChecked >= 2) {
                buttonView.setChecked(false);

            } else {
                numberOfCheckboxesChecked++;

            }
        }  else {
            numberOfCheckboxesChecked--;

        }
            if (!Question4cb1.isChecked() && Question4cb2.isChecked() && Question4cb3.isChecked() && !Question4cb4.isChecked()) {
                score += 1;
            }
            Log.i("MainActivity", "score" + score);


    }




}


//
// {
//         Toast.makeText(MainActivity.this,
//         "this item is selected", Toast.LENGTH_LONG).show();
//         }

//    public void onCheckBoxChecked(View view) {
//
//        if (!Question4cb1.isChecked() && !Question4cb2.isChecked() && !Question4cb3.isChecked() && !Question4cb4.isChecked()) {
//            Toast.makeText(this, R.string.select2, Toast.LENGTH_SHORT).show();
//
//        } else if
//
//                (!Question4cb1.isChecked() && Question4cb2.isChecked() && Question4cb3.isChecked() && !Question4cb4.isChecked()) {
//            score += 1;
//        }
//
//        Log.i("MainActivity", "score" + score);
//
//    }