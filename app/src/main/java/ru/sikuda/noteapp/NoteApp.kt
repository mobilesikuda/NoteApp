package ru.sikuda.noteapp

import android.app.Application
import androidx.room.Room
import dagger.hilt.android.HiltAndroidApp
import ru.sikuda.noteapp.feature_note.data.data_source.NoteDatabase
import ru.sikuda.noteapp.feature_note.data.repository.NoteRepositoryImpl
import ru.sikuda.noteapp.feature_note.domain.repository.NoteRepository
import ru.sikuda.noteapp.feature_note.domain.use_cases.GetNote
import ru.sikuda.noteapp.feature_note.domain.use_cases.GetNotes
import ru.sikuda.noteapp.feature_note.domain.use_cases.NoteUseCases

@HiltAndroidApp
class NoteApp : Application()
//{
//
//    fun provideNoteDatabase(): NoteDatabase {
//        return Room.databaseBuilder(
//            this,
//            NoteDatabase::class.java,
//            NoteDatabase.DATABASE_NAME
//        ).build()
//    }
//
//    fun provideNoteRepository(db: NoteDatabase = provideNoteDatabase()): NoteRepository {
//        return NoteRepositoryImpl(db.noteDao)
//    }
//
//    fun provideNoteUseCases(repository: NoteRepository = provideNoteRepository()): NoteUseCases {
//        return NoteUseCases(
//            getNotes = GetNotes(repository),
//            getNote = GetNote(repository)
//        )
//    }
//
//
//}