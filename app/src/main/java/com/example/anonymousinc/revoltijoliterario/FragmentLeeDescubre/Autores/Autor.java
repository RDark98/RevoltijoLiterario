package com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Autores;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.UUID;

/**
 * Created by Anonymous.Inc on 04/07/2017.
 */

public class Autor {
    //Atributos
    private String id;
    private String nombre;
    private String detalle;
    private String imagen;
    private String detalle1;
    private String detalle2;
    private String detalle3;

    //Constructor
    public Autor(String nombre, String detalle, String imagen, String detalle1, String detalle2, String detalle3) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.imagen = imagen;
        this.detalle = detalle;
        this.detalle1 = detalle1;
        this.detalle2 = detalle2;
        this.detalle3 = detalle3;
    }

    //Metodo donde se le asigna a los atributos los datos de la base de datos
    public Autor(Cursor cursor) {
        id = cursor.getString(cursor.getColumnIndex(AutoresContract.AutorEntry.ID));
        nombre = cursor.getString(cursor.getColumnIndex(AutoresContract.AutorEntry.NOMBRE));
        detalle = cursor.getString(cursor.getColumnIndex(AutoresContract.AutorEntry.DETALLE));
        imagen = cursor.getString(cursor.getColumnIndex(AutoresContract.AutorEntry.IMAGEN));
        detalle1 = cursor.getString(cursor.getColumnIndex(AutoresContract.AutorEntry.DETALLE1));
        detalle2 = cursor.getString(cursor.getColumnIndex(AutoresContract.AutorEntry.DETALLE2));
        detalle3 = cursor.getString(cursor.getColumnIndex(AutoresContract.AutorEntry.DETALLE3));
    }

    //Metodos donde se ubican los datos en la base de datos
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(AutoresContract.AutorEntry.ID, id);
        values.put(AutoresContract.AutorEntry.NOMBRE, nombre);
        values.put(AutoresContract.AutorEntry.DETALLE, detalle);
        values.put(AutoresContract.AutorEntry.IMAGEN, imagen);
        values.put(AutoresContract.AutorEntry.DETALLE1, detalle1);
        values.put(AutoresContract.AutorEntry.DETALLE2, detalle2);
        values.put(AutoresContract.AutorEntry.DETALLE3, detalle3);
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

    public String getDetalle3() {
        return detalle3;
    }
}
