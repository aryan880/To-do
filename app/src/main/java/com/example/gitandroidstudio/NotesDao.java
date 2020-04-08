package com.example.gitandroidstudio;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NotesDao {
    @Query("SELECT * FROM notes")
    List<Notes> getAll();

    @Insert
    void add(Notes notes);

}
