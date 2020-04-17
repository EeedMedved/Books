package ru.sennator.demo.books.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Book::class, Author::class], version = 2)
abstract class booksDB: RoomDatabase() {
    abstract fun booksDao(): booksDao

    companion object {
        @Volatile
        private var INSTANCE: booksDB? = null

        fun getInstance(context: Context): booksDB {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        booksDB::class.java,
                        "booksDB"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}