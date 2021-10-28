package com.example.blocnotastareas;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AgregarNota extends AppCompatActivity {
    Button Add;
    EditText TITLE, CONTENT;
    RadioButton rbNota, rbRecordatorio;
    private static final int SALIR = Menu.FIRST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_nota);

        Add = (Button) findViewById(R.id.btnAgregar);
        TITLE = (EditText) findViewById(R.id.etTitulo);
        CONTENT = (EditText) findViewById(R.id.etNota);
        rbNota = (RadioButton) findViewById(R.id.rbNota);
        rbRecordatorio = (RadioButton) findViewById(R.id.rbRecordatorio);


        Intent intent = new Intent(this, VerNota.class);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tipo = "";
                if(rbNota.isChecked()){
                    tipo = rbNota.getText().toString();
                } else if(rbRecordatorio.isChecked()){
                    tipo = rbRecordatorio.getText().toString();
                }

                DbNotas dbNotas = new DbNotas(AgregarNota.this);
                long id = dbNotas.insertarNotas(TITLE.getText().toString(), CONTENT.getText().toString(), tipo);

                if(id > 0){
                    Toast.makeText(AgregarNota.this,"Guardado", Toast.LENGTH_LONG).show();

                } else{
                    Toast.makeText(AgregarNota.this,"ERROR", Toast.LENGTH_LONG).show();
                }


                intent.putExtra("TITLE", TITLE.getText().toString());
                intent.putExtra("CONTENIDO", CONTENT.getText().toString());
                intent.putExtra("TIPO", tipo);
                startActivity(intent);
                limpiar();

            }
        });

    }

    private void limpiar(){
        TITLE.setText("");
        CONTENT.setText("");
    }
}
