package com.enigma.coroutine

import kotlinx.coroutines.*

//suspend fun main() = coroutineScope {
//    var defered : Deferred<Int> = async {
//        loadData()
//    }
//    println("waiting..")
//    println(defered.await())
//}
//
//suspend fun loadData(): Int {
//    println("loading..")
//    delay(3000)
//    println("loaded")
//    return 42
//}


suspend fun main() = coroutineScope {
//    async -> fungsinya adalah menjalankan proses dan mengembalikan nilai
    val numbers: Deferred<IntRange> = async { getRangeNumber() }
//    launch -> menjalankan proses saja tanpa return nilai
    launch {
        val result = numbers.await().map { produceNumber(it) }
        println(mapOf("result: " to result))
    }
    println("Starting...")
}

suspend fun getRangeNumber(): IntRange {
    return 0..5
}

suspend fun produceNumber (value: Int) : Int {
    println("Mock delay to produce data $value")
    delay(1000)
    return value * value
}