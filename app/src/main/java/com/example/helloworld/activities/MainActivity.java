package com.example.helloworld.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.example.HelloWorld2.R;

public class MainActivity extends AppCompatActivity {
    private CardView cvHead;
    private CardView cvSports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        cvHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), BeritaUtama.class));
            }
        });
        cvSports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Olahraga.class));
            }
        });
    }

    private void initView() {
        cvHead = (CardView) findViewById(R.id.cardHeadLine);
        cvSports = (CardView) findViewById(R.id.cardSports);
    }
}
