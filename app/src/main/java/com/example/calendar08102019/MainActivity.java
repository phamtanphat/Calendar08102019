package com.example.calendar08102019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Date date = new Date();
//        long currentTime = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        Log.d("BBB",year + "");

    }
}
