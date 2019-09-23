package com.example.lab7_789_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_layout.view.*

class MainActivity : AppCompatActivity() {
    val studentList = arrayListOf<Student>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testStudentData()
        recycler_view.adapter = StudentsAdepter(this.studentList,applicationContext)
        recycler_view.layoutManager = LinearLayoutManager(applicationContext)as RecyclerView.LayoutManager?
        recycler_view.itemAnimator = DefaultItemAnimator() as RecyclerView.ItemAnimator?
}
    fun addStudent(v: View){
        val mDialogView :View = LayoutInflater.from(this).inflate(R.layout.add_dialog_layout,null)
        val mBulider = AlertDialog.Builder(this)
        val mAlertDialog :AlertDialog = mBulider.show()

        mDialogView.btnAdd.setOnClickListener{
            studentList.add(Student(mDialogView.edt_id.text.toString(), mDialogView.edt_name.text.toString(),
                mDialogView.edt_age.text.toString().toInt()))
            recycler_view.adapter?.notifyDataSetChanged()
            Toast.makeText(applicationContext, "the student is added successfully", Toast.LENGTH_SHORT).show()
            mAlertDialog.dismiss()
        }
        mDialogView.btnCancel.setOnClickListener(){
            mAlertDialog.dismiss()
        }
    }
    fun testStudentData(){
        studentList.add(Student("601234567-8", "Student 1", 20))
        studentList.add(Student("601234567-8", "Student2", 21))
    }


    }
