package com.example.firstandroidapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class NoteDAO {

    NotesDBHelper notesDbHelper;

    public NoteDAO(Context context){
        notesDbHelper = new NotesDBHelper(context);
    }

    public boolean storeNote(String title, String description){
        SQLiteDatabase db = notesDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("title",title);
        values.put("description",description);

        long result = db.insert("note",null,values);
        return result !=-1;
    }

    public boolean updateNote(int id, String title, String description){
        SQLiteDatabase db = notesDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("title",title);
        values.put("description",description);

        int result = db.update("note", values, "id=?", new String[]{String.valueOf(id)});
        return result > 0;
    }

    public Cursor getAllNotes(){
        SQLiteDatabase db = notesDbHelper.getReadableDatabase();
        return db.rawQuery("SELECT * FROM name note", null);
    }

    public boolean deleteNote(int id){
        SQLiteDatabase db = notesDbHelper.getWritableDatabase();
        int result = db.delete("student", "id=?", new String[]{String.valueOf(id)});
        return result > 0;
    }
}
