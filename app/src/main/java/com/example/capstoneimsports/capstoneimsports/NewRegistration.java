package com.example.capstoneimsports.capstoneimsports;

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

public class NewRegistration extends AppCompatActivity implements View.OnClickListener
{
    Button bRegister;
    EditText  etEmail,etPassword,etPasswordConfirm;

    @Override
    protected void onCreate(Bundle savedInstaceState)
    {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_registration);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPasswordConfirm = (EditText) findViewById(R.id.etConfirmPass);
        bRegister = (Button) findViewById(R.id.register_button);
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.register_button:

                //On register button click, do this.

                break;

        }
    }
}

