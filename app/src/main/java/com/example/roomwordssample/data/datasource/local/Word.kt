package com.example.roomwordssample.data.datasource.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Word(var word: String){
    @Entity(tableName = "word_table")
    class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)
}
