package com.example.myfirstroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.textfield.TextInputLayout

class InsertNewStudent : AppCompatActivity() {
    val repo: StudentRepository by lazy {
        StudentRepository(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_new_student)

        var addStudent: View = findViewById(R.id.addStudent)
        var cancelStudent: View = findViewById(R.id.cancelStudent)
        var fName = findViewById<TextInputLayout>(R.id.firstName)
        var lName = findViewById<TextInputLayout>(R.id.lastName)


        addStudent.setOnClickListener(){
            repo.insertStudent(Students(null, fName.editText?.text.toString(), lName.editText?.text.toString()))
            val backMain = Intent(this, MainActivity::class.java)

            startActivity(backMain)
        }
        cancelStudent.setOnClickListener(){
            val backMain = Intent(this, MainActivity::class.java)

            startActivity(backMain)
        }
    }
}