package com.example.rodrigosouza.presencebarcode.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rodrigosouza.presencebarcode.R;
import com.example.rodrigosouza.presencebarcode.model.Turma;
import com.example.rodrigosouza.presencebarcode.utils.ConnectionRetrofit;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterTurma extends RecyclerView.Adapter<AdapterTurma.ViewHolder> {

    private final List<Turma> turmas;
    private Context context;
    private LayoutInflater inflator;

    public AdapterTurma(List<Turma> turmas, Context context) {
        this.turmas = turmas;
        this.context = context;
        inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflator = LayoutInflater.from(viewGroup.getContext());
        //inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =inflator.inflate(R.layout.item_lista_turma,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, int i) {
        Turma turmas = this.turmas.get(i);
        viewHolder.inputDisciplina_id.setText(turmas.getDisciplina());
        viewHolder.inputCargaHoraria_id.setText(turmas.getCarga_horaria());
        viewHolder.input_especificacao_id.setText(turmas.getEspecificacao_disciplina());


    }

    @Override
    public int getItemCount() {
        return turmas.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView text_carga_horaria_id;
        protected TextView text_especificacao_disciplina_id;
        protected TextView input_especificacao_id;
        protected TextView textDisciplina_id;
        protected TextView inputDisciplina_id;
        protected TextView inputCargaHoraria_id;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            text_especificacao_disciplina_id = itemView.findViewById(R.id.textEspDisciplina);
            //text_carga_horaria_id = itemView.findViewById(R.id.detalhesCargaHoraria );
            input_especificacao_id = itemView.findViewById(R.id.inputEspDisciplina);
            textDisciplina_id = itemView.findViewById(R.id.textDisciplina);
            inputDisciplina_id = itemView.findViewById(R.id.inputDisciplina);
            inputCargaHoraria_id = itemView.findViewById(R.id.inputCargaHoraria);
        }
    }




}