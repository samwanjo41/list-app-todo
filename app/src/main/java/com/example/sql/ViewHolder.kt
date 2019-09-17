package com.example.sql

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodosViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(todo: Todos){
        //itemView.findViewById<TextView>(R.id.createDate).setText(todo.createdAt)
        itemView.findViewById<TextView>(R.id.TodoTitle).setText(todo.title)
        itemView.findViewById<TextView>(R.id.descr).setText(todo.descr)
        itemView.findViewById<Button>(R.id.btnEdit)
        itemView.findViewById<Button>(R.id.btnDel)


    }
}