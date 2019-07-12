package com.example.rodrigosouza.presencebarcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.rodrigosouza.presencebarcode.adapters.HorarioAdapter;
import com.example.rodrigosouza.presencebarcode.model.Horario;
import com.example.rodrigosouza.presencebarcode.utils.ConnectionRetrofit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfessorHorarioActivity extends AppCompatActivity {
    private TextView diaSemana, dataDia;
    private ListView listHoararios;
    private HorarioAdapter horarioAdapter;
    private String diaDaSemana, date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_horario);
        bindView();
        getList();
    }
    public String diaSemana(String dia){
        Log.i("MyLOG",""+dia);
        //String diaSemana[] = {"NULL","TERÇA","QUARTA", "QUINTA", "SEXTA", "SABADO","DOMINGO","SEGUNDA"};
        String diaSemana[] = {"NULL","DOMINGO","SEGUNDA","TERCA","QUARTA", "QUINTA", "SEXTA", "SABADO"};
        diaDaSemana = diaSemana[Integer.parseInt(dia)];
        return diaDaSemana;
    }
    public void bindView(){
        Intent intent = getIntent();
        String ano =  intent.getStringExtra("year");
        String mes =  intent.getStringExtra("month");
        String dia =  intent.getStringExtra("dayOfMonth");
        String diaSe = intent.getStringExtra("dayOfWeek");
        diaSemana =(TextView)findViewById(R.id.tv_dia_da_semana);
        dataDia = (TextView)findViewById(R.id.tv_date);
        diaSemana.setText(diaSemana(diaSe));
        int mesInt = Integer.parseInt(mes);
        mesInt+=1;
        date = formDate(ano, ""+mesInt, dia);
        dataDia.setText(date);
    }
    public String formDate(String ano, String mes, String dia){
        if(dia.length() == 1){
            dia = "0"+dia;
        }
        if(mes.length() == 1){
            mes = "0"+mes;
        }
        return ano+"-"+mes+"-"+dia;
    }
    public void getList(){
        final Call<List<Horario>> horarioCall = new ConnectionRetrofit().horarioService().getHorarios(diaDaSemana);
        horarioCall.enqueue(new Callback<List<Horario>>() {
            @Override
            public void onResponse(Call<List<Horario>> call, Response<List<Horario>> response) {
                populateList(response.body());
            }

            @Override
            public void onFailure(Call<List<Horario>> call, Throwable t) {
                Log.i("MyLOG","Error: "+t.toString());
            }
        });
    }
    public void populateList(List<Horario> horarios){
        listHoararios = findViewById(R.id.list_horarios);
        horarioAdapter = new HorarioAdapter(horarios, this,date);
        listHoararios.setAdapter(horarioAdapter);
    }
}