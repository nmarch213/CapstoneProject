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
                }
                break;
            //When the register is clicked
            case R.id.link_register:
                startActivity(new Intent(this, Register_Activity.class));
                break;

        }
    }

    /**
     * @throws IOException When the login button is clicked, a user will begin the login process
     */
    protected void onLogin() throws IOException {

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
            String response = server.doLoginAuth(url, email, password);

            //Succesful login
            if (response.equals("Authenticated")) {

                Intent intent = new Intent(this, Home_Activity.class);
                startActivity(intent);
                Toast.makeText(Login_Activity.this, "Welcome!" , Toast.LENGTH_SHORT).show();
            }

            //Will display error if authentication failed
            else if (response.equals("Unauthorized")) {
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

