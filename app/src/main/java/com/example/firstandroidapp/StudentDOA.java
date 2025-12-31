package com.example.firstandroidapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class StudentDOA {
    DBHelper dbHelper;

    public StudentDOA(Context context){
        dbHelper = new DBHelper(context);
    }

    public boolean insertStudent(String name, int age){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("age", age);

        long result = db.insert("student", null, values);
        return result !=-1;
    }

    public Cursor getAllStudents(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.rawQuery("SELECT * FROM student", null);
    }

    public boolean updateStudent(String name, int age){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("age", age);

        int result = db.update("student", values, "name=?", new String[]{name});
        return result > 0;
    }

    public boolean deleteStudent(String name){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int result = db.delete("student", "name=?", new String[]{name});
        return result > 0;
    }
}
