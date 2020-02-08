package com.tf.datetimetest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    TextView tv_time;
    TextView tv_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //시간/날짜 출력용 컨트롤 참조값
        tv_date = findViewById(R.id.tv_date);
        tv_time = findViewById(R.id.tv_time);
    }

    //날짜선택 클릭
    public void onClickDate(View view){

        //날짜선택시 선택한 날짜를 처리할 리스너
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String str_date = String.format("%d년 %d월 %d일",year,month+1,dayOfMonth);
                tv_date.setText(str_date);
            }
        };

        //날짜선택 Picker
        Calendar today  = Calendar.getInstance();
        int year    =   today.get(Calendar.YEAR);
        int month   =   today.get(Calendar.MONTH);
        int date    =   today.get(Calendar.DATE);
        new DatePickerDialog(this,listener,year,month,date).show();
    }

    //시간선택 클릭
    public void onClickTime(View view){

        // TimePickerDialog에서 선택된 시간을 받을 리스너
        TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                String str_time = String.format("%d시 %d분",hourOfDay,minute);
                tv_time.setText(str_time);

            }
        };

        //타임피커 띄우기
        new TimePickerDialog(this,listener,12,0,true).show();



    }
}
