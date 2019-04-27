package com.baynecorp.blackjack.ui;

import android.app.AlertDialog;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baynecorp.blackjack.model.CardDeck;

public class GameFragment extends Fragment {
    CardDeck[] deck;
    int n = 0;
    View rootView;
    TextView textviewPlayer;
    static TextView textviewDealer;
    TextView textviewCash;
    TextView textviewBet;
    Handler mHandler;
    MediaPlayer mp;
    AlertDialog.Builder bustMessage;
    AlertDialog.Builder blackJackMessage;
    ImageView image;
}
