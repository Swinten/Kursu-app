package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class BD extends SQLiteOpenHelper {
    private Context context;
    public static final String DATABASE_NAME = "11zon";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "ASK";
    public ArrayList<Quest> arrayList = new ArrayList<>();

    public BD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query;
        query = "CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY, quest TEXT, sub1 TEXT, sub2 TEXT, sub3 TEXT, sub4 TEXT,ri TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public long addquest(String quest, String sub1, String sub2, String sub3, String sub4, String re) {
        SQLiteDatabase sqLiteDatabase = this .getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("quest", quest);
        values.put("sub1", sub1);
        values.put("sub2", sub2);
        values.put("sub3", sub3);
        values.put("sub4", sub4);
        values.put("ri", re);
        System.out.println(re);
        long ABOBA = sqLiteDatabase.insert(TABLE_NAME, null , values);
        if(ABOBA == -1){
            Toast.makeText(context, "Ошибка", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Успешно добавлен", Toast.LENGTH_SHORT).show();
        }
        sqLiteDatabase.close();
        System.out.println("WORK");
        return ABOBA;
    }


    public ArrayList<Quest> getNotes() {

        String select_query= "SELECT *FROM " + TABLE_NAME;

        SQLiteDatabase db = this .getWritableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);

        if (cursor.moveToFirst()) {
            do {
                Quest noteModel = new Quest();
                noteModel.setName(cursor.getString(1));
                noteModel.setTq1(cursor.getString(2));
                noteModel.setTq2(cursor.getString(3));
                noteModel.setTq3(cursor.getString(4));
                noteModel.setTq4(cursor.getString(5));
                noteModel.setri(cursor.getString(6));
                System.out.println(cursor.getString(0));
                System.out.println(cursor.getString(1));
                System.out.println(cursor.getString(2));
                System.out.println(cursor.getString(3));
                System.out.println(cursor.getString(4));
                System.out.println(cursor.getString(5));
                System.out.println(cursor.getString(6));
                arrayList.add(noteModel);
            }while (cursor.moveToNext());
        }
        return arrayList;
    }


    public void delete(String ID) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, "ID=" + ID, null);
        sqLiteDatabase.close();
    }
}
