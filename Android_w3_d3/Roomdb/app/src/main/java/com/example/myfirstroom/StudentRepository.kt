package com.example.myfirstroom

import android.content.Context

class StudentRepository(context: Context) {
    var db: StudentsDAO? = AppDatabase.getInstance(context)?.getDao()


    fun getAllStudents(): List<Students>{
        return db?.selectStudents() ?: listOf<Students>()
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