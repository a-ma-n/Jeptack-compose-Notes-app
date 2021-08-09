package com.aman.notesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.aman.notesapp.presentation.components.noteCard
import kotlinx.coroutines.ExperimentalCoroutinesApi

private const val TAG = "AllList"

class AllList : Fragment() {
    private val viewModel: AllListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Column(modifier = Modifier.padding(16.dp)) {
                    FloatingActionButton(
                        onClick = { findNavController().navigate(R.id.viewNote) },
                        modifier = Modifier.fillMaxWidth(1.0f).wrapContentWidth(Alignment.End)
                    )
                    {
                        Text(text = "+")
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                    val notesList by viewModel.allNotes.observeAsState(initial = emptyList())
                    displayData(viewModel, list = notesList)


                }
            }
        }
    }

    @ExperimentalCoroutinesApi
    @Composable
    fun displayData(viewModel: AllListViewModel, list: List<Note>) {
        LazyColumn {
            //needs a list we give a livedata
            items(list.size)
            { index ->
                noteCard(note = list[index], onClick = { viewModel.deleteNote(list[index]) })
            }
        }
    }
}



