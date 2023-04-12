package com.example.studentform_withsqlitedb

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

class userinformationActivity : AppCompatActivity(), AdapterView.OnItemClickListener,
    AdapterView.OnItemLongClickListener {
    private lateinit var binding: ActivityUserinformationBinding
    lateinit var factory: sqliteFactory
    lateinit var viewmodel: squliteviewmodel

    private var rowId =0
    //private var position = 0
    private lateinit var cursor: Cursor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_userinformation)


        factory = sqliteFactory(sqliteRepository(this))
        viewmodel = ViewModelProvider(this, factory)[squliteviewmodel::class.java]


        // send the data of listview from baseadopter


            val listofstudents = viewmodel.getAllData()
            val myadapter = list_viewAdapter(listofstudents)
            binding.listView.adapter = myadapter







        // register the context manu
        registerForContextMenu(binding.listView)
        binding.listView.setOnItemClickListener(this)
        binding.listView.setOnItemLongClickListener(this)


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





    override fun onItemClick(adapter: AdapterView<*>?, view: View?, position: Int, rowItem: Long) {

            Toast.makeText(this, "$position", Toast.LENGTH_SHORT).show()

        }

        override fun onItemLongClick(adapter: AdapterView<*>?, view: View?, position: Int, rowItem: Long): Boolean {
            rowId=position
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

                cursor.moveToPosition(rowId)
                var id = cursor.getString(0)
                viewmodel.deletesingleRecord(rowId)

            }

            R.id.update->{
                Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
            }
        }

        return super.onContextItemSelected(item)
    }


}
