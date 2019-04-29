package com.baynecorp.blackjack.ui;

import android.app.AlertDialog;
import android.content.Context;
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
import android.widget.ImageView;
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
    ImageView image;

    private static final String TAG = "GameFragment";

    //TODO:  Win/Lose show dialog with 2 options.  Keep playing or save/exit
    //TODO:  Get rid of Redeal and autorun method on Keep playing selection and in the onCreate

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

        Log.d(TAG, "Current Player is: " + GetSet.playerName);
        Log.d(TAG, "High Score Player is: " + GetSet.highPlayerName);
        Log.d(TAG, "High Score is: " + GetSet.highScore);
        Log.d(TAG, "Current Player is: " + GetSet.playerName);
        Log.d(TAG, "Current Player is: " + GetSet.playerName);

        deck = new CardDeck[52];
        for(int suit = 0; suit < 4; suit++){
            for (int rank = 0; rank < 13; rank++ ){
                deck[n] = new CardDeck(suit,rank);
                n++;
            }
        }
        GetSet.card = deck;
        deck = shuffleDeck(deck);

        mHandler = new Handler();
        mHandler.post(mUpdate); //??
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

    public void bustDialog(){
        bustMessage = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogLayout;
        //dialogLayout = inflater.inflate(bust_dialog,null);
        //bustMessage.setView(dialogLayout);
        bustMessage.setMessage("Bust");
        playSound(R.raw.crap);
        //TODO:  Add 1 to dealer win and commit

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

    public void blackJackDialog(){
        blackJackMessage = new AlertDialog.Builder(getContext());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        //View dialogLayout = inflater.inflate(black_jack_dialog,null);
        //blackJackMessage.setView(dialogLayout);
        blackJackMessage.setMessage("Black Jack!!");
        playSound(R.raw.excellent);
        //TODO:  Add 1 to 21 counter and commit

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
            if (GetSet.playerScore == 21){
                /// Black Jack
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
            }

            else if(GetSet.playerScore < 21){
                textViewPlayer.setText("Player: " + GetSet.playerScore + " ");
                textViewDealer.setText("Dealer: " + GetSet.dealerScore + " ");
                textViewCash.setText("Cash: " + (GetSet.cash) + " ");
                textViewBet.setText("Bet: " + GetSet.bet + " ");
            }
            else{
                textViewPlayer.setText("Bust!");
                if(GetSet.playerBust ==0){
                    GetSet.playerBust = 1;
                }
                judgeWin();
            }
            if(GetSet.buttonPressed == 0){
                if(GetSet.dealerHit > 1){
                    if(GetSet.dealerScore < 17 && GetSet.dealerScore != 0){ // if the dealer's hands is less than 17, take another hit
                        GetSet.playerScore = 0;
                        GetSet.dealerScore = 0;
                        GetSet.dealerHit++;
                        GetSet.buttonPressed = 1;
                    }
                    else{
                        judgeWin();
                    }
                }
            }

            if(GetSet.playerBlackjack == 1){
                blackJackDialog();
                GetSet.playerBlackjack = 2;
            }
            if(GetSet.playerBust == 1){
                bustDialog();
                judgeWin();
                GetSet.playerBust = 2;
            }
            if(GetSet.playerBust > 1){
                textViewDealer.setText("Dealer: " + GetSet.dealerScore + " ");
            }

            mHandler.postDelayed(this,1); //Causes the Runnable r to be added to the message queue, to be run after the specified amount of time elapses
        }
    };

    public void judgeWin(){
        if (GetSet.playerScore > 21){

        }
        else if(GetSet.dealerScore > 21){
            textViewDealer.setText("Bust!");
            if (GetSet.iswin == 0){
                GetSet.iswin = 1;
            }
        }
        else if(GetSet.playerScore > GetSet.dealerScore){
            if (GetSet.iswin == 0){
                GetSet.iswin = 1;
            }

        }
        else if(GetSet.playerScore < GetSet.dealerScore){
            if (GetSet.islose == 0){
                GetSet.islose = 1;
            }

        }
        else if (GetSet.playerScore == GetSet.dealerScore){
            textViewPlayer.setText("Push!");
            textViewDealer.setText("Push!");
        }
        else{

        }

        if(GetSet.iswin == 1){
            Context context = getContext();
            CharSequence text = "You Won!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            GetSet.iswin = 2;
        }
        if(GetSet.islose == 1){
            Context context = getContext();
            CharSequence text = "You Lost!";
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
            cardHolder = deck[randomIndex]; // assign randomth card to the first card(cardHolder)
            deck[randomIndex] = deck[n]; // assign the first card to randomth card (swapping the two cards)
            deck[n] = cardHolder;

        }
        return deck;
    }



}
