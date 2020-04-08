package com.example.gitandroidstudio;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

@Database(entities = {Notes.class}, version = 1)
public abstract class NotesDatabase extends RoomDatabase {
    private static NotesDatabase db;

    public abstract NotesDao notesDao();

    public static NotesDatabase getNotesDatabase(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context.getApplicationContext(), NotesDatabase.class, "notes-db")
                    .build();
        }
        return db;
    }

    public static void addNote(final Context context, final String noteString) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                // Insert Data
                Notes note = new Notes();
                note.setNotes(noteString);
                NotesDatabase.getNotesDatabase(context).notesDao().add(note);
                List<Notes> notes = NotesDatabase.getNotesDatabase(context).notesDao().getAll();
                Log.v("NotesDB", "Notes count is " + notes.size());
                for (int i = 0; i < notes.size(); i++) {
                    Log.v("NotesDB", "Note at "+ i + " is : " + notes.get(i).getNotes());
                }

            }
        });
    }

}
