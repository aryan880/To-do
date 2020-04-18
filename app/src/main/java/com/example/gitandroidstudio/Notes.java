package com.example.gitandroidstudio;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Arrays;

@Entity
public class Notes {
    @PrimaryKey(autoGenerate = true)
    private int uid;
    @ColumnInfo
    private String notes;

    public Notes(int uid, String notes) {
        this.uid = uid;
        this.notes = notes;
    }

    public Notes() {

    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
