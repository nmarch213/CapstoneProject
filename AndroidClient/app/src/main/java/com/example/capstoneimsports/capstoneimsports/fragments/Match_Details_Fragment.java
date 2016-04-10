package com.example.capstoneimsports.capstoneimsports.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.capstoneimsports.capstoneimsports.R;
import com.example.capstoneimsports.capstoneimsports.server.ServerHandler;

public class Match_Details_Fragment extends Fragment {
    ServerHandler server = new ServerHandler();
    String url = "http://104.197.124.0:8080/api/match_details";

    String team_one_name, team_two_name, match_league;
    int team_one_score, team_two_score, match_id;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_match_details_, container, false);


        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

}
