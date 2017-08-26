package com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Poemas;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.UUID;

/**
 * Created by Anonymous.Inc on 04/07/2017.
 */

public class Poema {
    //Atributos
    private String id;
    private String nombre;
    private String detalle;
    private String imagen;
    private String detalle1;

    //Constructor
    public Poema(String nombre, String detalle, String imagen, String detalle1) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.imagen = imagen;
        this.detalle = detalle;
        this.detalle1 = detalle1;
    }

    //Metodo donde se le asigna a los atributos los datos de la base de datos
    public Poema(Cursor cursor) {
        id = cursor.getString(cursor.getColumnIndex(PoemasContract.PoemaEntry.ID));
        nombre = cursor.getString(cursor.getColumnIndex(PoemasContract.PoemaEntry.NOMBRE));
        detalle = cursor.getString(cursor.getColumnIndex(PoemasContract.PoemaEntry.DETALLE));
        imagen = cursor.getString(cursor.getColumnIndex(PoemasContract.PoemaEntry.IMAGEN));
        detalle1 = cursor.getString(cursor.getColumnIndex(PoemasContract.PoemaEntry.DETALLE1));
    }

    //Metodos donde se ubican los datos en la base de datos
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(PoemasContract.PoemaEntry.ID, id);
        values.put(PoemasContract.PoemaEntry.NOMBRE, nombre);
        values.put(PoemasContract.PoemaEntry.DETALLE, detalle);
        values.put(PoemasContract.PoemaEntry.IMAGEN, imagen);
        values.put(PoemasContract.PoemaEntry.DETALLE1, detalle1);
        return values;
    }

    //Metodos para obtener los datos de los atributos
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public String getImagen() {
        return imagen;
    }

    public String getDetalle1() {
        return detalle1;
    }
}
