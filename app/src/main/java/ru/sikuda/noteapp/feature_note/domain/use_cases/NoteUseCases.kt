package ru.sikuda.noteapp.feature_note.domain.use_cases

import ru.sikuda.noteapp.feature_note.presentation.list_notes.NotesEvent

data class NoteUseCases(
    val getNotes: GetNotes,
    val deleteNote: DeleteNote,
    val addNote: AddNote,
    val getNote: GetNote
)