package com.wanma.kotlinapp.instance

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.wanma.kotlinapp.R
import kotlinx.android.synthetic.main.activity_instance.*
import java.io.*
import java.lang.StringBuilder

class InstanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instance)
//        getSharedPreferences("data", Context.MODE_PRIVATE)
//        getPreferences(Context.MODE_PRIVATE)
        val content = load()
        if(content.isNotEmpty()) {
            fileSaveEdit.setText(content)
            fileSaveEdit.setSelection(content.length)
            Toast.makeText(this, "load succeeded", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val inputText = fileSaveEdit.text.toString()
        save(inputText)
    }

    private fun save(inputText: String) {
        try {
            val output = openFileOutput("file_data", Context.MODE_PRIVATE)
            val writer = BufferedWriter(OutputStreamWriter(output))
            writer.use {
                it.write(inputText)
            }
        }catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun load(): String {
        val content = StringBuilder()
        try {
            val input = openFileInput("file_data")
            val reader = BufferedReader(InputStreamReader(input))
            reader.use {
                reader.forEachLine {
                    content.append(it)
                }
            }
        }catch (e: IOException) {
            e.printStackTrace()
        }
        return content.toString()
    }
}