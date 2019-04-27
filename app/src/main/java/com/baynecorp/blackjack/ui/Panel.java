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
    private CanvasThread canvasthread; // this holds bitmap object
    CardDraw cardDraw;
    int localScore;
    Bitmap bitmap;
    Bitmap mScaledBitmap;

    public Panel(Context context, AttributeSet attrs){ // initialize a panel(constructor)
        super(context, attrs); //??
        getHolder().addCallback(this); // getHolder is a method of SurfaceView
        canvasthread = new CanvasThread(getHolder(),this);
        setFocusable(true); // enable view's focus event
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
        //bitmap = BitmapFactory.decodeResource(res, R.drawable.greenboard);
//        int h = 1200;
//        int w = 1000;
//        Bitmap scaled = Bitmap.createScaledBitmap(bitmap, w, h, true);
//        mScaledBitmap = scaled;
    }

    @Override
    public void onDraw(Canvas canvas){ // this triggers animation(execute over and over again)!!!
        try {canvas.drawBitmap(bitmap, 0, 0, paint);}
        catch (Exception e) {
            Log.d("Jared", e.toString());
        }
//        canvas.drawColor(Color.GREEN);
        for (int x = 0; x <= 1; x++){ // draw first 2 cards for dealer
            if (x == 0 && GetSet.dealerHit < 3){
                cardDraw.deal(canvas,501, (80 * x), -200);// draw back card on screen. -200 is xdistance
            }
            else{
//                   cardDraw.deal(canvas,x, (80 * x), -200);
                if(GetSet.horizontalMove < 81){ // keep looping this statement untile horizantalMove hits 80
                    GetSet.horizontalMove = GetSet.horizontalMove + 4;
                    GetSet.verticalMove = GetSet.verticalMove - 20;
                }
                if(GetSet.verticalMove >= -200){
                    GetSet.verticalMove = -200;
                }
                cardDraw.deal(canvas,x, (GetSet.horizontalMove * x), GetSet.verticalMove);
            }
            if (GetSet.buttonPressed == 1){ // only after hit button, execute addScore
                addScore(x,false,true); // when hit stand, calculate score
            }
        }
        for (int n = 2; n <= 3; n++){ // draw first 2 cards for player
//                cardDraw.deal(canvas,n, (80 * n), 250);// draw multiple cards on screen. 700 is xdistance
            if(GetSet.horizontalMove < 81){ // keep looping this statement untile horizantalMove hits 80
                GetSet.horizontalMove = GetSet.horizontalMove + 4;
                GetSet.verticalMove = GetSet.verticalMove - 20;
            }
            if(GetSet.verticalMove <= 250){
                GetSet.verticalMove = 250;
            }
            cardDraw.deal(canvas,n, (GetSet.horizontalMove * n), GetSet.verticalMove);

            if (GetSet.buttonPressed == 1){ // only after hit button, execute addScore
                addScore(n,true,false); // when hit stand, calculate score
            }
        }

        for (int n = 4; n <=GetSet.hit; n++ ){ // after first 2 cards for player, calculate sum of score
            cardDraw.deal(canvas,n, (80 * n), 250);

            if (GetSet.buttonPressed == 1){
                addScore(n, true, false);
            }

        }

        for (int x = (GetSet.hit + 1); x <= GetSet.dealerHit; x++){ /// when hit stand button,
            cardDraw.deal(canvas,x, (80 * x), -200);

            if (GetSet.buttonPressed == 1){
                addScore(x,false,true);
            }
        }

        if (GetSet.playerBust == 1) {
            for (int x = 0; x <= 1; x++) {
                cardDraw.deal(canvas, x, (80 * x), -200);
                addScore(x, false, true);
            }
        }
        GetSet.buttonPressed = 0;
    }

    public void addScore(int n, boolean player,boolean dealer){
        if(n == 0 && GetSet.dealerHit < 3) { // when player has not clicked stand
            localScore = 0;
        }else{
            if(GetSet.card[n].rank >= 8 && GetSet.card[n].rank < 12){ /// if rank is 10, jack, queen and king, then give 10 as score
                localScore = 10;
            }
            if(GetSet.card[n].rank == 12){
                if(player){
                    if(GetSet.playerScore > 10){
                        localScore = 1;
                    }
                    else{
                        localScore = 11;
                    }
                }
                if(dealer){
                    if(GetSet.dealerScore > 10){
                        localScore = 1;
                    }
                    else{
                        localScore = 11;
                    }
                }

            }
            if (GetSet.card[n].rank < 8){ // less than 10
                localScore = GetSet.card[n].rank + 2; // I think I can refactor this later
            }

            if (player){
                GetSet.playerScore  = GetSet.playerScore + localScore;
            }
            if (dealer){
                GetSet.dealerScore  = GetSet.dealerScore + localScore;
            }
        }

    }

    public void update(){

    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

    }

    public void surfaceCreated(SurfaceHolder holder){
        canvasthread.setRunning(true); // as long as true, this redraws canvasthread forever
        canvasthread.start();
    }

    public void surfaceDestroyed(SurfaceHolder holder){
        boolean retry = true;
        canvasthread.setRunning(false); // this will stop redrawing
        while(retry){
            try { // try blocks to wrap things that may fail to execute properly
                canvasthread.join();//??
                retry = false;
            }
            catch(InterruptedException exception){

            }
        }

    }
}
