package com.example.calendar08102019;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText edtDayStart, edtDayEnd;
    TextView txtTotalDay;
    Button btnHandle;
    Calendar calendarStart, calendarEnd;
    SimpleDateFormat simpleDateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtDayEnd = findViewById(R.id.edittextDateEnd);
        edtDayStart = findViewById(R.id.edittextDateStart);
        txtTotalDay = findViewById(R.id.textviewDay);
        btnHandle = findViewById(R.id.buttonHandle);

        calendarStart = Calendar.getInstance();
        calendarEnd = Calendar.getInstance();

        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        edtDayStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                calendarStart.set(year, month, dayOfMonth);
                                edtDayStart.setText(simpleDateFormat.format(calendarStart.getTimeInMillis()));
                            }
                        }, calendarStart.get(Calendar.YEAR),
                        calendarStart.get(Calendar.MONTH),
                        calendarStart.get(Calendar.DATE));
                datePickerDialog.show();
            }
        });

        edtDayEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtDayStart.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Bạn chưa chọn ngày bắt đầu", Toast.LENGTH_SHORT).show();
                }else {
                    calendarEnd.setTimeInMillis(calendarStart.getTimeInMillis() + (24* 60 * 60 * 1000));
                    DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                    calendarEnd.set(year, month, dayOfMonth);
                                    edtDayEnd.setText(simpleDateFormat.format(calendarEnd.getTimeInMillis()));
                                }
                            }, calendarEnd.get(Calendar.YEAR),
                            calendarEnd.get(Calendar.MONTH),
                            calendarEnd.get(Calendar.DATE));
                    datePickerDialog.getDatePicker().setMinDate(calendarEnd.getTimeInMillis());
                    datePickerDialog.show();
                }
            }
        });


    }
}
