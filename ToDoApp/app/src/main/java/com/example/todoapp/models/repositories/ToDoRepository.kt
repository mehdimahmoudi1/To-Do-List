package com.example.todoapp.models.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.todoapp.models.dao.ToDoDao
import com.example.todoapp.data.TodoData
import com.example.todoapp.db.ToDoDatabese

class ToDoRepository(application: Application) {

    private  var toDoDao: ToDoDao
    private  var getAllToDos: LiveData<List<TodoData>>

    init {
        val database = ToDoDatabese.getInstance(application)
        toDoDao = database.toDoDao()
        getAllToDos = toDoDao.getAll()

    }
    suspend fun insertToDo(toDoData: TodoData) {
        toDoDao.insert(toDoData)

    }

    fun getAllToDo(): LiveData<List<TodoData>> {
        return getAllToDos
    }

}