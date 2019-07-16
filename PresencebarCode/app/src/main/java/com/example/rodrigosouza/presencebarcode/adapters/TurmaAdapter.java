package com.example.rodrigosouza.presencebarcode.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rodrigosouza.presencebarcode.R;
import com.example.rodrigosouza.presencebarcode.app.HomeActivity;
import com.example.rodrigosouza.presencebarcode.model.Turma;
import com.example.rodrigosouza.presencebarcode.utils.Constants;
import com.example.rodrigosouza.presencebarcode.utils.SecurityPreferences;

import java.util.ArrayList;
import java.util.List;

public class TurmaAdapter extends RecyclerView.Adapter<TurmaAdapter.ViewHolder> {

    private List<Turma> mDataset;
    private Context mContext;
    private SecurityPreferences securityPreferences;

    public TurmaAdapter(List<Turma> Dataset, Context context){
        mDataset = Dataset;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_turmas, viewGroup, false);

        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

        final Turma turma = mDataset.get(i);
        securityPreferences = new SecurityPreferences(mContext);


        viewHolder.tvNomeTurma.setText(turma.getDisciplina());
        viewHolder.llSelectTurma.setVisibility(View.GONE);
        viewHolder.llSelectTurma.setVisibility(View.VISIBLE);

        viewHolder.llCardTurma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.llSelectTurma.setVisibility(View.VISIBLE);
                viewHolder.progressBarStart.setVisibility(View.VISIBLE);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewHolder.progressBarStart.setVisibility(View.GONE);
                        viewHolder.llSelectTurma.setVisibility(View.VISIBLE);
                        Intent intent = new Intent(mContext, HomeActivity.class);
                        intent.putExtra("turmaId", turma.getId());
                        intent.putExtra("turmaDisciplinaNome", turma.getDisciplina());
                        mContext.startActivity(intent);
                    }
                }, 2000);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout llCardTurma, llSelectTurma;
        ProgressBar progressBarStart;
        TextView tvNomeTurma;

        public ViewHolder(View itemView){
            super(itemView);

            llCardTurma = itemView.findViewById(R.id.ll_card_turma);
            llSelectTurma = itemView.findViewById(R.id.ll_select_turma);
            progressBarStart = itemView.findViewById(R.id.progress_load_test);
            tvNomeTurma = itemView.findViewById(R.id.tv_nome_turma);
        }
    }
}
