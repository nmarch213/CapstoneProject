package com.example.capstoneimsports.capstoneimsports.activities;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.capstoneimsports.capstoneimsports.R;
import com.example.capstoneimsports.capstoneimsports.models.User_model;
import com.example.capstoneimsports.capstoneimsports.server.ServerHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ryan on 3/26/2016.
 */
public class Profile_Activity extends AppCompatActivity implements View.OnClickListener{

    //Butter knife the views for this
    @Bind(R.id.profAppBar)
    Toolbar toolbar;

    JSONObject obj = new JSONObject();
    ServerHandler server = new ServerHandler();
    String url = "http://104.197.124.0:8081/api/userProfile";
    EditText username, email, firstName, lastName;
    ImageView profilePic;
    Button bUpdateProfile;
    Uri imageUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        ButterKnife.bind(this);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        profilePic = (ImageView) findViewById(R.id.userPic);
        username = (EditText) findViewById(R.id.etUsername2);
        email = (EditText) findViewById(R.id.etEmail2);
        firstName = (EditText) findViewById(R.id.etFirstName);
        lastName = (EditText) findViewById(R.id.etLastName);
        bUpdateProfile = (Button) findViewById(R.id.updateProfileButton);

        if (bUpdateProfile != null) {
            bUpdateProfile.setOnClickListener(this);
        }

        //user clicks profile picture to add picture from gallery
        profilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Profile Picture"), 1);
            }
        });

        //Gets user details
        getUserDetails();

        setSupportActionBar(toolbar);
    }

    public void onActivityResult(int reqQcode, int resCode, Intent data) {
        if (resCode == RESULT_OK) {
            if (reqQcode == 1){
                imageUri = (data.getData());
                profilePic.setImageURI(data.getData());
            }
        }
    }

    public void getUserDetails() {
        username.setText(User_model.getUsername());
        email.setText(User_model.getEmail());
        firstName.setText(User_model.getFirstName());
        lastName.setText(User_model.getLastName());
        profilePic.setImageURI(User_model.getImageURI());
    }

    public void setUserDetails() throws IOException {
        boolean flag = false;

        //Set data from text fields to strings
        String str_username = username.getText().toString();
        String str_email = email.getText().toString();
        String str_firstName = firstName.getText().toString();
        String str_lastName = lastName.getText().toString();
        Uri img = imageUri;


        if (str_username.isEmpty() || str_username.length() < 3) {
            username.setError("at least 3 characters");
            flag = true;
        } else {
            username.setError(null);
        }

        if (str_email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(str_email).matches()) {
            email.setError("enter a valid email address");
            flag = true;
        } else {
            email.setError(null);
        }

        if (flag == false) {

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

            User_model.setEmail(str_email);
            User_model.setName(str_username);
            User_model.setFirstName(str_firstName);
            User_model.setLastName(str_lastName);
            User_model.setImageURI(img);
            Toast.makeText(Profile_Activity.this, response, Toast.LENGTH_SHORT).show();
        }
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

    @Override
    public void onClick(View v) {
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
