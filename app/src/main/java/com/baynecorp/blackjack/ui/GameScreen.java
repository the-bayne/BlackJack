package com.baynecorp.blackjack.ui;

import android.app.AlertDialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baynecorp.blackjack.R;
import com.baynecorp.blackjack.model.GetSet;

public class GameScreen extends AppCompatActivity {
    Button button;
    TextView textView = null;
    MediaPlayer mp;
    AlertDialog.Builder sample;
    ImageView image;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamescreen);
        button = findViewById(R.id.btnRedeal);
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


    public void clickMethodHit(View view){ // Hit button
        if(GetSet.isStanding == false){
            GetSet.playerScore  = 0;
            GetSet.dealerScore = 0;
            GetSet.hit++;
            GetSet.buttonPressed = 1;
            //playSound(R.raw.dealing_card);
        }

    }
    public void clickMethodStand(View view){ // stand button
        GetSet.playerScore = 0;
        GetSet.dealerScore = 0;
        GetSet.dealerHit = GetSet.hit; // when stand pressed, assign dealerHit to be equal to hit
        GetSet.buttonPressed = 1;
        GetSet.isStanding = true;
//        playSound(R.raw.dealing_card);
    }

    public void clickMethodRedeal(View view){ // redeal button
        if (GetSet.playerScore > 21){
            GetSet.cash = GetSet.cash - GetSet.bet;
        }
        else if(GetSet.dealerScore > 21){
            GetSet.cash = GetSet.cash + (GetSet.bet * 2);
        }
        else if(GetSet.playerScore > GetSet.dealerScore && GetSet.playerScore< 21){
            // Player win!!
            GetSet.cash = GetSet.cash + (GetSet.bet * 2);

        }
        else{
            // Dealer win! take betting amount
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
        shuffleDeck(GetSet.card);
        playSound(R.raw.dealing_card);
        GetSet.horizontalMove = 0;
        GetSet.verticalMove = 400;
        GetSet.iswin = 0;
        GetSet.islose = 0;
    }

    public void clickMethodDouble(View view){
        if(GetSet.isDouble == 1){
            Toast.makeText(GameScreen.this, "You cannot double twice", Toast.LENGTH_SHORT).show();

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
