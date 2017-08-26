package com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Autores;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anonymousinc.revoltijoliterario.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListaAutoresActivity extends AppCompatActivity{
    public static String currentAutorId;
    private AutoresDBHelper mAutoresDbHelper;
    private ListView mAutoresList;
    private AutoresCursorAdapter mAutoresAdapter;
    private Window window;

    Cursor cursor;
    private final static String TAG = ListaAutoresActivity.class.getName().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_autores);
        getSupportActionBar().setTitle("Autores");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#607D8B")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        window = getWindow();
        window.setStatusBarColor(Color.rgb(69,90,100));

        // Referencias View
        mAutoresList = (ListView) findViewById(R.id.lawyers_list);
        mAutoresAdapter = new AutoresCursorAdapter(getBaseContext(), null);

        // Confifuracion
        mAutoresList.setAdapter(mAutoresAdapter);
        mAutoresList.setTextFilterEnabled(true);

        // Eventos
        mAutoresList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cursor currentItem = (Cursor) mAutoresAdapter.getItem(i);
                currentAutorId = currentItem.getString(
                        currentItem.getColumnIndex(AutoresContract.AutorEntry.ID));

                mostrarPantallaDetalle();
            }
        });

        // Instancia de helper
        mAutoresDbHelper = new AutoresDBHelper(getBaseContext());

        // Carga de datos
        cargarAutores();
    }

    private void cargarAutores() {
        new AutoresLoadTask().execute();
    }

    private class AutoresLoadTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return mAutoresDbHelper.getAllAutores();
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                mAutoresAdapter.swapCursor(cursor);
            } else {
                // Mostrar empty state
            }
        }
    }

    private void mostrarPantallaDetalle() {
        Intent intent = new Intent(this, DetalleAutoresActivity.class);
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
