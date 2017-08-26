package com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Poemas;

import android.provider.BaseColumns;

/**
 * Created by Anonymous.Inc on 04/07/2017.
 */

public class PoemasContract {
    public static abstract class PoemaEntry implements BaseColumns {
        //Se establece el nombre de la base de datos y se etiquetan sus columnas a usar segun los datos
        public static final String TABLE_NAME ="poema";

        public static final String ID = "id";
        public static final String NOMBRE = "nombre";
        public static final String DETALLE = "detalle";
        public static final String IMAGEN = "imagen";
        public static final String DETALLE1 = "detalle1";

    }
}
