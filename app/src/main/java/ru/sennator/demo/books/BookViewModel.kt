package ru.sennator.demo.books

import android.content.Context
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.sennator.demo.books.database.Book
import ru.sennator.demo.books.database.booksDB

class BookViewModel(): ViewModel() {
    private val bookRepository = BookRepository.get()

    var allBooks: List<Book> = listOf()

    init {
        allBooks = bookRepository.getBooks()
    }

    fun insertBook(book: Book) {
        bookRepository.insertBook(book)
    }
}