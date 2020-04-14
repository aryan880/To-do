package com.example.gitandroidstudio;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
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
    private TextView textView;
    private ListView listView;
    final Context context = this;
    ArrayAdapter<String> arrayAdapter ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);
        fab = (FloatingActionButton) findViewById(R.id.fabBtn);
        listView = (ListView) findViewById(R.id.lstView);
        addArray = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,addArray);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.prompts, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);
                EditText userInput = (EditText) promptsView
                        .findViewById(R.id.edtText);
                String getInput = userInput.getText().toString();
                    addArray.add(getInput);
                    // set dialog message
                    alertDialogBuilder
                            .setCancelable(false)
                            .setPositiveButton("Add",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            // get user input
                                            listView.setAdapter(arrayAdapter);

                                        }
                                    })
                            .setNegativeButton("Cancel",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });

                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();

                }
        });
    }
}

