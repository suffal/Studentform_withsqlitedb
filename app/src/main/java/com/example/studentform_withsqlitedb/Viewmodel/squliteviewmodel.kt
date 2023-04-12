package com.example.studentform_withsqlitedb.Viewmodel

import android.database.Cursor
import androidx.lifecycle.ViewModel
import com.example.studentform_withsqlitedb.Repository.sqliteRepository
import com.example.studentform_withsqlitedb.students
import java.sql.RowId

class squliteviewmodel(private val repository: sqliteRepository):ViewModel() {


fun createData(fName:String ,lName:String,phone:String,Alphone:String,Email:String,Dob:String,Gender:String,course:String){
    repository.createdata(fName,lName,phone,Alphone,Email,Dob, Gender, course)
}

fun getAllData():ArrayList<students>{

return repository.getAlldata()

}


    // delete query to not need adaptar
fun deletesingleRecord(rowId:String){
    repository.deletesingleRecord(rowId)
}
 fun getdata():Cursor{
     return repository.getdata()
 }

}