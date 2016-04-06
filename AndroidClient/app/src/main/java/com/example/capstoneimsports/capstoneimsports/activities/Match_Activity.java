package com.example.capstoneimsports.capstoneimsports.activities;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.capstoneimsports.capstoneimsports.R;
import com.example.capstoneimsports.capstoneimsports.fragments.Match_Details_Fragment;
import com.example.capstoneimsports.capstoneimsports.models.Match_model;
import com.example.capstoneimsports.capstoneimsports.server.ServerHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Match_Activity extends AppCompatActivity {

    public static Match_model match;
    TextView team_one_name, team_one_score, team_two_name, team_two_score, league, gameDate;
    @Bind(R.id.match_details)
    FrameLayout matchDetails;
    ServerHandler server = new ServerHandler();
    String url = "http://104.197.91.105:8080/api/match_details";
    Match_Details_Fragment match_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_activity);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar_nav);
        setSupportActionBar(toolbar);

        setDetails();

        int matchId = 0;
        matchId = getIntent().getExtras().getInt("matchId");
        Toast.makeText(this, "" + matchId, Toast.LENGTH_SHORT).show();

        try {
            getMatch(matchId);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setDetails() {
        //Left Block
        team_one_name = (TextView) findViewById(R.id.team_one_name);
        team_one_name.setText(match.getTeam_one_name());
        team_one_score = (TextView) findViewById(R.id.team_one_score);
        team_one_score.setText(String.valueOf(match.getTeam_one_score()));

        //Middle Block
        league = (TextView) findViewById(R.id.league);
        league.setText(match.getMatch_league());
//        gameDate = (TextView) findViewById(R.id.gametime);
//        gameDate.setText(match.getMatch_date());

        //Right Block
        team_two_name = (TextView) findViewById(R.id.team_two_name);
        team_two_name.setText(match.getTeam_two_name());
        team_two_score = (TextView) findViewById(R.id.team_two_score);
        team_two_score.setText(String.valueOf(match.getTeam_two_score()));
    }

    public void getMatch(int matchId) throws JSONException, IOException {

        //Create the object to be sent to the database
        JSONObject obj = new JSONObject();
        //Calls for the match ID to be pulled from the database
        obj.put("match_id", matchId);
        //Makes a call to the server and stores the response in a String
        String response = server.doPostRequest(url, obj.toString());

        //Removes the Brackets from the String
        response = response.replace("[", "");
        response = response.replace("]", "");

        //Creates a JSON object to store the string into a JSON
        JSONObject resObj = new JSONObject(response);

        //Stores the match from the database into a match_model
        Match_model matches = new Match_model(
                resObj.getString("team_one_name"),
                resObj.getString("team_two_name"),
                resObj.getInt("team_one_score"),
                resObj.getInt("team_two_score"),
                resObj.getInt("match_id"),
                resObj.getString("match_league")
        );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
}
