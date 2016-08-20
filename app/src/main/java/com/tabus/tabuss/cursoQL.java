package com.tabus.tabuss;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Humberto on 29/05/2015.
 */
public class cursoQL extends SQLiteOpenHelper {

    public cursoQL(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE favoritos(id integer primary key autoincrement not null , ruta TEXT)");
        db.execSQL("CREATE TABLE numerodealarmas(id integer primary key autoincrement not null , cont INTEGER)");
        db.execSQL("CREATE TABLE alarmas(id integer primary key autoincrement not null , año INTEGER , mes INTEGER , dia INTEGER , hora INTEGER , min INTEGER, numalarma Integer, ruta TEXT)");
        db.execSQL("CREATE TABLE gpscamionz(id integer primary key autoincrement not null , a TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
