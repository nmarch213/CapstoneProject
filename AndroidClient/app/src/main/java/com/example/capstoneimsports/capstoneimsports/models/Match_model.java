package com.example.capstoneimsports.capstoneimsports.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by Ryan on 3/7/2016.
 */
public class Match_model {

    public static boolean connected = false;

    private String team_one_name;
    private String team_two_name;
    private int team_one_score;
    private int team_two_score;
    private int match_id;
    private String match_date;
    private String match_league;

    public Match_model(String team_one_name, String team_two_name, int team_one_score, int team_two_score, int match_id, String match_league) {

        this.team_one_name = team_one_name;
        this.team_two_name = team_two_name;
        this.team_one_score = team_one_score;
        this.team_two_score = team_two_score;
        this.match_id = match_id;
        this.match_date = match_date;
        this.match_league = match_league;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public String getMatch_league() {
        return match_league;
    }

    public void setMatch_league(String match_league) {
        this.match_league = match_league;
    }

    public String getMatch_date() {
        return match_date;
    }

    public void setMatch_date(String match_date) {
        this.match_date = match_date;
    }

    public String getTeam_one_name() {
        return team_one_name;
    }

    public void setTeam_one_name(String team_one_name) {
        this.team_one_name = team_one_name;
    }

    public int getTeam_one_score() {
        return team_one_score;
    }

    public void setTeam_one_score(int team_one_score) {
        this.team_one_score = team_one_score;
    }

    public String getTeam_two_name() {
        return team_two_name;
    }

    public void setTeam_two_name(String team_two_name) {
        this.team_two_name = team_two_name;
    }

    public int getTeam_two_score() {
        return team_two_score;
    }

    public void setTeam_two_score(int team_two_score) {
        this.team_two_score = team_two_score;
    }
}
