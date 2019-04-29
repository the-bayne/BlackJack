package com.baynecorp.blackjack.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.baynecorp.blackjack.R;

public class MainActivity extends AppCompatActivity {
    Button play;
    Button stats;
    MediaPlayer backgroundMusic;
    SharedPreferences prefs;

    //TODO:  Add read pref data and assign the data to variable if can/if not then set them to 0
    //TODO:  Stats:  High score, hands played, how many times player won, how many times dealer won, 21 counter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //prefs = getSharedPreferences("Statistics", MODE_WORLD_READABLE);
        //int highScore = prefs.getInt("highScore", )

        backgroundMusic = MediaPlayer.create(MainActivity.this, R.raw.background_noise);
        backgroundMusic.setLooping(true);
        backgroundMusic.start();

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
    @Override
    protected void onPause(){
        super.onPause();
        backgroundMusic.release();
        finish();
    }
}
