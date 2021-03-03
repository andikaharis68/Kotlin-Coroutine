package com.example.learncoroutine.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learncoroutine.R
import com.example.learncoroutine.model.DataLoop

class DataLoopViewAdapter : RecyclerView.Adapter<DataLoopViewHolder>() {
    private var dataLoopAdapter = ArrayList<DataLoop>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataLoopViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val cardView = inflater.inflate(R.layout.card_view, parent, false)
        return DataLoopViewHolder(cardView)
    }

    override fun getItemCount(): Int {
        return dataLoopAdapter.size
    }

    override fun onBindViewHolder(holder: DataLoopViewHolder, position: Int) {
        return holder.bind(dataLoopAdapter[position])
    }

    fun setDataLoop(dataLoopAdapter : ArrayList<DataLoop>){
        dataLoopAdapter.addAll(dataLoopAdapter)
        notifyDataSetChanged()
    }
}