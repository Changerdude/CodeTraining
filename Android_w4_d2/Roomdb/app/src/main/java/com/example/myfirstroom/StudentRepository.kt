package com.example.myfirstroom

import android.content.Context
import androidx.lifecycle.LiveData

class StudentRepository(context: Context) {
    var db: StudentsDAO? = AppDatabase.getInstance(context)?.getDao()


    fun getAllStudents(): LiveData<List<Students>>? {
        return db?.selectStudents()
    }

    fun insertStudent(student: Students){
        db?.insertStudent(student)
    }

    fun updateStudent(student: Students){
        db?.updateStudent(student)
    }

    fun deleteStudent(student: Students){
        db?.deleteStudent(student)
    }

}