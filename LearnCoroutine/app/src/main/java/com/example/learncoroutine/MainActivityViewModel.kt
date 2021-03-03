package com.example.learncoroutine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learncoroutine.model.DataLoop
import com.example.learncoroutine.repository.DataLoopRepositoryInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivityViewModel(val repositoryImpl: DataLoopRepositoryInterface) : ViewModel(){
    private lateinit var job : Job
    private var _dataLoopLiveData = MutableLiveData<ArrayList<DataLoop>>()
    val dataLoopLiveData : LiveData<ArrayList<DataLoop>>
        get() {
            return _dataLoopLiveData
        }

    fun playLoop(maxValue: Int){
        job = CoroutineScope(Dispatchers.Default).launch {
            for (i in 1..maxValue){
                launch {
                    if (i % 2 == 0){
                        repositoryImpl.add(DataLoop(i, "Genap"))
                    } else {
                        repositoryImpl.add(DataLoop(i, "Ganjil"))
                    }
                }
                _dataLoopLiveData.postValue(repositoryImpl.list())
            }
        }
    }

    fun stopLoop(){
        job.cancel()
    }
}


