package com.aman.notesapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note : Note)

    @Delete
    suspend fun delete(note:Note)

    @Query("SELECT * FROM notes_table ORDER BY id ASC")
    fun getAllNotes():LiveData<List<Note>>//Live Data to keep track what is happening in the db

    @Query("DELETE FROM notes_table")
    suspend fun deleteAllNotes()

}