package com.example.saad.student_management;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    private static String TABLE_NAME = "Students";

    private static String RollNo = "ROLLNO";
    private static String Name = "NAME";
    private static String Marks = "MARKS";
    private static String Phone = "PHONE";


    public DBHelper(Context context) {
        super(context,TABLE_NAME,null,1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "Create Table Students ( ROLLNO VARCHAR(10) NOT NULL, NAME TEXT NOT NULL, MARKS VARCHAR(4) NOT NULL, PHONE VARCHAR(15) NOT NULL )";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String query = "drop table if exists " +TABLE_NAME;
        db.execSQL(query);
        onCreate(db);
    }

    public long insert(String rollno, String name, String marks, String phone){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(RollNo,rollno);
        cv.put(Name,name);
        cv.put(Marks,marks);
        cv.put(Phone,phone);

        long i = sqLiteDatabase.insert(TABLE_NAME,null,cv);
        Log.d("Database Handler ", String.valueOf(i));
        sqLiteDatabase.close();

        return i;
    }

    public Cursor getData(String rollno){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query  = "Select * from " +TABLE_NAME +" Where " +RollNo +" = '" +rollno +"'";
        Cursor c = sqLiteDatabase.rawQuery(query,null);
        return c;
    }

    public boolean delete(String rollNo){
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_NAME,RollNo +" = " +rollNo, null) > 0;
    }
}

