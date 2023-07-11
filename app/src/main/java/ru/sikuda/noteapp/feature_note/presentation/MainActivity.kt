package ru.sikuda.noteapp.feature_note.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import ru.sikuda.noteapp.NoteApp
import ru.sikuda.noteapp.feature_note.domain.use_cases.NoteUseCases
import ru.sikuda.noteapp.feature_note.presentation.add_edit_notes.AddEditNoteScreen
import ru.sikuda.noteapp.feature_note.presentation.list_notes.NotesScreen
import ru.sikuda.noteapp.feature_note.presentation.list_notes.NotesViewModel
import ru.sikuda.noteapp.feature_note.presentation.utils.Screen
import ru.sikuda.noteapp.ui.theme.NoteAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            NoteAppTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        Screen.NotesScreen.route
                    ) {
                        composable( route = Screen.NotesScreen.route ){
                            NotesScreen(navController)
                        }
                       composable(
                            route = Screen.AddEditNoteScreen.route+"?noteId={noteId}&noteColor={noteColor}"
                                    ,
                            arguments = listOf(
                                navArgument(
                                    name = "noteId"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(
                                    name = "noteColor"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                            )
                        ) {
                            val color = it.arguments?.getInt("noteColor") ?: -1
                            AddEditNoteScreen(
                                navController = navController,
                                noteColor = color
                            )
                        }
                    }
                }
            }
        }
    }


}

@Composable
fun NoteScreen2() {
    Text("test")
}