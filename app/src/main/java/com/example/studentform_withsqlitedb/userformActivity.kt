package com.example.studentform_withsqlitedb

import android.content.Intent
import android.content.LocusId
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable.Factory
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.studentform_withsqlitedb.Repository.sqliteRepository
import com.example.studentform_withsqlitedb.Viewmodel.squliteviewmodel
import com.example.studentform_withsqlitedb.databinding.ActivityUserformBinding
import com.example.studentform_withsqlitedb.factory.sqliteFactory


class userformActivity : AppCompatActivity(), View.OnClickListener,
    RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: ActivityUserformBinding
    lateinit var factory: sqliteFactory
    lateinit var viewmodel: squliteviewmodel
    var gender: String? = null
    val list: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_userform)


        factory = sqliteFactory(sqliteRepository(this))
        viewmodel = ViewModelProvider(this, factory)[squliteviewmodel::class.java]


        binding.btnSubmit.setOnClickListener(this)


        // This peace of code for Radio Button
        binding.radioButton.setOnCheckedChangeListener(this)


        // This peace of code for Check Box
        binding.BTech.setOnCheckedChangeListener(this)
        binding.bca.setOnCheckedChangeListener(this)
        binding.MCA.setOnCheckedChangeListener(this)
        binding.MTech.setOnCheckedChangeListener(this)
        binding.BBA.setOnCheckedChangeListener(this)
        binding.MBA.setOnCheckedChangeListener(this)
        binding.BA.setOnCheckedChangeListener(this)
        binding.MA.setOnCheckedChangeListener(this)
        binding.BSc.setOnCheckedChangeListener(this)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.item, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item2 -> {
                val intent = Intent(this, userinformationActivity::class.java)
                startActivity(intent)

            }
        }


        return super.onOptionsItemSelected(item)
    }


    //  this method of submit button
    override fun onClick(view: View?) {

        when (view?.id) {

            R.id.btn_submit -> {

                val phone1 = binding.userformPhoneno1.editableText.toString()
                val phone2 = binding.userformAlphoneno1.editableText.toString()

                if (binding.userformFname.text!!.isEmpty() && binding.userformLname.text!!.isEmpty() && binding.userformPhoneno1.editableText.isEmpty() && binding.userformAlphoneno1.editableText.isEmpty() && binding.EmailIdEdtext.text!!.isEmpty()) {
                    binding.userformFname.requestFocus()
                    Toast.makeText(this, "fill required information ", Toast.LENGTH_SHORT).show()
                } else if (binding.userformFname.text!!.isEmpty()) {
                    binding.userformFname.requestFocus()
                    Toast.makeText(this, "Please fill your First name", Toast.LENGTH_SHORT).show()

                } else if (binding.userformLname.text!!.isEmpty()) {
                    binding.userformLname.requestFocus()
                    Toast.makeText(this, "Please fill your Last name", Toast.LENGTH_SHORT).show()

                } else if (binding.userformPhoneno1.editableText.isEmpty()) {
                    binding.userformPhoneno1.requestFocus()
                    Toast.makeText(this, "Please fill your Phone Number name", Toast.LENGTH_SHORT)
                        .show()

                } else {
                    viewmodel.createData(
                        binding.userformFirstName.editText?.text.toString(),
                        binding.userformLastName.editText?.text.toString(),
                        binding.userformPhoneno.editText?.text.toString(),
                        binding.userformAlphoneno.editText?.text.toString(),
                        binding.EmailIdInputlayout.editText?.text.toString(),
                        binding.DOBInputlayout.editText?.text.toString(),
                        binding.Gender.text.toString(),
                        binding.course.text.toString()
                    )
                }
            }


        }


    }


    // this method of redio group
    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when (group?.checkedRadioButtonId) {
            R.id.male -> {
                val rbMale = findViewById<RadioButton>(checkedId)
                gender = rbMale.text.toString()
            }
            R.id.Female -> {
                val rbFemale = findViewById<RadioButton>(checkedId)
                gender = rbFemale.text.toString()
            }
            R.id.TransGender -> {
                val rbtransgender = findViewById<RadioButton>(checkedId)
                gender = rbtransgender.text.toString()
            }

        }
    }


// this code of checkbox

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when (buttonView?.id) {


            R.id.B_tech -> {
                if (binding.BTech.isChecked) {
                    list.add(binding.BTech.text.toString())
                    // list.toString().replace("[", "").replace("]", "");
                } else {
                    list.remove(binding.BTech.text.toString())
                }

            }


            R.id.bca -> {
                if (binding.bca.isChecked) {
                    list.add(binding.bca.text.toString())
                    // list.toString().replace("[", "").replace("]", "");
                } else {
                    list.remove(binding.bca.text.toString())
                }

            }


            R.id.MCA -> {
                if (binding.MCA.isChecked) {
                    list.add(binding.MCA.text.toString())
                    // list.toString().replace("[", "").replace("]", "");
                } else {
                    list.remove(binding.MCA.text.toString())
                }

            }


            R.id.M_tech -> {
                if (binding.MTech.isChecked) {
                    list.add(binding.MTech.text.toString())
                    // list.toString().replace("[", "").replace("]", "");
                } else {
                    list.remove(binding.MTech.text.toString())
                }

            }


            R.id.B_B_A -> {
                if (binding.BBA.isChecked) {
                    list.add(binding.BBA.text.toString())
                    // list.toString().replace("[", "").replace("]", "");
                } else {
                    list.remove(binding.BBA.text.toString())
                }

            }


            R.id.M_B_A -> {
                if (binding.MBA.isChecked) {
                    list.add(binding.MBA.text.toString())
                    // list.toString().replace("[", "").replace("]", "");
                } else {
                    list.remove(binding.MBA.text.toString())
                }

            }


            R.id.B_A -> {
                if (binding.BA.isChecked) {
                    list.add(binding.BA.text.toString())
                    // list.toString().replace("[", "").replace("]", "");
                } else {
                    list.remove(binding.BA.text.toString())
                }
            }

            R.id.M_A -> {
                if (binding.MA.isChecked) {
                    list.add(binding.MA.text.toString())
                    // list.toString().replace("[", "").replace("]", "");
                } else {
                    list.remove(binding.MA.text.toString())
                }

            }





            R.id.B_Sc -> {
                if (binding.BSc.isChecked) {
                    list.add(binding.BSc.text.toString())
                    // list.toString().replace("[", "").replace("]", "");
                } else {
                    list.remove(binding.BSc.text.toString())
                }

            }









        }


    }
}


