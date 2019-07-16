package com.example.rodrigosouza.presencebarcode.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.VectorDrawable;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rodrigosouza.presencebarcode.app.MainActivity;
import com.example.rodrigosouza.presencebarcode.R;
import com.example.rodrigosouza.presencebarcode.utils.VectorDrawableUtils;

public class CardFrequenciaAdapter extends RecyclerView.Adapter<CardFrequenciaAdapter.ViewHolder> {
    private String[] mDataset;
    private Context mContext;
    private Activity activity;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        private ImageView imgAcao;
        private TextView tvGridName;

        public ViewHolder(View itemView) {
            super(itemView);

            imgAcao = itemView.findViewById(R.id.img_acao);
            tvGridName = itemView.findViewById(R.id.tv_name_grid);
        }
    }

    public CardFrequenciaAdapter(String[] myDataset, Context context, Activity activity) {
        mDataset = myDataset;
        mContext = context;
        this.activity = activity;
    }

    @Override
    public CardFrequenciaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card_frequencia, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Irá iniciar um frequência!",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}