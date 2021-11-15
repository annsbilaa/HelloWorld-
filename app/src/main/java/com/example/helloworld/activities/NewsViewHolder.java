package com.example.helloworld.activities;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.HelloWorld2.R;


public class NewsViewHolder extends RecyclerView.ViewHolder {

    public ImageView image;
    public TextView title;
    public TextView publishedAt;
    public CardView cvNews;
    public View view;

    public NewsViewHolder(View view) {
        super(view);
        cvNews = view.findViewById(R.id.cvNews);
        image = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);
        publishedAt = view.findViewById(R.id.publishedAt);
        this.view = view;
    }
}
