package com.example.android.mathquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mFirstAnswerText;
    private EditText mFourthAnswerText;
    private EditText mSixthAnswerText;
    private CheckBox mCheckBox1;
    private CheckBox mCheckBox2;
    private CheckBox mCheckBox3;
    private RadioButton mRadioButton2;
    private RadioButton mRadioButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstAnswerText = (EditText) findViewById(R.id.first_answer);
        mFourthAnswerText = (EditText) findViewById(R.id.fourth_answer);
        mSixthAnswerText = (EditText) findViewById(R.id.sixth_answer);
        mCheckBox1 = (CheckBox) findViewById(R.id.checkbox1);
        mCheckBox2 = (CheckBox) findViewById(R.id.checkbox2);
        mCheckBox3 = (CheckBox) findViewById(R.id.checkbox3);
        mRadioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        mRadioButton3 = (RadioButton) findViewById(R.id.radioButton3);
    }

    /**
     * Callback for the submit button click
     *
     * @param view
     */

    public void onSubmit(View view) {
        int score = evaluate();
        String message = null;
        if (score == 6) {
            message = getString(R.string.text_full_score);
        } else {
            message = getString(R.string.text_partial_score);
        }
        Toast.makeText(this, getString(R.string.score_message, score, message), Toast.LENGTH_SHORT).show();
    }

    /**
     * Evaluates submitted answers by user
     *
     * @return score of user
     */
    private int evaluate() {
        int score = 0;

        // First answer
        if (mFirstAnswerText.getText().toString().trim().equalsIgnoreCase(getString(R.string.first_answer))) {
            score++;
        }

        // Second answer
        if (mCheckBox1.isChecked() && !mCheckBox2.isChecked() && mCheckBox3.isChecked()) {
            score++;
        }

        // Third answer
        if (mRadioButton2.isChecked()) {
            score++;
        }

        // Fourth answer
        if (mFourthAnswerText.getText().toString().equalsIgnoreCase(getString(R.string.fourth_answer))) {
            score++;
        }

        // Fifth answer
        if (mRadioButton3.isChecked()) {
            score++;
        }

        // Sixth answer
        if (mSixthAnswerText.getText().toString().equalsIgnoreCase(getString(R.string.sixth_answer))) {
            score++;
        }

        return score;
    }
}