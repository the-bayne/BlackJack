package com.baynecorp.blackjack.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.baynecorp.blackjack.R;
import com.baynecorp.blackjack.model.GetSet;

public class StatisticsActivity extends AppCompatActivity {
    TextView highScore, highScoreName, totalWon, totalLost, hit21;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        highScore = findViewById(R.id.textViewHighScore);
        highScore.setText(String.valueOf(GetSet.highScore));

        highScoreName = findViewById(R.id.textViewHighScorePlayerName);
        highScoreName.setText(GetSet.highPlayerName);

        totalWon = findViewById(R.id.textViewTotalGamesWon);
        totalWon.setText(String.valueOf(GetSet.gamesWon));

        totalLost = findViewById(R.id.textViewTotalGamesLost);
        totalLost.setText(String.valueOf(GetSet.gamesLost));

        hit21 = findViewById(R.id.textViewTotalTimes21);
        hit21.setText(String.valueOf(GetSet.timesHit21));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

