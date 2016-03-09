package com.example.capstoneimsports.capstoneimsports.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;


import com.example.capstoneimsports.capstoneimsports.R;

public class Home_Activity extends AppCompatActivity implements View.OnClickListener {

    FrameLayout matchFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_appBar);
        setSupportActionBar(myToolbar);

        matchFragment = (FrameLayout) findViewById(R.id.match_details_fragment);

        matchFragment.setOnClickListener(this);

    }


    public void onClick(View v) {
        switch (v.getId()) {
            //When the login is pressed
            case R.id.match_details_fragment:
                startActivity(new Intent(this, Match_Activity.class));
                break;

        }

    }
}