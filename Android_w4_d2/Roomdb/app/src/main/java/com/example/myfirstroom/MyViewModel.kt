package com.example.myfirstroom

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MyViewModel(app: Application): AndroidViewModel(app) {
    private val repo: StudentRepository
    val allStudents : LiveData<List<Students>>?

    init {
        repo = StudentRepository(app)
        allStudents = repo.getAllStudents()
    }

    fun getAllStudents() = viewModelScope.launch  {
        repo.getAllStudents()
    }

    fun insertStudent(student: Students) = viewModelScope.launch  {
        repo.insertStudent(student)
    }

    fun updateStudent(student: Students) = viewModelScope.launch  {
        repo.updateStudent(student)
    }

    fun deleteStudent(student: Students) = viewModelScope.launch  {
        repo.deleteStudent(student)
    }
}