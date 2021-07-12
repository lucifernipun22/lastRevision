package com.nipun.evaluation5;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class MusicHandlerThread extends HandlerThread {
    private LooperReadyListner looperReadyListner;
    private Handler handler;
    public MusicHandlerThread(String name, LooperReadyListner looperReadyListner) {
        super(name);
        this.looperReadyListner = looperReadyListner;
        handler = new Handler(Looper.myLooper());
    }

    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        handler = new Handler(Looper.myLooper());
        looperReadyListner.onLooperPrepared();

    }
    public void addTakToMessageQueue(Runnable task){
        handler.post(task);
    }


}
