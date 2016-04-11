package com.example.capstoneimsports.capstoneimsports.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
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


public class Login_Activity extends AppCompatActivity implements View.OnClickListener {

    Button bLogin;
    TextView bRegister;
    EditText etEmail, etPassword;
    JSONObject obj = new JSONObject();
    ServerHandler server = new ServerHandler();
    String url = "http://104.197.124.0:8080/api/user";
    User_model user = new User_model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        etEmail = (EditText) findViewById(R.id.etEmailLogin);
        etPassword = (EditText) findViewById(R.id.etPasswordLogin);
        bLogin = (Button) findViewById(R.id.login_button);
        bRegister = (TextView) findViewById(R.id.link_register);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        bLogin.setOnClickListener(this);
        bRegister.setOnClickListener(this);


    }

    /**
     * @param v This handles whenever someone clicked on the screen, depeding on whats clicked
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //When the login is pressed
            case R.id.login_button:
                try {
                    onLogin();
                    final ProgressDialog progressDialog = new ProgressDialog(Login_Activity.this,
                            R.style.AppTheme);
                    progressDialog.setIndeterminate(true);
                    progressDialog.setMessage("Authenticating...");
                    progressDialog.show();
                    progressDialog.dismiss();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            //When the register is clicked
            case R.id.link_register:
                startActivity(new Intent(this, Register_Activity.class));
                break;

        }
    }

    /**
     * Grabs the user's profile information from the database and stores it into a user_model object
     * This method is very similar to the getMatches method in Home_Activity
     */
    public boolean getUserDetails(String email, String password) throws IOException, JSONException {

        //Makes a call to the server and stores the response in a String
        String response = server.doLoginAuth(url, email, password);
        boolean auth = false;

        //Removes the Brackets from the String
        response = response.replace("[", "");
        response = response.replace("]", "");

        if (response != null){
            auth = true;
        }

        //Creates a JSON object to store the string into a JSON
        JSONObject resObj = new JSONObject(response);

         user = new User_model(
                resObj.getString("email"),
                resObj.getString("username"),
                resObj.getString("firstName"),
                resObj.getString("lastName")
        );
        return auth;
    }


    /**
     * @throws IOException When the login button is clicked, a user will begin the login process
     */
    protected void onLogin() throws IOException, JSONException {

        //Get email and pass from etFields
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        // Begins login process if email and password fields are filled
        if (!email.isEmpty() && !password.isEmpty())
        {
            //Put email and pass into JSON
            try {
                obj.put("email", email);
                obj.put("password", password);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            //Begins login process through ServerHandler
            boolean response = getUserDetails(email, password);
            //String response = server.doLoginAuth(url, email, password);

            //Succesful login
            if (response) {
                Intent intent = new Intent(this, Home_Activity.class);
                startActivity(intent);
                if (user.getFirstName().equals("")) {
                    Toast.makeText(Login_Activity.this, "Welcome, " + user.getUsername() + "!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Login_Activity.this, "Welcome, " + user.getFirstName() + "!", Toast.LENGTH_SHORT).show();
                }
            }

            //Will display error if authentication failed
            else if (!response) {
                Toast.makeText(Login_Activity.this, "The email or password you entered doesn't match.", Toast.LENGTH_SHORT).show();
            }
        }

        else
        {
            //Makes sure the fields are not empty
            if (email.isEmpty()) {
                etEmail.setError("Please enter your email.");
            }
            if (password.isEmpty()) {
                etPassword.setError("Please enter your password.");
            }
        }


    }
}

