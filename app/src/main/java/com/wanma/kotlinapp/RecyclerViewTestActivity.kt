package com.wanma.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view_test.*

class RecyclerViewTestActivity : AppCompatActivity() {

    private val data = listOf("Apple","Banana","Orange","Watermelon","Pear","Banana","Banana","Banana",
        "Grape","Pineapple","Banana","Banana","Strawberry","Banana","Cherry","Banana","Banana","Mongo"
        ,"Orange","Banana","Apple","Banana","Pear","Banana","Cherry","Banana")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_test)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = FruitAdapter(data)
        recyclerView.adapter = adapter
    }
}

class FruitAdapter(private val fruitList: List<String>) : RecyclerView.Adapter<FruitAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fruitName: TextView = view.findViewById(R.id.fruitName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fruit_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.fruitName.text = fruit
    }

    override fun getItemCount(): Int = fruitList.size
}