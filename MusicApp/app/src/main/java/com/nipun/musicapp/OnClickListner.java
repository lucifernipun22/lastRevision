package com.nipun.musicapp;

public interface OnClickListner {
    void playMusic(int pos, Result result);
    void pauseMusic();
    void delete(int pos);
}
