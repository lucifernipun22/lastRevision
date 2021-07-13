package com.nipun.musicapp;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

public class DataViewHolder extends RecyclerView.ViewHolder {

    private TextView title, id;
    private ImageView Image;
    private Button btnPlay, btnPause, btnDelete;
    private OnClickListner onClickListner;
    int playing;
    public DataViewHolder(@NonNull @NotNull View itemView, OnClickListner onClickListner) {
        super(itemView);
        this.onClickListner = onClickListner;

        id = itemView.findViewById(R.id.id);
        title = itemView.findViewById(R.id.title1);
        Image = itemView.findViewById(R.id.trackImage);
        btnPlay = itemView.findViewById(R.id.btnPlay);
        btnPause = itemView.findViewById(R.id.btnPause);
        btnDelete = itemView.findViewById(R.id.btnDelete);
    }
    public void setData(int pos, Result result){
        id.setText(result.getArtistName());
        title.setText(result.getTrackName());
        Glide.with(Image).load(result.getArtworkUrl100()).into(Image);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playing = pos;
                onClickListner.playMusic(pos,result);
            }
        });
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(playing == pos){
                    onClickListner.pauseMusic();
                }
                playing =-1;
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(playing ==-1){
                    onClickListner.delete(pos);
                }
                else if(playing == pos){
                    playing =-1;
                    onClickListner.pauseMusic();
                    onClickListner.delete(pos);
                }
                else {
                    onClickListner.delete(pos);
                }
                Toast.makeText(v.getContext(), result.getTrackName()+"is delete", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
