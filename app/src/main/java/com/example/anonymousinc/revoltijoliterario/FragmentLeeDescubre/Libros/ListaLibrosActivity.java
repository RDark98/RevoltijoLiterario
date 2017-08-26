package com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Libros;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.anonymousinc.revoltijoliterario.R;

public class ListaLibrosActivity extends AppCompatActivity {
    public static String currentLibroId;
    private LibrosDBHelper mLibrosDbHelper;
    private ListView mLibrosList;
    private LibrosCursorAdapter mLibrosAdapter;
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_libros);
        getSupportActionBar().setTitle("Libros");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#607D8B")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        window = getWindow();
        window.setStatusBarColor(Color.rgb(69,90,100));

        // Referencias View
        mLibrosList = (ListView) findViewById(R.id.libros_list);
        mLibrosAdapter = new LibrosCursorAdapter(getBaseContext(), null);

        // Confifuracion
        mLibrosList.setAdapter(mLibrosAdapter);

        // Eventos
        mLibrosList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cursor currentItem = (Cursor) mLibrosAdapter.getItem(i);
                currentLibroId = currentItem.getString(
                        currentItem.getColumnIndex(LibrosContract.LibroEntry.ID));

                mostrarPantallaDetalle();
            }
        });

        // Instancia de helper
        mLibrosDbHelper = new LibrosDBHelper(getBaseContext());

        // Carga de datos
        cargarLibros();
    }

    private void cargarLibros() {
        new ListaLibrosActivity.LibrosLoadTask().execute();
    }

    private class LibrosLoadTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return mLibrosDbHelper.getAllLibros();
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                mLibrosAdapter.swapCursor(cursor);
            } else {
                // Mostrar empty state
            }
        }
    }

    private void mostrarPantallaDetalle() {
        Intent intent = new Intent(this, DetalleLibrosActivity.class);
        startActivity(intent);
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
