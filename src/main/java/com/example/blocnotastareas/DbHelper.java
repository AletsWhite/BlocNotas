package com.example.blocnotastareas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Vector;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NOMBRE = "bloc_db";
    public static final String TABLA_NOTAS = "t_notas";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE "+TABLA_NOTAS+"("+
                "idNota INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tituloNota TEXT NOT NULL,"+
                "contenidoNota TEXT NOT NULL," +
                "tipo TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE "+TABLA_NOTAS);
        onCreate(sqLiteDatabase);
    }
}
