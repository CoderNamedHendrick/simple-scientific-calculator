package com.hendrick.simplescientificcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private String PERSIST_STATE = "persist_state";
    private Button mClearBtn;
    private Button mHistoryBtn;
    private Button mEqualBtn;
    private Button mOneButton;
    private Button mTwoButton;
    private Button mThreeButton;
    private Button mFourButton;
    private Button mFiveButton;
    private Button mSixButton;
    private Button mSevenButton;
    private Button mEightButton;
    private Button mNineButton;
    private Button mZeroButton;
    private Button mDecimalButton;
    private Button mAddButton;
    private Button mSubtractButton;
    private Button mDivideButton;
    private Button mMultiplyButton;
    private Button mAddSubtractButton;
    private Button mNRootXBtn;
    private Button mRootXBtn;
    private Button mXRaisedToNBtn;
    private Button mXSquareBtn;
    private Button mNaturalLogBtn;
    private Button mLogBtn;
    private TextView mCalcTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeDisplayContent();
        buttonClicks();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(PERSIST_STATE, mCalcTV.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCalcTV.setText(savedInstanceState.getString(PERSIST_STATE));
    }

    private void initializeDisplayContent() {
        // Calculator TextView
        mCalcTV = findViewById(R.id.calcTV);

        // other buttons
        mClearBtn = findViewById(R.id.clearBtn);
        mHistoryBtn = findViewById(R.id.historyBtn);
        mEqualBtn = findViewById(R.id.equalBtn);

        // number buttons
        mOneButton = findViewById(R.id.oneBtn);
        mTwoButton = findViewById(R.id.twoBtn);
        mThreeButton = findViewById(R.id.threeBtn);
        mFourButton = findViewById(R.id.fourBtn);
        mFiveButton = findViewById(R.id.fiveBtn);
        mSixButton = findViewById(R.id.sixBtn);
        mSevenButton = findViewById(R.id.sevenBtn);
        mEightButton = findViewById(R.id.eightBtn);
        mNineButton = findViewById(R.id.nineBtn);
        mZeroButton = findViewById(R.id.zeroBtn);
        mDecimalButton = findViewById(R.id.decimalBtn);

        // operators buttons
        mAddButton = findViewById(R.id.addBtn);
        mSubtractButton = findViewById(R.id.subtractBtn);
        mDivideButton = findViewById(R.id.divideBtn);
        mMultiplyButton = findViewById(R.id.multiplyBtn);
        mAddSubtractButton = findViewById(R.id.addSubtractBtn);

        // other special operators
        mNRootXBtn = findViewById(R.id.nRootXBtn);
        mRootXBtn = findViewById(R.id.rootXBtn);
        mXRaisedToNBtn = findViewById(R.id.xRaiseToNBtn);
        mXSquareBtn = findViewById(R.id.xSquareBtn);
        mNaturalLogBtn = findViewById(R.id.naturalLogBtn);
        mLogBtn = findViewById(R.id.logBtn);
    }

    public void buttonClicks(){
        mOneButton.setOnClickListener(this);
        mTwoButton.setOnClickListener(this);
        mThreeButton.setOnClickListener(this);
        mFourButton.setOnClickListener(this);
        mFiveButton.setOnClickListener(this);
        mSixButton.setOnClickListener(this);
        mSevenButton.setOnClickListener(this);
        mEightButton.setOnClickListener(this);
        mNineButton.setOnClickListener(this);
        mZeroButton.setOnClickListener(this);
        mDecimalButton.setOnClickListener(this);
        mAddButton.setOnClickListener(this);
        mSubtractButton.setOnClickListener(this);
        mMultiplyButton.setOnClickListener(this);
        mDivideButton.setOnClickListener(this);
        mAddSubtractButton.setOnClickListener(this);
        mEqualBtn.setOnClickListener(this);
        mClearBtn.setOnClickListener(this);
        mHistoryBtn.setOnClickListener(this);
//        mNRootXBtn.setOnClickListener(this);
//        mRootXBtn.setOnClickListener(this);
//        mXRaisedToNBtn.setOnClickListener(this);
//        mXSquareBtn.setOnClickListener(this);
//        mNaturalLogBtn.setOnClickListener(this);
//        mLogBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mOneButton)
            input("1");
        else if (v == mTwoButton)
            input("2");
        else if (v == mThreeButton)
            input("3");
        else if (v == mFourButton)
            input("4");
        else if (v == mFiveButton)
            input("5");
        else if (v == mSixButton)
            input("6");
        else if (v == mSevenButton)
            input("7");
        else if (v == mEightButton)
            input("8");
        else if (v == mNineButton)
            input("9");
        else if (v == mZeroButton)
            input("0");
        else if (v == mDecimalButton)
            input(".");
        else if (v == mHistoryBtn){
            Intent intent = new Intent(MainActivity.this, CalculationHistory.class);
            startActivity(intent);
        }
    }

    private void input(String s) {
        String original = mCalcTV.getText().toString();
        mCalcTV.setText(original+s);
    }
}