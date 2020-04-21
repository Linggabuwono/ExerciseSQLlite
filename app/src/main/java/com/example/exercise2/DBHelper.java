package com.example.exercise2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "kontak.db";
    private static final int DATABASE_VERTSION = 1;
    public DBHelper(Context context){super(context, DATABASE_NAME,null,DATABASE_VERTSION); }

    public void onCreate(SQLiteDatabase db){
        String sql = "create table kontak(no integer primary key, nama text, nomor text, email text, alamat text);";
        Log.d("Data","onCreate: "+sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){

    }

}
