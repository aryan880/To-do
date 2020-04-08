package com.example.gitandroidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText;
    private ArrayList<String> addArray = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btn);
        editText = findViewById(R.id.edttext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotesDatabase.addNote(MainActivity.this, "Hello this is a new note aryan2");
            }
        });
    }
    private void openActivity2() {
        String getInput = editText.getText().toString();
        if (addArray.contains(getInput)) {
            Toast.makeText(getBaseContext(), "Item already added! ", Toast.LENGTH_LONG).show();
        } else if (getInput.trim().equals("")) {
            Toast.makeText(this, "Empty input!", Toast.LENGTH_LONG).show();
        } else {
            addArray.add(getInput);
            Intent intent = new Intent(this, Main2Activity.class);
            intent.putExtra(Main2Activity.LIST, addArray);
            startActivity(intent);
        }
    }
}
