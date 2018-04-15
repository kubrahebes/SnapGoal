package com.example.android.snapgoal.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
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

    @BindView(R.id.tabbar)
    TabLayout tabbar;
    @BindView(R.id.viewPager)
    ViewPager viewPager;


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
        final View rootView = inflater.inflate(R.layout.fragment_snap_me, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        ArrayList<SnapMe> arrayList = new ArrayList<>();
        arrayList.add(new SnapMe());
        arrayList.add(new SnapMe());
        arrayList.add(new SnapMe());
        arrayList.add(new SnapMe());

        SnapMeAdapter adapter = new SnapMeAdapter(rootView.getContext(), arrayList);
        listView.setAdapter(adapter);
tabbar.setSelectedTabIndicatorHeight(0);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
