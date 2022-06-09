package com.example.todoapp.fragments.list

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.adapters.MyListAdapter
import com.example.todoapp.databinding.FragmentListBinding
import com.example.todoapp.models.vm.ToDoViewModel


class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding
    private lateinit var listAdapter: MyListAdapter
    private lateinit var toDoViewModel: ToDoViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //set menu
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.list_fragment)
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater, container, false)


        val mainList = binding.mainList
        val layoutManager = LinearLayoutManager(requireActivity())
        mainList.layoutManager = layoutManager
        listAdapter = MyListAdapter()
        mainList.adapter = listAdapter

        toDoViewModel = ViewModelProvider(this)[ToDoViewModel::class.java]
        toDoViewModel.getAllToDos().observe(viewLifecycleOwner) { data ->
            listAdapter.setDataList(data)
        }

        mainList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0 && binding.floatingActionButton.visibility == View.VISIBLE) {
                    binding.floatingActionButton.hide()
                } else if (dy < 0 && binding.floatingActionButton.visibility != View.VISIBLE) {
                    binding.floatingActionButton.show()
                }
            }
        })

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        return binding.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.list_fragment_menu, menu)
    }
}