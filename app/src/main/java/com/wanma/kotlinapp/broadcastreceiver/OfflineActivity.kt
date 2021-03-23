package com.wanma.kotlinapp.broadcastreceiver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.wanma.kotlinapp.BaseActivity
import com.wanma.kotlinapp.R
import com.wanma.kotlinapp.TestActivity
import kotlinx.android.synthetic.main.activity_offline.*

class OfflineActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offline)

        login.setOnClickListener {
            val account = accountEdit.text.toString()
            val password = passwordEdit.text.toString()
//            if(account == "admin" && password == "123456") {
                val intent = Intent(this, TestActivity::class.java)
                startActivity(intent)
                finish()
//            }else {
//                Toast.makeText(this, "account or password is invalid", Toast.LENGTH_SHORT).show()
//            }
        }
    }
}