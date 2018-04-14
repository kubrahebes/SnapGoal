package com.example.android.snapgoal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.snapgoal.models.Leagues;
import com.example.android.snapgoal.models.LeaguesTeam;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeaguesAdapter extends ArrayAdapter<Leagues> {

    public LeaguesAdapter(@NonNull Context context, ArrayList<Leagues> arrayList) {
        super(context, 0, arrayList);
    }

    int counter = 0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = LayoutInflater.from(getContext()).inflate(
                    R.layout.leagues_item, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }


        Leagues obje = getItem(position);
        holder.clik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (holder.teamGridView.getVisibility()==View.VISIBLE) {
                    holder.upBtn.setBackgroundResource(R.drawable.down_arrow);
                    holder.teamGridView.setVisibility(View.GONE);
                } else {
                    holder.upBtn.setBackgroundResource(R.drawable.up_arrow);
                    holder.teamGridView.setVisibility(View.VISIBLE);
                }


            }
        });
        ArrayList<LeaguesTeam> arrayList = new ArrayList<>();
        arrayList.add(new LeaguesTeam());
        arrayList.add(new LeaguesTeam());
        arrayList.add(new LeaguesTeam());
        arrayList.add(new LeaguesTeam());
        arrayList.add(new LeaguesTeam());
        arrayList.add(new LeaguesTeam());
        arrayList.add(new LeaguesTeam());
        arrayList.add(new LeaguesTeam());
        arrayList.add(new LeaguesTeam());
        arrayList.add(new LeaguesTeam());
        arrayList.add(new LeaguesTeam());
        arrayList.add(new LeaguesTeam());
        LeaguesTeamsAdapter adapter= new LeaguesTeamsAdapter(getContext(),arrayList);
        holder.teamGridView.setAdapter(adapter);

        return view;
    }


    class ViewHolder {
        @BindView(R.id.logoImage)
        ImageView logoImage;
        @BindView(R.id.leaguName)
        TextView leaguName;
        @BindView(R.id.upBtn)
        Button upBtn;

        @BindView(R.id.teamGridView)
        GridView teamGridView;
        @BindView(R.id.clik)
        RelativeLayout clik;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
