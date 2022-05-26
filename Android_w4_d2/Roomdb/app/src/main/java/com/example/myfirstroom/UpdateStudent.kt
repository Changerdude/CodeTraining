package com.example.myfirstroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class UpdateStudent : AppCompatActivity() {
    lateinit var vm: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)
        vm = MyViewModel(application)
        var updateStudent: Button = findViewById(R.id.editStudent)
        var cancelStudent: View = findViewById(R.id.cancelStudent)
        var fName = findViewById<TextInputLayout>(R.id.firstName)
        var lName = findViewById<TextInputLayout>(R.id.lastName)
        var newTitle = findViewById<TextView>(R.id.newTitle)

        val isEdit: Boolean = intent.getBooleanExtra("isEdit", false)
        if(isEdit) {
            val student: Students = intent.getSerializableExtra("student") as Students
            fName.editText?.setText(student.firstName)
            lName.editText?.setText(student.lastName)
            updateStudent.setOnClickListener(){
                vm.updateStudent(Students(student.studentId, fName.editText?.text.toString(), lName.editText?.text.toString()))
                val backMain = Intent(this, MainActivity::class.java)

                startActivity(backMain)
            }
        } else {
            newTitle.text = "New Student Form"
            updateStudent.text = "Add"
            updateStudent.setOnClickListener(){
                vm.insertStudent(Students(null, fName.editText?.text.toString(), lName.editText?.text.toString()))
                val backMain = Intent(this, MainActivity::class.java)

                startActivity(backMain)
            }
        }
        cancelStudent.setOnClickListener(){
            val backMain = Intent(this, MainActivity::class.java)

            startActivity(backMain)
        }
    }
}