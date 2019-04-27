package com.baynecorp.blackjack.model;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

import com.baynecorp.blackjack.ui.Panel;

public class CanvasThread extends Thread {
    private SurfaceHolder _surfaceHolder;
    private Panel _panel;
    private boolean running = false;

    public CanvasThread(SurfaceHolder surfaceHolder, Panel panel){
        _surfaceHolder = surfaceHolder;
        _panel = panel;
    }

    public void setRunning(boolean run)
    {running = run;}

    @SuppressLint("WrongCall")
    @Override
    public void run(){
        Canvas canvas;
        _panel.init();
        while(running){
            canvas = null; //??
            try{
//                sleep(30);
                canvas = _surfaceHolder.lockCanvas(null); // lockCanvas creates a surface area until you call unlockCanvasAndPost() no other code can call lockCanvas() and write to the surface until your code is finished.
                synchronized (_surfaceHolder){ // synchronize means only one thread can execute this code at a time
                    _panel.onDraw(canvas);
                }
//            }
//            catch(InterruptedException ex){
//                ex.printStackTrace();
            }
            finally{// finally code will always run
                if (canvas != null){
                    _surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }

        }
    }
}

