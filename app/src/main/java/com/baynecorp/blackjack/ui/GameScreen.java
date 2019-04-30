package com.baynecorp.blackjack.ui;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.baynecorp.blackjack.R;
import com.baynecorp.blackjack.model.GetSet;

public class GameScreen extends AppCompatActivity {
    Button button;
    TextView textView = null;
    MediaPlayer mp;
    FragmentManager fragmentManager;
    GameFragment fragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamescreen);
        button = findViewById(R.id.btnRedeal);
        fragmentManager = getSupportFragmentManager();
        fragment = (GameFragment)fragmentManager.findFragmentById(R.id.game_fragment);
        textView = fragment.textViewPlayer;
    }

    private void playSound(int sound){
        if (mp != null){
            if (mp.isPlaying()||mp.isLooping()) {
                mp.stop();
            }
            mp.release();
            mp = null;
        }
        mp = MediaPlayer.create(this,sound);
        mp.start();
    }


    public void clickMethodHit(View view) {
        if(GetSet.isStanding == false){
            GetSet.playerScore  = 0;
            GetSet.dealerScore = 0;
            GetSet.hit++;
            GetSet.buttonPressed = 1;
            playSound(R.raw.dealing_card);
        }

    }
    public void clickMethodStand(View view) {
        GetSet.playerScore = 0;
        GetSet.dealerScore = 0;
        GetSet.dealerHit = GetSet.hit;
        GetSet.buttonPressed = 1;
        GetSet.isStanding = true;
        playSound(R.raw.dealing_card);
    }

    public void clickMethodRedeal(View view) {
        if (GetSet.cash > 0) {
            if (GetSet.playerScore > 21) {
                GetSet.cash = GetSet.cash - GetSet.bet;
            } else if (GetSet.dealerScore > 21) {
                GetSet.cash = GetSet.cash + (GetSet.bet * 2);
            } else if (GetSet.playerScore > GetSet.dealerScore && GetSet.playerScore < 21) {
                // Player wins - add bet to cash
                GetSet.cash = GetSet.cash + (GetSet.bet * 2);

            } else {
                // Dealer wins - You lose your bet money
                GetSet.cash = GetSet.cash - GetSet.bet;

            }
            GetSet.playerScore = 0;
            GetSet.dealerScore = 0;
            GetSet.hit = 3;
            GetSet.dealerHit = 1;
            GetSet.buttonPressed = 1;
            GetSet.isStanding = false;
            GetSet.isDouble = 0;
            GetSet.playerBust = 0;
            GetSet.playerBlackjack = 0;
            fragment.shuffleDeck(GetSet.card);
            playSound(R.raw.dealing_card);
            GetSet.horizontalMove = 0;
            GetSet.verticalMove = 400;
            GetSet.iswin = 0;
            GetSet.islose = 0;
        } else {
            Toast.makeText(GameScreen.this, "You are out of money!", Toast.LENGTH_SHORT).show();
            System.exit(0);
        }
    }

    public void clickMethodDouble(View view){
        if(GetSet.isDouble == 1){
            Toast.makeText(GameScreen.this, "You cannot double twice", Toast.LENGTH_SHORT).show();
            playSound(R.raw.difficult);
            // Can't triple stamp a double stamp
        }
        else{
            GetSet.playerScore  = 0;
            GetSet.dealerScore = 0;
            GetSet.hit++;
            GetSet.buttonPressed = 1;
            GetSet.isDouble = 1;
            GetSet.bet = GetSet.bet * 2;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        return true;
    }

}
