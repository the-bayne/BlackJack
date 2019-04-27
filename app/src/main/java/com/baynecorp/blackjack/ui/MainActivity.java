package com.baynecorp.blackjack.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.baynecorp.blackjack.R;

public class MainActivity extends AppCompatActivity {
    Button play;
    Button stats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent play = new Intent(MainActivity.this, BettingActivity.class);
                startActivity(play);
            }
        });
        stats = findViewById(R.id.statistics);
        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent stats = new Intent(MainActivity.this, StatisticsActivity.class);
                startActivity(stats);
            }
        });
    }
}
