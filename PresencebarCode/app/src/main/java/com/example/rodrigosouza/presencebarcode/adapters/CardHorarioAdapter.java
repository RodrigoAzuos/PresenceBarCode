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

import com.example.rodrigosouza.presencebarcode.app.AusenciaActivity;
import com.example.rodrigosouza.presencebarcode.app.InteresseActivity;
import com.example.rodrigosouza.presencebarcode.app.MainActivity;
import com.example.rodrigosouza.presencebarcode.R;
import com.example.rodrigosouza.presencebarcode.model.Item;

import java.util.List;

public class CardHorarioAdapter extends RecyclerView.Adapter<CardHorarioAdapter.ViewHolder> {
    private List<Item> mDataset;
    private Context mContext;
    private Activity activity;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        TextView tvNameGrid;
        ImageView imgAcao;

        public ViewHolder(View itemView) {
            super(itemView);
            imgAcao = itemView.findViewById(R.id.img_acao2);
            tvNameGrid = itemView.findViewById(R.id.tv_name_grid2);
        }
    }

    public CardHorarioAdapter(List<Item> myDataset, Context context, Activity activity) {
        mDataset = myDataset;
        mContext = context;
        this.activity = activity;
    }

    @Override
    public CardHorarioAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card_horario, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Item item = mDataset.get(position);

        holder.tvNameGrid.setText(item.getDescricao());

        if (item.getDescricao().equalsIgnoreCase("Declarar Interesse"))
            holder.imgAcao.setBackgroundResource(R.drawable.interesse2);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(activity , AusenciaActivity.class);
                Intent intent2 = new Intent(activity, InteresseActivity.class);
                if (item.getDescricao().equalsIgnoreCase("Declarar Interesse")){
                    activity.startActivityForResult(intent2,0);
                    activity.overridePendingTransition(R.anim.lefttoright, R.anim.stable);
                }else{
                    activity.startActivityForResult(intent1,0);
                    activity.overridePendingTransition(R.anim.lefttoright, R.anim.stable);
                }



            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}