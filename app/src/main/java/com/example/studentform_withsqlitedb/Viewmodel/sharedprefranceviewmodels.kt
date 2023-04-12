package com.example.studentform_withsqlitedb.Viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.studentform_withsqlitedb.Keys
import com.example.studentform_withsqlitedb.Repository.sharedprefranceRepository

class sharedprefranceviewmodels(private val sharedPrefrepo: sharedprefranceRepository, private val context: Context):ViewModel() {




    fun saveData(fname:String,lname:String,phonenumber:String,usertype:String){

        sharedPrefrepo.getpreference(context).edit().putString(Keys.FNAME,fname ).commit()
        sharedPrefrepo.getpreference(context).edit().putString(Keys.LNAME, lname).commit()
        sharedPrefrepo.getpreference(context).edit().putString(Keys.MOBNO,phonenumber).commit()
        sharedPrefrepo.getpreference(context).edit().putString(Keys.usertype,usertype).commit()

    }

    fun getphone():String{
        val phoneNo = sharedPrefrepo.getpreference(context).getString(Keys.MOBNO,"")
        return phoneNo!!

    }
fun getusertype():String{
    val usertype=sharedPrefrepo.getpreference(context).getString(Keys.usertype," ")
    return usertype!!
}
}