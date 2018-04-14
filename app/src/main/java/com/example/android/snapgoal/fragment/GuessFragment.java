package com.example.android.snapgoal.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.snapgoal.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public class GuessFragment extends Fragment {


    Unbinder unbinder;

    public GuessFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.guess_fragment, container, false);
        unbinder = ButterKnife.bind(this, rootView);


        return rootView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
