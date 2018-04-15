package com.example.android.snapgoal.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.snapgoal.LeaguesAdapter;
import com.example.android.snapgoal.R;
import com.example.android.snapgoal.models.Leagues;

import java.util.ArrayList;


public class SettingFragment extends Fragment {



    public SettingFragment() {

    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_leagues, container, false);
        ListView list=rootView.findViewById(R.id.leagueslistView);
        ArrayList<Leagues>arrayList=new ArrayList<>();
        arrayList.add(new Leagues(0));
        arrayList.add(new Leagues(0));
        LeaguesAdapter adapter=new LeaguesAdapter(getActivity(),arrayList);
        list.setAdapter(adapter);
        return rootView;
    }



}
