package com.example.capstoneimsports.capstoneimsports.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.capstoneimsports.capstoneimsports.R;
import com.example.capstoneimsports.capstoneimsports.models.User_model;
import com.example.capstoneimsports.capstoneimsports.server.ServerHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Handles Registering a user into the database
 * Directly connected with register_activity.xml
 */
public class Register_Activity extends AppCompatActivity implements View.OnClickListener {
    Button bRegister;
    EditText etEmail, etPassword, etPasswordConfirm, etUsername;
    //TextView bLogin;
    String message;
    JSONObject obj = new JSONObject();
    ServerHandler server = new ServerHandler();
    String url = "http://104.197.124.0:8081/api/user";

    /**
     * @param savedInstaceState
     */
    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.register_activity);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPasswordConfirm = (EditText) findViewById(R.id.etConfirmPass);
        bRegister = (Button) findViewById(R.id.register_button);

        bRegister.setOnClickListener(this);
    }


    /**
     * @param v is the view that you are currently in
     *          <p/>
     *          This handles when any click happens on the page
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_button:
                try {
                    onRegister();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }


    /**
     * @throws IOException When the register button is clicked, this function will take the information stored
     *                     in the etFields and place them into a JSON object then send that data to the server to be
     *                     stored
     */
    protected void onRegister() throws IOException {

        boolean valid = true;

        //Take data from text fields to strings
        String username = etUsername.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String passConfirm = etPasswordConfirm.getText().toString();

        if (username.isEmpty() || username.length() < 3) {
            etUsername.setError("at least 3 characters");
            valid = false;
        } else {
            etUsername.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("enter a valid email address");
            valid = false;
        } else {
            etEmail.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            etPassword.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            etPassword.setError(null);
        }

        // Puts email and password in JSON object
        try {
            obj.put("email", email);
            obj.put("password", password);
            obj.put("username", username);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //if passwords entered don't match
        if (!(passConfirm.equals(password))) {
            Toast.makeText(Register_Activity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        if (valid == true){
            //Calls from ServerHandler to Post to server
            String response = server.doPostRequest(url, obj.toString());

            //If the email is taken
            if (response.equals("Email Taken")) {
                Toast.makeText(Register_Activity.this, response, Toast.LENGTH_SHORT).show();
            } else {
                //Successful Registration, sent to homepage
                User_model.setEmail(email);
                User_model.setName(username);
                User_model.setFirstName("");
                User_model.setLastName("");
                User_model.setDateOfBirth("");
                User_model.setClassLevel("");
                User_model.setFavSport("");
                User_model.setIsOfficial(false);
                Intent intent = new Intent(this, Home_Activity.class);
                startActivity(intent);
                Toast.makeText(Register_Activity.this, response + username, Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * Created by Nick on 4/14/2016.
     */
    public static interface Communicator {

        public void onClickOne();
    }
}

