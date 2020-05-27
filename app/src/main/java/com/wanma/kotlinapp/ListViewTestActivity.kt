package com.wanma.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_view_test.*

class ListViewTestActivity : AppCompatActivity() {

    private val data = listOf("Apple","Banana","Orange","Watermelon","Pear","Banana","Banana","Banana",
        "Grape","Pineapple","Banana","Banana","Strawberry","Banana","Cherry","Banana","Banana","Mongo"
        ,"Orange","Banana","Apple","Banana","Pear","Banana","Cherry","Banana")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_test)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
        listView.adapter = adapter
    }
}
