package com.example.learncoroutine.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.learncoroutine.databinding.CardViewBinding
import com.example.learncoroutine.model.DataLoop

class DataLoopViewHolder(view: View) : RecyclerView.ViewHolder(view){
    private val binding = CardViewBinding.bind(view)

    fun bind(dataLoop:DataLoop){
        binding.apply {
            txtNumber.text = dataLoop.num.toString()
            txtDescribtion.text = dataLoop.description
        }
    }

}