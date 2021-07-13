package com.nipun.evaluation5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class DataAdapter(var responseList: Response, var onClickListner: OnClickListner) :
    RecyclerView.Adapter<DataViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return DataViewHolder(view, onClickListner)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val (_, results) = responseList
        holder.setData(position, results!![position])
    }

    override fun getItemCount(): Int {
        return responseList.results!!.size
    }

    fun updateList(responseList: Response) {
        this.responseList = responseList
        notifyDataSetChanged()
    }
}
