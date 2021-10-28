package com.example.blocnotastareas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaNotasAdapter extends RecyclerView.Adapter<ListaNotasAdapter.NotaViewHolder>{

    ArrayList<Notas> listaNotas;

    public ListaNotasAdapter(ArrayList<Notas> listaNotas){
        this.listaNotas = listaNotas;
    }


    @NonNull
    @Override
    public NotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_notas, null, false);
        return new NotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotaViewHolder holder, int position) {

        holder.tvTitle.setText(listaNotas.get(position).getTitle());
        holder.tvContent.setText(listaNotas.get(position).getContenido());
        holder.tvTipo.setText(listaNotas.get(position).getTipo());

    }

    @Override
    public int getItemCount() {
        return listaNotas.size();
    }

    public class NotaViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvContent, tvTipo;
        public NotaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTituloVista);
            tvContent = itemView.findViewById(R.id.tvContenidoVer);
            tvTipo = itemView.findViewById(R.id.tvTipo);
        }
    }
}
