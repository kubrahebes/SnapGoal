package com.example.android.snapgoal;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.snapgoal.fragment.GuessFragment;
import com.example.android.snapgoal.fragment.LeaguesFragment;
import com.example.android.snapgoal.fragment.PostFragment;
import com.example.android.snapgoal.fragment.SnapMeFragment;
import com.example.android.snapgoal.fragment.VideoFragment;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

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
    @BindView(R.id.tabbar)
    TabLayout tabbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private TextView mTextMessage;
    Fragment fragment;
    android.app.FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    /* private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
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

             //    fragmentTransaction = fragmentManager.beginTransaction();
             fragmentTransaction.replace(R.id.content1, fragment).commit();
             return true;
         }

     };*/
    private int[] tabIcons = {
            R.drawable.ic_football,
            R.drawable.ic_video,
            R.drawable.ic_two_dices_2,
            R.drawable.ic_post

    };
    TabItem snapMeTab, videoTab, guessTab, postTab;
    SectionsPagerAdapter mSectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //fragment ayarları
        //  final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        // navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //fragmentManager = getFragmentManager();
        //fragment = new SnapMeFragment();


        //   fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.content1, fragment).commit();

        snapMeTab = findViewById(R.id.snapMeTab);
        videoTab = findViewById(R.id.videoTab);
        guessTab = findViewById(R.id.guessTab);
        postTab = findViewById(R.id.postTab);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mSectionsPagerAdapter);
        tabbar.setSelectedTabIndicatorHeight(0);
        tabbar.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
        setupTabIcons();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:

                        break;
                    case 1:

                        break;

                    case 2:


                        break;
                    case 3:

                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });
        navigationDrawer();

    }

    private void setupTabIcons() {
        tabbar.getTabAt(0).setIcon(tabIcons[0]);
        tabbar.getTabAt(1).setIcon(tabIcons[1]);
        tabbar.getTabAt(2).setIcon(tabIcons[2]);
        tabbar.getTabAt(3).setIcon(tabIcons[3]);

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {

                case 0:
                    SnapMeFragment snapMeFragment = new SnapMeFragment();
                    return snapMeFragment;


                case 1:
                    VideoFragment videoFragment = new VideoFragment();
                    return videoFragment;
                case 2:
                    GuessFragment guessFragment = new GuessFragment();
                    return guessFragment;
                case 3:
                    PostFragment postFragment = new PostFragment();

                    return postFragment;

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

    @OnClick({R.id.searchBtn, R.id.alarmBtn, R.id.shareBtn, R.id.setBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.searchBtn:
                Intent intent2 = new Intent(MainActivity.this, LeaguesFragment.class);
                startActivity(intent2);

            case R.id.alarmBtn:
                break;
            case R.id.shareBtn:
                break;
            case R.id.setBtn:
                Intent intent1 = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent1);
        }
    }

    public void navigationDrawer() {


        //PrimaryDrawerItem primaryDrawerItem = new PrimaryDrawerItem().withIdentifier( 1 ).withName( "test" );
        SecondaryDrawerItem item1 = new SecondaryDrawerItem().withIdentifier(1)
                .withName("Home").withIcon(R.drawable.ic_home);
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2)
                .withName("Profile").withIcon(R.drawable.profile);
        SecondaryDrawerItem item3 = new SecondaryDrawerItem().withIdentifier(3)
                .withName("Contact Us").withIcon(R.drawable.ic_contact_me);
        SecondaryDrawerItem item4 = new SecondaryDrawerItem().withIdentifier(4)
                .withName("Rate App").withIcon(R.drawable.ic_star);

        SecondaryDrawerItem item5 = new SecondaryDrawerItem().withIdentifier(6)
                .withName("sign out").withIcon(R.drawable.ic_sign_out_option);
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.color.colorPrimaryDark)
                .addProfiles(
                        new ProfileDrawerItem().withName("Ayse ").withEmail(
                                "Ayse@gmail.com").withIcon(getResources().getDrawable(R.drawable.avatars_svg
                        ))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        //create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .addDrawerItems(item1, item2, item3, item4, item5)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        switch (position) {

                            case 1:

                                break;
                            case 2:

                                break;
                            case 3:
                                break;
                            case 4:

                                break;
                            case 5:

                                break;
                            case 6:

                                break;
                        }

                        return true;
                    }
                }).build();


    }


}
