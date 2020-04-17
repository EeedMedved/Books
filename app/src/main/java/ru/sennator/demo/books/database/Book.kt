package ru.sennator.demo.books.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class Book(

    @PrimaryKey(autoGenerate = true)
    var bookId: Long = 0,

    @ColumnInfo(name="book_title")
    val name: String,

    @ColumnInfo(name="book_year")
    val pub_year: Int = -1
)