package com.wanma.kotlinapp

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
        }
        button2.setOnClickListener {
            val intent = Intent(this, UITestActivity::class.java)
            startActivity(intent)
        }
    }
}
