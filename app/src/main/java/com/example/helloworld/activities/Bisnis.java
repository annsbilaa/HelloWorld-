package com.example.helloworld.activities;

import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class Bisnis extends AppCompatActivity{
    WebView webView;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_berita);
//
//        webView = (WebView) findViewById(R.id.webView);
//        webView.setWebViewClient(new Bisnis.myWebclient());
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.loadUrl("https://www.bisnis.com/");
//        webView.getSettings().setDomStorageEnabled(true);
//    }
//
//    public class myWebclient extends WebViewClient {
//        @Override
//        public void onPageFinished(WebView view, String url) {
//            super.onPageFinished(view, url);
//        }
//        @Override
//        public void onPageStarted(WebView view, String url, Bitmap favicon) {
//            super.onPageStarted(view, url, favicon);
//        }
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView wv, String url) {
//            if(url.startsWith("tel:") || url.startsWith("whatsapp:")) {
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse(url));
//                startActivity(intent);
//                return true;
//            }
//            return false;
//        }
//    }
//    public void onBackPressed() {
//
//        new AlertDialog.Builder(this)
//                .setMessage("Are you sure you want to exit?")
//                .setIcon(R.mipmap.ic_launcher)
//                .setCancelable(false)
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        Bisnis.this.finish();
//                    }
//                })
//                .setNegativeButton("No", null)
//                .show();
//    }
}