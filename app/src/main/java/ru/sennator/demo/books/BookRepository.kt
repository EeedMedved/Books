package ru.sennator.demo.books

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.sennator.demo.books.database.Author
import ru.sennator.demo.books.database.Book
import ru.sennator.demo.books.database.booksDB

class BookRepository private constructor(context: Context) {

    companion object {
        private var INSTANCE: BookRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = BookRepository(context)
            }
        }

        fun get(): BookRepository {
            return INSTANCE ?: throw IllegalStateException("BookRepository must be initialized")
        }
    }

    private val booksDao = booksDB.getInstance(context).booksDao()

    fun insertBook(book: Book) {
        CoroutineScope(Dispatchers.IO).launch {
            booksDao.insertBook(book)
        }
    }

    fun insertAuthor(author: Author) {
        CoroutineScope(Dispatchers.IO).launch {
            booksDao.insertAuthor(author)
        }
    }

    fun getBooks(): List<Book> {
        var books: List<Book> = listOf<Book>()
        CoroutineScope(Dispatchers.IO).launch {
            books = booksDao.getAllBooks()
        }
        return books
    }
}