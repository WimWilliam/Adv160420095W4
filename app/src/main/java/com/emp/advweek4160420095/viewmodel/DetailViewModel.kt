package com.example.advweek4160420095.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.emp.advweek4160420095.model.Student
import com.google.gson.Gson

class DetailViewModel {
    val studentLD= MutableLiveData<Student>()


    fun fetch(student_id:String) {

//        queue= Volley.newRequestQueue(getApplication())
        val student1 = Student(
            "16055", "Nonie", "1998/03/28", "5718444778",
            "http://dummyimage.com/75x100.jpg/cc0000/ffffff")
            studentLD.value = student1

    }
}