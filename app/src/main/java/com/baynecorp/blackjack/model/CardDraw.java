package com.baynecorp.blackjack.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.baynecorp.blackjack.R;

public class CardDraw {
    int x;
    int y;

    Bitmap back;
    Bitmap twoclubs;
    Bitmap threeclubs;
    Bitmap fourclubs;
    Bitmap fiveclubs;
    Bitmap sixclubs;
    Bitmap sevenclubs;
    Bitmap eightclubs;
    Bitmap nineclubs;
    Bitmap tenclubs;
    Bitmap jackclubs;
    Bitmap queenclubs;
    Bitmap kingclubs;
    Bitmap aceclubs;
    Bitmap twohearts;
    Bitmap threehearts;
    Bitmap fourhearts;
    Bitmap fivehearts;
    Bitmap sixhearts;
    Bitmap sevenhearts;
    Bitmap eighthearts;
    Bitmap ninehearts;
    Bitmap tenhearts;
    Bitmap jackhearts;
    Bitmap queenhearts;
    Bitmap kinghearts;
    Bitmap acehearts;
    Bitmap twospades;
    Bitmap threespades;
    Bitmap fourspades;
    Bitmap fivespades;
    Bitmap sixspades;
    Bitmap sevenspades;
    Bitmap eightspades;
    Bitmap ninespades;
    Bitmap tenspades;
    Bitmap jackspades;
    Bitmap queenspades;
    Bitmap kingspades;
    Bitmap acespades;
    Bitmap twodiamonds;
    Bitmap threediamonds;
    Bitmap fourdiamonds;
    Bitmap fivediamonds;
    Bitmap sixdiamonds;
    Bitmap sevendiamonds;
    Bitmap eightdiamonds;
    Bitmap ninediamonds;
    Bitmap tendiamonds;
    Bitmap jackdiamonds;
    Bitmap queendiamonds;
    Bitmap kingdiamonds;
    Bitmap acediamonds;

    public CardDraw(Context context){
        back = BitmapFactory.decodeResource(context.getResources(), R.drawable.back);
        back = Bitmap.createScaledBitmap(back,back.getWidth()/6,back.getHeight()/6,false);

        twoclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.twoclubs);
        twoclubs = Bitmap.createScaledBitmap(twoclubs,twoclubs.getWidth()/6,twoclubs.getHeight()/6,false); // adjusting scale
        threeclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.threeclubs);
        threeclubs = Bitmap.createScaledBitmap(threeclubs,threeclubs.getWidth()/6,threeclubs.getHeight()/6,false);
        fourclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.fourclubs);
        fourclubs = Bitmap.createScaledBitmap(fourclubs,fourclubs.getWidth()/6,fourclubs.getHeight()/6,false);
        fiveclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.fiveclubs);
        fiveclubs = Bitmap.createScaledBitmap(fiveclubs,fiveclubs.getWidth()/6,fiveclubs.getHeight()/6,false);
        sixclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.sixclubs);
        sixclubs = Bitmap.createScaledBitmap(sixclubs,sixclubs.getWidth()/6,sixclubs.getHeight()/6,false);
        sevenclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.sevenclubs);
        sevenclubs = Bitmap.createScaledBitmap(sevenclubs,sevenclubs.getWidth()/6,sevenclubs.getHeight()/6,false);
        eightclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.eightclubs);
        eightclubs = Bitmap.createScaledBitmap(eightclubs,eightclubs.getWidth()/6,eightclubs.getHeight()/6,false);
        nineclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.nineclubs);
        nineclubs = Bitmap.createScaledBitmap(nineclubs,nineclubs.getWidth()/6,nineclubs.getHeight()/6,false);
        tenclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.tenclubs);
        tenclubs = Bitmap.createScaledBitmap(tenclubs,tenclubs.getWidth()/6,tenclubs.getHeight()/6,false);
        jackclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.jackclubs);
        jackclubs = Bitmap.createScaledBitmap(jackclubs,jackclubs.getWidth()/6,jackclubs.getHeight()/6,false);
        queenclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.queenclubs);
        queenclubs = Bitmap.createScaledBitmap(queenclubs,queenclubs.getWidth()/6,queenclubs.getHeight()/6,false);
        kingclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.kingclubs);
        kingclubs = Bitmap.createScaledBitmap(kingclubs,kingclubs.getWidth()/6,kingclubs.getHeight()/6,false);
        aceclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.aceclubs);
        aceclubs = Bitmap.createScaledBitmap(aceclubs,aceclubs.getWidth()/6,aceclubs.getHeight()/6,false);

        twohearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.twohearts);
        twohearts = Bitmap.createScaledBitmap(twohearts,twohearts.getWidth()/6,twohearts.getHeight()/6,false);
        threehearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.threehearts);
        threehearts = Bitmap.createScaledBitmap(threehearts,threehearts.getWidth()/6,threehearts.getHeight()/6,false);
        fourhearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.fourhearts);
        fourhearts = Bitmap.createScaledBitmap(fourhearts,fourhearts.getWidth()/6,fourhearts.getHeight()/6,false);
        fivehearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.fivehearts);
        fivehearts = Bitmap.createScaledBitmap(fivehearts,fivehearts.getWidth()/6,fivehearts.getHeight()/6,false);
        sixhearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.sixhearts);
        sixhearts = Bitmap.createScaledBitmap(sixhearts,sixhearts.getWidth()/6,sixhearts.getHeight()/6,false);
        sevenhearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.sevenhearts);
        sevenhearts = Bitmap.createScaledBitmap(sevenhearts,sevenhearts.getWidth()/6,sevenhearts.getHeight()/6,false);
        eighthearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.eighthearts);
        eighthearts = Bitmap.createScaledBitmap(eighthearts,eighthearts.getWidth()/6,eighthearts.getHeight()/6,false);
        ninehearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.ninehearts);
        ninehearts = Bitmap.createScaledBitmap(ninehearts,ninehearts.getWidth()/6,ninehearts.getHeight()/6,false);
        tenhearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.tenhearts);
        tenhearts = Bitmap.createScaledBitmap(tenhearts,tenhearts.getWidth()/6,tenhearts.getHeight()/6,false);
        jackhearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.jackhearts);
        jackhearts = Bitmap.createScaledBitmap(jackhearts,jackhearts.getWidth()/6,jackhearts.getHeight()/6,false);
        queenhearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.queenhearts);
        queenhearts = Bitmap.createScaledBitmap(queenhearts,queenhearts.getWidth()/6,queenhearts.getHeight()/6,false);
        kinghearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.kinghearts);
        kinghearts = Bitmap.createScaledBitmap(kinghearts,kinghearts.getWidth()/6,kinghearts.getHeight()/6,false);
        acehearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.acehearts);
        acehearts = Bitmap.createScaledBitmap(acehearts,acehearts.getWidth()/6,acehearts.getHeight()/6,false);

        twospades = BitmapFactory.decodeResource(context.getResources(), R.drawable.twospades);
        twospades = Bitmap.createScaledBitmap(twospades,twospades.getWidth()/6,twospades.getHeight()/6,false); // adjusting scale
        threespades = BitmapFactory.decodeResource(context.getResources(), R.drawable.threespades);
        threespades = Bitmap.createScaledBitmap(threespades,threespades.getWidth()/6,threespades.getHeight()/6,false);
        fourspades = BitmapFactory.decodeResource(context.getResources(), R.drawable.fourspades);
        fourspades = Bitmap.createScaledBitmap(fourspades,fourspades.getWidth()/6,fourspades.getHeight()/6,false);
        fivespades = BitmapFactory.decodeResource(context.getResources(), R.drawable.fivespades);
        fivespades = Bitmap.createScaledBitmap(fivespades,fivespades.getWidth()/6,fivespades.getHeight()/6,false);
        sixspades = BitmapFactory.decodeResource(context.getResources(), R.drawable.sixspades);
        sixspades = Bitmap.createScaledBitmap(sixspades,sixspades.getWidth()/6,sixspades.getHeight()/6,false);
        sevenspades = BitmapFactory.decodeResource(context.getResources(), R.drawable.sevenspades);
        sevenspades = Bitmap.createScaledBitmap(sevenspades,sevenspades.getWidth()/6,sevenspades.getHeight()/6,false);
        eightspades = BitmapFactory.decodeResource(context.getResources(), R.drawable.eightspades);
        eightspades = Bitmap.createScaledBitmap(eightspades,eightspades.getWidth()/6,eightspades.getHeight()/6,false);
        ninespades = BitmapFactory.decodeResource(context.getResources(), R.drawable.ninespades);
        ninespades = Bitmap.createScaledBitmap(ninespades,ninespades.getWidth()/6,ninespades.getHeight()/6,false);
        tenspades = BitmapFactory.decodeResource(context.getResources(), R.drawable.tenspades);
        tenspades = Bitmap.createScaledBitmap(tenspades,tenspades.getWidth()/6,tenspades.getHeight()/6,false);
        jackspades = BitmapFactory.decodeResource(context.getResources(), R.drawable.jackspades);
        jackspades = Bitmap.createScaledBitmap(jackspades,jackspades.getWidth()/6,jackspades.getHeight()/6,false);
        queenspades = BitmapFactory.decodeResource(context.getResources(), R.drawable.queenspades);
        queenspades = Bitmap.createScaledBitmap(queenspades,queenspades.getWidth()/6,queenspades.getHeight()/6,false);
        kingspades = BitmapFactory.decodeResource(context.getResources(), R.drawable.kingspades);
        kingspades = Bitmap.createScaledBitmap(kingspades,kingspades.getWidth()/6,kingspades.getHeight()/6,false);
        acespades = BitmapFactory.decodeResource(context.getResources(), R.drawable.acespades);
        acespades = Bitmap.createScaledBitmap(acespades,acespades.getWidth()/6,acespades.getHeight()/6,false);

        twodiamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.twodiamonds);
        twodiamonds = Bitmap.createScaledBitmap(twodiamonds,twodiamonds.getWidth()/6,twodiamonds.getHeight()/6,false);
        threediamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.threediamonds);
        threediamonds = Bitmap.createScaledBitmap(threediamonds,threediamonds.getWidth()/6,threediamonds.getHeight()/6,false);
        fourdiamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.fourdiamonds);
        fourdiamonds = Bitmap.createScaledBitmap(fourdiamonds,fourdiamonds.getWidth()/6,fourdiamonds.getHeight()/6,false);
        fivediamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.fivediamonds);
        fivediamonds = Bitmap.createScaledBitmap(fivediamonds,fivediamonds.getWidth()/6,fivediamonds.getHeight()/6,false);
        sixdiamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.sixdiamonds);
        sixdiamonds = Bitmap.createScaledBitmap(sixdiamonds,sixdiamonds.getWidth()/6,sixdiamonds.getHeight()/6,false);
        sevendiamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.sevendiamonds);
        sevendiamonds = Bitmap.createScaledBitmap(sevendiamonds,sevendiamonds.getWidth()/6,sevendiamonds.getHeight()/6,false);
        eightdiamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.eightdiamonds);
        eightdiamonds = Bitmap.createScaledBitmap(eightdiamonds,eightdiamonds.getWidth()/6,eightdiamonds.getHeight()/6,false);
        ninediamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.ninediamonds);
        ninediamonds = Bitmap.createScaledBitmap(ninediamonds,ninediamonds.getWidth()/6,ninediamonds.getHeight()/6,false);
        tendiamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.tendiamonds);
        tendiamonds = Bitmap.createScaledBitmap(tendiamonds,tendiamonds.getWidth()/6,tendiamonds.getHeight()/6,false);
        jackdiamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.jackdiamonds);
        jackdiamonds = Bitmap.createScaledBitmap(jackdiamonds,jackdiamonds.getWidth()/6,jackdiamonds.getHeight()/6,false);
        queendiamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.queendiamonds);
        queendiamonds = Bitmap.createScaledBitmap(queendiamonds,queendiamonds.getWidth()/6,queendiamonds.getHeight()/6,false);
        kingdiamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.kingdiamonds);
        kingdiamonds = Bitmap.createScaledBitmap(kingdiamonds,kingdiamonds.getWidth()/6,kingdiamonds.getHeight()/6,false);
        acediamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.acediamonds);
        acediamonds = Bitmap.createScaledBitmap(acediamonds,acediamonds.getWidth()/6,acediamonds.getHeight()/6,false);
    }

    public void getCanvasDimensions(Canvas canvas){
        x = canvas.getHeight();
        y = canvas.getWidth();
    }

    public void dealTheCards(Canvas canvas, int cardnum, int xdistance, int ydistance){
        getCanvasDimensions(canvas);
        if(cardnum == 318) {
            canvas.drawBitmap(back,(x/2) - 800 + xdistance, (y/2) + ydistance, null);
        }else {
            if (GetSet.card[cardnum].suit == 0) {

                if (GetSet.card[cardnum].rank == 0) {
                    canvas.drawBitmap(twoclubs,(x/2) - 800 + xdistance,(y/2) + ydistance, null); // float left, float top
                }
                if (GetSet.card[cardnum].rank == 1) {
                    canvas.drawBitmap(threeclubs,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 2) {
                    canvas.drawBitmap(fourclubs,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 3) {
                    canvas.drawBitmap(fiveclubs,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 4) {
                    canvas.drawBitmap(sixclubs,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 5) {
                    canvas.drawBitmap(sevenclubs,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 6) {
                    canvas.drawBitmap(eightclubs,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 7) {
                    canvas.drawBitmap(nineclubs,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 8) {
                    canvas.drawBitmap(tenclubs,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 9){
                    canvas.drawBitmap(jackclubs,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 10){
                    canvas.drawBitmap(queenclubs,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 11){
                    canvas.drawBitmap(kingclubs,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 12){
                    canvas.drawBitmap(aceclubs,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
            }
            if (GetSet.card[cardnum].suit == 1){
                if (GetSet.card[cardnum].rank == 0){
                    canvas.drawBitmap(twohearts,(x/2) - 800 + xdistance,(y/2) + ydistance, null); // float left, float top
                }
                if (GetSet.card[cardnum].rank == 1){
                    canvas.drawBitmap(threehearts,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 2){
                    canvas.drawBitmap(fourhearts,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 3){
                    canvas.drawBitmap(fivehearts,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 4){
                    canvas.drawBitmap(sixhearts,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 5){
                    canvas.drawBitmap(sevenhearts,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 6){
                    canvas.drawBitmap(eighthearts,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 7){
                    canvas.drawBitmap(ninehearts,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 8){
                    canvas.drawBitmap(tenhearts,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 9){
                    canvas.drawBitmap(jackhearts,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 10){
                    canvas.drawBitmap(queenhearts,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 11){
                    canvas.drawBitmap(kinghearts,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 12){
                    canvas.drawBitmap(acehearts,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }

            }
            if (GetSet.card[cardnum].suit == 2){
                if (GetSet.card[cardnum].rank == 0){
                    canvas.drawBitmap(twospades,(x/2) - 800 + xdistance,(y/2) + ydistance, null); // float left, float top
                }
                if (GetSet.card[cardnum].rank == 1){
                    canvas.drawBitmap(threespades,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 2){
                    canvas.drawBitmap(fourspades,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 3){
                    canvas.drawBitmap(fivespades,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 4){
                    canvas.drawBitmap(sixspades,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 5){
                    canvas.drawBitmap(sevenspades,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 6){
                    canvas.drawBitmap(eightspades,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 7){
                    canvas.drawBitmap(ninespades,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 8){
                    canvas.drawBitmap(tenspades,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 9){
                    canvas.drawBitmap(jackspades,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 10){
                    canvas.drawBitmap(queenspades,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 11){
                    canvas.drawBitmap(kingspades,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 12){
                    canvas.drawBitmap(acespades,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }

            }
            if (GetSet.card[cardnum].suit == 3){
                if (GetSet.card[cardnum].rank == 0){
                    canvas.drawBitmap(twodiamonds,(x/2) - 800 + xdistance,(y/2) + ydistance, null); // float left, float top
                }
                if (GetSet.card[cardnum].rank == 1){
                    canvas.drawBitmap(threediamonds,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 2){
                    canvas.drawBitmap(fourdiamonds,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 3){
                    canvas.drawBitmap(fivediamonds,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 4){
                    canvas.drawBitmap(sixdiamonds,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 5){
                    canvas.drawBitmap(sevendiamonds,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 6){
                    canvas.drawBitmap(eightdiamonds,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 7){
                    canvas.drawBitmap(ninediamonds,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 8){
                    canvas.drawBitmap(tendiamonds,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 9){
                    canvas.drawBitmap(jackdiamonds,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 10){
                    canvas.drawBitmap(queendiamonds,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 11){
                    canvas.drawBitmap(kingdiamonds,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
                if (GetSet.card[cardnum].rank == 12){
                    canvas.drawBitmap(acediamonds,(x/2) - 800 + xdistance,(y/2) + ydistance, null);
                }
            }

        }


    }
}
