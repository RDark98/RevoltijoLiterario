package com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Autores;

import android.provider.BaseColumns;

/**
 * Created by Anonymous.Inc on 04/07/2017.
 */

public class AutoresContract {
    public static abstract class AutorEntry implements BaseColumns {
        //Se establece el nombre de la base de datos y se etiquetan sus columnas a usar segun los datos
        public static final String TABLE_NAME ="autor";

        public static final String ID = "id";
        public static final String NOMBRE = "nombre";
        public static final String DETALLE = "detalle";
        public static final String IMAGEN = "imagen";
        public static final String DETALLE1 = "detalle1";
        public static final String DETALLE2 = "detalle2";
        public static final String DETALLE3 = "detalle3";

    }
}
