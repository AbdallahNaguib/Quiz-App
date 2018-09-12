package com.example.abdallah.quiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // TODO: Declare constants here


    // TODO: Declare member variables here:
    Button mTrueButton , mFalseButton;
    int score=0;
    int questionNumber=0;
    ProgressBar progressBar;
    TextView question , tvScore;

    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=(ProgressBar)findViewById(R.id.progress_bar);
        mTrueButton=(Button)findViewById(R.id.true_button);
        mFalseButton=(Button)findViewById(R.id.false_button);
        question=(TextView)findViewById(R.id.question_text_view);
        tvScore=(TextView)findViewById(R.id.score);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionAsked(true);
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionAsked(false);
            }
        });
    }

    void questionAsked(boolean answer){

        if(questionNumber==12){
            lastQuestion(answer);
            return;
        }

        //answer result
        if(answer == mQuestionBank[questionNumber].isAnswer()){
            Toast.makeText(this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
            score++;
            //Score 0/13
            tvScore.setText("Score " + score + "/13");
        }else{
            Toast.makeText(this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
        }

        //updating the progress_bar
        progressBar.incrementProgressBy(8);

        //update question
        questionNumber++;
        question.setText(mQuestionBank[questionNumber].getQuestionId());

    }

    void lastQuestion(boolean answer){
        mTrueButton.setVisibility(View.INVISIBLE);
        mFalseButton.setVisibility(View.INVISIBLE);

        //updating the progress_bar
        progressBar.incrementProgressBy(8);

        if(answer == mQuestionBank[questionNumber].isAnswer()){
            Toast.makeText(this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
            score++;
            //Score 0/13
            tvScore.setText("Score " + score + "/13");
        }else{
            Toast.makeText(this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
        }

        question.setText("you finished! ");
    }
}
