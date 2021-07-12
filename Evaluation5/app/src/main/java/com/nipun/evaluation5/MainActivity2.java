package com.nipun.evaluation5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity2 extends AppCompatActivity implements OnClickListner {

    private Button button;
    private RecyclerView recyclerView;
    private Response responseList;
    private DataAdapter dataAdapter;
    private EditText editText;
    public MediaPlayer mediaPlayer = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = findViewById(R.id.btn);
        recyclerView = findViewById(R.id.recyclerView);
        editText = findViewById(R.id.editSearch);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });

    }
    private void callApi(){
        String str = editText.getText().toString();
        ApiService apiService = Network.getInstance().create(ApiService.class);
        apiService.getUser(str).enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                setRecyclerView(responseList);
                if(response.body()!= null){
                    responseList = response.body();
                    dataAdapter.updateList(responseList);
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
            }
        });
    }

    private void setRecyclerView(Response responseList) {
        dataAdapter = new DataAdapter(responseList, this);
        dataAdapter.notifyDataSetChanged();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(dataAdapter);
    }

    @Override
    public void playMusic(int pos, Result result) {
        mediaPlayer.reset();
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(result.getPreviewUrl());
            mediaPlayer.prepare();
        } catch (IOException e){
            e.printStackTrace();
        }
        mediaPlayer.start();
    }

    @Override
    public void pauseMusic() {
        mediaPlayer.stop();

    }

    @Override
    public void delete(int pos) {
        responseList.getResults().remove(pos);
        dataAdapter.updateList(responseList);
    }

}