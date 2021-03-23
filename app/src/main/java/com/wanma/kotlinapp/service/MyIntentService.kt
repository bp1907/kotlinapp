package com.wanma.kotlinapp.service

import android.app.IntentService
import android.content.Intent
import android.util.Log

/**
 * author: wanma
 * Date: 2021/3/12
 * Description
 */
class MyIntentService: IntentService("MyIntentService") {
    override fun onHandleIntent(intent: Intent?) {
        Log.d("MyIntentService", "Thread id is ${Thread.currentThread().name}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyIntentService", "onDestroy")
    }
}