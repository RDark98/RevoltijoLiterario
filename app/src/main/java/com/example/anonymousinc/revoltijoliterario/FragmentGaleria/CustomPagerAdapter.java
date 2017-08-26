package com.example.anonymousinc.revoltijoliterario.FragmentGaleria;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.anonymousinc.revoltijoliterario.R;

/**
 * Created by Anonymous.Inc on 01/07/2017.
 */

public class CustomPagerAdapter extends PagerAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private int[] mResources = {
            R.drawable.retrato1,
            R.drawable.retrato2,
            R.drawable.retrato3,
            R.drawable.retrato4,
            R.drawable.retrato5,
            R.drawable.retrato6,
    };

    private String[] mTitulos = {
            "Rubén Darío",
            "Ernesto Cardenal",
            "Pablo Antonio Cuadra",
            "Gioconda Belli",
            "Fernando Silva",
            "Monumento a Rubén Darío en el Parque Forestal, Santiago de Chile."
    };

    public CustomPagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mResources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.myImageView);
        imageView.setImageResource(mResources[position]);

        TextView textView = (TextView) itemView.findViewById(R.id.myImageViewText);
        textView.setText(mTitulos[position]);

        if(position==6){
            textView.setTextColor(Color.parseColor("#009688"));
        }

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
