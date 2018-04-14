package com.example.android.snapgoal.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.snapgoal.R;
import com.example.android.snapgoal.adapters.VideoFragmentAdapter;
import com.example.android.snapgoal.models.Video;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class VideoFragment extends Fragment {


    @BindView(R.id.videoList)
    ListView videoList;
    Unbinder unbinder;

    public VideoFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.video_fragment, container, false);

        unbinder = ButterKnife.bind(this, rootView);
        ArrayList<Video> arrayList = new ArrayList<>();
        arrayList.add(new Video());
        arrayList.add(new Video());
        arrayList.add(new Video());
        arrayList.add(new Video());

        VideoFragmentAdapter adapter = new VideoFragmentAdapter(rootView.getContext(), arrayList);
        videoList.setAdapter(adapter);

        return rootView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
