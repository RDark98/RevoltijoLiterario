package com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Autores;

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

import static com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Autores.ListaAutoresActivity.currentAutorId;

public class DetalleAutoresActivity extends AppCompatActivity {
    private CollapsingToolbarLayout mCollapsingView;
    private ImageView mImagen;
    private TextView mNum_Tel;
    private AutoresDBHelper mAutoresDbHelper;
    private Window window;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_autores);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        window = getWindow();
        window.setStatusBarColor(Color.rgb(69,90,100));

        //Referencias UI
        mCollapsingView = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        mImagen = (ImageView) findViewById(R.id.iv_avatar);
        mNum_Tel = (TextView) findViewById(R.id.iv_detalle);

        mAutoresDbHelper = new AutoresDBHelper(getBaseContext());

        cargarAutor();
    }

    private void cargarAutor() {
        new GetAutorByIdTask().execute();
    }

    private class GetAutorByIdTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return mAutoresDbHelper.getAutorById(currentAutorId);
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.moveToLast()) {
                mostrarContacto(new Autor(cursor));
            } else {
                mostrarErrorCargar();
            }
        }

    }

    private void mostrarContacto(Autor autor) {
        mCollapsingView.setTitle(autor.getNombre());
        Glide.with(this)
                .load(Uri.parse("file:///android_asset/" + autor.getImagen()))
                .centerCrop()
                .into(mImagen);
        mNum_Tel.setText(autor.getDetalle());
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
