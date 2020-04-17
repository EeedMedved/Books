package ru.sennator.demo.books

import androidx.lifecycle.ViewModel
import ru.sennator.demo.books.database.Author

class AuthorViewModel: ViewModel() {
    private val bookRepository = BookRepository.get()

    fun insertAuthor(author: Author) {
        bookRepository.insertAuthor(author)
    }
}