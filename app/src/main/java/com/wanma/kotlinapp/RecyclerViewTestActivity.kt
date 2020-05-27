package com.wanma.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view_test.*

class RecyclerViewTestActivity : AppCompatActivity() {

    private val tempData = listOf("Apple","Banana","Orange","Watermelon","Pear","Banana","Banana","Banana",
        "Grape","Pineapple","Banana","Banana","Strawberry","Banana","Cherry","Banana","Banana","Mongo"
        ,"Orange","Banana","Apple","Banana","Pear","Banana","Cherry","Banana")

    private var data = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {

        for(str in tempData) {
            data.add(getRandomLengthString(str))
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_test)

//        val layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        val adapter = FruitAdapter(data)
        recyclerView.adapter = adapter
    }

    private fun getRandomLengthString(str: String) : String {
        val n = (1..20).random()
        val builder = StringBuilder()
        repeat(n) {
            builder.append(str)
        }
        return builder.toString()
    }
}

class FruitAdapter(private val fruitList: List<String>) : RecyclerView.Adapter<FruitAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fruitName: TextView = view.findViewById(R.id.fruitName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fruit_item, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val str = fruitList[position]
            Toast.makeText(parent.context, "you clicked view $str", Toast.LENGTH_SHORT).show()
        }
        viewHolder.fruitName.setOnClickListener {
            val position = viewHolder.adapterPosition
            val str = fruitList[position]
            Toast.makeText(parent.context, "you clicked text $str", Toast.LENGTH_SHORT).show()
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.fruitName.text = fruit
    }

    override fun getItemCount(): Int = fruitList.size
}