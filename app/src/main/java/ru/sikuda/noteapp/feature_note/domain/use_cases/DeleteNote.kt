package ru.sikuda.noteapp.feature_note.domain.use_cases

import ru.sikuda.noteapp.feature_note.domain.model.Note
import ru.sikuda.noteapp.feature_note.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}