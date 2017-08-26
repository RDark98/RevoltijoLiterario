package com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Autores.ListaAutoresActivity;
import com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Libros.ListaLibrosActivity;
import com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Poemas.ListaPoemasActivity;
import com.example.anonymousinc.revoltijoliterario.ItemClickListener;
import com.example.anonymousinc.revoltijoliterario.R;

import java.util.ArrayList;

/**
 * Created by Anonymous.Inc on 01/07/2017.
 */

public class LeeDescubreAdapterRecyclerView extends RecyclerView.Adapter<LeeDescubreAdapterRecyclerView.LeeDescubreViewHolder>{
    private ArrayList<Modelo_LeeDescubre> modelold;
    private int resource;
    private Activity activity;

    public LeeDescubreAdapterRecyclerView(ArrayList<Modelo_LeeDescubre> modelold, int resource, Activity activity) {
        this.modelold = modelold;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public LeeDescubreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new LeeDescubreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LeeDescubreViewHolder holder, final int position) {
        Modelo_LeeDescubre modelo = modelold.get(position);
        holder.imageCard.setBackgroundResource(modelo.getImage());
        holder.textView.setText(modelo.getString());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void OnItemClick(View v, int pos, boolean isLongClick) {
                if(position == 0){
                    Intent intent = new Intent(activity, ListaAutoresActivity.class);
                    activity.startActivity(intent);
                }else if(position == 1){
                    Intent intent = new Intent(activity, ListaPoemasActivity.class);
                    activity.startActivity(intent);
                }else if(position == 2){
                    Intent intent = new Intent(activity, ListaLibrosActivity.class);
                    activity.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelold.size();
    }

    public class LeeDescubreViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView imageCard;
        private TextView textView;
        private ItemClickListener itemClickListener;

        public LeeDescubreViewHolder(View itemView) {
            super(itemView);

            imageCard = (ImageView) itemView.findViewById(R.id.imagecard);
            textView = (TextView) itemView.findViewById(R.id.textcard);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.OnItemClick(v, getLayoutPosition(), false);
        }

        public void setItemClickListener(ItemClickListener ic){
            this.itemClickListener = ic;
        }
    }
}
