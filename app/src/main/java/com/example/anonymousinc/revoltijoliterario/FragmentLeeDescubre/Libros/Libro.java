package com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Libros;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.UUID;

/**
 * Created by Anonymous.Inc on 04/07/2017.
 */

public class Libro {
    //Atributos
    private String id;
    private String nombre;
    private String detalle;
    private String imagen;
    private String detalle1;
    private String detalle2;

    //Constructor
    public Libro(String nombre, String detalle, String imagen, String detalle1, String detalle2) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.imagen = imagen;
        this.detalle = detalle;
        this.detalle1 = detalle1;
        this.detalle2 = detalle2;
    }

    //Metodo donde se le asigna a los atributos los datos de la base de datos
    public Libro(Cursor cursor) {
        id = cursor.getString(cursor.getColumnIndex(LibrosContract.LibroEntry.ID));
        nombre = cursor.getString(cursor.getColumnIndex(LibrosContract.LibroEntry.NOMBRE));
        detalle = cursor.getString(cursor.getColumnIndex(LibrosContract.LibroEntry.DETALLE));
        imagen = cursor.getString(cursor.getColumnIndex(LibrosContract.LibroEntry.IMAGEN));
        detalle1 = cursor.getString(cursor.getColumnIndex(LibrosContract.LibroEntry.DETALLE1));
        detalle2 = cursor.getString(cursor.getColumnIndex(LibrosContract.LibroEntry.DETALLE2));
    }

    //Metodos donde se ubican los datos en la base de datos
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(LibrosContract.LibroEntry.ID, id);
        values.put(LibrosContract.LibroEntry.NOMBRE, nombre);
        values.put(LibrosContract.LibroEntry.DETALLE, detalle);
        values.put(LibrosContract.LibroEntry.IMAGEN, imagen);
        values.put(LibrosContract.LibroEntry.DETALLE1, detalle1);
        values.put(LibrosContract.LibroEntry.DETALLE2, detalle2);
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

    public String getDetalle2() {
        return detalle2;
    }
}
