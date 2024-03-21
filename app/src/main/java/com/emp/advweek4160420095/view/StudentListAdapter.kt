package com.emp.advweek4160420095.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.emp.advweek4160420095.databinding.StudentListItemBinding
import com.emp.advweek4160420095.model.Student


class StudentListAdapter(val studentList:ArrayList<Student>)
    :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):StudentViewHolder {
        val binding = StudentListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)

    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.binding.txtId.text = studentList[position].id
        holder.binding.txtNama.text = studentList[position].name

        holder.binding.btnDetail.setOnClickListener {
            val action = StudentListFragmentDirections.actionStudentDetailFragment()
            Navigation.findNavController(it).navigate(action)
        }

    }

    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return studentList.size
    }

    class StudentViewHolder(var binding: StudentListItemBinding)
        :RecyclerView.ViewHolder(binding.root)
}

