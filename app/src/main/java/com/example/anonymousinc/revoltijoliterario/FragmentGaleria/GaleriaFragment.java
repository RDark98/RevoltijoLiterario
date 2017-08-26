package com.example.anonymousinc.revoltijoliterario.FragmentGaleria;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ToxicBakery.viewpager.transforms.FlipHorizontalTransformer;
import com.example.anonymousinc.revoltijoliterario.R;

import me.relex.circleindicator.CircleIndicator;

public class GaleriaFragment extends Fragment{
    private CustomPagerAdapter mCustomPagerAdapter;
    private ViewPager mViewPager;
    private CircleIndicator mViewPagerIndicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_galeria, container, false);

        mCustomPagerAdapter = new CustomPagerAdapter(getContext());

        mViewPager = (ViewPager) view.findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);
        mViewPager.setPageTransformer(true, new FlipHorizontalTransformer());

        mViewPagerIndicator = (CircleIndicator) view.findViewById(R.id.indicator_custom);
        mViewPagerIndicator.setViewPager(mViewPager);

        return view;
    }
}
