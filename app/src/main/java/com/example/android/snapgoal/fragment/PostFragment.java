package com.example.android.snapgoal.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.android.snapgoal.R;
import com.example.android.snapgoal.models.Post;
import com.example.android.snapgoal.adapters.PostAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class PostFragment extends Fragment {


    @BindView(R.id.teamGridView)
    GridView teamGridView;
    Unbinder unbinder;

    public PostFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.post_fragment, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        ArrayList<Post> arrayList=new ArrayList<>();
        arrayList.add(new Post());
        arrayList.add(new Post());
        arrayList.add(new Post());
        arrayList.add(new Post());
        PostAdapter adapter=new PostAdapter(rootView.getContext(),arrayList);
        teamGridView.setAdapter(adapter);
        return rootView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
