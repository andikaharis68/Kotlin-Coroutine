package com.example.learncoroutine.repository

import com.example.learncoroutine.model.DataLoop

class DataLoopRepositoryImpl : DataLoopRepositoryInterface {
    companion object {
        var dataLoopList = ArrayList<DataLoop>()
    }

    override fun add(dataLoop: DataLoop) {
        dataLoopList.add(dataLoop)
    }

    override fun clear() {
        dataLoopList.clear()
    }

    override fun list(): ArrayList<DataLoop> {
        return dataLoopList
    }
}