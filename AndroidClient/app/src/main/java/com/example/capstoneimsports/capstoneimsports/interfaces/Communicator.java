package com.example.capstoneimsports.capstoneimsports.interfaces;

import org.json.JSONException;

/**
 * Created by Nick on 4/17/2016.
 */
public interface Communicator {
    void respond();

    void addTeam2Score(int pointValue) throws JSONException;

    void addTeam1Score(int pointValue) throws JSONException;

    void editTeam1Score(int pointValue) throws JSONException;

    void editTeam2Score(int pointValue) throws JSONException;

    void onCreateClock();

    void setGameTime(String time);

}
