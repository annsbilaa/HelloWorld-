package com.example.helloworld.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.HelloWorld2.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class BeritaUtama extends AppCompatActivity implements NewsAdapter.onSelectData {

    RecyclerView rvHeadNews;
    NewsAdapter newsAdapter;
    List<ModelNews> modelNews = new ArrayList<>();
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita);

        mProgressBar = findViewById(R.id.progress_bar);
        mProgressBar.setMax(100);

        rvHeadNews = findViewById(R.id.recyclerView);
        rvHeadNews.setHasFixedSize(true);
        rvHeadNews.setLayoutManager(new LinearLayoutManager(this));
        mProgressBar.setProgress(0);
        loadJSON();
    }

    private void loadJSON() {
        mProgressBar.setProgress(0);
        AndroidNetworking.get(NewsApi.GET_TOP_HEADLINES)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            mProgressBar.setVisibility(View.GONE);
                            JSONArray playerArray = response.getJSONArray("articles");
                            for (int i = 0; i < playerArray.length(); i++) {
                                JSONObject temp = playerArray.getJSONObject(i);
                                ModelNews dataApi = new ModelNews();
                                dataApi.setTitle(temp.getString("title"));
                                dataApi.setUrl(temp.getString("url"));
                                dataApi.setPublishedAt(temp.getString("publishedAt"));
                                dataApi.setUrlToImage(temp.getString("urlToImage"));

                                modelNews.add(dataApi);
                                showNews();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(BeritaUtama.this, "Gagal menampilkan data!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(BeritaUtama.this, "Tidak ada jaringan internet!", Toast.LENGTH_SHORT).show();
                        mProgressBar.setVisibility(View.GONE);
                    }
                });
    }

    private void showNews() {
        newsAdapter = new NewsAdapter(BeritaUtama.this, modelNews, this);
        rvHeadNews.setAdapter(newsAdapter);
    }

    @Override
    public void onSelected(ModelNews mdlNews) {
        startActivity(new Intent(BeritaUtama.this, DetailBerita.class).putExtra("url", mdlNews.getUrl()));
    }
}