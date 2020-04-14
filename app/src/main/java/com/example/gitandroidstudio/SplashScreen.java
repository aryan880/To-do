package com.example.gitandroidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Button;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN_TIME_OUT=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(SplashScreen.this, ToDoList.class);
                    //Intent is used to switch from one activity to another.
                    startActivity(i);
                    //invoke the SecondActivity.
                    finish();
                    //the current activity will get finished.
                }
            }, SPLASH_SCREEN_TIME_OUT);

//        public class MainActivity extends AppCompatActivity {
//            private EditText tasks;
//            private Button btn1;
//            private ArrayList<String> addArray = new ArrayList<String>();
//            @Override
//            protected void onCreate(Bundle savedInstanceState) {
//                super.onCreate(savedInstanceState);
//                setContentView(R.layout.activity_main);
//                tasks = findViewById(R.id.edtText);
//                btn1 = findViewById(R.id.btn);
//                btn1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        openActivity2();
//                    }
//                });
//            }
//            private void openActivity2() {
//                String getInput = tasks.getText().toString();
//                if (addArray.contains(getInput)) {
//                    Toast.makeText(getBaseContext(), "Item already added! ", Toast.LENGTH_LONG).show();
//                } else if (getInput.trim().equals("")) {
//                    Toast.makeText(this, "Empty input!", Toast.LENGTH_LONG).show();
//                } else {
//                    addArray.add(getInput);
//                    Intent intent = new Intent(this, MainActivity2.class);
//                    intent.putExtra(MainActivity2.LIST, addArray);
//                    startActivity(intent);
//                }
//            }
//        }
//        public class MainActivity2 extends AppCompatActivity {
//            public static final String LIST = MainActivity2.class.getCanonicalName() + "list";
//            @Override
//            protected void onCreate(Bundle savedInstanceState) {
//                super.onCreate(savedInstanceState);
//                setContentView(R.layout.activity_main3);
//                ListView output = findViewById(R.id.list123);
//                Intent intent = getIntent();
//                ArrayList<String> list = intent.getStringArrayListExtra(LIST);
//                ArrayAdapter<String> arrayAdapter =
//                        new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_list_item_1, list);
//                output.setAdapter(arrayAdapter);
//            }
//        }
    }
}