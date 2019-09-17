package com.example.sql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_todo.*

class AddTodo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_todo)

        btnSave.setOnClickListener {
            if (editText1.text.isEmpty()) {
                Toast.makeText(this, "Enter Title", Toast.LENGTH_SHORT).show()
                editText1.requestFocus()
            } else {
                val todo = Todos()
                todo.title = editText1.text.toString()
                todo.descr = editText2.text.toString()
                MainActivity.dbHandler.addTodo(this, todo)
                ClearEdits()
                editText1.requestFocus()
            }
        }

        btnCancel.setOnClickListener {
            ClearEdits()
            finish()
        }

    }

    private fun ClearEdits() {
        editText1.text.clear()
        editText2.text.clear()
    }
}
