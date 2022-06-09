package com.example.todoapp.db

import android.content.Context
import androidx.room.*
import com.example.todoapp.convertor.ConvertPriority
import com.example.todoapp.models.dao.ToDoDao
import com.example.todoapp.data.TodoData

@Database(entities = [TodoData::class], version = 1)
@TypeConverters(ConvertPriority::class)
abstract class ToDoDatabese: RoomDatabase() {
    abstract fun toDoDao(): ToDoDao

    companion object {

        private var instance: ToDoDatabese? = null
        fun getInstance(context: Context): ToDoDatabese {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context, ToDoDatabese::class.java, "todo.db"
                ).fallbackToDestructiveMigration().build()
            }
            return instance as ToDoDatabese
        }
    }
}