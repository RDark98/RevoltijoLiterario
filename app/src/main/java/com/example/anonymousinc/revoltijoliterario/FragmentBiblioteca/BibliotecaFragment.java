package com.example.anonymousinc.revoltijoliterario.FragmentBiblioteca;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anonymousinc.revoltijoliterario.R;

import java.util.ArrayList;

public class BibliotecaFragment extends Fragment {
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_biblioteca, container, false);

        BibliotecaPoemasAdapterRecyclerView bprv = new BibliotecaPoemasAdapterRecyclerView(buidPoemas(), R.layout.cardview_biblioteca, getActivity());

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.addItemDecoration(new GridSpacingItemDecoration(4, dpToPx(15), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(bprv);

        //-------------------Primer RecyclerView----------------------------------------//

        /*RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        BibliotecaLibrosAdapterRecyclerView frasesAdapterRecyclerView = new BibliotecaLibrosAdapterRecyclerView(buidLibros(), R.layout.cardview_biblioteca, getActivity());
        recyclerView.setAdapter(frasesAdapterRecyclerView);*/

        //------------------Segundo RecyclerView--------------------------------------//

        /*RecyclerView rv = (RecyclerView) view.findViewById(R.id.recyclerView1);

        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        lm.setOrientation((LinearLayoutManager.HORIZONTAL));

        rv.setLayoutManager(lm);

        BibliotecaPoemasAdapterRecyclerView bprv = new BibliotecaPoemasAdapterRecyclerView(buidPoemas(), R.layout.cardview_biblioteca, getActivity());
        rv.setAdapter(bprv);*/

        return view;
    }

    public ArrayList<Modelo_Biblioteca> buidLibros(){
        ArrayList<Modelo_Biblioteca> libro = new ArrayList<>();
        libro.add(new Modelo_Biblioteca("Castigo divino", R.drawable.librom));
        libro.add(new Modelo_Biblioteca("El país de las mujeres", R.drawable.librom));
        libro.add(new Modelo_Biblioteca("La mujer habitada", R.drawable.librom));
        libro.add(new Modelo_Biblioteca("Cantos de vida y esperanza", R.drawable.librom));
        libro.add(new Modelo_Biblioteca("Azul", R.drawable.librom));
        return libro;
    }

    public ArrayList<Modelo_Biblioteca> buidPoemas(){
        ArrayList<Modelo_Biblioteca> poema = new ArrayList<>();
        poema.add(new Modelo_Biblioteca("Al Perderte yo a ti", R.drawable.poemam));
        poema.add(new Modelo_Biblioteca("Canción de otoño en primavera", R.drawable.poemam));
        poema.add(new Modelo_Biblioteca("Canto de esperanza", R.drawable.poemam));
        poema.add(new Modelo_Biblioteca("Canto de guerra de las cosas", R.drawable.poemam));
        poema.add(new Modelo_Biblioteca("Como pesa el amor", R.drawable.poemam));
        poema.add(new Modelo_Biblioteca("Esto es amor", R.drawable.poemam));
        poema.add(new Modelo_Biblioteca("Invocacion a la sonrisa", R.drawable.poemam));
        poema.add(new Modelo_Biblioteca("La mañanita", R.drawable.poemam));
        poema.add(new Modelo_Biblioteca("Mia", R.drawable.poemam));
        poema.add(new Modelo_Biblioteca("Petición", R.drawable.poemam));
        return poema;
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
