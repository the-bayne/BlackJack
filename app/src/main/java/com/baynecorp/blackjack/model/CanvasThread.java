package com.baynecorp.blackjack.model;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

import com.baynecorp.blackjack.ui.Panel;

public class CanvasThread extends Thread {
    private SurfaceHolder _surfaceHolder;
    private Panel _panel;
    private boolean running = false;

    public CanvasThread(SurfaceHolder surfaceHolder, Panel panel) {
        _surfaceHolder = surfaceHolder;
        _panel = panel;
    }

    public void setRunning(boolean run)
    {running = run;}

    @SuppressLint("WrongCall")
    @Override
    public void run() {
        Canvas canvas;
        _panel.init();
        while(running) {
            canvas = null;
            try {
                canvas = _surfaceHolder.lockCanvas(null);
                synchronized (_surfaceHolder) {
                    _panel.onDraw(canvas);
                }
            }
            finally {
                if (canvas != null) {
                    _surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }

        }
    }
}

