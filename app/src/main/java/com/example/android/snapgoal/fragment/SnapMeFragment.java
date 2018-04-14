package com.example.android.snapgoal.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.snapgoal.R;
import com.example.android.snapgoal.adapters.SnapMeAdapter;
import com.example.android.snapgoal.models.SnapMe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class SnapMeFragment extends Fragment {


    @BindView(R.id.listView)
    ListView listView;
    Unbinder unbinder;

    public SnapMeFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.snap_me_fragment, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        ArrayList<SnapMe> arrayList = new ArrayList<>();
        arrayList.add(new SnapMe());
        arrayList.add(new SnapMe());
        arrayList.add(new SnapMe());
        arrayList.add(new SnapMe());

        SnapMeAdapter adapter = new SnapMeAdapter(rootView.getContext(), arrayList);
        listView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
