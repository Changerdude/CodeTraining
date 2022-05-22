package com.example.myfirstroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.textfield.TextInputLayout

class DetailedView : AppCompatActivity() {
    val repo: StudentRepository by lazy {
        StudentRepository(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)
        var updateStudent: View = findViewById(R.id.editStudent)
        var cancelStudent: View = findViewById(R.id.cancelStudent)
        var fName = findViewById<TextInputLayout>(R.id.firstName)
        var lName = findViewById<TextInputLayout>(R.id.lastName)
        val student: Students = intent.getSerializableExtra("student") as Students
        fName.editText?.setText(student.firstName)
        lName.editText?.setText(student.lastName)

        updateStudent.setOnClickListener(){
            repo.updateStudent(Students(student.studentId, fName.editText?.text.toString(), lName.editText?.text.toString()))
            val backMain = Intent(this, MainActivity::class.java)

            startActivity(backMain)
        }
        cancelStudent.setOnClickListener(){
            val backMain = Intent(this, MainActivity::class.java)

            startActivity(backMain)
        }
    }
}