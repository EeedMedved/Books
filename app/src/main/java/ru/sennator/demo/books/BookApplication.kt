package ru.sennator.demo.books

import android.app.Application

class BookApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        BookRepository.initialize(this)
    }
}