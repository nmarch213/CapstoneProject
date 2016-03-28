package com.example.capstoneimsports.capstoneimsports;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.capstoneimsports.capstoneimsports.activities.Home_Activity;
import com.example.capstoneimsports.capstoneimsports.models.Match_model;

import java.util.Collections;
import java.util.List;

import static android.app.PendingIntent.getActivity;

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
        holder.team_one_score.setText(String.valueOf(current.getTeam_one_score()));
        holder.team_two_score.setText(String.valueOf(current.getTeam_two_score()));
        holder.league.setText(current.getMatch_league());


    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView team_one_name, team_one_score, team_two_name, team_two_score, league, gameDate;
        GridLayout layout;

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

            layout = (GridLayout) itemView.findViewById(R.id.match_frame);
            layout.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {


        }
    }
}
