package com.example.blocnotastareas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class VerNota extends AppCompatActivity {
    String title;
    String content, tipo;
    TextView cambioTitle;
    TextView TITLE, CONTENT;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_nota);

        title = getIntent().getStringExtra("TITLE");
        content = getIntent().getStringExtra("CONTENIDO");
        tipo = getIntent().getStringExtra("TIPO");

        TITLE = (TextView) findViewById(R.id.tvTitulo);
        cambioTitle = (TextView) findViewById(R.id.tvNotas);
        CONTENT = (TextView) findViewById(R.id.tvContenido);

        TITLE.setText(title);
        CONTENT.setText(content);
        cambioTitle.setText(tipo);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ver_nota, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuCrearOtraNota:
                volverAgregarNota();
                return true;

            case R.id.menuVolverInicio:
                volverMain();
                return true;
            case R.id.menuSalirVer:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void volverMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void volverAgregarNota(){
        Intent intent = new Intent(this, AgregarNota.class);
        startActivity(intent);
    }
}
