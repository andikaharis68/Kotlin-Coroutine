import kotlinx.coroutines.*

fun exampleBlocking(){
    println("cetak 1")
    GlobalScope.launch {
        printWithNoCoroutine("cetak 2")
    }
    println("cetak 3")
}

suspend fun printWithNoCoroutine(message: String){
    delay(10000)
    print(message)
}

fun main(){
//    exampleBlocking()

}