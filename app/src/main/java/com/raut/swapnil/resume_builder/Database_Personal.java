package com.raut.swapnil.resume_builder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sumit on 28-10-2017.
 */

class Database_Personal extends SQLiteOpenHelper {
    public Database_Personal(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists personal(_id integer primary key autoincrement, name text, mobile text, email text, dob text, age text, address text, language text, hobbies text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addValue(int id, String name, String mobile, String email,String dob, String age, String address, String language, String hobbies) {
        ContentValues emptyRow = new ContentValues();
        emptyRow.put("_id",id);
        emptyRow.put("name", name);
        emptyRow.put("mobile", mobile);
        emptyRow.put("email", email);
        emptyRow.put("dob", dob);
        emptyRow.put("age", age);
        //emptyRow.put("address", address);
        //emptyRow.put("language", language);
        //emptyRow.put("hobbies", hobbies);


        SQLiteDatabase db = getWritableDatabase();
        String[] col = {"address","language","age"};
        db.insert("personal",null , emptyRow);
    }

    public void readValues() {

        SQLiteDatabase db = getReadableDatabase();
        //String[] columns = { "name", "mobile" , "email" , "dob" , "age" , "address" , "language" , "hobbies" };
        Cursor c = db.query("personal", null , null, null, null, null, null);

        c.moveToFirst();

        for (int i = 0; i < c.getCount(); i++) {
            System.out.println(c.getString(c.getColumnIndex("_id")));
            System.out.println(c.getString(c.getColumnIndex("name")));
            System.out.println(c.getString(c.getColumnIndex("mobile")));
            System.out.println(c.getString(c.getColumnIndex("email")));
            System.out.println(c.getString(c.getColumnIndex("dob")));
            System.out.println(c.getString(c.getColumnIndex("age")));
            System.out.println(c.getString(c.getColumnIndex("address")));
            System.out.println(c.getString(c.getColumnIndex("language")));
            System.out.println(c.getString(c.getColumnIndex("hobbies")));


            c.moveToNext();
        }

    }


}
