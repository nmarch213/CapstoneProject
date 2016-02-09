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
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button bLogin,bRegister,bFacebookLogin;
    EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText)findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.etPassword);
        bLogin = (Button)findViewById(R.id.login_button);
        bRegister = (Button)findViewById(R.id.register_button);

        bLogin.setOnClickListener(this);
        bRegister.setOnClickListener(this);


    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.login_button:
                onLogin();
                break;
            case R.id.register_button:
                startActivity(new Intent(this,NewRegistration.class));
                break;
            case R.id.facebook_login_fragment:
                startActivity(new Intent(this,Facebook_Login_Fragment.class));
                break;
        }
    }

    protected void onLogin()
    {
        if(etUsername.toString().equals("user") && etPassword.toString().equals("pass"))
        {
            Intent intent = new Intent(this, HomePage.class);
            startActivity(intent);
            Toast.makeText(LoginActivity.this, "Thanks for logging in!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(LoginActivity.this, "Wrong Information", Toast.LENGTH_SHORT).show();
        }

    }
}

