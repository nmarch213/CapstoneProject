package com.example.capstoneimsports.capstoneimsports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.widget.RelativeLayout;
import android.os.AsyncTask;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import com.facebook.appevents.AppEventsLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import org.json.JSONException;
import org.json.JSONObject;
public class NewRegistration extends AppCompatActivity implements View.OnClickListener {
    Button bRegister2;
    EditText etEmail, etPassword, etPasswordConfirm;
    Socket client;
    InputStreamReader isr;
    BufferedReader bf;
    PrintWriter out;
    String message;
    AsyncClass ac = new AsyncClass();
    JSONObject obj = new JSONObject();

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_registration);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPasswordConfirm = (EditText) findViewById(R.id.etConfirmPass);
        bRegister2 = (Button) findViewById(R.id.register_button2);
    }

    class AsyncClass extends AsyncTask<Void, Void,Void>
    {
        protected Void doInBackground(Void... params)
        {
            hardtask();
            return null;
        }
        public void hardtask()
        {
            try
            {
                client = new Socket("10.0.1.7",8081);

                // The code below might be useful for getting a response back from server
                //isr = new InputStreamReader(client.getInputStream());
                //bf = new BufferedReader(isr);
                //message = bf.readLine();
                //Log.v("Message", message);

                // Sends JSON object to Server
                out = new PrintWriter(client.getOutputStream(), true);
                out.println(obj);
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.register_button2:
                onRegister();
                break;
        }
    }

    protected void onRegister()
    {
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

        if(!(passConfirm.equals(password)))
        {
            Toast.makeText(NewRegistration.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
        }
        else {
            // Connects to server as a separate task
            ac.execute();

            User userDetails = new User(email, password);
            Intent intent = new Intent(this, HomePage.class);
            startActivity(intent);
            Toast.makeText(NewRegistration.this, "Welcome!", Toast.LENGTH_SHORT).show();
        }
    }
}

