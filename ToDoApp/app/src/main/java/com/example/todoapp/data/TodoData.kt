package com.example.todoapp.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todoapp.models.enums.Priority
import kotlinx.parcelize.Parcelize

@Entity(tableName = "todo_table")
@Parcelize
data class TodoData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var title:String ,
    var description:String,
    var priority: Priority ,
) : Parcelable
