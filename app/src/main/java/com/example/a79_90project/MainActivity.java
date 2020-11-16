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

    private EditText tipcustomET;
    private TextView customtipTV;
    private EditText totalCustomET;
    private SeekBar customSeekbar;
    private EditText Tip10ET ;
    private EditText Tip15ET;
    private EditText Tip20ET;
    private EditText Total0ET;
    private EditText Total15ET;
    private EditText Total20ET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customtipTV = findViewById(R.id.CustomTipTextView);
        tipcustomET = findViewById(R.id.tipcustomEditText);
        totalCustomET = findViewById(R.id.totalcustomET);
        Tip10ET=findViewById(R.id.tip10ET);
        Tip15ET=findViewById(R.id.tip15ET);
        Tip20ET=findViewById(R.id.tip20ET);
        Total0ET=findViewById(R.id.total10ET);
        Total15ET=findViewById(R.id.total15ET);
        Total20ET=findViewById(R.id.total20ET);
        customSeekbar = findViewById(R.id.CustomseekBar);
        customSeekbar.setOnSeekBarChangeListener(customSeekBarListener);
        billET=findViewById(R.id.billET);
        billET.addTextChangedListener(BillETwatcher);

    }
    private void UpdateStandard()
    {
        double tenprecentTip=currentBillTotal*0.1;
        double tenprecentTotal=currentBillTotal+tenprecentTip;
        Tip10ET.setText(String.format("%.02f",tenprecentTip));
        Total0ET.setText(String.format("%.02f",tenprecentTotal));
        double fifteenprecentTip=currentBillTotal*0.15;
        double fifteenprecentTotal=currentBillTotal+fifteenprecentTip;
        Tip15ET.setText(String.format("%.02f",fifteenprecentTip));
        Total15ET.setText(String.format("%.02f",fifteenprecentTotal));
        double twentyprecentTip=currentBillTotal*0.2;
        double twentyprecentTotal=currentBillTotal+twentyprecentTip;
        Tip20ET.setText(String.format("%.02f",twentyprecentTip));
        Total20ET.setText(String.format("%.02f",twentyprecentTotal));
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

           }
           UpdateStandard();
           UpdateCustom();
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