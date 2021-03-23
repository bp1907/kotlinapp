package com.wanma.kotlinapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class TestBroadcastReceiverActivity : AppCompatActivity() {

//    lateinit var timeChangeReceiver: TimeChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_broadcast_receiver)
//        val intentFilter = IntentFilter()
//        intentFilter.addAction("android.intent.action.TIME_TICK")
//        timeChangeReceiver = TimeChangeReceiver()
//        registerReceiver(timeChangeReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
//        unregisterReceiver(timeChangeReceiver)
    }

    fun sendBroadcast(view: View) {
        val intent = Intent("com.wanma.test.mybroadcastreceiver")
        intent.setPackage(packageName)
//        sendBroadcast(intent)
        sendOrderedBroadcast(intent, null)
    }

//    inner class TimeChangeReceiver: BroadcastReceiver() {
//        override fun onReceive(context: Context?, intent: Intent?) {
//            Toast.makeText(context, "time has changed", Toast.LENGTH_SHORT).show()
//        }
//
//    }
}