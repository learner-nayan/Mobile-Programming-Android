package com.example.firstandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Redirection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.task4);

        EditText number = findViewById(R.id.userInput);
        Button submit = findViewById(R.id.submitButton);

        submit.setOnClickListener((e) ->{
            System.out.println("Clicked");
            Intent intent;

            String num = number.getText().toString();
            int score = Integer.parseInt(num);

            if (num.isEmpty()){
                Toast.makeText(this.peekAvailableContext(), "Please enter a score", Toast.LENGTH_SHORT).show();
                return;
            }

            System.out.println(score);

            if (score < 40){
                intent = new Intent(Redirection.this, FailActivity.class);
            } else if (score < 80) {
                intent = new Intent(Redirection.this, FirstActivity.class);
            } else if (score > 80) {
                intent = new Intent(Redirection.this, DistinctionActivity.class);
            }
            else {
                intent = null;
            }
            assert intent != null;
            intent.putExtra("score", score);
            startActivity(intent);
        });
    }

    public void redirectToResultPage(){

    }
}
