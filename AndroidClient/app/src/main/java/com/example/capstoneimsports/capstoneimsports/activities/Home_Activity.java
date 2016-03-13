package com.example.capstoneimsports.capstoneimsports.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.capstoneimsports.capstoneimsports.MatchAdapter;
import com.example.capstoneimsports.capstoneimsports.R;
import com.example.capstoneimsports.capstoneimsports.models.Match_model;
import com.example.capstoneimsports.capstoneimsports.server.ServerHandler;

import java.util.ArrayList;
import java.util.List;

public class Home_Activity extends AppCompatActivity implements View.OnClickListener {

    FrameLayout matchFragment;
    ServerHandler server = new ServerHandler();
    String url = "http://104.197.91.105:8080/api/match_details";

    //For the Card View
    RecyclerView recyclerView;
    MatchAdapter adapter;
    List<Match_model> matchArray;

    String team_one_name, team_two_name, match_league;
    int team_one_score, team_two_score, match_id;

    public static void getMatches() {
        List<Match_model> matches = new ArrayList<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        //Add Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        //Match Fragment
        // matchFragment = (FrameLayout) findViewById(R.id.match_details_fragment);
        //matchFragment.setOnClickListener(this);

        //RecyclerView card view
        recyclerView = (RecyclerView) findViewById(R.id.card_list);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            //When the login is pressed
            // case R.id.match_details_fragment:
            //     startActivity(new Intent(this, Match_Activity.class));
            //    break;


        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(this, "You Hit the settings!", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.navigate) {

        }

        return super.onOptionsItemSelected(item);
    }

}
