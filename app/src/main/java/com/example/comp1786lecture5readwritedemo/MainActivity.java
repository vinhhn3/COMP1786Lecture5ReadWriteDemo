package com.example.comp1786lecture5readwritedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private static final String NOTES_FILE_NAME = "notes.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onPause(){
        super.onPause();

        try {
            FileOutputStream out = openFileOutput(NOTES_FILE_NAME, Context.MODE_PRIVATE);

            EditText textEditor = findViewById(R.id.textEditor);

            out.write(textEditor.getText().toString().getBytes());

            out.close();
        }catch (Exception e){
            Toast.makeText(this, "Exception " + e.toString(),
                    Toast.LENGTH_LONG
            ).show();
        }
    }

}