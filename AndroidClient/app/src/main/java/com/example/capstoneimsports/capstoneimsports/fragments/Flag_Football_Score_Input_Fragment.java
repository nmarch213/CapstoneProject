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
import com.example.capstoneimsports.capstoneimsports.interfaces.Communicator;

/**
 * Created by Nick on 4/16/2016.
 */
public class Flag_Football_Score_Input_Fragment extends Fragment implements View.OnClickListener {

    Communicator comm;
    Button stopClock;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_flag_football_score_, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        comm = (Communicator) getActivity();
        stopClock = (Button) getActivity().findViewById(R.id.clock_input);
        stopClock.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //When the login is pressed
            case R.id.clock_input:
                Toast.makeText(getActivity(), "Ryans penis this big", Toast.LENGTH_SHORT).show();
                comm.respond();
                break;
        }
    }



}
