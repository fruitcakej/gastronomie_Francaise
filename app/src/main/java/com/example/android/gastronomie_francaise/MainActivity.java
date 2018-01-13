package com.example.android.gastronomie_francaise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    RadioGroup rgQ1;
    RadioGroup rgQ2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgQ1 = findViewById(R.id.rg1);
        rgQ2 = findViewById(R.id.rg2);
    }


    public void onRadioButtonClicked(View view, int CheckedRadioButtonId) {

        // Is the button now checked? then assign into a boolean named 'checked'
        boolean checked = ((RadioButton) view).isChecked();

        // Question 1 logic
        // Check correct answer is checked and update score

        switch (view.getId()) {
            case R.id.frites:
                if (checked) score += 1;
                Log.v("MainActivity", "score" + score);
                break;
        }
        int selectedId = rgQ1.getCheckedRadioButtonId();
        if (selectedId.hasValue) {

            for (int i = 0; i < rgQ1.getChildCount(); i++) {
                (rgQ1.getChildAt(i)).setEnabled(false);
            }
        }



        // Question 2 logic
        // Check correct answer is checked and update score

        switch (view.getId()) {
            case R.id.mille_feuille:
                if (checked) score += 1;
                Log.v("MainActivity", "score" + score);
                break;
        }

        for (int i = 0; i < rgQ2.getChildCount(); i++) {
            (rgQ2.getChildAt(i)).setEnabled(false);
        }
    }
}

//
// {
//         Toast.makeText(MainActivity.this,
//         "this item is selected", Toast.LENGTH_LONG).show();
//         }