package com.emp.advweek4160420095.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.emp.advweek4160420095.R
import com.emp.advweek4160420095.databinding.FragmentStudentListBinding
import com.example.advweek4160420105.viewmodel.ListViewModel

class StudentListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    private val studentListAdapter  = StudentListAdapter(arrayListOf())
    private lateinit var binding: FragmentStudentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_list, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        binding.recView.layoutManager = LinearLayoutManager(context)
        binding.recView.adapter = studentListAdapter

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.studentsLiveData.observe(viewLifecycleOwner, Observer {
            studentListAdapter.updateStudentList(it)
        })

        viewModel.studentLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                binding.txtEror?.visibility = View.VISIBLE
            } else {
                binding.txtEror?.visibility = View.GONE
            }
        })

        viewModel.loadingLiveData.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                binding.recView.visibility = View.GONE
                binding.progressload.visibility = View.VISIBLE
            } else {
                binding.recView.visibility = View.VISIBLE
                binding.progressload.visibility = View.GONE
            }
        })


    }



}