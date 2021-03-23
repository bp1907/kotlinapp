package com.wanma.kotlinapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.test.*

/**
 * author: wanma
 * Date: 2021/2/4
 * Description
 */
class TestActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test)

        driver_next.setOnClickListener {
            val intent = Intent("com.wanma.kotlinapp.broadcastreceiver.FORCE_OFFLINE")
            sendBroadcast(intent)
        }
    }


}