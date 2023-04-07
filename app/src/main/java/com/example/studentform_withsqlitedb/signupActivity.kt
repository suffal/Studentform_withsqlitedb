package com.example.studentform_withsqlitedb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.studentform_withsqlitedb.databinding.ActivitySignupBinding

class signupActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySignupBinding
    val Item = arrayOf("Guest", "HR", "Cunsultant", "Faculty", "Admin")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        getSupportActionBar()?.hide()

        getWindow().getDecorView()
            .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//  set status text dark
        getWindow().setStatusBarColor(
            ContextCompat.getColor(
                this,
                R.color.white
            )// background white
        )


        val ItemAdapter =
            ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, Item)
        binding.spinner.adapter = ItemAdapter


        binding.AlreadyIHaveAAccount.setOnClickListener(this)
        binding.btnSignupSignupactivity.setOnClickListener(this)
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
                    val intent = Intent(this, userformActivity::class.java)
                    startActivity(intent)
                }

            }
        }
    }
}


