package com.leogigant.dietynov;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.time.LocalDate;
import java.util.ArrayList;
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
        String strSql2 = "create table weight ("
                + " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + " date_de_mesure TEXT NOT NULL,"
                + " value REAL NOT NULL"
                + ");";
        String strSql3 = " create table recette ("
                + " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + " title TEXT NOT NULL,"
                + " portions INTEGER NOT NULL,"
                + " picture_url TEXT NOT NULL,"
                + " time_total INTEGER NOT NULL,"
                + " time_prep INTEGER NOT NULL,"
                + " time_backing INTEGER NOT NULL"
                + ");";
        String strSql4 = " create table ingredients ("
                + " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + " recette_id INTEGER NOT NULL,"
                + " name TEXT NOT NULL,"
                + " unit TEXT,"
                + " quantity INTEGER NOT NULL,"
                + " FOREIGN KEY(recette_id) REFERENCES recette(id)"
                + ");";
        String strSql5 = " create table nutritions ("
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
                + ");";
        try{
            db.execSQL(strSql);
            db.execSQL(strSql2);
            db.execSQL(strSql3);
            db.execSQL(strSql4);
            db.execSQL(strSql5);
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
        android.text.format.DateFormat dateFormat = new android.text.format.DateFormat();
        String dateFound = dateFormat.format("dd/MM/yyyy", date).toString();

        String strSql = "insert into my_account("
                + "birth_date, size, start_weight, gender) values ('"
                + dateFound + "', " + size + ", " + startWeight + ", '" + gender + "')";
        this.getWritableDatabase().execSQL(strSql);
        Log.i("DATABASE", "createAccount invoked");
    }

    public Cursor getAccount(){
        String strSql = "select * from my_account";
        Cursor cursor = this.getReadableDatabase().rawQuery(strSql, null);
        cursor.moveToFirst();

        return cursor;
    }

    public void addWeight(Float value){
        Date date = new Date();
        android.text.format.DateFormat dateFormat = new android.text.format.DateFormat();
        String dateFound = dateFormat.format("dd/MM/yyyy", date).toString();

        String strSql = "insert into weight("
                + "date_de_mesure, value) values ('" + dateFound + "', " + value + ");";
        this.getWritableDatabase().execSQL(strSql);
        Log.i("DATABASE", "addWeight invoked");
    }

    public ArrayList<Weight> getWeight(){
        ArrayList<Weight> weightArray = new ArrayList<Weight>();
        String strSql = "select * from weight order by id desc";
        Cursor cursor = this.getReadableDatabase().rawQuery(strSql, null);
        cursor.moveToFirst();

        while (! cursor.isAfterLast()){
            Weight myWeight = new Weight(cursor.getString(1), cursor.getFloat(2));
            weightArray.add(myWeight);
            cursor.moveToNext();
        }

        return weightArray;
    }
}