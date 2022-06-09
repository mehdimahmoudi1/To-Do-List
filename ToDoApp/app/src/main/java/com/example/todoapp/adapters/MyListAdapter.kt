package com.example.todoapp.adapters

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.data.TodoData
import com.example.todoapp.models.enums.Priority


class MyListAdapter(
) : RecyclerView.Adapter<MyListAdapter.ToDoHolder>() {

    private val dataList = ArrayList<TodoData>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoHolder {
        return ToDoHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.row_item, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ToDoHolder, position: Int) {
        val items = dataList[position]
        holder.txtTitle.text = items.title
        holder.description.text = items.description
        when (items.priority) {
            Priority.High -> {
                holder.priorityIndicator.setCardBackgroundColor(Color.RED)
            }
            Priority.Medium -> {
                holder.priorityIndicator.setCardBackgroundColor(Color.YELLOW)
            }
            Priority.Low -> {
                holder.priorityIndicator.setCardBackgroundColor(Color.GREEN)
            }
        }

        holder.listBackgrund?.setOnClickListener {

            holder.listBackgrund?.findNavController()!!
                .navigate(R.id.action_listFragment_to_updateFragment)

        }
    }

    fun setDataList(list: List<TodoData>) {
        dataList.clear()
        dataList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ToDoHolder(v: View) : RecyclerView.ViewHolder(v) {

        var txtTitle: TextView = v.findViewById(R.id.txt_title)
        var description: TextView = v.findViewById(R.id.txt_description)
        var priorityIndicator: CardView = v.findViewById(R.id.priority_card)
        var listBackgrund: View? = v.findViewById(R.id.list_backgrund)
    }


}