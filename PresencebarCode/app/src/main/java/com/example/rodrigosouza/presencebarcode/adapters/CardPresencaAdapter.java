package com.example.rodrigosouza.presencebarcode.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rodrigosouza.presencebarcode.app.MainActivity;
import com.example.rodrigosouza.presencebarcode.R;
import com.example.rodrigosouza.presencebarcode.model.Item;

import java.util.List;

public class CardPresencaAdapter extends RecyclerView.Adapter<CardPresencaAdapter.ViewHolder> {
    private List<Item> mDataset;
    private Context mContext;
    private Activity activity;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        TextView tvNameGrid;
        ImageView imgAcao;

        public ViewHolder(View itemView) {
            super(itemView);
            imgAcao = itemView.findViewById(R.id.img_acao);
            tvNameGrid = itemView.findViewById(R.id.tv_name_grid);
        }
    }

    public CardPresencaAdapter(List<Item> myDataset, Context context, Activity activity) {
        mDataset = myDataset;
        mContext = context;
        this.activity = activity;
    }

    @Override
    public CardPresencaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card_presenca, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Item item = mDataset.get(position);

        holder.tvNameGrid.setText(item.getDescricao());

        if (item.getDescricao().equalsIgnoreCase("Carga Horária"))
            holder.imgAcao.setBackgroundResource(R.drawable.cargahoraria);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity , MainActivity.class);
                activity.startActivityForResult(intent,0);
                activity.overridePendingTransition(R.anim.lefttoright, R.anim.stable);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}