package com.example.blocnotastareas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView listaNotes;
    ArrayList<Notas> listaArrayNotas;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaNotes=(RecyclerView) findViewById(R.id.listaNotas);
        listaNotes.setLayoutManager(new LinearLayoutManager(this));

        DbNotas dbNotas = new DbNotas(MainActivity.this);

        listaArrayNotas = new ArrayList<>();

        ListaNotasAdapter adapter = new ListaNotasAdapter(dbNotas.mostrarNotas());
        listaNotes.removeAllViews();
        listaNotes.setAdapter(adapter);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuNota:
                nuevoRegistro();
                return true;

            case R.id.menuSalir:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void nuevoRegistro(){
        Intent intent = new Intent(this, AgregarNota.class);
        startActivity(intent);
    }
}