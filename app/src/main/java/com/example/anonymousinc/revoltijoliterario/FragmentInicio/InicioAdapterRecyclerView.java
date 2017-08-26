package com.example.anonymousinc.revoltijoliterario.FragmentInicio;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anonymousinc.revoltijoliterario.ItemClickListener;
import com.example.anonymousinc.revoltijoliterario.R;

import java.util.ArrayList;

/**
 * Created by Anonymous.Inc on 04/07/2017.
 */

public class InicioAdapterRecyclerView extends RecyclerView.Adapter<InicioAdapterRecyclerView.FrasesViewHolder> {
    private ArrayList<Modelo_Inicio> frases;
    private int resource;
    private Activity activity;

    public InicioAdapterRecyclerView(ArrayList<Modelo_Inicio> frases, int resource, Activity activity) {
        this.frases = frases;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public FrasesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new FrasesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final FrasesViewHolder holder, final int position) {
        Modelo_Inicio frase = frases.get(position);
        holder.imageCard.setBackgroundResource(frase.getImage());
        holder.textView.setText(frase.getString());
        holder.textViewinfo.setText(frase.getInfo());

        //holder.setItemClickListener(new ItemClickListener() {
        //    @Override
        //    public void OnItemClick(View v, int pos) {
        //        if(position == 0){

        //        }else if(position == 1){

        //        }else if(position == 2){

        //        }
        //    }
        //});
    }

    @Override
    public int getItemCount() {
        return frases.size();
    }

    public class FrasesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private static final int DURATION = 250;
        private ImageView imageCard;
        private TextView textView;
        private ImageView imageViewExpand;
        private ViewGroup linearLayoutDetails;
        private TextView textViewinfo;
        private ItemClickListener itemClickListener;

        public FrasesViewHolder(View itemView) {
            super(itemView);

            imageCard = (ImageView) itemView.findViewById(R.id.imageView);
            textView = (TextView) itemView.findViewById(R.id.titulo);
            imageViewExpand = (ImageView) itemView.findViewById(R.id.imageViewExpand);
            linearLayoutDetails = (ViewGroup) itemView.findViewById(R.id.linearLayoutDetails);
            textViewinfo = (TextView) itemView.findViewById(R.id.textViewInfo);

            //itemView.setOnClickListener(this);

            imageViewExpand.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toggleDetails(v);
                }
            });

        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.OnItemClick(v, getLayoutPosition(), false);
        }

        public void setItemClickListener(ItemClickListener ic){
            this.itemClickListener = ic;
        }

        public void toggleDetails(View view) {
            if (linearLayoutDetails.getVisibility() == view.GONE) {
                ExpandAndCollapseViewUtil.expand(linearLayoutDetails, DURATION);
                imageViewExpand.setImageResource(R.drawable.more);
                rotate(-180.0f);
            } else {
                ExpandAndCollapseViewUtil.collapse(linearLayoutDetails, DURATION);
                imageViewExpand.setImageResource(R.drawable.less);
                rotate(180.0f);
            }
        }

        private void rotate(float angle) {
            Animation animation = new RotateAnimation(0.0f, angle, Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f);
            animation.setFillAfter(true);
            animation.setDuration(DURATION);
            imageViewExpand.startAnimation(animation);
        }

    }
}
