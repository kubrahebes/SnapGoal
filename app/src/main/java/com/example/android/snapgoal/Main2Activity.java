package com.example.android.snapgoal;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.snapgoal.fragment.GuessFragment;
import com.example.android.snapgoal.fragment.LeaguesFragment;
import com.example.android.snapgoal.fragment.PostFragment;
import com.example.android.snapgoal.fragment.SnapMeFragment;
import com.example.android.snapgoal.fragment.VideoFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.searchBtn)
    Button searchBtn;
    @BindView(R.id.alarmBtn)
    Button alarmBtn;
    @BindView(R.id.shareBtn)
    Button shareBtn;
    @BindView(R.id.setBtn)
    Button setBtn;
    @BindView(R.id.snapMeRelativ)
    RelativeLayout snapMeRelativ;
    @BindView(R.id.videRelativ)
    RelativeLayout videRelativ;
    @BindView(R.id.guessRelativ)
    RelativeLayout guessRelativ;
    @BindView(R.id.postRelativ)
    RelativeLayout postRelativ;
    @BindView(R.id.snapMeBtn)
    ImageView snapMeBtn;
    @BindView(R.id.videoBtn)
    ImageView videoBtn;
    @BindView(R.id.guessBtn)
    ImageView guessBtn;
    @BindView(R.id.postBtn)
    ImageView postBtn;
    private TextView mTextMessage;
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new SnapMeFragment();

                    break;
                case R.id.navigation_dashboard:
                    fragment = new VideoFragment();

                    break;
                case R.id.navigation_notifications:
                    fragment = new PostFragment();

                    break;



            }

            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content1, fragment).commit();
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        //fragment ayarları
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fragmentManager = getFragmentManager();
        fragment = new SnapMeFragment();


        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content1, fragment).commit();
    }


    @OnClick({R.id.searchBtn, R.id.alarmBtn, R.id.shareBtn, R.id.setBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.searchBtn:
                Intent intent2 = new Intent(Main2Activity.this, LeaguesFragment.class);
                startActivity(intent2);
                break;
            case R.id.alarmBtn:
                Intent intent = new Intent(Main2Activity.this, GuessFragment.class);
                startActivity(intent);
                break;
            case R.id.shareBtn:
                break;
            case R.id.setBtn:
                Toast.makeText(this, "blablanlaa", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(Main2Activity.this, SettingActivity.class);
                startActivity(intent1);
        }
    }


}
