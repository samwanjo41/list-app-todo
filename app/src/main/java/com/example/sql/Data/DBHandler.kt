package com.example.sql.Data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.lang.Exception

class DBHandler (context: Context, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) :
    SQLiteOpenHelper(context,
        DATABASE_NAME, factory,
        DATABASE_VERSION
    ) {

    companion object {
        //table name, version and columns
        private val DATABASE_NAME = "MyDb.db"
        private val DATABASE_VERSION = 1

        val TODOS_TABLE_NAME = "Todos"
        val COLUMN_TODOID = "Todoid"
        val COLUMN_TODOTITLE = "Todotitle"
        val COLUMN_TODODESCR = "tododescr"

    }

    override fun onCreate(db: SQLiteDatabase?) {
val CREATE_TODOS_TABLE = ("CREATE TABLE $TODOS_TABLE_NAME("+ "$COLUMN_TODOID INTEGER PRIMARY KEY AUTOINCREMENT," +
        "$COLUMN_TODOTITLE TEXT," +
        "$COLUMN_TODODESCR TEXT)")
        db?.execSQL(CREATE_TODOS_TABLE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    fun getTodos(mctx: Context): ArrayList<Todos>{
        val qry = "Select * From $TODOS_TABLE_NAME"
        val db = this.readableDatabase
        val cursor = db.rawQuery(qry, null)
        val todos = ArrayList<Todos>()

        if(cursor.count == 0) {
            Toast.makeText(mctx, "No records Found", Toast.LENGTH_SHORT).show()
        } else {
            while(cursor.moveToNext()){
                val todo = Todos()
                todo.todosID = cursor.getInt(cursor.getColumnIndex(COLUMN_TODOID))
                todo.title = cursor.getString((cursor.getColumnIndex(COLUMN_TODOTITLE)))
                todo.descr = cursor.getString((cursor.getColumnIndex(COLUMN_TODODESCR)))
                todos.add(todo)
            }
            Toast.makeText(mctx, "${cursor.count.toString()} Records Found", Toast.LENGTH_SHORT).show()
        }
cursor.close()
        db.close()
        return todos

    }

    fun addTodo(mctx: Context, todos: Todos){
        val values = ContentValues()
        values.put(COLUMN_TODOTITLE, todos.title)
        values.put(COLUMN_TODODESCR, todos.descr)
        val db = this.writableDatabase
        try {
           db.insert(TODOS_TABLE_NAME, null, values)
            Toast.makeText(mctx, "Todo Added", Toast.LENGTH_SHORT).show()
        } catch (e: Exception){
Toast.makeText(mctx, e.message, Toast.LENGTH_SHORT).show()
        }
        db.close()
    }
}