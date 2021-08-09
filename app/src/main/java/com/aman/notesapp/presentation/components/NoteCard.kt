package com.aman.notesapp.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aman.notesapp.Note
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun noteCard(
    note: Note,
    onClick: () -> Unit,
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp,
            )
            .fillMaxWidth(),
        elevation = 8.dp,
    ) {
        Column {
            Text(
                text = note.title,
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .wrapContentWidth(Alignment.CenterHorizontally),
            fontSize = 30.sp
            )
            Text(
                text = " "+note.body,
                modifier = Modifier
                    .fillMaxWidth(1.0f)
                    .wrapContentWidth(Alignment.Start),
                fontSize = 20.sp
            )
            }
            Button(
                onClick = onClick,
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .wrapContentWidth(Alignment.End)
            ) {
                Text(text = "Delete",)
            }
        Spacer(modifier = Modifier.padding(1.dp))
        }
    }





