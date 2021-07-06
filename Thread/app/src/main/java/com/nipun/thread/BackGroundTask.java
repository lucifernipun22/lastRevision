package com.nipun.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;


public class BackGroundTask extends Thread {

    private static final String TAG = BackGroundTask.class.getSimpleName();
    public Handler mHandler;
    public Looper looper;

    @Override
    public void run() {
        super.run();
        Looper.prepare();
        looper = Looper.myLooper();
        mHandler = new Handler(looper);
        Looper.loop();
        Log.d(TAG, "Outside Loop");

    }


}