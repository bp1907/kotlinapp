package com.wanma.kotlinapp.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.wanma.kotlinapp.MainActivity

class BootCompleteReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "Boot Complete", Toast.LENGTH_LONG).show()
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }
}
