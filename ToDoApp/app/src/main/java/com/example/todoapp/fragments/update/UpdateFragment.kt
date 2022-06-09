package com.example.todoapp.fragments.update

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentUpdateBinding


class UpdateFragment : Fragment() {
    lateinit var binding : FragmentUpdateBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.update_fragment)
        binding = FragmentUpdateBinding.inflate(inflater,container,false)
        return  binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.update_fragment_manu,menu)
    }

}