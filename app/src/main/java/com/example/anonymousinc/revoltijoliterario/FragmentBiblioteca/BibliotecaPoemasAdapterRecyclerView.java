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

public class BibliotecaPoemasAdapterRecyclerView extends RecyclerView.Adapter<BibliotecaPoemasAdapterRecyclerView.BibliotecaPoemasViewHolder> {
    private ArrayList<Modelo_Biblioteca> modelop;
    private int resource;
    private Activity activity;

    private String []infopoema = {"Titulo: Al perderte yo a ti\nAutor: Ernesto Cardenal",
                            "Titulo: Canción de otoño en primavera\nAutor: Ruben Dario",
                            "Titulo: Canto de esperanza\nAutor: Ruben Dario",
                            "Titulo: Canto de guerra de las cosas\nAutor: Joaquin Pasos",
                            "Titulo: Como pesa el amor\nAutora: Gioconda Belli",
                            "Titulo: Esto es amor\nAutora: Gioconda Belli",
                            "Titulo: Invocacion a la sonrisa\nAutora: Gioconda Belli",
                            "Titulo: La mananita\nAutor: Ernesto Cardenal",
                            "Titulo: Mia\nAutor: Ruben Dario",
                            "Titulo: Petición\nAutora: Gioconda Belli"};

    public BibliotecaPoemasAdapterRecyclerView(ArrayList<Modelo_Biblioteca> modelop, int resource, Activity activity) {
        this.modelop = modelop;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public BibliotecaPoemasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new BibliotecaPoemasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BibliotecaPoemasViewHolder holder, final int position) {
        Modelo_Biblioteca modelo_biblioteca = modelop.get(position);
        holder.imageCard1.setBackgroundResource(modelo_biblioteca.getmImage());
        holder.textView1.setText(modelo_biblioteca.getmText());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void OnItemClick(View view, int position, boolean isLongClick) {
                if (isLongClick) {
                    Toast.makeText(activity, infopoema[position], Toast.LENGTH_SHORT).show();
                } else {
                    if(position == 0){
                        String []titulos = {"Al perderte yo a ti","alperderteyoati.pdf"};
                        Intent intent = new Intent(activity, VisorPDFActivity.class);
                        intent.putExtra("ArrayA", titulos);
                        activity.startActivity(intent);
                    }else if(position == 1){
                        String []titulos = {"Cancion de otoño en primavera","canciondeotonoenprimavera.pdf"};
                        Intent intent = new Intent(activity, VisorPDFActivity.class);
                        intent.putExtra("ArrayA", titulos);
                        activity.startActivity(intent);
                    }else if(position == 2){
                        String []titulos = {"Canto de esperanza","cantodeesperanza.pdf"};
                        Intent intent = new Intent(activity, VisorPDFActivity.class);
                        intent.putExtra("ArrayA", titulos);
                        activity.startActivity(intent);
                    }else if(position == 3){
                        String []titulos = {"Canto de guerra de las cosas","cantodeguerradelascosas.pdf"};
                        Intent intent = new Intent(activity, VisorPDFActivity.class);
                        intent.putExtra("ArrayA", titulos);
                        activity.startActivity(intent);
                    }else if(position == 4){
                        String []titulos = {"Como pesa el amor","comopesaelamor.pdf"};
                        Intent intent = new Intent(activity, VisorPDFActivity.class);
                        intent.putExtra("ArrayA", titulos);
                        activity.startActivity(intent);
                    }else if(position == 5){
                        String []titulos = {"Esto es amor","estoesamor.pdf"};
                        Intent intent = new Intent(activity, VisorPDFActivity.class);
                        intent.putExtra("ArrayA", titulos);
                        activity.startActivity(intent);
                    }else if(position == 6){
                        String []titulos = {"Invocacion a la sonrisa","invocacionalasonrisa.pdf"};
                        Intent intent = new Intent(activity, VisorPDFActivity.class);
                        intent.putExtra("ArrayA", titulos);
                        activity.startActivity(intent);
                    }else if(position == 7){
                        String []titulos = {"La mañanita","lamananita.pdf"};
                        Intent intent = new Intent(activity, VisorPDFActivity.class);
                        intent.putExtra("ArrayA", titulos);
                        activity.startActivity(intent);
                    }else if(position == 8){
                        String []titulos = {"Mia","mia.pdf"};
                        Intent intent = new Intent(activity, VisorPDFActivity.class);
                        intent.putExtra("ArrayA", titulos);
                        activity.startActivity(intent);
                    }else if(position == 9){
                        String []titulos = {"Peticion","peticion.pdf"};
                        Intent intent = new Intent(activity, VisorPDFActivity.class);
                        intent.putExtra("ArrayA", titulos);
                        activity.startActivity(intent);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelop.size();
    }

    public class BibliotecaPoemasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        private ImageView imageCard1;
        private TextView textView1;
        private ItemClickListener itemClickListener;

        public BibliotecaPoemasViewHolder(View itemView) {
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
            return true;
        }

        public void setItemClickListener(ItemClickListener ic){
            this.itemClickListener = ic;
        }


    }
}
