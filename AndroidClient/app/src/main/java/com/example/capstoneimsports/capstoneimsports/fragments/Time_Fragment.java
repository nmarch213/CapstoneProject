package com.example.capstoneimsports.capstoneimsports.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.capstoneimsports.capstoneimsports.R;
import com.example.capstoneimsports.capstoneimsports.server.ServerHandler;
import com.github.nkzawa.socketio.client.Socket;

import java.util.Timer;
import java.util.TimerTask;


public class Time_Fragment extends Fragment implements View.OnClickListener {

    public Button testButton = null;
    ServerHandler server = new ServerHandler();
    String url = "http://104.197.124.0:8081/api/match_details";
    EditText editText;
    Timer timer = new Timer();
    TextView txtView;
    int temp;
    int currentTime, time;
    Button ResetButton;
    String stime;
    private Socket mSocket;
    private Button stopClock;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_time, container, false);

        txtView = (TextView) view.findViewById(R.id.textView);
        editText = (EditText) view.findViewById(R.id.editText);
        testButton = (Button) view.findViewById(R.id.button);
        ResetButton = (Button) view.findViewById(R.id.button2);


        editText.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event){
                boolean handled = false;
                if(actionId == EditorInfo.IME_ACTION_DONE){

                    //handled = true;
                    testButton.setEnabled(true);
                    time = toSeconds(editText.getText().toString());
                    txtView.setText(String.format("%d:%02d",
                            (time/60),
                            time-(60*(time/60))));
                    stime= editText.getText().toString();
                    editText.getText().clear();


                    //return handled;
                }
                return handled;
            }
        });


        testButton.setTag(1);
        testButton.setText("Start Time");
        testButton.setOnClickListener( new View.OnClickListener()

        {

            @Override
            public void onClick (View v){
                final int status = (Integer) v.getTag();
                if (status == 1) {
                    ResetButton.setEnabled(false);
                    editText.setEnabled(false);
                    sendMessage();
                    testButton.setText("Pause Time");

                    v.setTag(0); //pause
                }
                else if(status == 2)
                {
                    editText.setEnabled(false);
                    ResetButton.setEnabled(false);
                    testButton.setText("Pause Time");
                    timer = new Timer();
                    countdown();
                    v.setTag(0);
                }
                else {
                    testButton.setText("Resume Time");
                    timer.cancel();
                    ResetButton.setEnabled(true);
                    v.setTag(2); //pause
                }
            }
        });
        ResetButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v) {
                editText.getText().clear();
                resetClock();
                testButton.setText("Start Time");
                testButton.setEnabled(false);


            }

        });



        //stopClock = (Button) view.findViewById(R.id.stop_clock_button);

        //stopClock.setOnClickListener(this);

        return view;
    }

    private void stopClockClicked(View v) {

        mSocket.emit("stopClock", "Stop Clock");

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
//            //When the login is pressed
//            case R.id.stop_clock_button:
//                mSocket.emit("foo", "suh dude");
//                break;


        }
    }

    void resetClock()
    {
        testButton.setVisibility(View.VISIBLE);
        editText.setEnabled(true);
        txtView.setText("00:00");
        //editText.setText("00:00");
        timer = new Timer();


        testButton.setEnabled(true);
        //sendMessage();

    }



    void sendMessage()
    {
        //String stime = editText.getText().toString();

        time = toSeconds(stime);
        countdown();

        //System.out.println(editText.getText());
    }

    int toSeconds(String ftime){
        if(!ftime.contains(":"))
            return (Integer.parseInt(ftime)) * 60;
        int L = ftime.indexOf(":");
        int minutes = Integer.parseInt(ftime.substring(0, L).trim());
        int seconds = Integer.parseInt(ftime.substring(L + 1).trim());

        seconds += minutes * 60;
        return seconds;
    }

    void countdown() {
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                final String cTime = String.format("%d:%02d",
                        (time/60),
                        time-(60*(time/60)));
                time--;

                getActivity().runOnUiThread(new Runnable() {
                    String nTime = cTime;

                    @Override
                    public void run() {

                        //stuff that updates ui
                        txtView.setText(nTime);
                        if(nTime.equalsIgnoreCase("0:00"))
                        {
                            txtView.setText("00:00");
                            timer.cancel();
                            testButton.setVisibility(View.GONE);
                            testButton.setText("Reset Game Clock");
                            testButton.setEnabled(false);
                            testButton.setTag(1);
                            ResetButton.setEnabled(true);
                        }

                    }
                });
            }
        }, 0, 1000);
    }
}
