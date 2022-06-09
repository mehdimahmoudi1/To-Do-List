package com.example.todoapp.convertor

import androidx.room.TypeConverter
import com.example.todoapp.models.enums.Priority

class ConvertPriority {
    @TypeConverter
    fun fromPriority(priority: Priority):String{
        return priority.name
    }

    @TypeConverter
    fun toPriority(priority: String): Priority {
        return Priority.valueOf(priority)
    }
}