package com.aman.notesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class CreateNoteFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

                Column(modifier = Modifier.padding(16.dp)) {
                    var title by rememberSaveable { mutableStateOf("") }
                    var body by rememberSaveable { mutableStateOf("") }
                    Spacer(modifier = Modifier.height(100.dp))
                    Text(
                        text="Title",
                        style = MaterialTheme.typography.h4
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    TextField(
                        value = title,
                        onValueChange = { title = it }
                    )
                    Spacer(modifier = Modifier.height(50.dp))

                    Text(
                        text="Description",
                        style = MaterialTheme.typography.h4
                    )

                    TextField(
                        value = body,
                        onValueChange = { body = it },
                        label = { Text("Start Typing Something...") },
                    )

                    val dao = NoteDatabase.getDatabase(requireContext()).getNoteDao()
                    val repository = NoteRepository(dao)

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(shape = MaterialTheme.shapes.small,
                        modifier=Modifier.fillMaxWidth(1.0f).wrapContentWidth(Alignment.CenterHorizontally),

                        onClick = {
                            repository.insert(Note(body = body,
                                title = title,
                                fav = false))
                            findNavController().navigate(R.id.saveNote)
                        })
                    {
                        Text(text = "Save")
                    }
                }
            }
        }
    }
}
