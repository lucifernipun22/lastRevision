package com.nipun.musicapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;



public class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {
    OnClickListner onClickListner;
    Response responseList;
    public DataAdapter(Response responseList , OnClickListner onClickListner){
        this.onClickListner = onClickListner;
        this.responseList = responseList;
    }
    @NonNull
    @NotNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);

        return new DataViewHolder(view, onClickListner);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DataViewHolder holder, int position) {

        Response response = responseList;
        holder.setData(position,response.getResults().get(position));
    }

    @Override
    public int getItemCount() {
        return responseList.getResults().size();
    }
    public void updateList(Response responseList){
        this.responseList = responseList;
        notifyDataSetChanged();
    }
}
