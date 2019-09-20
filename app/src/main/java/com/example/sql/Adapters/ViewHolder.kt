package com.example.sql.Adapters

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sql.R
import com.example.sql.Data.Todos

class TodosViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(todo: Todos){
        //itemView.findViewById<TextView>(R.id.createDate).setText(todo.createdAt)
        itemView.findViewById<TextView>(R.id.TodoTitle).setText(todo.title)
        itemView.findViewById<TextView>(R.id.descr).setText(todo.descr)
        itemView.findViewById<Button>(R.id.btnEdit)
        itemView.findViewById<Button>(R.id.btnDel)


    }
}