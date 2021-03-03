package com.example.learncoroutine.repository

import com.example.learncoroutine.model.DataLoop

interface DataLoopRepositoryInterface {
    fun add(dataLoop : DataLoop)
    fun clear()
    fun list(): ArrayList<DataLoop>
}