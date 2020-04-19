package com.example.gitandroidstudio;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Notes> addArray = new ArrayList<>();
    Notes currentNote = new Notes();

    public CustomAdapter(Context mContext, ArrayList<Notes> addArray) {
        this.mContext = mContext;
        this.addArray = addArray;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position)  {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null)
            view = LayoutInflater.from(mContext).inflate(R.layout.adaptercustom,parent,false);
        Notes currentNote = addArray.get(position);
        TextView notes = (TextView) view.findViewById(R.id.txtViewCa);
        notes.setText(currentNote.getNotes());
        return view;
    }
}



