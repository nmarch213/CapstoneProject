package com.example.capstoneimsports.capstoneimsports.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
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
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
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

    int rangeOfMatches = 4;

    String team_one_name, team_two_name, match_league;
    int team_one_score, team_two_score, match_id;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);


        //Trying to populate Matches
        try {
            matchArray = getMatches();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //RecyclerView card view
        recyclerView = (RecyclerView) findViewById(R.id.card_list);

        adapter = new MatchAdapter(Home_Activity.this, matchArray);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(Home_Activity.this));


        Toast.makeText(Home_Activity.this.getApplicationContext(), matchArray.get(1).getTeam_two_name(), Toast.LENGTH_LONG).show();

        //Add Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        //Match Fragment
        // matchFragment = (FrameLayout) findViewById(R.id.match_details_fragment);
        //matchFragment.setOnClickListener(this);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /*@Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {

        //RecyclerView card view
        recyclerView = (RecyclerView) findViewById(R.id.card_list);

        try {
            adapter = new MatchAdapter(Home_Activity.this, getMatches());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(Home_Activity.this));

        return super.onCreateView(parent, name, context, attrs);

    }*/

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

    public List<Match_model> getMatches() throws IOException, JSONException {

        matchArray = new ArrayList<>();

        for (int i = 1; i < rangeOfMatches; i++) {
            JSONObject obj = new JSONObject();
            obj.put("match_id", i);
            String response = server.doPostRequest(url, obj.toString());

            response = response.replace("[", "");
            response = response.replace("]", "");

            JSONObject resObj = new JSONObject(response);

            Match_model matches = new Match_model(resObj.getString("team_one_name"), resObj.getString("team_two_name"),
                    resObj.getInt("team_one_score"), resObj.getInt("team_two_score"), resObj.getInt("match_id"),
                    resObj.getString("match_league"));


            matchArray.add(i - 1, matches);
        }

        for (int i = 0; i < 3; i++) {
            Toast.makeText(this, "test" + matchArray.get(i).getTeam_two_name(), Toast.LENGTH_SHORT).show();
        }
        return matchArray;

    }
}
