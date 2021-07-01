package com.nipun.getitemviewtype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nipun.getitemviewtype.adapter.ChatAdapter;
import com.nipun.getitemviewtype.model.BaseModel;
import com.nipun.getitemviewtype.model.receiver;
import com.nipun.getitemviewtype.model.sender;

import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<BaseModel> baseModels = new ArrayList<>();
    private RecyclerView recyclerView;
    private EditText etChat;
    private EditText etSelect;
    private Button btSend;
    private ChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setRecyclerView();
        chat();

    }

    private void chat() {
        if(etSelect.getText().toString().equals("1")){
            baseModels.add(new sender(etChat.getText().toString()));

        }else if(etSelect.getText().toString().equals("2")){
            baseModels.add(new receiver(etChat.getText().toString(),getFormateDate()));
        }
        chatAdapter.notifyDataSetChanged();

    }

    private void setRecyclerView() {

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        chatAdapter= new ChatAdapter(baseModels);
        recyclerView.setAdapter(chatAdapter);
    }

    private void initView() {

        recyclerView = findViewById(R.id.rcyclerView);
        etChat = findViewById(R.id.etChatMessage);
        etSelect = findViewById(R.id.etUserSelect);
        btSend = findViewById(R.id.btnSend);
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chat();
            }
        });
    }

    public String getFormateDate(){
        Timestamp timestamp = new Timestamp((System.currentTimeMillis()));
        Date date = new Date(timestamp.getTime());
        Format format = new SimpleDateFormat("HH.mm");
        return format.format(date);
    }
}