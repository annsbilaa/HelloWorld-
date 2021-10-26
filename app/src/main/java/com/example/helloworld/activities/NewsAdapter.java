package com.example.helloworld.activities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.HelloWorld2.R;

import java.util.ArrayList;

/***
 * The adapter class for the RecyclerView, contains the sports data.
 */
class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>  {

    // Member variables.
    private ArrayList<Berita> mberitaData;
    private Context mContext;

    /**
     * Constructor that passes in the sports data and the context.
     *
     * @param BeritaData ArrayList containing the sports data.
     * @param context Context of the application.
     */
    NewsAdapter(Context context, ArrayList<Berita> BeritaData) {
        this.mberitaData = BeritaData;
        this.mContext = context;
    }


    /**
     * Required method for creating the viewholder objects.
     *
     * @param parent The ViewGroup into which the new View will be added
     *               after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return The newly created ViewHolder.
     */
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.list_item_berita, parent, false));
    }

    /**
     * Required method that binds the data to the viewholder.
     *
     * @param holder The viewholder into which the data should be put.
     * @param position The adapter position.
     */
    @Override
    public void onBindViewHolder(NewsAdapter.ViewHolder holder,
                                 int position) {
        // Get current sport.
        Berita currentberita = mberitaData.get(position);

        // Populate the textviews with data.
        holder.bindTo(currentberita);
    }

    /**
     * Required method for determining the size of the data set.
     *
     * @return Size of the data set.
     */
    @Override
    public int getItemCount() {
        return mberitaData.size();
    }


    /**
     * ViewHolder class that represents each row of data in the RecyclerView.
     */
    class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        // Member Variables for the TextViews
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mBeritaImage;

        /**
         * Constructor for the ViewHolder, used in onCreateViewHolder().
         *
         * @param itemView The rootview of the list_item_berita.xml layout file.
         */
        ViewHolder(View itemView) {
            super(itemView);

            // Initialize the views.
            mTitleText = itemView.findViewById(R.id.title);
            mInfoText = itemView.findViewById(R.id.subTitle);
            mBeritaImage = itemView.findViewById(R.id.beritaImage);


            // Set the OnClickListener to the entire view.
            itemView.setOnClickListener(this);
        }

        void bindTo(Berita currentberita) {
            // Populate the textviews with data.
            mTitleText.setText(currentberita.getTitle());
            mInfoText.setText(currentberita.getInfo());

            // Load the images into the ImageView using the Glide library.
            Glide.with(mContext).load(
                    currentberita.getImageResource()).into(mBeritaImage);
        }

        /**
         * Handle click to show DetailActivity.
         *
         * @param view View that is clicked.
         */
        @Override
        public void onClick(View view) {
            Berita currentberita = mberitaData.get(getAdapterPosition());
            Intent detailIntent = new Intent(mContext, DetailBerita.class);
            detailIntent.putExtra("title", currentberita.getTitle());
            detailIntent.putExtra("image_resource",
                    currentberita.getImageResource());
            detailIntent.putExtra("detail", currentberita.getdetail());
            mContext.startActivity(detailIntent);
        }
    }
}

