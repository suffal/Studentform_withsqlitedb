package com.example.studentform_withsqlitedb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.studentform_withsqlitedb.Repository.sharedprefranceRepository
import com.example.studentform_withsqlitedb.Viewmodel.sharedprefranceviewmodels
import com.example.studentform_withsqlitedb.databinding.ActivityMainBinding
import com.example.studentform_withsqlitedb.factory.sharedprefrenceviewmodelfactory

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    lateinit var viewmodelFactory: sharedprefrenceviewmodelfactory
    lateinit var viewmodel: sharedprefranceviewmodels

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        getSupportActionBar()?.hide()





        binding.btnLogin.setOnClickListener(this)
        binding.btnSkip.setOnClickListener(this)
        binding.dontHaveAAccount.setOnClickListener(this)

        viewmodelFactory = sharedprefrenceviewmodelfactory(sharedprefranceRepository, this)
        viewmodel = ViewModelProvider(this, viewmodelFactory)[sharedprefranceviewmodels::class.java]


    }

    override fun onClick(View: View?) {


        when (View?.id) {
            R.id.btn_skip ->{
                val intent = Intent(this, userformActivity::class.java)
                startActivity(intent)
            }

            R.id.dont_have_a_account -> {
                val intent = Intent(this, signupActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_login -> {
                if (binding.logonPhoneno1.editableText.isEmpty()){
                    Toast.makeText(
                        this,
                        "${binding.logonPhoneno1.editableText.toString()} please enter the phone number",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else {

                    if (binding.logonPhoneno1.editableText.toString().equals(viewmodel.getphone()))
                     {
                        startActivity(Intent(this, userformActivity::class.java))
                         Toast.makeText(this, "Login succesfully", Toast.LENGTH_SHORT).show()

                    }

                    else {
                        Toast.makeText(this, "${binding.logonPhoneno1.editableText.toString()} not registered", Toast.LENGTH_SHORT).show()
                    }


                }



            }

        }
    }
}
