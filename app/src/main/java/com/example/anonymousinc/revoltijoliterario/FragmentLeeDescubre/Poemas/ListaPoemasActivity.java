package com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Poemas;

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

import com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Autores.AutoresContract;
import com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Autores.AutoresCursorAdapter;
import com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Autores.AutoresDBHelper;
import com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Autores.DetalleAutoresActivity;
import com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Autores.ListaAutoresActivity;
import com.example.anonymousinc.revoltijoliterario.R;

public class ListaPoemasActivity extends AppCompatActivity {
    public static String currentPoemaId;
    private PoemasDBHelper mPoemasDbHelper;
    private ListView mPoemasList;
    private PoemasCursorAdapter mPoemasAdapter;
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_poemas);
        getSupportActionBar().setTitle("Poemas");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#607D8B")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        window = getWindow();
        window.setStatusBarColor(Color.rgb(69,90,100));

        // Referencias View
        mPoemasList = (ListView) findViewById(R.id.poemas_list);
        mPoemasAdapter = new PoemasCursorAdapter(getBaseContext(), null);

        // Confifuracion
        mPoemasList.setAdapter(mPoemasAdapter);

        // Eventos
        mPoemasList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cursor currentItem = (Cursor) mPoemasAdapter.getItem(i);
                currentPoemaId = currentItem.getString(
                        currentItem.getColumnIndex(AutoresContract.AutorEntry.ID));

                mostrarPantallaDetalle();
            }
        });

        // Instancia de helper
        mPoemasDbHelper = new PoemasDBHelper(getBaseContext());

        // Carga de datos
        cargarPoemas();
    }

    private void cargarPoemas() {
        new ListaPoemasActivity.PoemasLoadTask().execute();
    }

    private class PoemasLoadTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return mPoemasDbHelper.getAllPoemas();
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                mPoemasAdapter.swapCursor(cursor);
            } else {
                // Mostrar empty state
            }
        }
    }

    private void mostrarPantallaDetalle() {
        Intent intent = new Intent(this, DetallePoemasActivity.class);
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
