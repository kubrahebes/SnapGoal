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
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.android.snapgoal.models.LeaguesTeam;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeaguesTeamsAdapter extends ArrayAdapter<LeaguesTeam> {

    public LeaguesTeamsAdapter(@NonNull Context context, ArrayList<LeaguesTeam> arrayList) {
        super(context, 0, arrayList);
    }



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = LayoutInflater.from(getContext()).inflate(
                    R.layout.leaguea_teams_item, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }


        LeaguesTeam obje = getItem(position);
        holder.radioBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                   holder.radioBtn.setChecked(false);


            }
        });
        return view;
    }


    static class ViewHolder {
        @BindView(R.id.teamImageView)
        ImageView teamImageView;
        @BindView(R.id.radiBtn)
        RadioButton radioBtn;
        @BindView(R.id.radioGroup)
        RadioGroup radioGroup;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
