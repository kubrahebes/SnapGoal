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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.snapgoal.R;
import com.example.android.snapgoal.models.Video;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoFragmentAdapter extends ArrayAdapter<Video> {

    public VideoFragmentAdapter(@NonNull Context context, ArrayList<Video> arrayList) {
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
                    R.layout.video_item, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }


        Video obje = getItem(position);

        return view;
    }


    static class ViewHolder {
        @BindView(R.id.videoImage)
        ImageView videoImage;
        @BindView(R.id.scoreB)
        TextView scoreB;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
