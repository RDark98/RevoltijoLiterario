package com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Libros;

import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.anonymousinc.revoltijoliterario.R;

import static com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Libros.ListaLibrosActivity.currentLibroId;

public class DetalleLibrosActivity extends AppCompatActivity {
    private CollapsingToolbarLayout mCollapsingView;
    private ImageView mImagen;
    private TextView mNum_Tel;
    private LibrosDBHelper mLibroDbHelper;
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_libros);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarlibro);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        window = getWindow();
        window.setStatusBarColor(Color.rgb(69,90,100));

        //Referencias UI
        mCollapsingView = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layoutlibro);
        mImagen = (ImageView) findViewById(R.id.iv_avatarlibro);
        mNum_Tel = (TextView) findViewById(R.id.iv_detallelibro);

        mLibroDbHelper = new LibrosDBHelper(getBaseContext());

        cargarLibro();
    }

    private void cargarLibro() {
        new DetalleLibrosActivity.GetLibroByIdTask().execute();
    }

    private class GetLibroByIdTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return mLibroDbHelper.getLibroById(currentLibroId);
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.moveToLast()) {
                mostrarPoema(new Libro(cursor));
            } else {
                mostrarErrorCargar();
            }
        }

    }

    private void mostrarPoema(Libro libro) {
        mCollapsingView.setTitle(libro.getNombre());
        Glide.with(this)
                .load(Uri.parse("file:///android_asset/" + libro.getImagen()))
                .centerCrop()
                .into(mImagen);
        mNum_Tel.setText(libro.getDetalle());
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
