package helloworld.example.com.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class TipCalculator extends AppCompatActivity {
    TextView textView, tipView, totalView;
    RatingBar ratingBar;
    Button  button7, button8, button9, buttonClr,
            button4, button5, button6, button1,
            button2, button3, buttonPeriod, button0,
            buttonTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        textView = (TextView) findViewById(R.id.billTextView);
        tipView = (TextView) findViewById(R.id.tipTextView);
        totalView = (TextView) findViewById(R.id.totalTextView);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        button7 = (Button) findViewById(R.id.button_7);
        button4 = (Button) findViewById(R.id.button_4);
        button1 = (Button) findViewById(R.id.button_1);
        buttonPeriod = (Button) findViewById(R.id.button_per);
        button8 = (Button) findViewById(R.id.button_8);
        button5 = (Button) findViewById(R.id.button_5);
        button2 = (Button) findViewById(R.id.button_2);
        button0 = (Button) findViewById(R.id.button_0);
        button9 = (Button) findViewById(R.id.button_9);
        button6 = (Button) findViewById(R.id.button_6);
        button3 = (Button) findViewById(R.id.button_3);
        buttonTotal = (Button) findViewById(R.id.buttonCalculate);
        buttonClr = (Button) findViewById(R.id.button_Clr);
    }

}
