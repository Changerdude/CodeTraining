package com.example.firstdi

class BooksRepoImplementer: BooksRepo {

    override fun getBooks(): List<Books> {
        return listOf(
            Books(1,"Bible"),
            Books(2,"Dr Suess"),
            Books(3,"No Longer Human"),
            Books(4,"Attack on Titan"),
            Books(5,"Deadman Wonderland"),
            Books(6,"My Father is a Unicorn")
        )
    }
}