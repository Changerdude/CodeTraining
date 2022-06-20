package com.example.firstdi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BooksVm @Inject constructor(var repo: BooksRepo): ViewModel() {

    var booksList = MutableLiveData<List<Books>>()
    init {
        getBooks()
    }

    fun getBooks() {
        booksList.value = repo.getBooks()
    }

}