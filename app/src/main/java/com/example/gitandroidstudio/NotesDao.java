package com.example.gitandroidstudio;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NotesDao {
    @Query("SELECT * FROM notes")
    List<Notes> getAll();

    @Insert
    void add(Notes notes);

    @Update
    void update(Notes notes);

    @Delete
    void delete(Notes notes);

}
