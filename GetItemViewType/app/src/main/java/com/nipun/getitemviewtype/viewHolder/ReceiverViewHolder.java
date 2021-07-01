package com.nipun.getitemviewtype.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nipun.getitemviewtype.R;
import com.nipun.getitemviewtype.model.receiver;

public class ReceiverViewHolder extends RecyclerView.ViewHolder {

    private TextView tvReceiverChatMessage;
    private TextView mTvTime;

    public ReceiverViewHolder(@NonNull View itemView) {
        super(itemView);
        tvReceiverChatMessage = itemView.findViewById(R.id.tvReceiverChatMessage);
        mTvTime = itemView.findViewById(R.id.tvTime);
    }

    public void setData(receiver receiver){
        mTvTime.setText(receiver.getTimestamp());
        tvReceiverChatMessage.setText(receiver.getMessage());
    }
}