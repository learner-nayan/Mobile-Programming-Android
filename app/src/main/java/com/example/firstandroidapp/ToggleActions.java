package com.example.firstandroidapp;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class ToggleActions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.toggle);

        ToggleButton toggleBtn = findViewById(R.id.toggleButton);
        ScrollView toggleScrollView = findViewById(R.id.toggleScrollView);
        TextView toggleTextView = findViewById(R.id.toggleTextView);

        toggleBtn.setOnCheckedChangeListener((button, isChecked) -> {
            System.out.println("hi");
            if (isChecked){
                toggleScrollView.setBackgroundColor(Color.GRAY);
                toggleTextView.setTextColor(Color.WHITE);
                toggleBtn.setBackgroundColor(Color.BLACK);
                toggleBtn.setTextColor(Color.WHITE);
            }
            else {
                toggleScrollView.setBackgroundColor(Color.WHITE);
                toggleTextView.setTextColor(Color.BLACK);
                toggleBtn.setBackgroundColor(Color.WHITE);
                toggleBtn.setTextColor(Color.BLACK);
            }
        });

    }
}
