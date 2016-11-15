package helloworld.example.com.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button  button7, button8, button9, buttonClr, button4,
            button5, button6, buttonDiv, button1, button2,
            button3, buttonMultiply, buttonPeriod, button0,
            buttonEqual, buttonSub, buttonAdd;
    Button buttonTrans;
    float mValue1, mValue2;
    boolean mAdd, mSub, mMulti, mDivide;
    FloatingActionButton fab, fab2, fab3;

    Animation fabOpen, fabClose, fabRClockWise, fabRAntiClockwise, trans_open, trans_close;
    boolean isOpen = false;
    StringBuilder stringBuilder = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region findViewByIds
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        trans_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.trans_open);
        trans_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.trans_close);
        fabOpen = AnimationUtils.
                loadAnimation(getApplicationContext(), R.anim.fab_open);
        fabClose = AnimationUtils.
                loadAnimation(getApplicationContext(), R.anim.fab_close);
        fabRClockWise = AnimationUtils.
                loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        fabRAntiClockwise = AnimationUtils.
                loadAnimation(getApplicationContext(), R.anim.rotate_anti_clockwise);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonClr = (Button) findViewById(R.id.buttonclr);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        buttonDiv = (Button) findViewById(R.id.buttonDivide);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        button1 = (Button) findViewById(R.id.button1);
        buttonPeriod = (Button) findViewById(R.id.buttonPeriod);
        button0 = (Button) findViewById(R.id.button0);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        buttonSub = (Button) findViewById(R.id.buttonSubtract);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        textView = (TextView) findViewById(R.id.textView);
        buttonTrans = (Button) findViewById(R.id.buttonTrans);
        //endregion
        //region fab (setOnCLickListener)
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isOpen){
                    buttonTrans.startAnimation(trans_close);buttonTrans.setClickable(false);
                    fab3.startAnimation(fabClose);fab2.startAnimation(fabClose);
                    fab.startAnimation(fabRAntiClockwise);fab3.setClickable(false);
                    fab2.setClickable(false);isOpen = false;
                    button7.setClickable(true);button8.setClickable(true);
                    button9.setClickable(true);buttonClr.setClickable(true);
                    button4.setClickable(true);button5.setClickable(true);
                    button6.setClickable(true);buttonDiv.setClickable(true);
                    button1.setClickable(true);button2.setClickable(true);
                    button3.setClickable(true);buttonMultiply.setClickable(true);
                    buttonPeriod.setClickable(true);button0.setClickable(true);
                    buttonEqual.setClickable(true);buttonSub.setClickable(true);
                    buttonAdd.setClickable(true);
                }else{
                    buttonTrans.setClickable(true);buttonTrans.startAnimation(trans_open);
                    fab3.startAnimation(fabOpen);fab2.startAnimation(fabOpen);
                    fab.startAnimation(fabRClockWise);fab3.setClickable(true);
                    fab2.setClickable(true);isOpen = true;
                    button7.setClickable(false);button8.setClickable(false);
                    button9.setClickable(false);buttonClr.setClickable(false);
                    button4.setClickable(false);button5.setClickable(false);
                    button6.setClickable(false);buttonDiv.setClickable(false);
                    button1.setClickable(false);button2.setClickable(false);
                    button3.setClickable(false);buttonMultiply.setClickable(false);
                    buttonPeriod.setClickable(false);button0.setClickable(false);
                    buttonEqual.setClickable(false);buttonSub.setClickable(false);
                    buttonAdd.setClickable(false);
                }
            }
        });

        buttonTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fab.callOnClick();
            }
        });


        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Opens history fab button.
                Intent intent = new Intent(getApplication(), HistoryActivity.class);
                startActivity(intent);
                fab.callOnClick();
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), TipCalculator.class);
                startActivity(intent);
                fab.callOnClick();
            }
        });
        //endregion)
        //region button(setOnClickListener
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView.getText().toString().equals("0")){
                    textView.setText(button0.getText());
                }else{
                textView.append(button0.getText());
                stringBuilder.append(button0.getText());}
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView.getText().toString().equals("0")){
                    textView.setText(button1.getText());
                    stringBuilder.append(button1.getText());
                }else{
                textView.append(button1.getText());
                stringBuilder.append(button1.getText());}
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView.getText().toString().equals("0")){
                    textView.setText(button2.getText());
                    stringBuilder.append(button2.getText());
                }else{
                textView.append(button2.getText());
                stringBuilder.append(button2.getText());}
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView.getText().toString().equals("0")){
                    textView.setText(button3.getText());
                    stringBuilder.append(button3.getText());
                }else{
                textView.append(button3.getText());
                stringBuilder.append(button3.getText());}
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView.getText().toString().equals("0")){
                    textView.setText(button4.getText());
                    stringBuilder.append(button4.getText());
                }else{
                textView.append(button4.getText());
                stringBuilder.append(button4.getText());}
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView.getText().toString().equals("0")){
                    textView.setText(button5.getText());
                    stringBuilder.append(button5.getText());
                }else{
                textView.append(button5.getText());
                stringBuilder.append(button5.getText());}
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView.getText().toString().equals("0")){
                    textView.setText(button6.getText());
                    stringBuilder.append(button6.getText());
                }else{
                textView.append(button6.getText());
                stringBuilder.append(button6.getText());}
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView.getText().toString().equals("0")){
                    textView.setText(button7.getText());
                    stringBuilder.append(button7.getText());
                }else{
                textView.append(button7.getText());
                stringBuilder.append(button7.getText());}
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView.getText().toString().equals("0")){
                    textView.setText(button8.getText());
                    stringBuilder.append(button8.getText());
                }else{
                textView.append(button8.getText());
                stringBuilder.append(button8.getText());}
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView.getText().toString().equals("0")){
                    textView.setText(button9.getText());
                    stringBuilder.append(button9.getText());
                }else{
                textView.append(button9.getText());
                stringBuilder.append(button9.getText());}
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValue1 = Float.parseFloat(textView.getText() + "");
                textView.setText("0");
                stringBuilder.delete(0, stringBuilder.length());
                mAdd = true;
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValue1 = Float.parseFloat(textView.getText() + "");
                textView.setText("0");
                stringBuilder.delete(0, stringBuilder.length());
                mSub = true;
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValue1 = Float.parseFloat(textView.getText() + "");
                textView.setText("0");
                stringBuilder.delete(0, stringBuilder.length());
                mDivide = true;
            }
        });
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValue1 = Float.parseFloat(textView.getText() + "");
                textView.setText("0");
                stringBuilder.delete(0, stringBuilder.length());
                mMulti = true;
            }
        });
        buttonClr.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                textView.setText("0");
                stringBuilder.delete(0, stringBuilder.length());
                return false;
            }
        });
        buttonClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //I used try catch exception so app won't crash with Sting out of bounce exception.
                try{
                    textView.setText(stringBuilder.toString().
                            substring(0, stringBuilder.toString().length()-1));
                    stringBuilder.setLength(stringBuilder.length()-1);
                    if(textView.getText().toString().equals("")){
                        textView.setText("0");
                    }
                    }catch (StringIndexOutOfBoundsException e){
                    textView.setText("0");
                    stringBuilder.delete(0, stringBuilder.length());
                }
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValue2 = Float.parseFloat(textView.getText() + "");
                //TODO Find a better way to concatenate this.
                if(mAdd){
                    textView.setText(mValue1 + mValue2 + "");
                    stringBuilder.delete(0, stringBuilder.length());
                    mSub=false;
                }
                if(mSub){
                    textView.setText(mValue1 - mValue2 + "");
                    stringBuilder.delete(0, stringBuilder.length());
                    mSub=false;
                }
                if(mMulti){
                    textView.setText(mValue1 * mValue2 + "");
                    stringBuilder.delete(0, stringBuilder.length());
                    mMulti=false;
                }
                if(mDivide){
                    textView.setText(mValue1 / mValue2 + "");
                    stringBuilder.delete(0, stringBuilder.length());
                    mDivide=false;
                }
            }
        });
        buttonPeriod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView.getText().toString().contains(".")){
                    textView.append("");
                }else{
                    textView.append(buttonPeriod.getText());
                }
            }
        });
        //endregion
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}


