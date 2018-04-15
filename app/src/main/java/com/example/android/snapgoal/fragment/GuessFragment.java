package com.example.android.snapgoal.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.snapgoal.R;
import com.example.android.snapgoal.adapters.GuessAdapter;
import com.example.android.snapgoal.models.Guess;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class GuessFragment extends Fragment {


    Unbinder unbinder;
    @BindView(R.id.chatList)
    ListView chatList;

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
        final View rootView = inflater.inflate(R.layout.fragment_guess, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        ArrayList<Guess> arrayList = new ArrayList<>();
        arrayList.add(new Guess());
        arrayList.add(new Guess());
        arrayList.add(new Guess());
        arrayList.add(new Guess());

        GuessAdapter adapter = new GuessAdapter(rootView.getContext(), arrayList);
        chatList.setAdapter(adapter);
        return rootView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
