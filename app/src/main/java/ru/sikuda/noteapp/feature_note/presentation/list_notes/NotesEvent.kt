package ru.sikuda.noteapp.feature_note.presentation.list_notes

import ru.sikuda.noteapp.feature_note.domain.model.Note
import ru.sikuda.noteapp.feature_note.domain.util.NoteOrder

sealed class NotesEvent {
    class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}