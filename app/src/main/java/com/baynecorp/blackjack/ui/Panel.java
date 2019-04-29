package com.baynecorp.blackjack.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.baynecorp.blackjack.R;
import com.baynecorp.blackjack.model.CanvasThread;
import com.baynecorp.blackjack.model.CardDraw;
import com.baynecorp.blackjack.model.GetSet;

public class Panel extends SurfaceView implements SurfaceHolder.Callback {
    Paint paint;
    private CanvasThread canvasthread; // Holds bitmap objects
    CardDraw cardDraw;
    int localScore;
    Bitmap bitmap;

    public Panel(Context context, AttributeSet attrs){
        super(context, attrs);
        getHolder().addCallback(this);
        canvasthread = new CanvasThread(getHolder(),this);
        setFocusable(true);
        paint = new Paint();
        cardDraw = new CardDraw(context);

    }

    public Panel(Context context){
        super(context);
        getHolder().addCallback(this);
        canvasthread = new CanvasThread(getHolder(), this);
        setFocusable(true);
    }

    public void init(){
        Resources res = getResources();
        bitmap = BitmapFactory.decodeResource(res, R.drawable.greenboard);
    }

    @Override
    public void onDraw(Canvas canvas) {
        try {canvas.drawBitmap(bitmap, 0, 0, paint);}
        catch (Exception e) {
            Log.d("Jared", e.toString());
        }
        for (int x = 0; x <= 1; x++) { // New game so draw 2 cards for dealer
            if (x == 0 && GetSet.dealerHit < 3) {
                cardDraw.dealTheCards(canvas,318, (80 * x), -200);
            }
            else{
                if(GetSet.horizontalMove < 81){ // Push cards to correct spot on panel
                    GetSet.horizontalMove = GetSet.horizontalMove + 4;
                    GetSet.verticalMove = GetSet.verticalMove - 20;
                }
                if(GetSet.verticalMove >= -200) {
                    GetSet.verticalMove = -200;
                }
                cardDraw.dealTheCards(canvas,x, (GetSet.horizontalMove * x), GetSet.verticalMove);
            }
            if (GetSet.buttonPressed == 1){
                addScore(x,false,true); // Stand
            }
        }
        for (int n = 2; n <= 3; n++){ // New game so draw 2 cards for player
            if(GetSet.horizontalMove < 81) { // Push cards to correct spot on panel
                GetSet.horizontalMove = GetSet.horizontalMove + 4;
                GetSet.verticalMove = GetSet.verticalMove - 20;
            }
            if(GetSet.verticalMove <= 250){
                GetSet.verticalMove = 250;
            }
            cardDraw.dealTheCards(canvas,n, (GetSet.horizontalMove * n), GetSet.verticalMove);

            if (GetSet.buttonPressed == 1) {
                addScore(n,true,false); // Stand
            }
        }

        for (int n = 4; n <= GetSet.hit; n++ ) {
            cardDraw.dealTheCards(canvas,n, (80 * n), 250);

            if (GetSet.buttonPressed == 1) {
                addScore(n, true, false);
            }

        }

        for (int x = (GetSet.hit + 1); x <= GetSet.dealerHit; x++) {
            cardDraw.dealTheCards(canvas,x, (80 * x), -200);

            if (GetSet.buttonPressed == 1) {
                addScore(x,false,true);
            }
        }

        if (GetSet.playerBust == 1) {
            for (int x = 0; x <= 1; x++) {
                cardDraw.dealTheCards(canvas, x, (80 * x), -200);
                addScore(x, false, true);
            }
        }
        GetSet.buttonPressed = 0;
    }

    public void addScore(int n, boolean player,boolean dealer){
        if(n == 0 && GetSet.dealerHit < 3) {
            localScore = 0;
        }else {
            if(GetSet.card[n].rank >= 8 && GetSet.card[n].rank < 12){ // Face cards
                localScore = 10;
            }
            if(GetSet.card[n].rank == 12) { // Ace - counts as 11 unless it would cause a bust
                if(player) {
                    if(GetSet.playerScore > 10) {
                        localScore = 1;
                    }
                    else {
                        localScore = 11;
                    }
                }
                if(dealer){
                    if(GetSet.dealerScore > 10) {
                        localScore = 1;
                    }
                    else{
                        localScore = 11;
                    }
                }

            }
            if (GetSet.card[n].rank < 8) {  // Card rank is 2 less than value of card
                localScore = GetSet.card[n].rank + 2;
            }

            if (player) {
                GetSet.playerScore  = GetSet.playerScore + localScore;
            }
            if (dealer) {
                GetSet.dealerScore  = GetSet.dealerScore + localScore;
            }
        }

    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

    }

    public void surfaceCreated(SurfaceHolder holder){
        canvasthread.setRunning(true); // Redraws canvasthread until false
        canvasthread.start();
    }

    public void surfaceDestroyed(SurfaceHolder holder){
        boolean retry = true;
        canvasthread.setRunning(false); // this will stop redrawing
        while(retry){
            try {
                canvasthread.join();
                retry = false;
            }
            catch(InterruptedException exception){

            }
        }

    }


}
