package com.example.studentform_withsqlitedb.Repository

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.studentform_withsqlitedb.students
//private lateinit var cursor: Cursor
private const val SRNO="Sr"
private const val DB_NAME = "db_chetu"
private const val DB_VERSION = 1
private const val TABLE_NAME="student"
private const val FNAME="FirstName"
private const val LNAME="LastName"
private const val PHONE_NUMBER="PhoneNumber"
private const val ALTERNATIVEPHONE_NUMBER="AlternativePhoneNumber"
private const val E_MAIL="Email"
private const val DOB="Dob"
private const val GENDER="Gender"
private const val COURSE="Course"


class sqliteRepository(private val context: Context){

       val query="CREATE TABLE $TABLE_NAME($SRNO INTEGER PRIMARY KEY AUTOINCREMENT,$FNAME TEXT,$LNAME TEXT,$PHONE_NUMBER TEXT,$ALTERNATIVEPHONE_NUMBER TEXT,$E_MAIL TEXT,$DOB TEXT,$GENDER TEXT,$COURSE TEXT)"

    // creat inner class object
    val  dbHelper = myDbHelper(context)

    // use writable method to write data base
    val sqliteDb=dbHelper.writableDatabase

   fun createdata(fName:String ,lName:String,phone:String,Alphone:String,Email:String,Dob:String,Gender:String,course:String){

       val contentValue = ContentValues()
       contentValue.put(FNAME,fName)
       contentValue.put(LNAME,lName)
       contentValue.put(PHONE_NUMBER,phone)
       contentValue.put(ALTERNATIVEPHONE_NUMBER,Alphone)
       contentValue.put(E_MAIL,Email)
       contentValue.put(DOB,Dob)
       contentValue.put(GENDER,Gender)
       contentValue.put(COURSE,course)

      val id:Long= sqliteDb.insert(TABLE_NAME,null,contentValue)

      if (id>0){

          Toast.makeText(context,"Data saved succesfully",Toast.LENGTH_SHORT).show()
      }
       else{

          Toast.makeText(context,"Something went wrong ",Toast.LENGTH_SHORT).show()
      }
   }

fun getAlldata(): ArrayList<students> {
    var listofstudent1=ArrayList<students>()
    val columns= arrayOf(SRNO, FNAME, LNAME, PHONE_NUMBER, ALTERNATIVEPHONE_NUMBER, E_MAIL, DOB,
        GENDER, COURSE)
    val  cursor=sqliteDb.query(TABLE_NAME,columns,null,null,null,null,null)
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
        Toast.makeText(context, "something went wrong", Toast.LENGTH_SHORT).show()
    }

    return listofstudent1
}

    fun getdata():Cursor {
        val columns= arrayOf(SRNO, FNAME, LNAME, PHONE_NUMBER, ALTERNATIVEPHONE_NUMBER, E_MAIL, DOB,
            GENDER, COURSE)
        return sqliteDb.query(TABLE_NAME,columns,null,null,null,null,null)


    }

// write a delete quere

fun deletesingleRecord(rowId:String){
    val id =sqliteDb.delete(TABLE_NAME,"$SRNO=$rowId",null)
    if (id>0){
        Toast.makeText(context, "successfully deleted", Toast.LENGTH_SHORT).show()
    }else{
        Toast.makeText(context, "something went wrong", Toast.LENGTH_SHORT).show()
    }
}





//  get data from this pese of code

  //  fun get data

// sqlieopenhelperclass is a parent class it have a two mathod oncreat and onupgraed
    // dbhelper class to have only permision to read and write .

    inner class myDbHelper(private val context: Context):SQLiteOpenHelper(context, DB_NAME,null,
        DB_VERSION){
        override fun onCreate(sqliteDb: SQLiteDatabase?) {
         sqliteDb?.execSQL(query)

        }

        override fun onUpgrade(sqliteDb: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            TODO("Not yet implemented")
        }


    }






}

