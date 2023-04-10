package com.example.studentform_withsqlitedb.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.studentform_withsqlitedb.Repository.sqliteRepository
import com.example.studentform_withsqlitedb.Viewmodel.sharedprefranceviewmodels
import com.example.studentform_withsqlitedb.Viewmodel.squliteviewmodel

class sqliteFactory(private val repository: sqliteRepository): ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(squliteviewmodel::class.java)){
            return squliteviewmodel(repository) as T
        }
        throw IllegalArgumentException("Unknown class")
    }



}

