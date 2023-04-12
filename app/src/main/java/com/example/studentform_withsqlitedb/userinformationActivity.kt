package com.example.studentform_withsqlitedb

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.icu.text.Transliterator.Position
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
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

class userinformationActivity : AppCompatActivity(),
    AdapterView.OnItemLongClickListener {
    private lateinit var binding: ActivityUserinformationBinding
    lateinit var factory: sqliteFactory
    lateinit var viewmodel: squliteviewmodel


    private var position = 0
    private lateinit var cursor: Cursor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_userinformation)
        factory = sqliteFactory(sqliteRepository(this))
        viewmodel = ViewModelProvider(this, factory)[squliteviewmodel::class.java]
        // register the context manu
        registerForContextMenu(binding.listView)
        //binding.listView.setOnItemClickListener(this)
        binding.listView.setOnItemLongClickListener(this)
               setlistview()

        // send the data of listview from baseadopter


//            val listofstudents = getAllData()
//            val myadapter = list_viewAdapter(listofstudents)
//            binding.listView.adapter = myadapter
//








    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.delete_all, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.deleteAll -> {

                return true
            }
        }


        return super.onOptionsItemSelected(item)
    }





//    override fun onItemClick(adapter: AdapterView<*>?, view: View?, position: Int, rowItem: Long) {
//
//            Toast.makeText(this, "$position", Toast.LENGTH_SHORT).show()
//
//        }




    override fun onItemLongClick(adapter: AdapterView<*>?, view: View?, position: Int, rowItem: Long): Boolean {

        this.position  = position

            return false

        }

        override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
            super.onCreateContextMenu(menu, v, menuInfo)
            menuInflater.inflate(R.menu.context_manu, menu)
        }


    // creat  a context manu
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.delete->{

                cursor.moveToPosition(position)
//                var id = cursor.getString(0)
               val rowId= cursor.getString(0)
               viewmodel.deletesingleRecord(rowId)
                setlistview()
            }

            R.id.update->{
                Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
            }
        }

        return super.onContextItemSelected(item)
    }


    // use the code of delete the data so direct put the data
private fun getAllData():ArrayList<students>{

    cursor=viewmodel.getdata()
    var listofstudent1=ArrayList<students>()
    if(cursor.count>0){

        cursor.moveToFirst()
        do {
            val SrNo= cursor.getString(0)
            val FirstName= cursor.getString(1)
            val LastName= cursor.getString(2)
            val PhoneNo= cursor.getString(3)
            val AlPhoneNo= cursor.getString(4)
            val Email= cursor.getString(5)
            val Dob= cursor.getString(6)
            val gender= cursor.getString(7)
            val course= cursor.getString(8)


            val Student=students(SrNo,FirstName,LastName,PhoneNo,AlPhoneNo,Email,Dob,gender,course)

            listofstudent1.add(Student)

        }while (cursor.moveToNext())

    }else{
        Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show()
    }

    return listofstudent1
}
    fun setlistview() {
        val listofstudents = getAllData()
        val myadapter = list_viewAdapter(listofstudents)
        binding.listView.adapter = myadapter


    }

}


