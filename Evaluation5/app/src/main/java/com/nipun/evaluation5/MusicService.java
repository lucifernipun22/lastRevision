package com.nipun.evaluation5;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MusicService extends Service implements LooperReadyListner {
    private static final String TAG= MusicService.class.getSimpleName();
    private MediaPlayer mediaPlayer;
    private boolean isLooperReady;
    private MusicHandlerThread handlerThread;

    public MusicService(){

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG,"OnBind");
        mediaPlayer = MediaPlayer.create(this, R.raw.shape_of_you);
        startBackgroundTask();
        return new MusicServiceBinder();
    }

    private void startBackgroundTask() {
    }

    @Override
    public void onLooperPrepared() {
        isLooperReady = true;

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    public class MusicServiceBinder extends Binder{
        public MusicService getMusicServiceInstance(){
            return MusicService.this;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }
}
