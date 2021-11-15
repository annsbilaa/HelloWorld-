package com.example.helloworld.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import com.example.HelloWorld2.R;

public class DetailBerita extends AppCompatActivity {

    private WebView mWebView;

    String url = "https://www.google.com";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //android theme
        setContentView(R.layout.activity_detail);

        url =  getIntent().getStringExtra("url");

        mWebView = findViewById(R.id.read_news);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl(url);
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String newUrl) {
                view.loadUrl(newUrl);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String urlStart, Bitmap favicon) {
                //mProgressBar.setProgress(0);
                url = urlStart;
                invalidateOptionsMenu();

            }

            @Override
            public void onPageFinished(WebView view, String urlPage) {
                invalidateOptionsMenu();
            }
        });
    }

    //back pressed
    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    //share news
    private void shareUrl(String url) {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        share.putExtra(Intent.EXTRA_TEXT, url);
        startActivity(Intent.createChooser(share, "Bagikan ke : "));
    }
}


