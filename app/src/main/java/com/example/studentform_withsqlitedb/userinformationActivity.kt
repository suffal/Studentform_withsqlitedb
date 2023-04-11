package com.example.studentform_withsqlitedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TableRow
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.studentform_withsqlitedb.Repository.sqliteRepository
import com.example.studentform_withsqlitedb.Viewmodel.squliteviewmodel
import com.example.studentform_withsqlitedb.adapter.list_viewAdapter
import com.example.studentform_withsqlitedb.databinding.ActivityUserformBinding
import com.example.studentform_withsqlitedb.databinding.ActivityUserinformationBinding
import com.example.studentform_withsqlitedb.factory.sqliteFactory
import java.text.FieldPosition

class userinformationActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private lateinit var binding:ActivityUserinformationBinding
    lateinit var factory: sqliteFactory
    lateinit var viewmodel: squliteviewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil.setContentView(this,R.layout.activity_userinformation)


        factory = sqliteFactory(sqliteRepository(this))
        viewmodel = ViewModelProvider(this, factory)[squliteviewmodel::class.java]



       // Log.d("listofstudents","$listofstudents")
       // val arrayAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,listofstudents)

       // binding.listView.adapter=arrayAdapter

        // send the data of listview from baseadopter
        val listofstudents=viewmodel.getAllData()
        val myadapter = list_viewAdapter(listofstudents)
        binding.listView.adapter=myadapter



        binding.listView.setOnItemClickListener(this)




    }

    override fun onItemClick(adapter: AdapterView<*>?, view: View?, position: Int, rowItem: Long) {

        Toast.makeText(this, "$position", Toast.LENGTH_SHORT).show()








    }


}