package com.example.zhucan.joke.ui.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.zhucan.joke.R;

import java.util.Calendar;

/**
 * Created by zhucan on 2016/12/14.
 */

public class Useragree extends Activity {
    Button post;
    String response;
    private int year;
    private int month;
    private int day;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.useragreement);

        DatePicker datePicker=(DatePicker)findViewById(R.id.date);
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker arg0, int year, int month, int day) {
                Useragree.this.year = year;
                Useragree.this.month = month;
                Useragree.this.day = day;
                showDate(year, month, day);
            }
        });

        post=(Button)findViewById(R.id.button);

    }
    private void showDate(int year,int month,int day){
        TextView textView=(TextView)findViewById(R.id.text);

       textView.setText("您的出生年月是:"+year+"年"+(month+1)+"月"+day
               +"日");
    }




}
