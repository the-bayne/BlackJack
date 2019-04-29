package com.baynecorp.blackjack.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.baynecorp.blackjack.R;
import com.baynecorp.blackjack.model.GetSet;

public class BettingActivity extends AppCompatActivity {
    MediaPlayer mp;
    Button enterButton;
    EditText playerName;
    private SharedPreferences prefs;
    private SharedPreferences.Editor prefsEditor;
    private static final String TAG = "BettingActivity";
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_betting);
        playerName = findViewById(R.id.playerName);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        prefsEditor = prefs.edit();

        enterButton = findViewById(R.id.deal);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BettingActivity.this, GameScreen.class);
                String currentPlayer = playerName.getText().toString();
                if (currentPlayer.trim().length() > 0 && GetSet.bet != 0) {
                    //TODO:  Save currentPlayer name
                    prefsEditor.putString("currentPlayer", currentPlayer);
                    prefsEditor.commit();
                    GetSet.playerName = currentPlayer;
                    startActivity(intent);
                    playSound(R.raw.shuffle);
                }
                else if(currentPlayer.trim().length() < 1) {
                    Toast.makeText(BettingActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                }
                else if(GetSet.bet == 0){
                    Toast.makeText(BettingActivity.this, "No free plays!  Enter a bet.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Log.d(TAG, "Something didn't work");
                }

            }
        });
    }

    private void playSound(int sound) {
        if (mp != null) {
            if (mp.isPlaying()||mp.isLooping()) {
                mp.stop();
            }
            mp.release();
            mp = null;
        }
        mp = MediaPlayer.create(this,sound);
        mp.start();
    }

    private void displayCashTotal(int cashTotal) {
        TextView cashTotalTextView = findViewById(R.id.cashTotal);
        cashTotalTextView.setText("Cash Available: $" + cashTotal);
    }

    private void displayBet(int betTotal) {
        TextView betTotalTextView = findViewById(R.id.betTotal);
        betTotalTextView.setText("Bet Total: $" + betTotal);
    }

    public void clearBet(View view) {
        GetSet.cash = GetSet.cash + GetSet.bet;
        GetSet.bet = 0;
        displayCashTotal(GetSet.cash);
        displayBet(GetSet.bet);
    }

    public void plusOne(View view){
        if (GetSet.cash == 0) {
            return;
        }
        GetSet.cash = GetSet.cash - 1;
        GetSet.bet = GetSet.bet + 1;
        displayCashTotal(GetSet.cash);
        displayBet(GetSet.bet);
        playSound(R.raw.chips);
    }

    public void plusFive(View view){
        if (GetSet.cash < 5) {
            return;
        }
        GetSet.cash = GetSet.cash - 5;
        GetSet.bet = GetSet.bet + 5;
        displayCashTotal(GetSet.cash);
        displayBet(GetSet.bet);
        playSound(R.raw.chips);
    }

    public void plusTwentyFive(View view){
        if (GetSet.cash < 25) {
            return;
        }
        GetSet.cash = GetSet.cash - 25;
        GetSet.bet = GetSet.bet + 25;
        displayCashTotal(GetSet.cash);
        displayBet(GetSet.bet);
        playSound(R.raw.chips);
    }

    public void plusFifty(View view){
        if (GetSet.cash < 50) {
            return;
        }
        GetSet.cash = GetSet.cash - 50;
        GetSet.bet = GetSet.bet + 50;
        displayCashTotal(GetSet.cash);
        displayBet(GetSet.bet);
        playSound(R.raw.chips);
    }

    public void plusHundred(View view){
        if (GetSet.cash < 100) {
            return;
        }
        GetSet.cash = GetSet.cash - 100;
        GetSet.bet = GetSet.bet + 100;
        displayCashTotal(GetSet.cash);
        displayBet(GetSet.bet);
        playSound(R.raw.chips);
    }
}
