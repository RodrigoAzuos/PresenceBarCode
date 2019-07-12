package com.example.rodrigosouza.presencebarcode.adapters;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rodrigosouza.presencebarcode.R;
import com.example.rodrigosouza.presencebarcode.model.AusenciaInteresse;
import com.example.rodrigosouza.presencebarcode.model.DeclaracaoAusencia;
import com.example.rodrigosouza.presencebarcode.model.DeclaracaoInteresse;
import com.example.rodrigosouza.presencebarcode.utils.ConnectionRetrofit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        final String professorLogado = "1";
        view = LayoutInflater.from(context).inflate(R.layout.list_disponivel, parent, false);
        DeclaracaoAusencia ausencia = horariosDisponiveis.get(position);
        TextView dataDisponivel = (TextView)view.findViewById(R.id.tv_data_disponivel);
        dataDisponivel.setText(ausencia.getData_falta().toString());
        //TextView horaDisponivel = (TextView)view.findViewById(R.id.tv_hora_disponivel);
        //horaDisponivel.setText(ausencia.getData_declaracao().toString());
        final TextView prof = (TextView)view.findViewById(R.id.tv_professor);
        prof.setText(ausencia.getProfessor());
        TextView turma = (TextView)view.findViewById(R.id.tv_turma);
        turma.setText(ausencia.getTurma());
        TextView horario = (TextView)view.findViewById(R.id.tv_horario);
        horario.setText(ausencia.getHorario());
        //final TextView cod = (TextView)view.findViewById(R.id.tv_cod);
        //cod.setText(""+ausencia.getCod());
        //TextView justi = (TextView)view.findViewById(R.id.tv_justificativa);
        //justi.setText(ausencia.getJustificativa());
        Button solicitar = (Button)view.findViewById(R.id.bt_solicitar_horario);
        solicitar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                //Toast.makeText(context, "Clicou aqui", Toast.LENGTH_SHORT).show();
                //createInteresse(cod.getText().toString(), "2019-06-30");
                Date hoje = new Date();
                Log.i("MyLOG", hoje.toString());

                createInteresse("125896", formatDate(hoje));
            }
        });
        return view;
    }

    private void createInteresse(String declarador, String dataDeclaracao){
        DeclaracaoInteresse declaracao = new DeclaracaoInteresse(declarador,dataDeclaracao);
        Call<DeclaracaoInteresse> declaracaoInteresseCall = new ConnectionRetrofit().service().declararInteresse(declaracao);
        declaracaoInteresseCall.enqueue(new Callback<DeclaracaoInteresse>() {
            @Override
            public void onResponse(Call<DeclaracaoInteresse> call, Response<DeclaracaoInteresse> response) {
                DeclaracaoInteresse declaracaoInteresse = response.body();
                if(declaracaoInteresse != null){
                    Toast.makeText(context, "Sucesso!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "Eita porra!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DeclaracaoInteresse> call, Throwable t) {
                Log.i("MyLOG","Error na solicitacao "+t.toString());
            }
        });
    }

    private String formatDate(Date date){
        SimpleDateFormat simDate = new SimpleDateFormat("yyyy-MM-dd");
        String myDate = simDate.format(date);
        return myDate;
    }

}