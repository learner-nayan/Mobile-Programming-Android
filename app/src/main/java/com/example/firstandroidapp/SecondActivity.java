package com.example.firstandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        int age = intent.getIntExtra("age", 0);

        TextView uname = findViewById(R.id.textViewUsername);
        TextView ageView = findViewById(R.id.textViewAge);

        uname.setText(username);
        ageView.setText(String.valueOf(age));
    }
}
