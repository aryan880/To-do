package com.example.gitandroidstudio;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NotesDao {
    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    LiveData<List<Notes>> getAllNotes();

    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    @Insert
    void insert(Notes notes);

    @Update
    void update(Notes notes);

    @Delete
    void delete(Notes notes);

}
