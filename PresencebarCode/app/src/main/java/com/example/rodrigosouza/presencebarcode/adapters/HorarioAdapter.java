package com.example.rodrigosouza.presencebarcode.adapters;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.rodrigosouza.presencebarcode.HorarioDetailActivity;
import com.example.rodrigosouza.presencebarcode.R;
import com.example.rodrigosouza.presencebarcode.model.Horario;

import java.util.List;

public class HorarioAdapter extends BaseAdapter {
    private final List<Horario> horarios;
    private Context context;
    private String date;
    public HorarioAdapter(List<Horario> horarios, Context context, String date){
        this.horarios = horarios;
        this.context = context;
        this.date = date;
    }

    @Override
    public int getCount() {
        return horarios.size();
    }

    @Override
    public Object getItem(int position) {
        return horarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(context).inflate(R.layout.list_horario, parent, false);

        final Horario horario = horarios.get(position);
        TextView turmaHorario = view.findViewById(R.id.tv_horario_turma);
        TextView horaInicio = view.findViewById(R.id.tv_horario_hora_inicio);
        TextView horaFim = view.findViewById(R.id.tv_horario_hora_fim);
        Button btDetail = view.findViewById(R.id.bt_horario_detail);
        turmaHorario.setText(horario.getTurma());
        horaInicio.setText(horario.getHora_inicio());
        horaFim.setText(horario.getHora_fim());
        final View myView = view;
        btDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotHorarioDetail(horario,myView);
            }
        });
        return view;
    }

    public void gotHorarioDetail(Horario horario, View v){
        Intent intent = new Intent(v.getContext(), HorarioDetailActivity.class);
        intent.putExtra("idHorario",horario.getId());
        intent.putExtra("turma",horario.getTurma());
        intent.putExtra("horaInicio",horario.getHora_inicio());
        intent.putExtra("horaFim",horario.getHora_fim());
        intent.putExtra("date",date);
        context.startActivity(intent);
    }
}