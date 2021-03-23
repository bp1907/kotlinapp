package com.wanma.kotlinapp.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * author: wanma
 * Date: 2021/3/5
 * Description
 */
class AnotherBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "received another_broadcast", Toast.LENGTH_SHORT).show()
        abortBroadcast()
    }
}