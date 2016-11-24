package helloworld.example.com.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.Objects;

import static helloworld.example.com.calculator.R.string.bill;
import static helloworld.example.com.calculator.R.string.tip;
import static helloworld.example.com.calculator.R.string.total;

public class TipCalculator extends AppCompatActivity {
    TextView billView, tipView, totalView;
    RatingBar ratingBar;
    StringBuilder stringBuilder = new StringBuilder();
    Button  button7, button8, button9, buttonClr,
            button4, button5, button6, button1,
            button2, button3, buttonPeriod, button0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        billView = (TextView) findViewById(R.id.billTextView);
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
        buttonClr = (Button) findViewById(R.id.button_Clr);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                billView.append(button7.getText());
                stringBuilder.append(button7.getText());
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                billView.append(button4.getText());
                stringBuilder.append(button4.getText());
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                billView.append(button1.getText());
                stringBuilder.append(button1.getText());
            }
        });
        buttonPeriod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(billView.getText().toString().contains(".")){
                    billView.append("");
                }else{
                    billView.append(buttonPeriod.getText());
                    stringBuilder.append(buttonPeriod.getText());
                }

            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                billView.append(button8.getText());
                stringBuilder.append(button8.getText());
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                billView.append(button5.getText());
                stringBuilder.append(button5.getText());
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                billView.append(button2.getText());
                stringBuilder.append(button2.getText());
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                billView.append(button0.getText());
                stringBuilder.append(button0.getText());
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                billView.append(button9.getText());
                stringBuilder.append(button9.getText());
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                billView.append(button6.getText());
                stringBuilder.append(button6.getText());
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                billView.append(button3.getText());
                stringBuilder.append(button3.getText());
            }
        });

        buttonClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    billView.setText(getText(bill) + stringBuilder.toString().
                            substring(0, stringBuilder.toString().length() - 1));
                    stringBuilder.setLength(stringBuilder.length() - 1);
                    if (billView.getText().toString().equals("")) {
                        billView.setText(bill);
                    }else if(stringBuilder.toString().isEmpty()){
                        totalView.setText(total);
                        tipView.setText(tip);
                    }
                }catch (StringIndexOutOfBoundsException e){
                    billView.setText(getText(bill));
                    stringBuilder.delete(0, stringBuilder.length());
                }
            }
        });
        buttonClr.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                billView.setText(getText(bill));
                tipView.setText(tip);
                totalView.setText(total);
                stringBuilder.delete(0, stringBuilder.length());
                return false;
            }
        });

        Thread t = new Thread() {


            @Override
            public void run() {

                try {
                    while (!isInterrupted()) {
                        Thread.sleep(100);
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {

                                    if(ratingBar.getRating() == 1 && !Objects.equals(stringBuilder.toString(), "")&&!Objects.equals(stringBuilder.toString(), ".")){
                                        tipView.setText(getText(tip).toString().concat("$") + String.format ("%.2f",Double.parseDouble(stringBuilder.toString()) * 0.05));
                                        totalView.setText(getText(total).toString().concat("$")  + String.format("%.2f",Double.parseDouble(stringBuilder.toString())
                                                + (Double.parseDouble(stringBuilder.toString()) * 0.05)));
                                    }else if(ratingBar.getRating() == 2 && !Objects.equals(stringBuilder.toString(), "")&&!Objects.equals(stringBuilder.toString(), ".")){
                                        tipView.setText(getText(tip).toString().concat("$") + String.format("%.2f",Double.parseDouble(stringBuilder.toString()) * 0.10));
                                        totalView.setText(getText(total).toString().concat("$") + String.format("%.2f",Double.parseDouble(stringBuilder.toString())
                                                + (Double.parseDouble(stringBuilder.toString()) * 0.10)));
                                    }else if(ratingBar.getRating() == 3 && !Objects.equals(stringBuilder.toString(), "")&&!Objects.equals(stringBuilder.toString(), ".")){
                                        tipView.setText(getText(tip).toString().concat("$") + String.format("%.2f",Double.parseDouble(stringBuilder.toString()) * 0.15));
                                        totalView.setText(getText(total).toString().concat("$") + String.format("%.2f",Double.parseDouble(stringBuilder.toString())
                                                + (Double.parseDouble(stringBuilder.toString()) * 0.15)));
                                    }else if(ratingBar.getRating() == 4 && !Objects.equals(stringBuilder.toString(), "")&&!Objects.equals(stringBuilder.toString(), ".")){
                                        tipView.setText(getText(tip).toString().concat("$") + String.format("%.2f",Double.parseDouble(stringBuilder.toString()) * 0.20));
                                        totalView.setText(getText(total).toString().concat("$") + String.format("%.2f",Double.parseDouble(stringBuilder.toString())
                                                + (Double.parseDouble(stringBuilder.toString()) * 0.20)));
                                    }else if(ratingBar.getRating() == 5 && !Objects.equals(stringBuilder.toString(), "")&&!Objects.equals(stringBuilder.toString(), ".")) {
                                        tipView.setText(getText(tip).toString().concat("$") + String.format("%.2f",Double.parseDouble(stringBuilder.toString()) * 0.25));
                                        totalView.setText(getText(total).toString().concat("$") + String.format("%.2f",Double.parseDouble(stringBuilder.toString())
                                                + (Double.parseDouble(stringBuilder.toString()) * 0.25)));

                                    }
                            }
                        });
                    }
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}


