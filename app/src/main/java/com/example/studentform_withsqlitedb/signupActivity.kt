package com.example.studentform_withsqlitedb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TableRow
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.studentform_withsqlitedb.Repository.sharedprefranceRepository
import com.example.studentform_withsqlitedb.Viewmodel.sharedprefranceviewmodels
import com.example.studentform_withsqlitedb.databinding.ActivitySignupBinding
import com.example.studentform_withsqlitedb.factory.sharedprefrenceviewmodelfactory

class signupActivity : AppCompatActivity(), View.OnClickListener,
    AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivitySignupBinding
    lateinit var viewmodelFactory: sharedprefrenceviewmodelfactory
    lateinit var viewmodel: sharedprefranceviewmodels

    val Item = arrayOf("Guest", "HR", "Cunsultant", "Faculty", "Admin")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        getSupportActionBar()?.hide()



        val ItemAdapter = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, Item)
        binding.spinner.adapter = ItemAdapter

          binding.spinner.onItemSelectedListener=this  // to use click listener on the spinner view to use Itemselectedlistener

        binding.AlreadyIHaveAAccount.setOnClickListener(this)
        binding.btnSignupSignupactivity.setOnClickListener(this)



        viewmodelFactory =  sharedprefrenceviewmodelfactory(sharedprefranceRepository,this)
        viewmodel = ViewModelProvider(this, viewmodelFactory)[sharedprefranceviewmodels::class.java]




    }

    override fun onClick(View: View?) {
        when (View?.id) {


            R.id.Already_I_have_a_account -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_signup_signupactivity -> {


                if (binding.SFname.editableText!!.isEmpty() && binding.SLname.editableText!!.isEmpty()

                    && binding.signupPhoneno1.editableText!!.isEmpty()
                ) {
                    Toast.makeText(this, "please fill required value", Toast.LENGTH_SHORT).show()
                } else if (binding.SFname.editableText!!.isEmpty()) {
                    Toast.makeText(this, "Please enter Firstname", Toast.LENGTH_SHORT).show()
                    binding.SLname.requestFocus()

                } else if (binding.SLname.editableText!!.isEmpty()) {
                    Toast.makeText(this, "Please enter last name", Toast.LENGTH_SHORT).show()
                    binding.SLname.requestFocus()

                } else if (binding.signupPhoneno1.editableText!!.isEmpty()) {
                    Toast.makeText(this, "Please enter Phone number", Toast.LENGTH_SHORT).show()
                    binding.signupPhoneno1.requestFocus()
                } else {
                    Toast.makeText(this, "successfully registered", Toast.LENGTH_LONG).show()
                    viewmodel.saveData(binding.SFname.text.toString(), binding.SLname.text.toString(),binding.signupPhoneno1.text.toString())
                    startActivity(Intent(this,userformActivity::class.java))

                }

            }
        }
    }

    // onItemSelectedListener have a two mathed onitemselected , on NpthingSelected
    override fun onItemSelected(adapter: AdapterView<*>?, view: View?, position:Int, row: Long) {
        val data = adapter?.getItemAtPosition(position)
        Toast.makeText(this, "You are selected $data", Toast.LENGTH_SHORT).show()

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }


}




