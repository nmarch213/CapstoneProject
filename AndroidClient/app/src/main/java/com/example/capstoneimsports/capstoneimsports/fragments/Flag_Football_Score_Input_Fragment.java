package com.example.capstoneimsports.capstoneimsports.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
=======
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
>>>>>>> origin/master
import android.widget.Toast;

import com.example.capstoneimsports.capstoneimsports.R;
import com.example.capstoneimsports.capstoneimsports.interfaces.Communicator;

import org.json.JSONException;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Nick on 4/16/2016.
 */
public class Flag_Football_Score_Input_Fragment extends Fragment implements View.OnClickListener {

    public Button stopClock;
    Communicator comm;

    Button stopClock, addOneT1, addTwoT1, addThreeT1, addSixT1, addOneT2, addTwoT2, addThreeT2, addSixT2, editScoreT1, editScoreT2;
    EditText editScoreField1, editScoreField2;

    Button addOneT1, addTwoT1, addThreeT1, addSixT1, addOneT2, addTwoT2, addThreeT2, addSixT2, startClockButton, stopClockButton, resetClockButton;
    EditText enterTime;
    int time;
    TextView clockTime;
    Timer timer = new Timer();
    boolean isTimerRunning = false;
    boolean isTimerEntered = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_flag_football_score_, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        comm = (Communicator) getActivity();

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

        //Clock
        clockTime = (TextView) getActivity().findViewById(R.id.Clocktime);
        enterTime = (EditText) getActivity().findViewById(R.id.enter_time);

        enterTime.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    time = toSeconds(enterTime.getText().toString());
                    clockTime.setText(String.format("%d:%02d",
                            (time / 60),
                            time - (60 * (time / 60))));
                    enterTime.getText().toString();
                    handled = true;
                    isTimerEntered = true;


                    //return handled;
                }
                return handled;
            }
        });
        startClockButton = (Button) getActivity().findViewById(R.id.start_clock);
        startClockButton.setOnClickListener(this);
        resetClockButton = (Button) getActivity().findViewById(R.id.reset_clock);
        resetClockButton.setOnClickListener(this);
//        stopClockButton = (Button) getActivity().findViewById(R.id.s);
//        stopClockButton.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //When the login is pressed
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
            case R.id.start_clock:
                if (startClockButton.getText().equals("Start Clock")) {
                    if (isTimerEntered) {
                        comm.setGameTime(clockTime.getText().toString());
                        countdown();
                        startClockButton.setText("Stop Clock");
                    } else {
                        Toast.makeText(getActivity(), "Please Set the clock!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    comm.setGameTime(clockTime.getText().toString());
                    startClockButton.setText("Start Clock");
                    timer.cancel();
                    timer = new Timer();
                    isTimerRunning = false;
                }
                break;
            case R.id.reset_clock:
                comm.setGameTime(clockTime.getText().toString());
                resetClock();
                break;

        }
    }

    int toSeconds(String ftime) {
        if (!ftime.contains(":"))
            return (Integer.parseInt(ftime)) * 60;
        int L = ftime.indexOf(":");
        int minutes = Integer.parseInt(ftime.substring(0, L).trim());
        int seconds = Integer.parseInt(ftime.substring(L + 1).trim());

        seconds += minutes * 60;
        return seconds;
    }


    void countdown() {
        if (isTimerRunning) {
            return;
        }
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                isTimerRunning = true;
                final String cTime = String.format(
                        "%d:%02d",
                        (time / 60),
                        time - (60 * (time / 60)));
                time--;
                getActivity().runOnUiThread(new Runnable() {
                    String nTime = cTime;

                    @Override
                    public void run() {
                        //stuff that updates ui
                        clockTime.setText(nTime);
                        if (nTime.equalsIgnoreCase("0:00")) {
                            clockTime.setText("00:00");
                            timer.cancel();
                        }
                    }
                });
            }
        }, 0, 1000);
    }

    void resetClock() {
        enterTime.setEnabled(true);
        clockTime.setText("20:00");
        timer.cancel();
        timer = new Timer();
        isTimerRunning = false;
        isTimerEntered = true;

    }
}
