package com.example.sql.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.sql.Data.Todo
import com.example.sql.Data.TodoRepository
import com.example.sql.Data.TodoRoomDatabase
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    // The ViewModel maintains a reference to the repository to get data.
    private val repository: TodoRepository
    // LiveData gives us updated words when they change.
    val allWords: LiveData<List<Todo>>

    init {
        // Gets reference to WordDao from WordRoomDatabase to construct
        // the correct WordRepository.
        val wordsDao = TodoRoomDatabase.getDatabase(application).todoDao()
        repository = TodoRepository(wordsDao)
        allWords = repository.allTodos
    }

    // The implementation of insert() is completely hidden from the UI.
    // We don't want insert to block the main thread, so we're launching a new
    // coroutine. ViewModels have a coroutine scope based on their lifecycle called
    // viewModelScope which we can use here.
    fun insert(todo: Todo) = viewModelScope.launch {
        repository.insert(todo)
    }
}