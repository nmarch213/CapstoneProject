package com.example.capstoneimsports.capstoneimsports.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.capstoneimsports.capstoneimsports.R;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;


public class Football_Score_Input_Fragment extends Fragment implements View.OnClickListener {

    private Socket mSocket;
    private Button stopClock;


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


        mSocket.connect();
        mSocket.on(Socket.EVENT_CONNECT_ERROR, onConnectError);
        mSocket.on(Socket.EVENT_CONNECT_TIMEOUT, onConnectError);
        mSocket.emit("connection", "Stop Clock");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_football_score_input_, container, false);

        stopClock = (Button) view.findViewById(R.id.stop_clock_button);

        stopClock.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        stopClockClicked(v);
                    }
                }
        );

        return view;
    }

    private void stopClockClicked(View v) {

        mSocket.emit("stopClock", "Stop Clock");

    }

    @Override
    public void onClick(View v) {

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
