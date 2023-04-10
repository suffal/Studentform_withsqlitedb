package com.example.studentform_withsqlitedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.studentform_withsqlitedb.databinding.ActivityUserformBinding

class userinformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserformBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil.setContentView(this,R.layout.activity_userinformation)




    }
}