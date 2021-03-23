package com.wanma.kotlinapp.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * author: wanma
 * Date: 2021/3/3
 * Description
 */
class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "received broadcast", Toast.LENGTH_SHORT).show()
    }
}