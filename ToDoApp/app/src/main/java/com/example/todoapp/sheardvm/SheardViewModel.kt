package com.example.todoapp.sheardvm

import android.app.Application
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView

import androidx.lifecycle.AndroidViewModel

import com.example.todoapp.models.enums.Priority

class SheardViewModel(application: Application) : AndroidViewModel(application) {

    fun varifyDataFromUser(title: String, desc: String): Boolean {
        return if (TextUtils.isEmpty(title) || TextUtils.isEmpty(desc)) {
            false
        } else !(title.isEmpty() || desc.isEmpty())
    }

    fun parsePriority(priority: String): Priority {
        return when (priority) {
            "High Priority" -> Priority.High
            "Low Priority" -> Priority.Low
            "Medium Priority" -> Priority.Medium
            else -> Priority.High
        }
    }
}