package com.example.android.snapgoal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.android.snapgoal.adapters.LeaguesAdapter;
import com.example.android.snapgoal.models.Leagues;

import java.util.ArrayList;

public class LeaguesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leagues);
        ListView list=findViewById(R.id.leagueslistView);
        ArrayList<Leagues> arrayList=new ArrayList<>();
        arrayList.add(new Leagues(0));
        arrayList.add(new Leagues(0));
        LeaguesAdapter adapter=new LeaguesAdapter(this,arrayList);
        list.setAdapter(adapter);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(LeaguesActivity.this,MainActivity.class);
                startActivity(intent);
            }
        }, 4000);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.leagues_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.navigation_home2) {


            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
