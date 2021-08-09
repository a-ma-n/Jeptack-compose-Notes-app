package com.aman.notesapp

import android.util.Log
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private const val TAG = "NoteRepository"

class NoteRepository(private val noteDao: NoteDao) {

    fun insert(note: Note) = runBlocking {
        launch(Dispatchers.Default) {
            Log.i(TAG, "insert: adding note ${note.title}")
            noteDao.insert(note)
        }
    }

    suspend fun delete(note: Note) {
        noteDao.delete(note)
    }

    val getAllNotes = liveData {
        emitSource(noteDao.getAllNotes())
    //        val data = NoteDatabase.loadUser()
    }

    suspend fun deleteAllNotes() {
        noteDao.deleteAllNotes()
    }
//TODO add condns to access fav notes
//    suspend fun getFavs(){
//        noteDao.getFavs()
//    }
}