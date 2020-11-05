package com.example.a79_90project;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends Activity {
    private double currentBillTotal;
    private int Currentcustomprecent;
    private EditText billET;
    private EditText tip10ET;
    private EditText total0ET;
    private EditText tip15ET;
    private EditText total15ET;
    private EditText total20ET;
    private EditText tip20ET;
    private EditText tipcustomET;
    private TextView customtipTV;
    private EditText totalCustomET;
    private SeekBar customSeekbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customtipTV = findViewById(R.id.CustomTipTextView);
        tipcustomET = findViewById(R.id.tipcustomEditText);
        totalCustomET = findViewById(R.id.totalcustomET);
        customSeekbar = findViewById(R.id.CustomseekBar);
        customSeekbar.setOnSeekBarChangeListener(customSeekBarListener);
        billET=findViewById(R.id.billET);


        billET.addTextChangedListener(BillETwatcher);

    }
    private void UpdateCustom() {
        customtipTV.setText(Currentcustomprecent + "%");
        double customTipAmount = currentBillTotal * Currentcustomprecent * 0.01;
        double customTotalAmount = currentBillTotal + customTipAmount;
        tipcustomET.setText(String.format("%.02f", customTipAmount));
        totalCustomET.setText(String.format("%.02f", customTotalAmount));
    }
   private TextWatcher BillETwatcher=new TextWatcher() {
       @Override
       public void beforeTextChanged(CharSequence s, int start, int count, int after) {

       }

       @Override
       public void onTextChanged(CharSequence s, int start, int before, int count) {
           try {
               currentBillTotal = Double.parseDouble(s.toString());
           } catch (NumberFormatException E) {
               currentBillTotal = 0.0;
               UpdateCustom();
           }

       }
       @Override
       public void afterTextChanged(Editable s) {

       }
   };



        private SeekBar.OnSeekBarChangeListener customSeekBarListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Currentcustomprecent = seekBar.getProgress();
                UpdateCustom();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        };

}