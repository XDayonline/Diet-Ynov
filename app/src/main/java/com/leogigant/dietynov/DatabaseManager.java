package com.leogigant.dietynov;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Date;

public class DatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME= "DietYnov.db";
    private static final int DATABASE_VERSION= 2;

    public DatabaseManager (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        /* String strSql = "create table menstruations ("
                + " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + " type_de_menstruation TEXT NOT NULL,"
                + " date_de_mesure DATE NOT NULL,"
                + " mesure REAL NOT NULL"
                + "); create table my_account ("
                + " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + " birth_date DATE NOT NULL,"
                + " start_weight REAL NOT NULL,"
                + " genre TEXT NOT NULL"
                + ");"
                + " create table recette ("
                + " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + " title TEXT NOT NULL,"
                + " portions INTEGER NOT NULL,"
                + " picture_url TEXT NOT NULL,"
                + " time_total INTEGER NOT NULL,"
                + " time_prep INTEGER NOT NULL,"
                + " time_backing INTEGER NOT NULL"
                + ");"
                + " create table ingredients ("
                + " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + " recette_id INTEGER NOT NULL,"
                + " name TEXT NOT NULL,"
                + " unit TEXT,"
                + " quantity INTEGER NOT NULL,"
                + " FOREIGN KEY(recette_id) REFERENCES recette(id)"
                + ");"
                + " create table nutritions ("
                + " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + " recette_id INTEGER NOT NULL,"
                + " kcal REAL,"
                + " protein REAL,"
                + " fat REAL,"
                + " carbohydrate REAL,"
                + " sugar REAL,"
                + " sat_fat REAL,"
                + " fiber REAL,"
                + " sodium REAL,"
                + " FOREIGN KEY(recette_id) REFERENCES recette(id) "
                + ");"
                + " create table weight ("
                + " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + " date_de_mesure DATE NOT NULL,"
                + " value REAL NOT NULL"
                + ");";*/
        String strSql = "create table my_account ("
                + " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + " birth_date DATE NOT NULL,"
                + " size INTEGER NOT NULL,"
                + " start_weight REAL NOT NULL,"
                + " gender TEXT NOT NULL"
                + ");";
        try{
            Log.i("DATABASE", " " + strSql);
            db.execSQL(strSql);
            Log.i("DATABASE", "onCreate invoked");
        }catch (SQLiteException e){
            e.printStackTrace();
            e.getMessage();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String strSql = "drop table menstruations; ";
        String strSql2 = "drop table my_account; drop table recette;"
                + "drop table ingredients; drop table nutritions; drop table weight;";
        db.execSQL(strSql + strSql2);
        this.onCreate(db);
        Log.i("DATABASE", "onUpgrade invoked");
    }

    public void createAccount(int size, Date date, float startWeight, String gender){
        String strSql = "insert into my_account("
                + "birth_date, size, start_weight, gender) values ('"
                + date + "', " + size + ", " + startWeight + ", '" + gender + "')";
        this.getWritableDatabase().execSQL(strSql);
        Log.i("DATABASE", "createAccount invoked");
    }

    public Cursor getAccount(){
        String strSql = "select * from my_account";
        Cursor cursor = this.getReadableDatabase().rawQuery(strSql, null);
        cursor.moveToFirst();

        return cursor;
    }
}