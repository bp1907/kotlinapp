package com.wanma.kotlinapp.instance

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.wanma.kotlinapp.R
import kotlinx.android.synthetic.main.activity_s_q_lite.*

class SQLiteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_s_q_lite)

        val dbHelper = MyDatabaseHelper(this, "BookStore.db", 2)

        createDatabase.setOnClickListener {
            dbHelper.readableDatabase
        }

        insert.setOnClickListener {
            val db = dbHelper.writableDatabase
            val values1 = ContentValues().apply {
                put("name", "三国演义")
                put("author", "罗贯中")
                put("pages", 568)
                put("price", 15.5)
            }
            db.insert("Book", null, values1)
            val values2 = ContentValues().apply {
                put("name", "西游记")
                put("author", "吴承恩")
                put("pages", 566)
                put("price", 15.8)
            }
            db.insert("Book", null, values2)
        }

        update.setOnClickListener {
            val db = dbHelper.readableDatabase
            val values = ContentValues()
            values.put("price", 20)
            values.put("pages", 1000)

            db.update("Book", values, "name=? or author=?", arrayOf("三国演义", "吴承恩"))
            Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show()
        }
    }
}