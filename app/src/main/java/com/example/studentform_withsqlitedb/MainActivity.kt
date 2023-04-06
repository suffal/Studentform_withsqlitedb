package com.example.studentform_withsqlitedb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.studentform_withsqlitedb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        getSupportActionBar()?.hide()

        getWindow().getDecorView()
            .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//  set status text dark
        getWindow().setStatusBarColor(
            ContextCompat.getColor(
                this,
                R.color.white
            )
        )


        binding.btnSignup.setOnClickListener(this)
        binding.btnLogin.setOnClickListener(this)
        binding.btnSkip.setOnClickListener(this)




    }

    override fun onClick(View:View?) {


        when(View?.id){

            R.id.btn_signup->{
                val intent= Intent(this,signupActivity::class.java)
                startActivity(intent)
            }
           R.id.btn_login->{
               val intent= Intent(this,userformActivity::class.java)
               startActivity(intent)

           }
            R.id.btn_skip->{
                val intent= Intent(this,userformActivity::class.java)
                startActivity(intent)

            }

        }

    }
}