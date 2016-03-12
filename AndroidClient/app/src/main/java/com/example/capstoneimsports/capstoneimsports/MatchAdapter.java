package com.example.capstoneimsports.capstoneimsports;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.capstoneimsports.capstoneimsports.models.Match_model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick on 3/12/2016.
 */
public abstract class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder> {


    List<Match_model> list = new ArrayList<>();

    public MatchAdapter(List<Match_model> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.Match = getItem(position);
        /*
        holder.cardtitle.setText(list.get(position).name);
        holder.cardimage.setImageResource(list.get(position).id);
        */
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public Match_model getItem(int i) {
        return list.get(i);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cardimage;
        TextView cardtitle;
        Match_model Match;

        public ViewHolder(View itemView) {
            super(itemView);
            cardimage = (ImageView) itemView.findViewById(R.id.cardimage);
            cardtitle = (TextView) itemView.findViewById(R.id.cardtitle);
        }
    }
}

