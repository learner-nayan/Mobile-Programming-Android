package com.example.firstandroidapp;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class NoteDbOperation extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_linear);

        EditText title = findViewById(R.id.title);
        EditText description = findViewById(R.id.description);

        Button create = findViewById(R.id.create_note);
//        Button update = findViewById(R.id.update_student);
//        Button delete = findViewById(R.id.delete_student);
//        Button get = findViewById(R.id.get_students);

        NoteDAO dao = new NoteDAO(this);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = title.getText().toString().trim();
                String a = description.getText().toString().trim();

                if(a.isEmpty() || n.isEmpty()){
                    Toast.makeText(NoteDbOperation.this, "All fields required", Toast.LENGTH_SHORT).show();
                    return;
                }

                dao.storeNote(n, a);

                title.getText().clear();
                description.getText().clear();

                Toast.makeText(NoteDbOperation.this, "Create clicked", Toast.LENGTH_SHORT).show();
            }
        });

//        update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String n = name.getText().toString().trim();
//                String a = age.getText().toString().trim();
//
//                if(a.isEmpty() || n.isEmpty()){
//                    Toast.makeText(StudentDbOperation.this, "All fields required", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                dao.updateStudent(n,Integer.parseInt(a));
//
//                name.getText().clear();
//                age.getText().clear();
//
//                Toast.makeText(StudentDbOperation.this, "Update clicked", Toast.LENGTH_SHORT).show();
//            }
//        });

//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String n = name.getText().toString().trim();
//
//                if(n.isEmpty()){
//                    Toast.makeText(StudentDbOperation.this, "Name", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                dao.deleteStudent(n);
//
//                name.getText().clear();
//                age.getText().clear();
//
//                Toast.makeText(StudentDbOperation.this, "Delete clicked", Toast.LENGTH_SHORT).show();
//            }
//        });

//        get.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v){
//                Cursor cursor = dao.getAllStudents();
//
//                if (cursor.getCount() == 0){
//                    Toast.makeText(StudentDbOperation.this, "No Data", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                StringBuilder builder = new StringBuilder();
//
//                while (cursor.moveToNext()){
//                    builder.append("ID: ").append(cursor.getInt(0)).append("\n");
//                    builder.append("Name: ").append(cursor.getString(1)).append("\n");
//                    builder.append("Age: ").append(cursor.getInt(2)).append("\n");
//                }
//
//                new AlertDialog.Builder(StudentDbOperation.this)
//                        .setTitle("Students")
//                        .setMessage(builder.toString())
//                        .setCancelable(true)
//                        .show();
//            }
//        });

    }
}
