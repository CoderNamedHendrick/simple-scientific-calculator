package com.hendrick.simplescientificcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private String PERSIST_STATE = "persist_state";
    public static String HISTORY_DATA = "history_expressions";
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
    private HistoryHelper mHistoryHelper;
    private double firstArgument;
    private double secondArgument;
    private int count;
    private boolean operatorCheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHistoryHelper = HistoryHelper.getInstance();
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            initializeDisplayContent();
            defaultButtonConfiguration();
        } else
            initializeDisplayContent();
        mAddButton.setEnabled(false);
        mSubtractButton.setEnabled(false);
        mDivideButton.setEnabled(false);
        mMultiplyButton.setEnabled(false);
        mRootXBtn.setEnabled(false);
        mXRaisedToNBtn.setEnabled(false);
        mNRootXBtn.setEnabled(false);
        mXSquareBtn.setEnabled(false);
        mLogBtn.setEnabled(false);
        mNaturalLogBtn.setEnabled(false);
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

    private void defaultButtonConfiguration(){
        mNRootXBtn.setVisibility(View.GONE);
        mRootXBtn.setVisibility(View.GONE);
        mXRaisedToNBtn.setVisibility(View.GONE);
        mXSquareBtn.setVisibility(View.GONE);
        mNaturalLogBtn.setVisibility(View.GONE);
        mLogBtn.setVisibility(View.GONE);
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
        mNRootXBtn.setOnClickListener(this);
        mRootXBtn.setOnClickListener(this);
        mXRaisedToNBtn.setOnClickListener(this);
        mXSquareBtn.setOnClickListener(this);
        mNaturalLogBtn.setOnClickListener(this);
        mLogBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mOneButton) {
            input("1");
            mAddButton.setEnabled(true);
            mSubtractButton.setEnabled(true);
            mDivideButton.setEnabled(true);
            mMultiplyButton.setEnabled(true);
            mRootXBtn.setEnabled(true);
            mXRaisedToNBtn.setEnabled(true);
            mNRootXBtn.setEnabled(true);
            mXSquareBtn.setEnabled(true);
            mLogBtn.setEnabled(true);
            mNaturalLogBtn.setEnabled(true);
        }
        else if (v == mTwoButton) {
            input("2");
            mAddButton.setEnabled(true);
            mSubtractButton.setEnabled(true);
            mDivideButton.setEnabled(true);
            mMultiplyButton.setEnabled(true);
            mRootXBtn.setEnabled(true);
            mXRaisedToNBtn.setEnabled(true);
            mNRootXBtn.setEnabled(true);
            mXSquareBtn.setEnabled(true);
            mLogBtn.setEnabled(true);
            mNaturalLogBtn.setEnabled(true);
        }
        else if (v == mThreeButton) {
            input("3");
            mAddButton.setEnabled(true);
            mSubtractButton.setEnabled(true);
            mDivideButton.setEnabled(true);
            mMultiplyButton.setEnabled(true);
            mRootXBtn.setEnabled(true);
            mXRaisedToNBtn.setEnabled(true);
            mNRootXBtn.setEnabled(true);
            mXSquareBtn.setEnabled(true);
            mLogBtn.setEnabled(true);
            mNaturalLogBtn.setEnabled(true);
        }
        else if (v == mFourButton) {
            input("4");
            mAddButton.setEnabled(true);
            mSubtractButton.setEnabled(true);
            mDivideButton.setEnabled(true);
            mMultiplyButton.setEnabled(true);
            mRootXBtn.setEnabled(true);
            mXRaisedToNBtn.setEnabled(true);
            mNRootXBtn.setEnabled(true);
            mXSquareBtn.setEnabled(true);
            mLogBtn.setEnabled(true);
            mNaturalLogBtn.setEnabled(true);
        }
        else if (v == mFiveButton) {
            input("5");
            mAddButton.setEnabled(true);
            mSubtractButton.setEnabled(true);
            mDivideButton.setEnabled(true);
            mMultiplyButton.setEnabled(true);
            mRootXBtn.setEnabled(true);
            mXRaisedToNBtn.setEnabled(true);
            mNRootXBtn.setEnabled(true);
            mXSquareBtn.setEnabled(true);
            mLogBtn.setEnabled(true);
            mNaturalLogBtn.setEnabled(true);
        }
        else if (v == mSixButton) {
            input("6");
            mAddButton.setEnabled(true);
            mSubtractButton.setEnabled(true);
            mDivideButton.setEnabled(true);
            mMultiplyButton.setEnabled(true);
            mRootXBtn.setEnabled(true);
            mXRaisedToNBtn.setEnabled(true);
            mNRootXBtn.setEnabled(true);
            mXSquareBtn.setEnabled(true);
            mLogBtn.setEnabled(true);
            mNaturalLogBtn.setEnabled(true);
        }
        else if (v == mSevenButton) {
            input("7");
            mAddButton.setEnabled(true);
            mSubtractButton.setEnabled(true);
            mDivideButton.setEnabled(true);
            mMultiplyButton.setEnabled(true);
            mRootXBtn.setEnabled(true);
            mXRaisedToNBtn.setEnabled(true);
            mNRootXBtn.setEnabled(true);
            mXSquareBtn.setEnabled(true);
            mLogBtn.setEnabled(true);
            mNaturalLogBtn.setEnabled(true);
        }
        else if (v == mEightButton) {
            input("8");
            mAddButton.setEnabled(true);
            mSubtractButton.setEnabled(true);
            mDivideButton.setEnabled(true);
            mMultiplyButton.setEnabled(true);
            mRootXBtn.setEnabled(true);
            mXRaisedToNBtn.setEnabled(true);
            mNRootXBtn.setEnabled(true);
            mXSquareBtn.setEnabled(true);
            mLogBtn.setEnabled(true);
            mNaturalLogBtn.setEnabled(true);
        }
        else if (v == mNineButton) {
            input("9");
            mAddButton.setEnabled(true);
            mSubtractButton.setEnabled(true);
            mDivideButton.setEnabled(true);
            mMultiplyButton.setEnabled(true);
            mRootXBtn.setEnabled(true);
            mXRaisedToNBtn.setEnabled(true);
            mNRootXBtn.setEnabled(true);
            mXSquareBtn.setEnabled(true);
            mLogBtn.setEnabled(true);
            mNaturalLogBtn.setEnabled(true);
        }
        else if (v == mZeroButton) {
            input("0");
            mAddButton.setEnabled(true);
            mSubtractButton.setEnabled(true);
            mDivideButton.setEnabled(true);
            mMultiplyButton.setEnabled(true);
            mRootXBtn.setEnabled(true);
            mXRaisedToNBtn.setEnabled(true);
            mNRootXBtn.setEnabled(true);
            mXSquareBtn.setEnabled(true);
            mLogBtn.setEnabled(true);
            mNaturalLogBtn.setEnabled(true);
        }
        else if (v == mDecimalButton) {
            mAddButton.setEnabled(true);
            mSubtractButton.setEnabled(true);
            mDivideButton.setEnabled(true);
            mMultiplyButton.setEnabled(true);
            mRootXBtn.setEnabled(true);
            mXRaisedToNBtn.setEnabled(true);
            mNRootXBtn.setEnabled(true);
            mXSquareBtn.setEnabled(true);
            mLogBtn.setEnabled(true);
            mNaturalLogBtn.setEnabled(true);
            if (mCalcTV.getText().toString().contains(".")){
                mDecimalButton.setEnabled(false);
            }else
                input(".");
        }else if (v == mAddButton){
            firstArgument =  Double.parseDouble(mCalcTV.getText().toString());
            mAddButton.setEnabled(false);
            mSubtractButton.setEnabled(false);
            mDivideButton.setEnabled(false);
            mMultiplyButton.setEnabled(false);
            mRootXBtn.setEnabled(false);
            mXRaisedToNBtn.setEnabled(false);
            mNRootXBtn.setEnabled(false);
            mXSquareBtn.setEnabled(false);
            mLogBtn.setEnabled(false);
            mNaturalLogBtn.setEnabled(false);
            mHistoryHelper.addToExpression(mCalcTV.getText().toString());
            mHistoryHelper.addToExpression("+");
            mCalcTV.setText("");
        } else if (v == mSubtractButton){
            firstArgument =  Double.parseDouble(mCalcTV.getText().toString());
            mAddButton.setEnabled(false);
            mSubtractButton.setEnabled(false);
            mDivideButton.setEnabled(false);
            mMultiplyButton.setEnabled(false);
            mRootXBtn.setEnabled(false);
            mXRaisedToNBtn.setEnabled(false);
            mNRootXBtn.setEnabled(false);
            mXSquareBtn.setEnabled(false);
            mLogBtn.setEnabled(false);
            mNaturalLogBtn.setEnabled(false);
            mHistoryHelper.addToExpression(mCalcTV.getText().toString());
            mHistoryHelper.addToExpression("-");
            mCalcTV.setText("");
        } else if (v == mDivideButton){
            firstArgument =  Double.parseDouble(mCalcTV.getText().toString());
            mAddButton.setEnabled(false);
            mSubtractButton.setEnabled(false);
            mDivideButton.setEnabled(false);
            mMultiplyButton.setEnabled(false);
            mRootXBtn.setEnabled(false);
            mXRaisedToNBtn.setEnabled(false);
            mNRootXBtn.setEnabled(false);
            mXSquareBtn.setEnabled(false);
            mLogBtn.setEnabled(false);
            mNaturalLogBtn.setEnabled(false);
            mHistoryHelper.addToExpression(mCalcTV.getText().toString());
            mHistoryHelper.addToExpression("\u00F7");
            mCalcTV.setText("");
        } else if (v == mMultiplyButton){
            firstArgument =  Double.parseDouble(mCalcTV.getText().toString());
            mAddButton.setEnabled(false);
            mSubtractButton.setEnabled(false);
            mDivideButton.setEnabled(false);
            mMultiplyButton.setEnabled(false);
            mRootXBtn.setEnabled(false);
            mXRaisedToNBtn.setEnabled(false);
            mNRootXBtn.setEnabled(false);
            mXSquareBtn.setEnabled(false);
            mLogBtn.setEnabled(false);
            mNaturalLogBtn.setEnabled(false);
            mHistoryHelper.addToExpression(mCalcTV.getText().toString());
            mHistoryHelper.addToExpression("*");
            mCalcTV.setText("");
        } else if (v == mAddSubtractButton){
            mCalcTV.setText(mCalcTV.getText().toString().contains("-") ?
                    mCalcTV.getText().toString().substring(1) : "-"+mCalcTV.getText().toString());
        }// operations for the buttons that shows in landscape mode
        else if (v == mRootXBtn){
            mAddButton.setEnabled(false);
            mSubtractButton.setEnabled(false);
            mDivideButton.setEnabled(false);
            mMultiplyButton.setEnabled(false);
            mRootXBtn.setEnabled(false);
            mXRaisedToNBtn.setEnabled(false);
            mNRootXBtn.setEnabled(false);
            mXSquareBtn.setEnabled(false);
            mLogBtn.setEnabled(false);
            mNaturalLogBtn.setEnabled(false);
            firstArgument = 2;
            mCalcTV.setText("\u221A" + mCalcTV.getText().toString());
            mHistoryHelper.addToExpression("");
            mHistoryHelper.addToExpression("\u221A");
        } else if (v == mNRootXBtn){
            mAddButton.setEnabled(false);
            mSubtractButton.setEnabled(false);
            mDivideButton.setEnabled(false);
            mMultiplyButton.setEnabled(false);
            mRootXBtn.setEnabled(false);
            mXRaisedToNBtn.setEnabled(false);
            mNRootXBtn.setEnabled(false);
            mXSquareBtn.setEnabled(false);
            mLogBtn.setEnabled(false);
            mNaturalLogBtn.setEnabled(false);
            firstArgument = Double.parseDouble(mCalcTV.getText().toString());
            input("\u221A");
            mHistoryHelper.addToExpression(mCalcTV.getText().toString());
            mHistoryHelper.addToExpression("\u221A");
        } else if (v == mXRaisedToNBtn){
            mAddButton.setEnabled(false);
            mSubtractButton.setEnabled(false);
            mDivideButton.setEnabled(false);
            mMultiplyButton.setEnabled(false);
            mRootXBtn.setEnabled(false);
            mXRaisedToNBtn.setEnabled(false);
            mNRootXBtn.setEnabled(false);
            mXSquareBtn.setEnabled(false);
            mLogBtn.setEnabled(false);
            mNaturalLogBtn.setEnabled(false);
            firstArgument = Double.parseDouble(mCalcTV.getText().toString());
            mHistoryHelper.addToExpression(mCalcTV.getText().toString());
            mHistoryHelper.addToExpression("^");
            input("^");
        } else if (v == mXSquareBtn){
            mAddButton.setEnabled(false);
            mSubtractButton.setEnabled(false);
            mDivideButton.setEnabled(false);
            mMultiplyButton.setEnabled(false);
            mRootXBtn.setEnabled(false);
            mXRaisedToNBtn.setEnabled(false);
            mNRootXBtn.setEnabled(false);
            mXSquareBtn.setEnabled(false);
            mLogBtn.setEnabled(false);
            mNaturalLogBtn.setEnabled(false);
            firstArgument = Double.parseDouble(mCalcTV.getText().toString());
            mHistoryHelper.addToExpression(mCalcTV.getText().toString());
            mHistoryHelper.addToExpression("^");
            input("^2");
        } else if (v == mLogBtn){
            mAddButton.setEnabled(false);
            mSubtractButton.setEnabled(false);
            mDivideButton.setEnabled(false);
            mMultiplyButton.setEnabled(false);
            mRootXBtn.setEnabled(false);
            mXRaisedToNBtn.setEnabled(false);
            mNRootXBtn.setEnabled(false);
            mXSquareBtn.setEnabled(false);
            mLogBtn.setEnabled(false);
            mNaturalLogBtn.setEnabled(false);
            mCalcTV.setText("log(" + mCalcTV.getText().toString() + ")");
        } else if (v == mNaturalLogBtn){
            mAddButton.setEnabled(false);
            mSubtractButton.setEnabled(false);
            mDivideButton.setEnabled(false);
            mMultiplyButton.setEnabled(false);
            mRootXBtn.setEnabled(false);
            mXRaisedToNBtn.setEnabled(false);
            mNRootXBtn.setEnabled(false);
            mXSquareBtn.setEnabled(false);
            mLogBtn.setEnabled(false);
            mNaturalLogBtn.setEnabled(false);
            mCalcTV.setText("ln(" + mCalcTV.getText().toString() + ")");
        } else if (v == mEqualBtn){
            mAddButton.setEnabled(true);
            mSubtractButton.setEnabled(true);
            mDivideButton.setEnabled(true);
            mMultiplyButton.setEnabled(true);
            mRootXBtn.setEnabled(true);
            mXRaisedToNBtn.setEnabled(true);
            mNRootXBtn.setEnabled(true);
            mXSquareBtn.setEnabled(true);
            mLogBtn.setEnabled(true);
            mNaturalLogBtn.setEnabled(true);
            String result = "0";
            if (mCalcTV.getText().toString().contains("\u221A")) {
                String getInfo = mCalcTV.getText().toString();
               if (mCalcTV.getText().toString().startsWith("\u221A")){
                   secondArgument = Double.parseDouble(mCalcTV.getText().toString().substring(1));
                   mHistoryHelper.addToExpression(mCalcTV.getText().toString().substring(1));
               } else {
                   secondArgument = Double.parseDouble(mCalcTV.getText().toString().substring(2));
                   mHistoryHelper.addToExpression(mCalcTV.getText().toString().substring(2));
               }
               mHistoryHelper.addToList();
               mHistoryHelper.reset();
               mCalcTV.setText("");
            } else if (mCalcTV.getText().toString().contains("^")){
                secondArgument = Double.parseDouble(mCalcTV.getText().toString().substring(mCalcTV.getText().toString().indexOf("^") + 1));
                mHistoryHelper.addToExpression(mCalcTV.getText().toString().substring(mCalcTV.getText().toString().indexOf("^")));
                mHistoryHelper.addToList();
                mHistoryHelper.reset();
                mCalcTV.setText("");
            } else if (mCalcTV.getText().toString().contains("log")){
                secondArgument = Double.parseDouble(mCalcTV.getText().toString().substring(mCalcTV.getText().toString().indexOf("(") + 1,
                        mCalcTV.getText().toString().indexOf(")")));
                mHistoryHelper.addToList("log(" + secondArgument + ")");
                mHistoryHelper.reset();
                mCalcTV.setText("");
            }else if (mCalcTV.getText().toString().contains("ln")) {
                secondArgument = Double.parseDouble(mCalcTV.getText().toString().substring(mCalcTV.getText().toString().indexOf("(") + 1,
                        mCalcTV.getText().toString().indexOf(")")));
                mHistoryHelper.addToList("ln(" + secondArgument + ")");
                mHistoryHelper.reset();
                mCalcTV.setText("");
            }
            else{
                secondArgument = Double.parseDouble(mCalcTV.getText().toString());
                mHistoryHelper.addToExpression(mCalcTV.getText().toString());
                mHistoryHelper.addToList();
                mHistoryHelper.reset();
                mCalcTV.setText("");
            }

            // Calculation Operations
            if (mHistoryHelper.returnOperationbyIndex(count).contains("+"))
                result = CalculationOperation.add(firstArgument, secondArgument);
            else if (mHistoryHelper.returnOperationbyIndex(count).contains("-"))
                result = CalculationOperation.subtract(firstArgument, secondArgument);
            else if (mHistoryHelper.returnOperationbyIndex(count).contains("*"))
                result = CalculationOperation.multiply(firstArgument, secondArgument);
            else if (mHistoryHelper.returnOperationbyIndex(count).contains("\u00F7"))
                result = CalculationOperation.divide(firstArgument, secondArgument);
            else if (mHistoryHelper.returnOperationbyIndex(count).contains("\u221A"))
                result = CalculationOperation.root(secondArgument, (int) firstArgument);
            else if(mHistoryHelper.returnOperationbyIndex(count).contains("^"))
                result = CalculationOperation.power(firstArgument, (int) secondArgument);
            else if (mHistoryHelper.returnOperationbyIndex(count).contains("log"))
                result = CalculationOperation.logarithm(secondArgument);
            else if (mHistoryHelper.returnOperationbyIndex(count).contains("ln"))
                result = CalculationOperation.naturalLog(secondArgument);

            mCalcTV.setText(result);

            count++;
        }else if (v == mClearBtn){
            mCalcTV.setText("");
            mAddButton.setEnabled(true);
            mSubtractButton.setEnabled(true);
            mDivideButton.setEnabled(true);
            mMultiplyButton.setEnabled(true);
            mRootXBtn.setEnabled(true);
            mXRaisedToNBtn.setEnabled(true);
            mNRootXBtn.setEnabled(true);
            mXSquareBtn.setEnabled(true);
            mLogBtn.setEnabled(true);
            mNaturalLogBtn.setEnabled(true);
            mHistoryHelper.reset();
        } // passing the intent when the history button is pressed
        else if (v == mHistoryBtn){
            Intent intent = new Intent(MainActivity.this, CalculationHistory.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("ARRAYLIST", (Serializable) mHistoryHelper.returnOperationsList());
            intent.putExtra(HISTORY_DATA, bundle);
            startActivity(intent);
        }
    }

    private void input(String s) {
        String original = mCalcTV.getText().toString();
        mCalcTV.setText(original+s);
    }
}