package com.example.capstoneimsports.capstoneimsports.fragments;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.capstoneimsports.capstoneimsports.R;
import com.example.capstoneimsports.capstoneimsports.models.Match_model;
import com.example.capstoneimsports.capstoneimsports.server.ServerHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class Match_Details_Fragment extends Fragment {

    ServerHandler server = new ServerHandler();
    String url = "http://104.197.91.105:8080/api/match_details";

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

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        try {
            JSONObject obj = new JSONObject();
            obj.put("match_id", 1);
            String response = server.doPostRequest(url, obj.toString());

            response = response.replace("[", "");
            response = response.replace("]", "");

            JSONObject resObj = new JSONObject(response);

            Match_model match = new Match_model(resObj.getString("team_one_name"), resObj.getString("team_two_name"),
                    resObj.getInt("team_one_score"), resObj.getInt("team_two_score"), resObj.getInt("match_id"),
                    resObj.getString("match_league"));

            team_one_name = resObj.getString("team_one_name");
            team_two_name = resObj.getString("team_two_name");
            team_one_score = resObj.getInt("team_one_score");
            team_two_score = resObj.getInt("team_two_score");
            match_id = resObj.getInt("match_id");
            match_league = resObj.getString("match_league");

            String t1_score_format = getActivity().getResources().getString(R.string.team_one_score);
            String t1_score_msg = String.format(t1_score_format, team_one_score);


            Toast.makeText(getActivity().getApplicationContext(),
                    "Match Added", Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
