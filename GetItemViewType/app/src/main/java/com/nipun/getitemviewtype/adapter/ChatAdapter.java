package com.nipun.getitemviewtype.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nipun.getitemviewtype.R;
import com.nipun.getitemviewtype.model.BaseModel;
import com.nipun.getitemviewtype.model.receiver;
import com.nipun.getitemviewtype.model.sender;
import com.nipun.getitemviewtype.viewHolder.ReceiverViewHolder;
import com.nipun.getitemviewtype.viewHolder.SenderViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<BaseModel> baseModelList;
 public ChatAdapter(List<BaseModel> baseModelList){
     this.baseModelList = baseModelList;
 }
    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sender,parent,false);
                return new SenderViewHolder(view);
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receiver,parent,false);
                return new ReceiverViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {

        int viewType = baseModelList.get(position).getItemType();
        BaseModel model = baseModelList.get(position);
        switch (viewType) {
            case 1:
                if (holder instanceof SenderViewHolder) {
                    ((SenderViewHolder) holder).setDataChange((sender) model);
                }
                break;
            case 2:
                if (holder instanceof ReceiverViewHolder) {
                    ((ReceiverViewHolder) holder).setData((receiver) model);
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        return baseModelList.size();
    }
    @Override
    public int getItemViewType(int position) {
        return baseModelList.get(position).getItemType();
    }

}
