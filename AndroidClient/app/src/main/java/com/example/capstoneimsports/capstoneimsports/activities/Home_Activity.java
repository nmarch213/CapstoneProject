package com.example.capstoneimsports.capstoneimsports.activities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.capstoneimsports.capstoneimsports.MatchAdapter;
import com.example.capstoneimsports.capstoneimsports.R;
import com.example.capstoneimsports.capstoneimsports.models.Match_model;
import com.example.capstoneimsports.capstoneimsports.server.ServerHandler;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

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
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

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


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {

        //RecyclerView card view
        recyclerView = (RecyclerView) findViewById(R.id.card_list);

        //adapter = new MatchAdapter();

        return super.onCreateView(parent, name, context, attrs);

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

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Home_ Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.capstoneimsports.capstoneimsports.activities/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Home_ Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.capstoneimsports.capstoneimsports.activities/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
