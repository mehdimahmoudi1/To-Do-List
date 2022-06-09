package com.example.todoapp.fragments.add

import android.app.Application
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.todoapp.R
import com.example.todoapp.data.TodoData
import com.example.todoapp.databinding.FragmentAddBinding
import com.example.todoapp.models.enums.Priority
import com.example.todoapp.models.vm.ToDoViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class AddFragment : Fragment() {
    lateinit var binding: FragmentAddBinding
    private lateinit var toDoViewModel: ToDoViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        setHasOptionsMenu(true)
        toDoViewModel = ToDoViewModel(context?.applicationContext as Application)
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.add_fragment)
        binding = FragmentAddBinding.inflate(inflater, container, false)
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> {
                        (parent?.getChildAt(0) as TextView).setTextColor(
                            ContextCompat.getColor(
                                context!!.applicationContext,
                                R.color.red
                            )
                        )
                    }
                    1 -> {
                        (parent?.getChildAt(0) as TextView).setTextColor(
                            ContextCompat.getColor(
                                context!!.applicationContext,
                                R.color.yellow
                            )
                        )
                    }
                    2 -> {
                        (parent?.getChildAt(0) as TextView).setTextColor(
                            ContextCompat.getColor(
                                context!!.applicationContext,
                                R.color.green
                            )
                        )
                    }
                }
            }

        }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_manu_fragment, menu)
    }

      override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.btn_add) {
            val edtTitle = binding.edtTitle.text.toString()
            val edtDes = binding.edtDescription.text.toString()
            val edtPriority = binding.spinner.selectedItem.toString()
            if(edtTitle == "" || edtDes == ""){
                Toast.makeText(context, "Please fill all fields!", Toast.LENGTH_SHORT).show()
                return false
            } else {
                val toDoData = TodoData(
                    0,
                    edtTitle,
                    edtDes,
                    parsePriority(edtPriority)
                )
                MainScope().launch {  toDoViewModel.insert(toDoData) }
                Toast.makeText(context, "New todo added ...", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_addFragment_to_listFragment)
            }

            //insertDataToDB()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun insertDataToDB() {

    }

    private fun parsePriority(priority: String): Priority {
        return when (priority) {
            "High Priority" -> Priority.High
            "Low Priority" -> Priority.Low
            "Medium Priority" -> Priority.Medium
            else -> Priority.High
        }
    }


}