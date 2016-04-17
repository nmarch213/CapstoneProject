package com.example.capstoneimsports.capstoneimsports.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.capstoneimsports.capstoneimsports.R;

/**
 * Created by Nick on 4/16/2016.
 */
public class Flag_Football_Score_Input_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_flag_football_score_, container, false);
    }
}
