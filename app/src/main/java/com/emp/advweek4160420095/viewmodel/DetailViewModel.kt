package com.example.advweek4160420095.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.emp.advweek4160420095.model.Student
import com.google.gson.Gson

class DetailViewModel(application: Application):AndroidViewModel(application){
    val studentLD= MutableLiveData<Student>()
    val TAG = "wtag"
    private  var queue:RequestQueue? = null

    fun fetch(student_id:String) {

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://adv.jitusolution.com/student.php?id=$student_id"
        val stringRequest = StringRequest(
            Request.Method.GET, url, {
                //val sType=object : TypeToken<Student>(){}.type
                val result = Gson().fromJson<Student>(it, Student::class.java)
                studentLD.value = result

                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
            }
        )
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
    //        val student1 = Student(
//            "16055", "Nonie", "1998/03/28", "5718444778",
//            "http://dummyimage.com/75x100.jpg/cc0000/ffffff")
//            studentLD.value = student1
//
}

