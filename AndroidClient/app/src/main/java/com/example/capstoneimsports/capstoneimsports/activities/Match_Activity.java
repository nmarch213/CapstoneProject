package com.example.capstoneimsports.capstoneimsports.activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.capstoneimsports.capstoneimsports.R;
import com.example.capstoneimsports.capstoneimsports.fragments.Time_Fragment;
import com.example.capstoneimsports.capstoneimsports.models.Match_model;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Match_Activity extends AppCompatActivity {

    public static Match_model match;
    TextView team_one_name, team_one_score, team_two_name, team_two_score, league, gameDate;

    @Bind(R.id.app_bar)
    Toolbar toolbar;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_activity);
        ButterKnife.bind(this);



        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setDetails();

        final FrameLayout team1 = (FrameLayout) findViewById(R.id.match_fragment);
        assert team1 != null;
        team1.setOnClickListener(new FrameLayout.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (findViewById(R.id.drawer_layout) != null) {

                    // However, if we're being restored from a previous state,
                    // then we don't need to do anything and should return or else
                    // we could end up with overlapping fragments.
                    if (savedInstanceState != null) {
                        return;
                    }

                    // Create a new Fragment to be placed in the activity layout
                    Time_Fragment firstFragment = new Time_Fragment();

                    // In case this activity was started with special instructions from an
                    // Intent, pass the Intent's extras to the fragment as arguments
                    firstFragment.setArguments(getIntent().getExtras());

                    // Add the fragment to the 'fragment_container' FrameLayout
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.drawer_layout, firstFragment).commit();
                }


                //Dialog score = onCreateDialog();
                //score.show();
               // View popupView = getLayoutInflater().inflate(R.layout.fragment_time, null);

              //  PopupWindow popupWindow = new PopupWindow(popupView ,
                       // FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);

                // If the PopupWindow should be focusable
               // popupWindow.setFocusable(true);

                // If you need the PopupWindow to dismiss when when touched outside
                //popupWindow.setBackgroundDrawable(new ColorDrawable());

               // int location[] = new int[2];

                // Get the View's(the one that was clicked in the Fragment) location
                //team1.getLocationOnScreen(location);

                // Using location, the PopupWindow will be displayed right under anchorView
                //popupWindow.showAtLocation(team1, Gravity.NO_GRAVITY,
                       // location[0], location[1] + team1.getHeight());
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

    public Dialog onCreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Get the layout inflater
        LayoutInflater inflater = this.getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.fragment_time, null))
                // Add action buttons
                .setPositiveButton("sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                })
                .setNegativeButton("test 2", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //Do stuff
                    }
                });
        return builder.create();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflates the menu which adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



}
