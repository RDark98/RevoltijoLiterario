package com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Poemas;

import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.anonymousinc.revoltijoliterario.R;

import static com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Poemas.ListaPoemasActivity.currentPoemaId;

public class DetallePoemasActivity extends AppCompatActivity {
    private CollapsingToolbarLayout mCollapsingView;
    private ImageView mImagen;
    private TextView mNum_Tel;
    private PoemasDBHelper mPoemaDbHelper;
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_poemas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarpoema);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        window = getWindow();
        window.setStatusBarColor(Color.rgb(69,90,100));

        //Referencias UI
        mCollapsingView = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layoutpoema);
        mImagen = (ImageView) findViewById(R.id.iv_avatarpoema);
        mNum_Tel = (TextView) findViewById(R.id.iv_detallepoema);

        mPoemaDbHelper = new PoemasDBHelper(getBaseContext());

        cargarPoema();
    }

    private void cargarPoema() {
        new DetallePoemasActivity.GetPoemaByIdTask().execute();
    }

    private class GetPoemaByIdTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return mPoemaDbHelper.getPoemaById(currentPoemaId);
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.moveToLast()) {
                mostrarPoema(new Poema(cursor));
            } else {
                mostrarErrorCargar();
            }
        }

    }

    private void mostrarPoema(Poema poema) {
        mCollapsingView.setTitle(poema.getNombre());
        Glide.with(this)
                .load(Uri.parse("file:///android_asset/" + poema.getImagen()))
                .centerCrop()
                .into(mImagen);
        mNum_Tel.setText(poema.getDetalle());
    }

    private void mostrarErrorCargar() {
        Toast.makeText(getApplicationContext(),
                "Error al cargar información", Toast.LENGTH_SHORT).show();
    }

    //Metodo para regresar a una actividad anterior desde un boton del toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
