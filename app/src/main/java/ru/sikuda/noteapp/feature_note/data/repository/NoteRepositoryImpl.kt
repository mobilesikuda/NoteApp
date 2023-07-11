package ru.sikuda.noteapp.feature_note.data.repository

import androidx.compose.ui.graphics.toArgb
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.sikuda.noteapp.feature_note.data.data_source.NoteDao
import ru.sikuda.noteapp.feature_note.domain.model.Note
import ru.sikuda.noteapp.feature_note.domain.repository.NoteRepository
import java.lang.System.currentTimeMillis

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {

//    init{
//        MainScope().launch {
//            initTest()
//        }
//    }

    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }


    private suspend fun initTest() {

        withContext(Dispatchers.IO) {
            for (i in 0..10) {
                val rcol = (0..4).random()
                val rint = (0 until Int.MAX_VALUE - 1).random()

                val note = Note(
                    "Title $i",
                    "$rint",
                    currentTimeMillis(),
                    Note.noteColors[rcol].toArgb(),
                    rint
                )
                dao.insertNote(note)
            }
        }

    }

}