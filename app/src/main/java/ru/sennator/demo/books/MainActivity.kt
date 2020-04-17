package ru.sennator.demo.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.sennator.demo.books.database.Author
import ru.sennator.demo.books.database.Book
import ru.sennator.demo.books.database.booksDB
import ru.sennator.demo.books.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var authorViewModel: AuthorViewModel
    private lateinit var bookViewModel: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
        authorViewModel = ViewModelProvider(this).get(AuthorViewModel::class.java)
        bookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        binding.btnSaveAuthor.setOnClickListener {
            saveAuthor()
        }

        binding.button2.setOnClickListener {
            saveBook()
        }
    }

    private fun saveAuthor() {
        val authorName = binding.inputName.text.toString()
        val author = Author(name = authorName)
        authorViewModel.insertAuthor(author)
        binding.inputName.text.clear()
    }

    private fun saveBook() {
        val bookTitle = binding.inputBookTitle.text.toString()
        val book = Book(name = bookTitle)
        bookViewModel.insertBook(book)
        binding.inputBookTitle.text.clear()
    }
}