package com.wanma.kotlinapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.res.AssetManager
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.wanma.kotlinapp.broadcastreceiver.OfflineActivity
import com.wanma.kotlinapp.camera.CameraTestActivity
import com.wanma.kotlinapp.instance.InstanceActivity
import com.wanma.kotlinapp.instance.SQLiteActivity
import com.wanma.kotlinapp.notification.NotificationActivity
import com.wanma.kotlinapp.permission.ContactsActivity
import com.wanma.kotlinapp.permission.RuntimePermissionActivity
import com.wanma.kotlinapp.service.ServiceTestActivity
import com.wanma.kotlinapp.webview.WebViewTestActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//       var a = AssetManager()

        button1.setOnClickListener {
        }
        button2.setOnClickListener {
            val intent = Intent(this, UITestActivity::class.java)
            startActivity(intent)
        }
        button3.setOnClickListener {
            val intent = Intent(this, ListViewTestActivity::class.java)
            startActivity(intent)
        }
        button4.setOnClickListener {
            val intent = Intent(this, RecyclerViewTestActivity::class.java)
            startActivity(intent)
        }
        button5.setOnClickListener {
            val intent = Intent(this, CoroutineTestActivity::class.java)
            startActivity(intent)
        }
        button6.setOnClickListener {
            val intent = Intent(this, TestBroadcastReceiverActivity::class.java)
            startActivity(intent)
        }
        button7.setOnClickListener {
            val intent = Intent(this, OfflineActivity::class.java)
            startActivity(intent)
        }
        button8.setOnClickListener {
            val intent = Intent(this, InstanceActivity::class.java)
            startActivity(intent)
        }
        button9.setOnClickListener {
            val intent = Intent(this, SQLiteActivity::class.java)
            startActivity(intent)
        }
        button10.setOnClickListener {
            val intent = Intent(this, RuntimePermissionActivity::class.java)
            startActivity(intent)
        }
        button11.setOnClickListener {
            val intent = Intent(this, ContactsActivity::class.java)
            startActivity(intent)
        }
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        manager.cancel(1)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("normal", "Normal", NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }
        button12.setOnClickListener {
            val intent = Intent(this, NotificationActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this,0, intent, 0)

            val notification = NotificationCompat.Builder(this, "normal")
                .setContentTitle("I'm Title")
                .setContentText("I'm content,click me to get more message please!I'm content,click me to get more message please!" +
                        "I'm content,click me to get more message please!I'm content,click me to get more message please!")
//                .setStyle(NotificationCompat.BigTextStyle().bigText(""))
                .setSmallIcon(R.mipmap.logo)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_launcher_foreground))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build()
            manager.notify(1, notification)
        }
        button13.setOnClickListener {
            val intent = Intent(this, CameraTestActivity::class.java)
            startActivity(intent)
        }
        button14.setOnClickListener {
            val intent = Intent(this, ServiceTestActivity::class.java)
            startActivity(intent)
        }
        button15.setOnClickListener {
            val intent = Intent(this, WebViewTestActivity::class.java)
            startActivity(intent)
        }
    }
}
