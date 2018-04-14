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

import com.example.android.snapgoal.R;
import com.example.android.snapgoal.models.Post;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostAdapter extends ArrayAdapter<Post> {

    public PostAdapter(@NonNull Context context, ArrayList<Post> arrayList) {
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
                    R.layout.post_item, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }


        Post obje = getItem(position);

        return view;
    }


    static class ViewHolder {
        @BindView(R.id.newsImage)
        ImageView newsImage;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
