package com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anonymousinc.revoltijoliterario.R;

import java.util.ArrayList;

public class LeeDescubreFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lee_descubre, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvLeeDescubre);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        LeeDescubreAdapterRecyclerView leeDescubreAdapterRecyclerView = new LeeDescubreAdapterRecyclerView(buidFrases(), R.layout.cardview_leedescubre, getActivity());
        recyclerView.setAdapter(leeDescubreAdapterRecyclerView);

        return view;
    }

    public ArrayList<Modelo_LeeDescubre> buidFrases(){
        ArrayList<Modelo_LeeDescubre> arrayList = new ArrayList<>();
        arrayList.add(new Modelo_LeeDescubre("Autores", R.drawable.autorescv));
        arrayList.add(new Modelo_LeeDescubre("Poemas", R.drawable.poemascv));
        arrayList.add(new Modelo_LeeDescubre("Libros", R.drawable.libroscv));
        return arrayList;
    }
}
