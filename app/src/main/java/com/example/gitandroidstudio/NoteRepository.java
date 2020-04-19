package com.example.gitandroidstudio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;

import java.util.List;

public class NoteRepository {
    private NotesDao notesDao;
    private LiveData<List<Notes>> allNotes;
    public NoteRepository(Application application){
        NotesDatabase database = NotesDatabase.getDb((application));
        notesDao = database.notesDao();
        allNotes = notesDao.getAllNotes();
    }
    public void insert(Notes notes){
        new InsertNoteAsyncTask(notesDao).execute(notes);
    }
    public void update(Notes notes){


    }
    public void delete(Notes notes){

    }
    public void deleteAllNotes(){

    }
    public LiveData<List<Notes>>getAllNotes(){
        return allNotes;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Notes,Void,Void>{
        private NotesDao notesDao;
        private InsertNoteAsyncTask(NotesDao notesDao){
            this.notesDao = notesDao;
        }
        @Override
        protected Void doInBackground(Notes... notes) {
            notesDao.insert(notes[0]);
            return null;

        }
    }
    private static class UpdateNoteAsyncTask extends AsyncTask<Notes,Void,Void>{
        private NotesDao notesDao;
        private UpdateNoteAsyncTask(NotesDao notesDao){
            this.notesDao = notesDao;
        }
        @Override
        protected Void doInBackground(Notes... notes) {
            notesDao.update(notes[0]);
            return null;

        }
    }
    private static class DeleteNoteAsyncTask extends AsyncTask<Notes,Void,Void>{
        private NotesDao notesDao;
        private DeleteNoteAsyncTask(NotesDao notesDao){
            this.notesDao = notesDao;
        }
        @Override
        protected Void doInBackground(Notes... notes) {
            notesDao.delete(notes[0]);
            return null;

        }
    }
    private static class DeleteAllNoteAsyncTask extends AsyncTask<Void,Void,Void>{
        private NotesDao notesDao;
        private DeleteAllNoteAsyncTask(NotesDao notesDao){
            this.notesDao = notesDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            notesDao.deleteAllNotes();
            return null;

        }
    }

}
