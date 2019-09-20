package com.example.sql.Data

import androidx.lifecycle.LiveData

class TodoRepository(private val todoDao: TodoDao) {
    val allTodos: LiveData<List<Todo>> = todoDao.getAllWords()

    suspend fun insert(todo: Todo){
        todoDao.insert(todo)
    }
}