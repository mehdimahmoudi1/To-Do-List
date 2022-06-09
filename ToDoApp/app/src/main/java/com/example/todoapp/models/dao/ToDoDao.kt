package com.example.todoapp.models.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todoapp.data.TodoData

@Dao
interface ToDoDao {

    @Query("SELECT * FROM todo_table order by id asc")
    fun getAll():LiveData<List<TodoData>>

    @Insert
    suspend fun insert(todoData: TodoData)

    @Update
    suspend fun update(todoData: TodoData)

    @Delete
    suspend fun delete(todoData: TodoData)
}