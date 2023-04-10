package com.example.studentform_withsqlitedb.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.studentform_withsqlitedb.Repository.sharedprefranceRepository
import com.example.studentform_withsqlitedb.Viewmodel.sharedprefranceviewmodels

class sharedprefrenceviewmodelfactory(private val sharedPrefrepo: sharedprefranceRepository, private val context: Context):ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(sharedprefranceviewmodels::class.java)){
            return sharedprefranceviewmodels(sharedPrefrepo, context) as T
        }
        throw IllegalArgumentException("Unknown class")
    }



}

