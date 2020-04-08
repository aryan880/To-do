package com.example.gitandroidstudio;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private ListView output;
    public static final String LIST = Main2Activity.class.getCanonicalName() + "list";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        output = findViewById(R.id.lstview);
        Intent intent = getIntent();
        ArrayList<String> list = intent.getStringArrayListExtra(LIST);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Main2Activity.this, android.R.layout.simple_list_item_1, list);
        output.setAdapter(arrayAdapter);
    }
}
