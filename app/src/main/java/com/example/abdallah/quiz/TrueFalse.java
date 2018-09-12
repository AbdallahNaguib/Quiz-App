package com.example.abdallah.quiz;

/**
 * Created by Abd Allah on 6/12/2018.
 */

public class TrueFalse {
    private int mQuestionId;
    private boolean mAnswer;
    public TrueFalse(int questionResourceId,boolean trueOrFalse){
        this.mQuestionId=questionResourceId;
        this.mAnswer=trueOrFalse;
    }

    public int getQuestionId() {
        return mQuestionId;
    }

    public void setQuestionId(int mQuestionId) {
        this.mQuestionId = mQuestionId;
    }

    public boolean isAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean mAnswer) {
        this.mAnswer = mAnswer;
    }
}
