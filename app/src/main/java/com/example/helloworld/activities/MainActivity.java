package com.example.helloworld.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.example.HelloWorld2.R;

public class MainActivity extends AppCompatActivity {
    private CardView cvHead;
    private CardView cvSports;
    private CardView cvTechno;
    private CardView cvBusiness;
    private CardView cvHealth;
    private CardView cvEntertaiment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        cvHead.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), BeritaUtama.class)));
        cvSports.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Olahraga.class)));
        cvTechno.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Teknologi.class)));
        cvBusiness.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Bisnis.class)));
        cvHealth.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Kesehatan.class)));
        cvEntertaiment.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Hiburan.class)));
    }

    private void initView() {
        cvHead = (CardView) findViewById(R.id.cardHeadLine);
        cvSports = (CardView) findViewById(R.id.cardSports);
        cvTechno = (CardView) findViewById(R.id.cardTechno);
        cvBusiness = (CardView) findViewById(R.id.cardBusiness);
        cvHealth = (CardView) findViewById(R.id.cardHealth);
        cvEntertaiment = (CardView) findViewById(R.id.cardEnter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.profile:
                startActivity(new Intent(getApplicationContext(), Profile.class));
                overridePendingTransition(0, 0);
                return true;
            case R.id.settings:
                startActivity(new Intent(getApplicationContext(), Settings.class));
                overridePendingTransition(0, 0);
                ;
                return true;


        }
        return super.onOptionsItemSelected(item);
    }
}
