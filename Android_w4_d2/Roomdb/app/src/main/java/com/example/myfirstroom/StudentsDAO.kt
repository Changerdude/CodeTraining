package com.example.myfirstroom

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentsDAO {
    //CRUD
    //create
    @Insert
    fun insertStudent(student: Students)

    //read
    @Query("select * from students")
    fun selectStudents(): LiveData<List<Students>>

    //update
    @Update
    fun updateStudent(student: Students)

    //delete
    @Delete
    fun deleteStudent(student: Students)
}