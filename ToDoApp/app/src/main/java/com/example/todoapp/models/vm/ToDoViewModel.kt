package com.example.todoapp.models.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.todoapp.data.TodoData
import com.example.todoapp.models.repositories.ToDoRepository

class ToDoViewModel(application: Application):AndroidViewModel(application) {

    private var repasitorie : ToDoRepository = ToDoRepository(application)
    private var allToDOList = repasitorie.getAllToDo()

    suspend fun insert(toDoData:TodoData){
            repasitorie.insertToDo(toDoData)
    }

    fun getAllToDos():LiveData<List<TodoData>>{
        return allToDOList
    }

}