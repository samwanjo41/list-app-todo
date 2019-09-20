package com.example.sql.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Todo_table")
class Todo(
    @PrimaryKey @ColumnInfo(name = "title") val title: String,

    @ColumnInfo(name = "Description")
    val descr: String,

    @ColumnInfo(name = "Due_Date")
    val dueDate: String
)