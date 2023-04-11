package com.example.studentform_withsqlitedb.Viewmodel

import androidx.lifecycle.ViewModel
import com.example.studentform_withsqlitedb.Repository.sqliteRepository
import com.example.studentform_withsqlitedb.students

class squliteviewmodel(private val repository: sqliteRepository):ViewModel() {


fun createData(fName:String ,lName:String,phone:String,Alphone:String,Email:String,Dob:String,Gender:String,course:String){
    repository.createdata(fName,lName,phone,Alphone,Email,Dob, Gender, course)
}

fun getAllData():ArrayList<students>{

return repository.getAlldata()

}



}