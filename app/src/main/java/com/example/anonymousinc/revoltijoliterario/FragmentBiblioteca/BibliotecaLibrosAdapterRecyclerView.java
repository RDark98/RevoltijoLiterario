package com.example.anonymousinc.revoltijoliterario.FragmentBiblioteca;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anonymousinc.revoltijoliterario.ItemClickListener;
import com.example.anonymousinc.revoltijoliterario.R;
import com.example.anonymousinc.revoltijoliterario.VisorPDF.VisorPDFActivity;

import java.util.ArrayList;

/**
 * Created by Anonymous.Inc on 29/06/2017.
 */

public class BibliotecaLibrosAdapterRecyclerView extends RecyclerView.Adapter<BibliotecaLibrosAdapterRecyclerView.BibliotecaLibrosViewHolder>{
    private ArrayList<Modelo_Biblioteca> modelol;
    private int resource;
    private Activity activity;

    private String []infolibro = {"Titulo: Castigo divino\nAutor: Sergio Ramírez",
            "Titulo: El país de las mujeres\nAutora: Gioconda Belli",
            "Titulo: La mujer habitada \nAutora: Gioconda Belli",
            "Titulo: Cantos de vida y esperanza\nAutor: Rubén Darío ",
            "Titulo: Azul\nAutor: Rubén Darío "};

    public BibliotecaLibrosAdapterRecyclerView(ArrayList<Modelo_Biblioteca> modelol, int resource, Activity activity) {
        this.modelol = modelol;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public BibliotecaLibrosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new BibliotecaLibrosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BibliotecaLibrosViewHolder holder, final int position) {
        Modelo_Biblioteca modelo_biblioteca = modelol.get(position);
        holder.imageCard1.setBackgroundResource(modelo_biblioteca.getmImage());
        holder.textView1.setText(modelo_biblioteca.getmText());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void OnItemClick(View view, int position, boolean isLongClick) {
                if (isLongClick) {
                    Toast.makeText(activity, infolibro[position], Toast.LENGTH_SHORT).show();
                } else {
                    if(position == 0){

                    }else if(position == 1){

                    }else if(position == 2){

                    }else if(position == 3){

                    }else if(position == 4){

                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelol.size();
    }

    public class BibliotecaLibrosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        private ImageView imageCard1;
        private TextView textView1;
        private ItemClickListener itemClickListener;

        public BibliotecaLibrosViewHolder(View itemView) {
            super(itemView);

            imageCard1 = (ImageView) itemView.findViewById(R.id.thumbnail);
            textView1 = (TextView) itemView.findViewById(R.id.title);

            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.OnItemClick(v, getLayoutPosition(), false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.OnItemClick(v, getPosition(), true);
            return false;
        }

        public void setItemClickListener(ItemClickListener ic){
            this.itemClickListener = ic;
        }


    }
}
