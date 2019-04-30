package com.baynecorp.blackjack.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.baynecorp.blackjack.R;
import com.baynecorp.blackjack.model.CardDeck;
import com.baynecorp.blackjack.model.GetSet;

import java.util.Random;

public class GameFragment extends Fragment {
    CardDeck[] deck;
    int n = 0;
    View rootView;
    TextView textViewPlayer;
    static TextView textViewDealer;
    TextView textViewCash;
    TextView textViewBet;
    Handler mHandler;
    MediaPlayer mp;
    AlertDialog.Builder bustMessage;
    AlertDialog.Builder blackJackMessage;

    int hit21 = GetSet.timesHit21;
    int gamesWon = GetSet.gamesWon;
    int gamesLost = GetSet.gamesLost;
    String player = GetSet.playerName;
    int highScore = GetSet.highScore;
    int currentScore;

    private SharedPreferences prefs;
    private SharedPreferences.Editor prefsEditor;

    public GameFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        rootView = inflater.inflate(R.layout.fragment_main,container, false);

        textViewPlayer = rootView.findViewById(R.id.playerScore);
        textViewPlayer.setTextColor(Color.WHITE);
        textViewPlayer.setTextSize(20);

        textViewDealer = rootView.findViewById(R.id.dealerScore);
        textViewDealer.setTextColor(Color.WHITE);
        textViewDealer.setTextSize(20);

        textViewCash = rootView.findViewById(R.id.cash);
        textViewCash.setTextColor(Color.WHITE);
        textViewCash.setTextSize(20);

        textViewBet = rootView.findViewById(R.id.bet);
        textViewBet.setTextColor(Color.WHITE);
        textViewBet.setTextSize(20);


        deck = new CardDeck[52];
        for(int suit = 0; suit < 4; suit++){
            for (int rank = 0; rank < 13; rank++ ){
                deck[n] = new CardDeck(suit,rank);
                n++;
            }
        }

        prefs = this.getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        GetSet.card = deck;
        deck = shuffleDeck(deck);

        mHandler = new Handler();
        mHandler.post(mUpdate);
        return rootView;
    }

    private void playSound(int sound){
        if (mp != null){
            if (mp.isPlaying()||mp.isLooping()) {
                mp.stop();
            }
            mp.release();
            mp = null;
        }
        mp = MediaPlayer.create(getContext(),sound);
        mp.start();
    }

    public void updatePrefs(String key, String value) {
        prefsEditor = prefs.edit();
        prefsEditor.putString(key, value);
        prefsEditor.commit();
        Log.d("Jared", "Current Score: " + currentScore + " High Score: " + highScore);
    }

    public void bustDialog(){
        bustMessage = new AlertDialog.Builder(getContext());

        bustMessage.setTitle("Busted Big Time!");
        bustMessage.setMessage("Better luck next hand!");
        playSound(R.raw.crap);
        gamesLost = gamesLost + 1;
        updatePrefs("GamesLost", String.valueOf(gamesLost));

        final AlertDialog alert = bustMessage.create();
        alert.show();
        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onFinish() {
                // TODO Auto-generated method stub
                alert.dismiss();
            }
        }.start();
    }

    public void highScore() {
        if (currentScore > highScore) {
            updatePrefs("HighScore", String.valueOf(currentScore));
            updatePrefs("HighScorePlayerName", player);
        }
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    public void blackJackDialog(){
        blackJackMessage = new AlertDialog.Builder(getContext());

        hit21 = hit21 + 1;
        updatePrefs("Hit21", String.valueOf(hit21));
        blackJackMessage.setTitle("You WON!");
        blackJackMessage.setMessage("You hit 21!!!");
        playSound(R.raw.excellent);

        final AlertDialog alert = blackJackMessage.create();

        alert.show();
        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onFinish() {
                // TODO Auto-generated method stub
                alert.dismiss();
            }
        }.start();
    }

    private Runnable mUpdate = new Runnable() {
        @Override
        public void run() {
            currentScore = GetSet.cash;
            if (GetSet.playerScore == 21) {
                textViewPlayer.setText("Player: " + GetSet.playerScore + " ");
                textViewDealer.setText("Dealer: " + GetSet.dealerScore + " ");
                textViewCash.setText("Cash: " + (GetSet.cash) + " ");
                textViewBet.setText("Bet: " + GetSet.bet +  " ");
                GetSet.isBlackJack = true;
                GetSet.isStanding = true;
                if(GetSet.playerBlackjack == 0){
                    GetSet.playerBlackjack = 1;
                }
                judgeWin();
                highScore();
            }

            else if(GetSet.playerScore < 21){
                textViewPlayer.setText("Player: " + GetSet.playerScore + " ");
                textViewDealer.setText("Dealer: " + GetSet.dealerScore + " ");
                textViewCash.setText("Cash: " + (GetSet.cash) + " ");
                textViewBet.setText("Bet: " + GetSet.bet + " ");
                highScore();
            }
            else{
                textViewPlayer.setText("Bust!");
                if(GetSet.playerBust ==0){
                    GetSet.playerBust = 1;
                }
                judgeWin();
                highScore();
            }
            if(GetSet.buttonPressed == 0) {
                if(GetSet.dealerHit > 1) {
                    if(GetSet.dealerScore < 17 && GetSet.dealerScore != 0){
                        GetSet.playerScore = 0;
                        GetSet.dealerScore = 0;
                        GetSet.dealerHit++;
                        GetSet.buttonPressed = 1;
                        highScore();
                    }
                    else{
                        judgeWin();
                        highScore();
                    }
                }
            }

            if(GetSet.playerBlackjack == 1){
                blackJackDialog();
                highScore();
                GetSet.playerBlackjack = 2;
            }
            if(GetSet.playerBust == 1){
                bustDialog();
                judgeWin();
                highScore();
                GetSet.playerBust = 2;
            }
            if(GetSet.playerBust > 1){
                textViewDealer.setText("Dealer: " + GetSet.dealerScore + " ");
                highScore();
            }

            mHandler.postDelayed(this,1);
        }
    };

    public void judgeWin(){
        if (GetSet.playerScore > 21){
            highScore();
        }
        else if(GetSet.dealerScore > 21){
            highScore();
            textViewDealer.setText("Bust!");
            if (GetSet.iswin == 0){
                GetSet.iswin = 1;
            }
        }
        else if(GetSet.playerScore > GetSet.dealerScore){
            highScore();
            if (GetSet.iswin == 0){
                GetSet.iswin = 1;
            }

        }
        else if(GetSet.playerScore < GetSet.dealerScore){
            highScore();
            if (GetSet.islose == 0){
                GetSet.islose = 1;
            }

        }
        else if (GetSet.playerScore == GetSet.dealerScore){
            highScore();
            textViewPlayer.setText("Push!");
            textViewDealer.setText("Push!");
        }
        else{

        }

        if(GetSet.iswin == 1){
            highScore();
            Context context = getContext();
            CharSequence text = "You Won!";
            gamesWon = gamesWon + 1;
            updatePrefs("GamesWon", String.valueOf(gamesWon));
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            GetSet.iswin = 2;
        }
        if(GetSet.islose == 1){
            highScore();
            Context context = getContext();
            CharSequence text = "You Lost!";
            gamesLost = gamesLost + 1;
            updatePrefs("GamesLost", String.valueOf(gamesLost));
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            GetSet.islose = 2;
        }
    }

    public CardDeck[] shuffleDeck(CardDeck[] deck){
        Random random = new Random();
        CardDeck cardHolder = new CardDeck(0,0);
        for (int n = 0; n <52; n++){
            int randomIndex = random.nextInt(52);
            cardHolder = deck[randomIndex];
            deck[randomIndex] = deck[n];
            deck[n] = cardHolder;

        }
        return deck;
    }



}
