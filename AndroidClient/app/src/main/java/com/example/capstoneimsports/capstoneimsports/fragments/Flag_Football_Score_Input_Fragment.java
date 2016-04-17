package com.example.capstoneimsports.capstoneimsports.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.capstoneimsports.capstoneimsports.R;
import com.example.capstoneimsports.capstoneimsports.interfaces.Communicator;

import org.json.JSONException;

/**
 * Created by Nick on 4/16/2016.
 */
public class Flag_Football_Score_Input_Fragment extends Fragment implements View.OnClickListener {

    Communicator comm;
    Button stopClock, addOneT1, addTwoT1, addThreeT1, addSixT1, addOneT2, addTwoT2, addThreeT2, addSixT2, editScoreT1, editScoreT2;
    EditText editScoreField1, editScoreField2;
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

        editScoreField1 = (EditText) getActivity().findViewById(R.id.team1_edit);
        editScoreField2 = (EditText) getActivity().findViewById(R.id.team2_edit);

        //Team 1
        addOneT1 = (Button) getActivity().findViewById(R.id.t1_score_1);
        addOneT1.setOnClickListener(this);
        addTwoT1 = (Button) getActivity().findViewById(R.id.t1_score_2);
        addTwoT1.setOnClickListener(this);
        addThreeT1 = (Button) getActivity().findViewById(R.id.t1_score_3);
        addThreeT1.setOnClickListener(this);
        addSixT1 = (Button) getActivity().findViewById(R.id.t1_score_6);
        addSixT1.setOnClickListener(this);
        editScoreT1 = (Button) getActivity().findViewById(R.id.t1_timeout);
        editScoreT1.setOnClickListener(this);

        //Team 2
        addOneT2 = (Button) getActivity().findViewById(R.id.t2_score_1);
        addOneT2.setOnClickListener(this);
        addTwoT2 = (Button) getActivity().findViewById(R.id.t2_score_2);
        addTwoT2.setOnClickListener(this);
        addThreeT2 = (Button) getActivity().findViewById(R.id.t2_score_3);
        addThreeT2.setOnClickListener(this);
        addSixT2 = (Button) getActivity().findViewById(R.id.t2_score_6);
        addSixT2.setOnClickListener(this);
        editScoreT2 = (Button) getActivity().findViewById(R.id.t2_timeout);
        editScoreT2.setOnClickListener(this);
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
                try {
                    comm.addTeam1Score(2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.t1_score_3:
                try {
                    comm.addTeam1Score(3);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.t1_score_6:
                try {
                    comm.addTeam1Score(6);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.t2_score_1:
                try {
                    comm.addTeam2Score(1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.t2_score_2:
                try {
                    comm.addTeam2Score(2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.t2_score_3:
                try {
                    comm.addTeam2Score(3);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.t2_score_6:
                try {
                    comm.addTeam2Score(6);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.t1_timeout:
                try {
                    comm.editTeam1Score(Integer.parseInt(editScoreField1.getText().toString()));
                    editScoreField1.clearFocus();
                    editScoreField1.setText("");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.t2_timeout:
                try {
                    comm.editTeam2Score(Integer.parseInt(editScoreField2.getText().toString()));
                    editScoreField2.clearFocus();
                    editScoreField2.setText("");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
