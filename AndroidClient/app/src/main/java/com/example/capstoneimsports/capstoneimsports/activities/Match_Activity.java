package com.example.capstoneimsports.capstoneimsports.activities;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.capstoneimsports.capstoneimsports.R;
import com.example.capstoneimsports.capstoneimsports.models.Match_model;
import butterknife.Bind;
import butterknife.ButterKnife;

public class Match_Activity extends AppCompatActivity {

    public static Match_model match;
    TextView team_one_name, team_one_score, team_two_name, team_two_score, league, gameDate;

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.nav_view)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_activity);
        ButterKnife.bind(this);

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
        setDetails();

        FrameLayout team1 = (FrameLayout) findViewById(R.id.team_one_container);
        team1.setOnClickListener(new FrameLayout.OnClickListener() {

            @Override
            public void onClick(View v) {
                LayoutInflater scoreInput =
                        (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View popUpScore = scoreInput.inflate(R.layout.fragment_football_score_input_, null);
                PopupWindow window = new PopupWindow(popUpScore);
                window.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
                window.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
            }
        });

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflates the menu which adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
