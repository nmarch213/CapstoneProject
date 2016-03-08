package com.example.capstoneimsports.capstoneimsports.models;

import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Ryan on 3/7/2016.
 */
public class Match_model {

    public static boolean connected = false;

    private static String team_one_name;
    private static String team_two_name;
    private static int team_one_score;
    private static int team_two_score;
    private static int match_id;
    private static Date match_date;
    private static String match_league;

    public Match_model(String team_one_name, String team_two_name, int team_one_score, int team_two_score, int match_id, Date match_date, String match_league) {

        this.team_one_name = team_one_name;
        this.team_two_name = team_two_name;
        this.team_one_score = team_one_score;
        this.team_two_score = team_two_score;
        this.match_id = match_id;
        this.match_date = match_date;
        this.match_league = match_league;
    }

    public static JSONObject newMatch(Match_model match) throws JSONException {

        JSONObject json = new JSONObject("{" +
                "'team_one_name': " + team_one_name +
                "'team_two_name': " + team_two_name +
                "'team_one_score': " + team_one_score +
                "'team_two_score': " + team_two_score +
                "'match_id': " + match_id +
                "'match_date': " + match_date +
                "'match_league': " + match_league + "}");

        return json;
    }

    public static String getTeam_one_name() {
        return team_one_name;
    }

    public static void setTeam_one_name(String team_one_name) {
        Match_model.team_one_name = team_one_name;
    }

    public static int getTeam_one_score() {
        return team_one_score;
    }

    public static void setTeam_one_score(int team_one_score) {
        Match_model.team_one_score = team_one_score;
    }

    public static String getTeam_two_name() {
        return team_two_name;
    }

    public static void setTeam_two_name(String team_two_name) {
        Match_model.team_two_name = team_two_name;
    }

    public static int getTeam_two_score() {
        return team_two_score;
    }

    public static void setTeam_two_score(int team_two_score) {
        Match_model.team_two_score = team_two_score;
    }

    public static int getMatch_id() {
        return match_id;
    }

    public static void setMatch_id(int match_id) {
        Match_model.match_id = match_id;
    }

    public static String getMatch_league() {
        return match_league;
    }

    public static void setMatch_league(String match_league) {
        Match_model.match_league = match_league;
    }

    public static Date getMatch_date() {
        return match_date;
    }

    public static void setMatch_date(Date match_date) {
        Match_model.match_date = match_date;
    }
}
