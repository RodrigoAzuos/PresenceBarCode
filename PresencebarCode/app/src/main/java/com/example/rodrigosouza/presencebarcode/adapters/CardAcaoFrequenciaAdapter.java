package com.example.rodrigosouza.presencebarcode.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rodrigosouza.presencebarcode.R;
import com.example.rodrigosouza.presencebarcode.app.RegistrarFrequenciaActivity;
import com.example.rodrigosouza.presencebarcode.app.TurmasActivity;

public class CardAcaoFrequenciaAdapter extends RecyclerView.Adapter<CardAcaoFrequenciaAdapter.ViewHolder> {
    private String[] mDataset;
    private Context mContext;
    private Activity activity;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvWatch;
        TextView tvNameAcaoFrequencia;
        LinearLayout llCollapsingLayout,llCardBackground;
        ImageView imgIniciarFrequencia;
        ImageButton btnCollapse;
        boolean collpased = true;

        public ViewHolder(View itemView) {
            super(itemView);
            tvWatch = itemView.findViewById(R.id.tv_watch);
            btnCollapse = itemView.findViewById(R.id.btn_collapse);
            llCollapsingLayout = itemView.findViewById(R.id.ll_collapsing_layout);
            tvNameAcaoFrequencia = itemView.findViewById(R.id.tv_name_acao_frequencia);
            llCardBackground = itemView.findViewById(R.id.ll_card_background);
            imgIniciarFrequencia = itemView.findViewById(R.id.imgIniciarFrequencia);

        }
    }

    public CardAcaoFrequenciaAdapter(String[] myDataset, Context context, Activity mActivity) {
        mDataset = myDataset;
        mContext = context;
        activity = mActivity;
    }

    @Override
    public CardAcaoFrequenciaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_frequencia, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.llCardBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, RegistrarFrequenciaActivity.class);
                intent.putExtra("turmaId",activity.getIntent().getLongExtra("turmaId", -1));
                activity.startActivityForResult(intent,0);
                activity.overridePendingTransition(R.anim.lefttoright, R.anim.stable);

            }
        });

        holder.imgIniciarFrequencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivityForResult(new Intent(activity, RegistrarFrequenciaActivity.class),0);
                activity.overridePendingTransition(R.anim.lefttoright, R.anim.stable);
            }
        });

        Shader textShader=new LinearGradient(0, 0, 100, 20,
                new int[]{Color.BLUE, Color.parseColor("#00BCD4")},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        holder.tvWatch.getPaint().setShader(textShader);

        holder.btnCollapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.collpased){
                    holder.collpased = false;
                    holder.llCollapsingLayout.setVisibility(View.VISIBLE);
                    holder.btnCollapse.setImageResource(R.drawable.ic_up_arrow);
                } else {
                    holder.collpased = true;
                    holder.llCollapsingLayout.setVisibility(View.GONE);
                    holder.btnCollapse.setImageResource(R.drawable.ic_down_arrow);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}