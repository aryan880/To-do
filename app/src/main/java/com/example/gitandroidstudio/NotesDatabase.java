package com.example.gitandroidstudio;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Notes.class, version = 1)
public abstract class NotesDatabase extends RoomDatabase {
    private static NotesDatabase db;

    public abstract NotesDao notesDao();

    public static NotesDatabase getAppDatabase(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context.getApplicationContext(), NotesDatabase.class, "notes-db")

                    .allowMainThreadQueries()
                    .build();
        }
        return db;
    }

}
