package com.example.ambuj.followclass.activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.ambuj.followclass.LoginEntry;

public class MyDBHandler extends SQLiteOpenHelper {

    //database information
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "StudentDB.db";
    public static final String TABLE_NAME = "Student";
    public static final String COLUMN_ID = "StudentID";
    public static final String COLUMN_NAME = "StudentName";


    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //method used to create table
        String create_table_query = "CREATE TABLE "+TABLE_NAME+"("+COLUMN_ID+" INTEGER PRIMARY KEY,"+COLUMN_NAME+" TEXT)";
        sqLiteDatabase.execSQL(create_table_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_NAME);
    }

    //method to load data from table Student
    public String loadHandler(){
        String result="";
        String query = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        while(cursor.moveToNext()){
            int first_column = cursor.getInt(0);
            String second_column = cursor.getString(1);

            result += String.valueOf(first_column) + " " + second_column + System.getProperty("line.separator");

        }

        cursor.close();
        db.close();
        return result;

    }

    //method to add record to table Student
    public void addHandler(LoginEntry student){
        ContentValues contentValues = new ContentValues();
        Log.e("VALUE",""+student.getStudentName()+student.getStudentID());
        contentValues.put(COLUMN_ID,student.getStudentID());
        contentValues.put(COLUMN_NAME,student.getStudentName());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME,null,contentValues);
        db.close();
    }



}
