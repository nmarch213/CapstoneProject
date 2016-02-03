package com.example.capstoneimsports.capstoneimsports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.appevents.AppEventsLogger;

public class NewRegistration extends AppCompatActivity implements View.OnClickListener {
    Button bRegister;
    EditText etUsername, etPassword, etPasswordConfirm;

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_registration);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPasswordConfirm = (EditText) findViewById(R.id.etConfirmPass);
        bRegister = (Button) findViewById(R.id.register_button);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_button:
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String passConfirm = etPasswordConfirm.getText().toString();

                if(passConfirm.equals(password))
                {
                    Toast.makeText(NewRegistration.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    User userDetails = new User(username, password);
                    Intent intent = new Intent(this,HomePage.class);
                    startActivity(intent);
                    Toast.makeText(NewRegistration.this, "Welcome!", Toast.LENGTH_SHORT).show();

                }


                break;

        }
    }

}

