package com.example.advweek4160420105.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emp.advweek4160420095.model.Student
//import com.example.advweek4160420105.model.Student

class ListViewModel:ViewModel() {
    val studentsLiveData = MutableLiveData<ArrayList<Student>>()
    val studentLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLiveData = MutableLiveData<Boolean>()

    fun refresh() {
        studentsLiveData.value = arrayListOf(
            Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100" +
                    ".jpg/cc0000/ffffff"),
            Student("13312","Rich","1994/12/14","3925444073","http://dummyimage.com/75x100" +
                    ".jpg/5fa2dd/ffffff"),
            Student("11204","Dinny","1994/10/07","6827808747",
                "http://dummyimage.com/75x100.jpg/5fa2dd/ffffff1")
        )

        studentLoadErrorLD.value = false
        loadingLiveData.value = false
    }

}
