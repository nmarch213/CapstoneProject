package com.example.capstoneimsports.capstoneimsports.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.capstoneimsports.capstoneimsports.R;
import com.example.capstoneimsports.capstoneimsports.models.User_model;
import com.example.capstoneimsports.capstoneimsports.server.ServerHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ryan on 3/26/2016.
 */
public class Profile_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

    //Butter knife the views for this
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.nav_view)
    NavigationView navigationView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    JSONObject obj = new JSONObject();
    ServerHandler server = new ServerHandler();
    String url = "http://104.197.124.0:8081/api/userProfile";
    EditText username, email, firstName, lastName;
    Button bUpdateProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        ButterKnife.bind(this);

        username = (EditText) findViewById(R.id.etUsername2);
        email = (EditText) findViewById(R.id.etEmail2);
        firstName = (EditText) findViewById(R.id.etFirstName);
        lastName = (EditText) findViewById(R.id.etLastName);
        bUpdateProfile = (Button) findViewById(R.id.updateProfileButton);

        bUpdateProfile.setOnClickListener(this);

        //Gets user details
        getUserDetails();

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
    }

    public void getUserDetails() {
        username.setText(User_model.getUsername());
        email.setText(User_model.getEmail());
        firstName.setText(User_model.getFirstName());
        lastName.setText(User_model.getLastName());
    }

    public void setUserDetails() throws IOException {

        //Take data from text fields to strings
        String str_username = username.getText().toString();
        String str_email = email.getText().toString();
        String str_firstName = firstName.getText().toString();
        String str_lastName = lastName.getText().toString();

        if (str_username.isEmpty() || username.length() < 3) {
            username.setError("at least 3 characters");
        } else {
            username.setError(null);
        }

        if (str_email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(str_email).matches()) {
            email.setError("enter a valid email address");
        } else {
            email.setError(null);
        }

        // Puts email and password in JSON object
        try {
            obj.put("email", str_email);
            obj.put("username", str_username);
            obj.put("firstName", str_firstName);
            obj.put("lastName", str_lastName);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String response = server.doPostRequest(url, obj.toString());

        //Successful Registration, sent to homepage
        User_model.setEmail(str_email);
        User_model.setName(str_username);
        User_model.setFirstName(str_firstName);
        User_model.setLastName(str_lastName);
        Toast.makeText(Profile_Activity.this, response, Toast.LENGTH_SHORT).show();
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
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Intent intent = new Intent(this, Profile_Activity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_home) {
            Intent intent = new Intent(this, Home_Activity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_myTeams) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        //TODO Call setUserDetails method when update button is pressed
        switch (v.getId()) {
            //When the login is pressed
            case R.id.updateProfileButton:
                try {
                    setUserDetails();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }


}
