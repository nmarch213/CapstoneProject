package com.example.capstoneimsports.capstoneimsports.fragments;


import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.capstoneimsports.capstoneimsports.R;
import com.example.capstoneimsports.capstoneimsports.server.ServerHandler;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;


public class Football_Score_Input_Fragment extends Fragment implements View.OnClickListener {

    private Socket mSocket;
    private Button stopClock;
    ServerHandler server = new ServerHandler();
    String url = "http://104.197.91.105:8080/api/match_details";



    {
        try {
            mSocket = IO.socket("http://104.197.91.105:8080");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        mSocket.connect();
        mSocket.on(Socket.EVENT_CONNECT_ERROR, onConnectError);
        mSocket.on(Socket.EVENT_CONNECT_TIMEOUT, onConnectError);
        JSONObject obj = new JSONObject();
        try {
            obj.put("hello", "server");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            obj.put("binary", "Sucks");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mSocket.emit("foo", obj);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_football_score_input_, container, false);

        stopClock = (Button) view.findViewById(R.id.stop_clock_button);

        stopClock.setOnClickListener(this);

        return view;
    }

    private void stopClockClicked(View v) {

        mSocket.emit("stopClock", "Stop Clock");

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            //When the login is pressed
            case R.id.stop_clock_button:
                mSocket.emit("foo", "suh dude");
                break;


        }
    }

    private Emitter.Listener onConnectError = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Error connecting", Toast.LENGTH_LONG).show();
                }
            });
        }
    };
}
