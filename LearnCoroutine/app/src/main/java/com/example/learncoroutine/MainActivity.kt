package com.example.learncoroutine

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learncoroutine.databinding.ActivityMainBinding
import com.example.learncoroutine.recycler.DataLoopViewAdapter
import com.example.learncoroutine.repository.DataLoopRepositoryImpl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_view.*
import kotlinx.coroutines.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainActivityViewModel
    private lateinit var viewAdapter: DataLoopViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        subscribe()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            recycle_view.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                viewAdapter = DataLoopViewAdapter()
                adapter = viewAdapter
            }

            btStart.setOnClickListener {
                val maxValue = editTextInput.text.toString().toInt()
                viewModel.playLoop(maxValue)
            }
            btStop.setOnClickListener {
                viewModel.stopLoop()
            }
        }
    }

    private fun initViewModel(){
        viewModel = ViewModelProvider(this, object:ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val repositoryImpl = DataLoopRepositoryImpl()
                return MainActivityViewModel(repositoryImpl) as T
            }
        }).get(MainActivityViewModel::class.java)
    }

    private fun subscribe(){
        viewModel.dataLoopLiveData.observe(this) {
            viewAdapter.setDataLoop(it)
            binding.recycleView.adapter = viewAdapter
        }
    }
}
