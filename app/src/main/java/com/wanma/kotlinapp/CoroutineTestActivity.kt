package com.wanma.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_coroutine_test.*
import kotlinx.coroutines.*
import java.io.File

class CoroutineTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_test)
    }
}


fun main() {
    GlobalScope.launch {
       println("codes run in global scope")
    }
    runBlocking {
        println("codes run in coroutine scope")
        delay(1500)
        println("codes run in coroutine finished")
    }

    Thread.sleep(1000)
}