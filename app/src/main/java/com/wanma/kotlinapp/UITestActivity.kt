package com.wanma.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_uitest.*

class UITestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uitest)

        button.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("alertDialog")
                setMessage("something important.")
                setCancelable(false)
                setPositiveButton("ok") {dialog, whitch ->}
                setNegativeButton("cancle") {dialog, which ->}
            }.show()
        }
    }
}
