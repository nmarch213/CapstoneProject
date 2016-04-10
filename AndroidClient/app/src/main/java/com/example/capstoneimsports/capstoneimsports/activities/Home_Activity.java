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
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.capstoneimsports.capstoneimsports.adapters.MatchAdapter;
import com.example.capstoneimsports.capstoneimsports.R;
import com.example.capstoneimsports.capstoneimsports.models.Match_model;
import com.example.capstoneimsports.capstoneimsports.server.ServerHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class Home_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, MatchAdapter.ClickListener {

    ServerHandler server = new ServerHandler();
    String url = "http://104.197.91.105:8080/api/match_details";
    MatchAdapter adapter;
    List<Match_model> matchArray;
    int rangeOfMatches = 4;
    Layout layout;

    //Butter knife the views for this
    @Bind(R.id.matches_home)
    RecyclerView matchesHome;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.nav_view)
    NavigationView navigationView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        ButterKnife.bind(this);


        //Trying to populate Matches
        try {
            matchArray = getMatches();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //RecyclerView of the matches on the home_activity
        // RecyclerView matchesHome = (RecyclerView) findViewById(R.id.matches_home);

        //The adapter used to populate the recycler view
        adapter = new MatchAdapter(Home_Activity.this, matchArray);
        matchesHome.setAdapter(adapter);
        matchesHome.setLayoutManager(new LinearLayoutManager(Home_Activity.this));
        adapter.setClickListener(this);


        //Add Toolbar
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //How to change elements in the header programatically
        View headerView = navigationView.getHeaderView(0);
        TextView emailText = (TextView) headerView.findViewById(R.id.textView);
        emailText.setText("newemail@email.com");

        navigationView.setNavigationItemSelectedListener(this);
    }


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

    }

    /**
     * This function grabs the matches from the database and stores it into a matchArray
     *
     * @return matchArray, which is to be passed into the MatchAdapter
     * @throws IOException
     * @throws JSONException
     */
    public List<Match_model> getMatches() throws IOException, JSONException {

        //Creates the ArrayList to store the information from the database
        matchArray = new ArrayList<>();


        //Loops for however many matches are in the database
        for (int i = 1; i < rangeOfMatches; i++) {

            //Create the object to be sent to the database
            JSONObject obj = new JSONObject();
            //Calls for the match ID to be pulled from the database
            obj.put("match_id", i);
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

            //Adds the match to the ArrayList, matchArray
            matchArray.add(i - 1, matches);
        }

        //Returns the array when finished
        return matchArray;
    }

    public int getMatchFromArray(int matchId) {
        return matchId;
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

    @Override
    public void matchClicked(View view, int position) {

        Match_model match = matchArray.get(position);
        int matchId = match.getMatch_id();
        Match_Activity.match = match;
        Intent intent = new Intent(this, Match_Activity.class);
        intent.putExtra("matchId", matchId);
        startActivity(intent);
    }

}
