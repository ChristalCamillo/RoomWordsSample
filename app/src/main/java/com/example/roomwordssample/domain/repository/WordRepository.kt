package com.example.roomwordssample.domain.repository

import androidx.annotation.WorkerThread
import com.example.roomwordssample.data.datasource.local.Word
import com.example.roomwordssample.data.datasource.local.dao.WordDao
import kotlinx.coroutines.flow.Flow

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class WordRepository(private val wordDao: WordDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    //A lista de palavras é uma propriedade pública. Ela é inicializada com a lista de palavras do Flow do Room.
    // É possível fazer isso devido à forma como você definiu o método getAlphabetizedWords para retornar um Flow na etapa "Como observar mudanças no banco de dados". O Room executa todas as consultas em uma linha de execução separada.
    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}