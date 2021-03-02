package com.example.learncoroutine

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    var start = true
    var startValue = 1
    var max = 0
    var time = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun inputValue(view: View?){
        if(view == input_bt){
            if (input_et.text.toString() == ""){
                Toast.makeText(this, "you must input number", Toast.LENGTH_SHORT).show()
            } else {
                max = input_et.text.toString().toInt()
                progressBar.max = max
                max_value.text = "Max Value = $max"
                startValue = 1
            }
        }
    }

    fun startProgress(view: View?){
        thread(true) {
            if (view == pencet){
                start = true
                for (i in startValue..max){
                    Thread.sleep(1000)
                    time = i * 1000.0
                    startValue = i
                    if (!start){
                        break
                    }
                    runOnUiThread{
                        progressBar.progress = i
                        if(i%2==0){
                            tv_value.text = "$i Genap"
                        } else {
                            tv_value.text = "$i Ganjil"
                        }
                        time_tv.text = "Total Time = $time ms"
                        pencet?.isEnabled = false
                    }
                }
                runOnUiThread {
                    pencet?.isEnabled = true
                }
            }
        }
    }

    fun stopProgress(view: View?){
        if (view == stop_bt){
            start = false
        }
    }
}
