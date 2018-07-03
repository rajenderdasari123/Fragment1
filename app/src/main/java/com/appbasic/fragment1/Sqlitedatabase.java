package com.appbasic.fragment1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Sqlitedatabase extends SQLiteOpenHelper {
    public static final String DATABASENAME = "person.db";
    public static final String TABLENAME = "persontable";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PERSON_NAME = "name";
    public static final String COLUMN_PERSON_AGE = "age";
    public static final String COLUMN_PERSON_OCCUPATION = "occupation";


    public Sqlitedatabase(Context context) {
        super(context, DATABASENAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // sqLiteDatabase.execSQL("create table " + TABLENAME +" (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,age TEXT,occupation TEXT,image TEXT)");
        // db.execSQL("create table " + TABLENAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,age TEXT,occupation TEXT)");
        db.execSQL("create table " + TABLENAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,age TEXT,occupation TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert(String id, String name, String age, String occupation) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ID, id);
        cv.put(COLUMN_PERSON_NAME, name);
        cv.put(COLUMN_PERSON_AGE, age);
        cv.put(COLUMN_PERSON_OCCUPATION, occupation);
        long result = database.insert(TABLENAME, null, cv);
        if (result == -1)
            return false;
        else
            return true;

    }


    public boolean update(String id, String name, String age, String occupation) {

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ID, id);
        cv.put(COLUMN_PERSON_NAME, name);
        cv.put(COLUMN_PERSON_AGE, age);
        cv.put(COLUMN_PERSON_OCCUPATION, occupation);
        database.update(TABLENAME, cv, "id=?", new String[]{id});

        return true;

    }

    public Integer delete(String id) {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete(TABLENAME, "id=?", new String[]{id});
    }

    public Cursor getAlldata() {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor res = database.rawQuery("select * from " + TABLENAME, null);

        return res;
    }
}
