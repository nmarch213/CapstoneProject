package com.example.capstoneimsports.capstoneimsports.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.capstoneimsports.capstoneimsports.MatchAdapter;
import com.example.capstoneimsports.capstoneimsports.R;
import com.example.capstoneimsports.capstoneimsports.models.Match_model;
import com.example.capstoneimsports.capstoneimsports.server.ServerHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Home_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    ServerHandler server = new ServerHandler();
    String url = "http://104.197.91.105:8080/api/match_details";
    NavigationView navigationView = null;
    Toolbar toolbar = null;

    MatchAdapter adapter;
    List<Match_model> matchArray;

    int rangeOfMatches = 4;

    String team_one_name, team_two_name, match_league;
    int team_one_score, team_two_score, match_id;

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
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card_list);

        adapter = new MatchAdapter(Home_Activity.this, matchArray);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(Home_Activity.this));


        //Add Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        //How to change elements in the header programatically
        View headerView = navigationView.getHeaderView(0);
        TextView emailText = (TextView) headerView.findViewById(R.id.textView);
        emailText.setText("newemail@email.com");

        navigationView.setNavigationItemSelectedListener(this);
    }

    //@Override
    /*@Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {

        //RecyclerView card view
        recyclerView = (RecyclerView) findViewById(R.id.card_list);

        //adapter = new MatchAdapter();
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

    }
    }*/

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {

        }

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

        return matchArray;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflates the menu which adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(this, "You Hit the settings!", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_fav) {
            // Handle the camera action
        } else if (id == R.id.nav_live) {

        } else if (id == R.id.nav_teams) {

        } else if (id == R.id.nav_sports) {

        } else if (id == R.id.nav_uni) {

        } else if (id == R.id.nav_profile) {
            Intent intent = new Intent(this, Profile_Activity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
