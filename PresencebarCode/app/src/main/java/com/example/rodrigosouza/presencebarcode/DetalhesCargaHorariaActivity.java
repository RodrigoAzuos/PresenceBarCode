package com.example.rodrigosouza.presencebarcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.rodrigosouza.presencebarcode.model.Turma;

import java.util.ArrayList;
import java.util.List;

public class DetalhesCargaHorariaActivity extends AppCompatActivity {
    public int carga_horaria;
    public int horas_restantes = 0;
    public int horas_antecipadas = 0;
    public int horas_ministradas =0;
    public int horas_ausencias = 0;
    public List<Turma> turmas = new ArrayList<Turma>();
    public TextView txt_carga_horaria;
    public TextView txt_horas_antecipadas;
    public TextView txt_horas_ausentes;
    public TextView txt_horas_ministradas;
    public TextView txt_horas_restantes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_carga_horaria);

        txt_carga_horaria = findViewById(R.id.inputCargaHoraria);
        txt_horas_antecipadas = findViewById(R.id.input_horas_antecipadas);
        txt_horas_ausentes = findViewById(R.id.input_ausencias);
        txt_horas_ministradas  = findViewById(R.id.input_horas_ministradas);
        txt_horas_restantes = findViewById(R.id.input_horas_restantes);



    }

    public void MostrarCargaHoraria(){

        for (int i = 0;i<turmas.size();i++){

            carga_horaria = Integer.parseInt(turmas.get(i).getCarga_horaria());
            txt_carga_horaria.setText(carga_horaria);


        }


    }

}