package com.example.helloworld.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.HelloWorld2.R;

public class SplashScreenActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finishAffinity();
                startActivity(new Intent(getApplicationContext(), SplashActivity.class));
            }
        }, 4000);
    }
}