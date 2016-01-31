package com.example.capstoneimsports.capstoneimsports;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    Button bLogIn,bRegister;
    EditText etEmail,etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        //Sign in Button
        bLogIn = (Button)findViewById(R.id.login_button);


        bLogIn.setOnClickListener(this);

        //Register Button
        bRegister = (Button)findViewById(R.id.register_button);
        bRegister.setOnClickListener(this);

        //Edit Text Email
        etEmail = (EditText) findViewById(R.id.etEmail);

        //Edit Text Password field
        etPassword = (EditText) findViewById(R.id.etPassword);
        FacebookSdk.sdkInitialize(this.getApplicationContext());

        CallbackManager callbackManager = CallbackManager.Factory.create();
        final Intent intent = new Intent(LoginActivity.this, HomePage.class);
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        startActivity(intent);
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.login_button:

                //Responds to login button click

                break;

            case R.id.register_button:

                //When Register button clicked, take to Register page
                startActivity(new Intent(this,NewRegistration.class));

                break;
            case R.id.facebook_login_fragment:

                startActivity(new Intent(LoginActivity.this,HomePage.class));

                break;
        }
    }
    @Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }

}

