package ru.sennator.demo.books.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface booksDao {

    @Insert
    fun insertBook(book: Book)

    @Insert
    fun insertAuthor(author: Author)

    @Query("SELECT * FROM books")
    fun getAllBooks(): List<Book>
}