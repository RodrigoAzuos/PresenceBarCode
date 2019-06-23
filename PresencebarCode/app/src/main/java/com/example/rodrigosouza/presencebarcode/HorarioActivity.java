package com.example.rodrigosouza.presencebarcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;

public class HorarioActivity extends AppCompatActivity {
    private int year, month, day, hour, minute;
    CalendarView calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);
        calendar = (CalendarView)findViewById(R.id.simpleCalendarView);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                goDetail(year, month, dayOfMonth);
            }
        });
    }
    private void goDetail(int year, int month, int dayOfMonth){
        Intent intent = new Intent(this, HorarioDetailActivity.class);
        intent.putExtra("year",""+year);
        intent.putExtra("month",""+month);
        intent.putExtra("dayOfMonth",""+dayOfMonth);
        startActivity(intent);
    }
}
