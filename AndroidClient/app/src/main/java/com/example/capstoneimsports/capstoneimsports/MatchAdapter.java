package com.example.capstoneimsports.capstoneimsports;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.capstoneimsports.capstoneimsports.models.Match_model;

import java.util.Collections;
import java.util.List;

/**
 * Created by Nick on 3/12/2016.
 */
public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MyViewHolder> {

    List<Match_model> matches = Collections.emptyList();
    private LayoutInflater inflater;

    public MatchAdapter(Context context, List<Match_model> matches) {
        inflater = LayoutInflater.from(context);
        this.matches = matches;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.fragment_match_details_, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Match_model current = matches.get(position);

        holder.team_one_name.setText(current.getTeam_one_name());
        holder.team_two_name.setText(current.getTeam_two_name());
        holder.team_one_score.setText(current.getTeam_one_score());
        holder.team_two_score.setText(current.getTeam_two_score());

    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView team_one_name, team_one_score, team_two_name, team_two_score, league, gameDate;

        public MyViewHolder(View itemView) {
            super(itemView);

            //Left Block
            team_one_name = (TextView) itemView.findViewById(R.id.team_one_name);
            team_one_score = (TextView) itemView.findViewById(R.id.team_one_score);

            //Middle Block
            league = (TextView) itemView.findViewById(R.id.league);
            gameDate = (TextView) itemView.findViewById(R.id.gametime);

            //Right Block
            team_two_name = (TextView) itemView.findViewById(R.id.team_two_name);
            team_two_score = (TextView) itemView.findViewById(R.id.team_two_score);
        }
    }
}

