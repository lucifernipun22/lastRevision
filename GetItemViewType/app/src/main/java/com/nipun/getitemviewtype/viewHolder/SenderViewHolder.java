package com.nipun.getitemviewtype.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nipun.getitemviewtype.R;
import com.nipun.getitemviewtype.model.sender;

import org.jetbrains.annotations.NotNull;

public class SenderViewHolder extends RecyclerView.ViewHolder {
    private TextView tvMessage;
    public SenderViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        tvMessage = itemView.findViewById(R.id.tvSenderChatMessage);
    }
    public void setDataChange(sender sender){
        tvMessage.setText(sender.getMessage());
    }
}
