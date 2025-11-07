package com.example.firstandroidapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
//        setContentView(R.layout.activity_relative);

        ListView listView = findViewById(R.id.listViewExample);

        ArrayAdapter<CharSequence> listAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.student_list,
                android.R.layout.simple_list_item_1
        );

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selected = parent.getItemAtPosition(position).toString();
            Toast.makeText(this, "You selected: " + selected, Toast.LENGTH_SHORT).show();
        });

        listView.setAdapter(listAdapter);
    }
}