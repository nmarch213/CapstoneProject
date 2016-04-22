package com.example.capstoneimsports.capstoneimsports.activities;

import android.app.ProgressDialog;
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
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.capstoneimsports.capstoneimsports.MatchMessage.Fragment_Chat;
import com.example.capstoneimsports.capstoneimsports.R;
import com.example.capstoneimsports.capstoneimsports.adapters.MatchAdapter;
import com.example.capstoneimsports.capstoneimsports.models.Match_model;
import com.example.capstoneimsports.capstoneimsports.models.User_model;
import com.example.capstoneimsports.capstoneimsports.server.ServerHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Home_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, MatchAdapter.ClickListener {

    private static Home_Activity homeActivity;
    TabHost locTabHost;
    TabHost.TabSpec tabSpec;
    ServerHandler server = new ServerHandler();
    String url = "http://104.197.124.0:8081/api/match_details";
    MatchAdapter adapterHome, adapterFootball, adapterSoccer, adapterVolleyball, adapterBasketball;
    List<Match_model> matchArray, footballMatchArray, soccerMatchArray, volleyballMatchArray, basketballMatchArray;
    int rangeOfMatches = 10;
    Layout layout;

    //Butter knife the views for this
    @Bind(R.id.matches_home)
    RecyclerView matchesHome;

    @Bind(R.id.matches_football)
    RecyclerView matchesFootball;

    @Bind(R.id.matches_basketball)
    RecyclerView matchesBasketball;

    @Bind(R.id.matches_soccer)
    RecyclerView matchesSoccer;

    @Bind(R.id.matches_volleyball)
    RecyclerView matchesVolleyball;


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.nav_view)
    NavigationView navigationView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    public static Home_Activity getInstance() {
        return homeActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("message");
        dialog.show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        ButterKnife.bind(this);
        homeActivity = this;

        //Trying to populate Matches
        try {
            matchArray = getMatches();
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }

        //Gets foothball matches from match arrayList
        getOtherMatches();


        //RecyclerView of the matches on the home_activity
        // RecyclerView matchesHome = (RecyclerView) findViewById(R.id.matches_home);

        //Handles functionality for tabs
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        if (tabHost != null) {
            tabHost.setup();
        }

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("homepage");
        tabSpec.setContent(R.id.homeTab);
        tabSpec.setIndicator("", this.getDrawable(R.drawable.home_icon));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("football");
        tabSpec.setContent(R.id.footballTab);
        tabSpec.setIndicator("", this.getDrawable(R.drawable.football));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("volleyball");
        tabSpec.setContent(R.id.volleyTab);
        tabSpec.setIndicator("", this.getDrawable(R.drawable.volley_ball));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("basketball");
        tabSpec.setContent(R.id.basketBallTab);
        tabSpec.setIndicator("", this.getDrawable(R.drawable.basketball));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("soccer");
        tabSpec.setContent(R.id.soccerTab);
        tabSpec.setIndicator("", this.getDrawable(R.drawable.soccer_ball));
        tabHost.addTab(tabSpec);

        //The adapter used to populate the recycler view in Home
        adapterHome = new MatchAdapter(Home_Activity.this, matchArray);
        matchesHome.setAdapter(adapterHome);
        matchesHome.setLayoutManager(new LinearLayoutManager(Home_Activity.this));
        adapterHome.setClickListener(this);

        //Seperate adapter used to populate another recycler view in Football tab
        adapterFootball = new MatchAdapter(Home_Activity.this, footballMatchArray);
        matchesFootball.setAdapter(adapterFootball);
        matchesFootball.setLayoutManager(new LinearLayoutManager(Home_Activity.this));
        adapterFootball.setClickListener(this);

        //Seperate adapter used to populate another recycler view in soccer tab
        adapterSoccer = new MatchAdapter(Home_Activity.this, soccerMatchArray);
        matchesSoccer.setAdapter(adapterSoccer);
        matchesSoccer.setLayoutManager(new LinearLayoutManager(Home_Activity.this));
        adapterSoccer.setClickListener(this);

        //Seperate adapter used to populate another recycler view in basketball tab
        adapterBasketball = new MatchAdapter(Home_Activity.this, basketballMatchArray);
        matchesBasketball.setAdapter(adapterBasketball);
        matchesBasketball.setLayoutManager(new LinearLayoutManager(Home_Activity.this));
        adapterBasketball.setClickListener(this);

        //Seperate adapter used to populate another recycler view in volleyball tab
        adapterVolleyball = new MatchAdapter(Home_Activity.this, volleyballMatchArray);
        matchesVolleyball.setAdapter(adapterVolleyball);
        matchesVolleyball.setLayoutManager(new LinearLayoutManager(Home_Activity.this));
        adapterVolleyball.setClickListener(this);

//        //When a tab is pressed do this
//        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
//
//            public void onTabChanged(String tabId) {
//                switch (tabHost.getCurrentTab()) {
//                    case 0:
//                        Toast.makeText(Home_Activity.this, "Tab 1", Toast.LENGTH_SHORT).show();
//                        break;
//                    case 1:
//
//                        break;
//                    case 2:
//                        Toast.makeText(Home_Activity.this, "Tab 3", Toast.LENGTH_SHORT).show();
//                        break;
//                    case 3:
//                        Toast.makeText(Home_Activity.this, "Tab 4", Toast.LENGTH_SHORT).show();
//                        break;
//                    case 4:
//                        Toast.makeText(Home_Activity.this, "Tab 5", Toast.LENGTH_SHORT).show();
//                        break;
//                }
//            }
//        });

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
        TextView headerText = (TextView) headerView.findViewById(R.id.headerName);
        headerText.setText(User_model.getFirstName() + " " + User_model.getLastName());
        emailText.setText(User_model.getEmail());

        navigationView.setNavigationItemSelectedListener(this);

        dialog.hide();
        dialog.dismiss();
    }

    public void getOtherMatches() {
        footballMatchArray = new ArrayList<>();
        soccerMatchArray = new ArrayList<>();
        basketballMatchArray = new ArrayList<>();
        volleyballMatchArray = new ArrayList<>();

        int footballIndex = 0, soccerIndex = 0, basketballIndex = 0, volleyballIndex = 0;
        for (int i = 0; i < matchArray.size(); i++) {
            String league = matchArray.get(i).getMatch_league();

            if (league.compareTo("Men's Football") == 0) {

                //Adds the match to the ArrayList, matchArray
                footballMatchArray.add(footballIndex, matchArray.get(i));
                footballIndex++;
            }
            else if (league.compareTo("Men's Soccer") == 0 || league.compareTo("Women's Soccer") == 0) {
                soccerMatchArray.add(soccerIndex, matchArray.get(i));
                soccerIndex++;
            }
            else if (league.compareTo("Men's Basketball") == 0 || league.compareTo("Women's Basketball") == 0) {
                basketballMatchArray.add(basketballIndex, matchArray.get(i));
                basketballIndex++;
            }
            else if (league.compareTo("Men's Volleyball") == 0 || league.compareTo("Women's Volleyball") == 0) {
                volleyballMatchArray.add(volleyballIndex, matchArray.get(i));
                volleyballIndex++;
            }
        }
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
                    resObj.getString("match_league"),
                    resObj.getString("gameTime")
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
            Toast.makeText(this, "Bye, " + User_model.getFirstName(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Login_Activity.class);
            startActivity(intent);
            new User_model();
            new Match_model();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Intent intent = new Intent(this, Profile_Activity.class);
            startActivity(intent);
        } else if (id == R.id.nav_home) {
            Intent intent = new Intent(this, Home_Activity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_myTeams) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void matchClicked(View view, int position) {

        Match_model match = matchArray.get(position);

//        if (locTabHost.getCurrentTab() == 1) {
//            match = footballMatchArray.get(position);
//        }
//        else {
//            match = matchArray.get(position);
//        }
        int matchId = match.getMatch_id();
        Match_Activity.match = match;
        Fragment_Chat.match = match;
        Intent intent = new Intent(this, Match_Activity.class);
        intent.putExtra("matchId", matchId);
        startActivity(intent);
    }
}
