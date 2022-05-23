package com.example.parqueaderocolombia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminDatabase extends SQLiteOpenHelper {

    // Declaración de constantes, en versión y nombre de base de datos
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Parqueadero.db";

    private static final String SQL_CREATE = "CREATE TABLE registros (placa text primary key, vehiculo text, hora datetime, registro text)";

    public AdminDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if exists registros");
        db.execSQL(SQL_CREATE);
    }
}
