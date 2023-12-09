package com.example.ataa_frag_2.ui

import com.example.ataa_frag_2.R

data class Book(val id: Int, val name: String, val author: String, val editor: String,val Volumesnumber: Int, val type : String, val iconName: Int)
val booklist = listOf(
    Book(18,"Book_1", "Author_1", "editor_1", 1, "type_1", R.drawable.book_1),
    Book(18,"Book_2", "Author_2", "editor_2", 2, "type_2", R.drawable.book_2),
    Book(18,"Book_3", "Author_3", "editor_3", 3, "type_3", R.drawable.book_3),
    Book(18,"Book_4", "Author_4", "editor_4", 2, "type_4", R.drawable.book_4),
    )
