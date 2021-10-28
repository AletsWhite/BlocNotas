package com.example.blocnotastareas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbNotas extends DbHelper{

    Context context;
    public DbNotas(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarNotas(String title, String content, String tipo){
        long id = 0;

            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("tituloNota", title);
            values.put("contenidoNota", content);
            values.put("tipo", tipo);

            id = db.insert(TABLA_NOTAS, null, values);

        return id;
    }

    public ArrayList<Notas> mostrarNotas(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Notas> listaNotas = new ArrayList<>();
        Notas notas = null;
        Cursor cursorNotas = null;

        cursorNotas = db.rawQuery("SELECT * FROM " + TABLA_NOTAS, null);

        if(cursorNotas.moveToFirst()){
            do{
                notas = new Notas();
                notas.setId(cursorNotas.getInt(0));
                notas.setTitle(cursorNotas.getString(1));
                notas.setContenido(cursorNotas.getString(2));
                notas.setTipo(cursorNotas.getString(3));
                listaNotas.add(notas);
            }while(cursorNotas.moveToNext());
        }

        cursorNotas.close();

        return listaNotas;
    }
}
