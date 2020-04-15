package com.example.gitandroidstudio;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;
import androidx.room.Room;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jediburrell.customfab.FloatingActionButton;

import java.util.ArrayList;

public class ToDoList extends AppCompatActivity {
    private ArrayList<String> addArray;
    private FloatingActionButton fab;
    private ListView listView;
    final Context context = this;
    NotesAdapter arrayAdapter ;
    private NotesDatabase notesDatabase;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);
        fab = (FloatingActionButton) findViewById(R.id.fabBtn);
        listView = (ListView) findViewById(R.id.lstView);
        addArray = new ArrayList<String>();
        arrayAdapter = new NotesAdapter();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater.from(context);
                final View promptsView = li.inflate(R.layout.prompts, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                listView.setAdapter(arrayAdapter);
                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.edtText);
                alertDialogBuilder.setView(promptsView);

                alertDialogBuilder
                            .setCancelable(false)
                            .setPositiveButton("Add",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            String getInput = userInput.getText().toString();
                                            addArray.add(getInput);


                                        }
                                    })
                            .setNegativeButton("Cancel",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    alertDialog.show();

                }

        });

    }
    class NotesAdapter extends ArrayAdapter<String> {
        NotesAdapter(){
            super(ToDoList.this,android.R.layout.simple_list_item_1,addArray);
        }
        public View getView(int position, View convertView,
                            ViewGroup parent){
            View row = convertView;
            if(row==null){
                LayoutInflater inflater=getLayoutInflater();
                row = inflater.inflate(R.layout.adaptercustom,null);
            }
            ((TextView)row.findViewById(R.id.txtViewCa)).setText(addArray.get(position));
            return (row);
        }

    }


}
