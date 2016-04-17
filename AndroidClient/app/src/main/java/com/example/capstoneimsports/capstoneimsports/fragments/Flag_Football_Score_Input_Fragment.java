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

import org.json.JSONException;

/**
 * Created by Nick on 4/16/2016.
 */
public class Flag_Football_Score_Input_Fragment extends Fragment implements View.OnClickListener {

    Communicator comm;
    Button stopClock, addOneT1, addTwoT1, addThreeT1, addSixT1, addOneT2, addTwoT2, addThreeT2, addSixT2;

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

        //Team 1
        addOneT1 = (Button) getActivity().findViewById(R.id.t1_score_1);
        addOneT1.setOnClickListener(this);
        addTwoT1 = (Button) getActivity().findViewById(R.id.t1_score_2);
        addTwoT1.setOnClickListener(this);
        addThreeT1 = (Button) getActivity().findViewById(R.id.t1_score_3);
        addThreeT1.setOnClickListener(this);
        addSixT1 = (Button) getActivity().findViewById(R.id.t1_score_6);
        addSixT1.setOnClickListener(this);

        //Team 2
        addOneT2 = (Button) getActivity().findViewById(R.id.t2_score_1);
        addOneT2.setOnClickListener(this);
        addTwoT2 = (Button) getActivity().findViewById(R.id.t2_score_2);
        addTwoT2.setOnClickListener(this);
        addThreeT2 = (Button) getActivity().findViewById(R.id.t2_score_3);
        addThreeT2.setOnClickListener(this);
        addSixT2 = (Button) getActivity().findViewById(R.id.t2_score_6);
        addSixT2.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //When the login is pressed
            case R.id.clock_input:
                Toast.makeText(getActivity(), "Ryans penis this big", Toast.LENGTH_SHORT).show();
                comm.respond();
                break;
            case R.id.t1_score_1:
                try {
                    comm.addTeam1Score(1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.t1_score_2:
                comm.addTeam1Score(2);
                break;
            case R.id.t1_score_3:
                comm.addTeam1Score(3);
                break;
            case R.id.t1_score_6:
                comm.addTeam1Score(6);
                break;
            case R.id.t2_score_1:
                comm.addTeam2Score(1);
                break;
            case R.id.t2_score_2:
                comm.addTeam2Score(2);
                break;
            case R.id.t2_score_3:
                comm.addTeam2Score(3);
                break;
            case R.id.t2_score_6:
                comm.addTeam2Score(6);
                break;
        }
    }


}
