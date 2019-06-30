package com.example.rodrigosouza.presencebarcode.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rodrigosouza.presencebarcode.R;
import com.example.rodrigosouza.presencebarcode.model.DeclaracaoAusencia;

import java.util.List;

public class DeclaracaoAusenciaAdapter  extends BaseAdapter {
    private final List<DeclaracaoAusencia> horariosDisponiveis;
    private Context context;
    public DeclaracaoAusenciaAdapter(List<DeclaracaoAusencia> disponiveis, Context activity){
        this.horariosDisponiveis = disponiveis;
        this.context = activity;
    }
    @Override
    public int getCount() {
        return horariosDisponiveis.size();
    }

    @Override
    public Object getItem(int position) {
        return horariosDisponiveis.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(context).inflate(R.layout.list_disponivel, parent, false);
        DeclaracaoAusencia ausencia = horariosDisponiveis.get(position);
        TextView dataDisponivel = (TextView)view.findViewById(R.id.tv_data_disponivel);
        dataDisponivel.setText(ausencia.getData_falta().toString());
        //TextView horaDisponivel = (TextView)view.findViewById(R.id.tv_hora_disponivel);
        //horaDisponivel.setText(ausencia.getData_declaracao().toString());
        TextView prof = (TextView)view.findViewById(R.id.tv_professor);
        prof.setText(ausencia.getProfessor());
        TextView turma = (TextView)view.findViewById(R.id.tv_turma);
        turma.setText(ausencia.getTurma());
        TextView horario = (TextView)view.findViewById(R.id.tv_horario);
        horario.setText(ausencia.getHorario());
        //TextView cod = (TextView)view.findViewById(R.id.tv_cod);
        //cod.setText(""+ausencia.getCod());
        //TextView justi = (TextView)view.findViewById(R.id.tv_justificativa);
        //justi.setText(ausencia.getJustificativa());
        return view;
    }

}
