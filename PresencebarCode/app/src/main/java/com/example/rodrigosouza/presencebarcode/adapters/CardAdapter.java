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

import com.example.rodrigosouza.presencebarcode.MainActivity;
import com.example.rodrigosouza.presencebarcode.R;
import com.example.rodrigosouza.presencebarcode.utils.CommonUtils;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private String[] mDataset;
    private Context mContext;
    private Activity activity;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public CardAdapter(String[] myDataset, Context context, Activity activity) {
        mDataset = myDataset;
        mContext = context;
        this.activity = activity;
    }

    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card_presenca, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
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
        return mDataset.length;
    }
}