package com.example.sql.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.sql.R
import com.example.sql.Data.Todos

class TodosAdapter : ListAdapter<Todos, TodosViewHolder>(object : DiffUtil.ItemCallback<Todos>() {
    override fun areItemsTheSame(oldItem: Todos, newItem: Todos): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: Todos, newItem: Todos): Boolean = oldItem == newItem
})

{



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return TodosViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodosViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}