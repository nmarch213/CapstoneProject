package com.example.capstoneimsports.capstoneimsports;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.capstoneimsports.capstoneimsports.server.ServerHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Handles Registering a user into the database
 * Directly connected with activity_registration.xml
 */
public class NewRegistration extends AppCompatActivity implements View.OnClickListener {
    Button bRegister2;
    EditText etEmail, etPassword, etPasswordConfirm;
    String message;
    JSONObject obj = new JSONObject();
    ServerHandler server = new ServerHandler();
    String url = "http://104.197.91.105:8080/api/user";

    /**
     * @param savedInstaceState
     */
    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_registration);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPasswordConfirm = (EditText) findViewById(R.id.etConfirmPass);
        bRegister2 = (Button) findViewById(R.id.register_button2);
    }


    /**
     * @param v is the view that you are currently in
     *
     * This handles when any click happens on the page
     */
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.register_button2:
                try {
                    onRegister();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }


    /**
     * @throws IOException
     *
     *  When the register button is clicked, this function will take the information stored
     *  in the etFields and place them into a JSON object then send that data to the server to be
     *  stored
     */
    protected void onRegister() throws IOException {

        //Take data from text fields to strings
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String passConfirm = etPasswordConfirm.getText().toString();

        // Puts email and password in JSON object
        try {
            obj.put("email", email);
            obj.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //if passwords entered don't match
        if(!(passConfirm.equals(password)))
        {
            Toast.makeText(NewRegistration.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
        }
        else {
            //Calls from ServerHandler to Post to server
            String response = server.doPostRequest(url,obj.toString());

            //If the email is taken
            if(response.equals("Email Taken"))
                Toast.makeText(NewRegistration.this, response, Toast.LENGTH_SHORT).show();
            else {
                //Successful Registration, sent to homepage
                Intent intent = new Intent(this, HomePage.class);
                startActivity(intent);
                Toast.makeText(NewRegistration.this, response, Toast.LENGTH_SHORT).show();
            }
        }
    }
}

