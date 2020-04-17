package ru.sennator.demo.books.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "authors")
class Author(
    @PrimaryKey(autoGenerate = true)
    val authorId: Int = 0,
    @ColumnInfo(name = "author_name")
    val name: String
) {
}