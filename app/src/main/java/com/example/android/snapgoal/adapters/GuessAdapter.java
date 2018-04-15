package com.example.android.snapgoal.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.android.snapgoal.R;
import com.example.android.snapgoal.models.Guess;
import com.example.android.snapgoal.models.Video;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class GuessAdapter extends ArrayAdapter<Guess> {

    public GuessAdapter(@NonNull Context context, ArrayList<Guess> arrayList) {
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
                    R.layout.chat_item, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }


        Guess obje = getItem(position);

        return view;
    }


    static class ViewHolder {


        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
