package com.example.studentform_withsqlitedb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.Converters
import com.example.studentform_withsqlitedb.R
import com.example.studentform_withsqlitedb.databinding.StudentdataBinding
import com.example.studentform_withsqlitedb.students
//import android.icu.text.Transliterator.Position as

/*BaseAdapter is a very generic adapter that allows you to do pretty much whatever you want. However,
you have to do a bit more coding yourself to get it working.
ArrayAdapter is a more complete implementation that works well for data in arrays or ArrayLists.
Similarly, there is a related CursorAdapter that you should use if your data is in a Cursor.
Both of these extend BaseAdapter.*/
// base adapter ke pass four method hote hai
class list_viewAdapter(private val listofstudent:ArrayList<students>):BaseAdapter() {
    override fun getCount(): Int {
       return listofstudent.size
    }

    override fun getItem(position: Int): Any {
        return listofstudent[position]
    }

    override fun getItemId(position: Int): Long {

        return listofstudent[position].hashCode().toLong()

    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = convertView

        view = LayoutInflater.from(parent!!.context).inflate(R.layout.studentdata, parent, false)

        val binding=DataBindingUtil.bind<StudentdataBinding>(view)

        binding!!.fname.text = listofstudent[position].FName
        binding!!.lname.text = listofstudent[position].LName
        binding!!.phone.text = listofstudent[position].PhoneNo
        binding!!.AlPhone.text = listofstudent[position].AlPhoneNo
        binding!!.Email.text = listofstudent[position].Email
        binding!!.dob.text = listofstudent[position].Dob
        binding!!.Gender.text = listofstudent[position].gender
        binding!!.course.text = listofstudent[position].course

//view.setOnClickListener {
//
//    Toast.makeText(parent!!.context, listofstudent[position].SrNo, Toast.LENGTH_SHORT).show()
//
//
//}


        return view


    }
}