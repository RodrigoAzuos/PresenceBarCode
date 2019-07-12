package com.example.rodrigosouza.presencebarcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;

import java.util.Calendar;

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
        Intent intent = new Intent(this, ProfessorHorarioActivity.class);
        intent.putExtra("year",""+year);
        intent.putExtra("month",""+month);
        intent.putExtra("dayOfMonth",""+dayOfMonth);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        intent.putExtra("dayOfWeek",""+dayOfWeek);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.horario, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_hrlist) {
            Intent intent = new Intent(this,HorarioDisponivelActivity.class);
            startActivity(intent);
            return true;
        }else if(id == R.id.action_turma) {
            Intent intent = new Intent(this,ListaDeTurmaActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}