package com.example.helloworld.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.HelloWorld2.R;
import java.util.List;

/***
 * The adapter class for the RecyclerView, contains the sports data.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    public List<ModelNews> androidList;
    private Context mContext;
    private NewsAdapter.onSelectData onSelectData;

    public interface onSelectData {
        void onSelected(ModelNews mdlNews);
    }

    public NewsAdapter(Context context, List<ModelNews> android, NewsAdapter.onSelectData onSelectData) {
        this.mContext = context;
        this.androidList = android;
        this.onSelectData = onSelectData;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_berita, viewGroup, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder viewHolder, int i) {

        final ModelNews berita = androidList.get(i);

        Glide.with(mContext)
                .load(berita.getUrlToImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_image_list)
                //.transform(new CenterInside(), new RoundedCorners(30))
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                .into(viewHolder.image);

        viewHolder.title.setText(berita.getTitle());
        viewHolder.publishedAt.setText(TimeUnits.getTimeAgo(berita.getPublishedAt()));
        viewHolder.cvNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSelectData.onSelected(berita);
            }
        });
    }

    @Override
    public int getItemCount() {
        return androidList.size();
    }

}
