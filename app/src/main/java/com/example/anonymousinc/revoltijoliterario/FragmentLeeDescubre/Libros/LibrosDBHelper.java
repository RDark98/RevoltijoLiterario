package com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Libros;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Anonymous.Inc on 04/07/2017.
 */

public class LibrosDBHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Libros.db";

    public LibrosDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Se crea la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + LibrosContract.LibroEntry.TABLE_NAME + " ("
                + LibrosContract.LibroEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + LibrosContract.LibroEntry.ID + " TEXT NOT NULL,"
                + LibrosContract.LibroEntry.NOMBRE + " TEXT NOT NULL,"
                + LibrosContract.LibroEntry.DETALLE + " TEXT NOT NULL,"
                + LibrosContract.LibroEntry.IMAGEN + " TEXT,"
                + LibrosContract.LibroEntry.DETALLE1 + " TEXT NOT NULL,"
                + LibrosContract.LibroEntry.DETALLE2 + " TEXT NOT NULL,"
                + "UNIQUE (" + LibrosContract.LibroEntry.ID + "))");

        // Se insertan datos ficticios para prueba inicial
        librosDatos(db);

    }

    //Metodo donde se establecen los datos para cada contacto
    private void librosDatos(SQLiteDatabase sqLiteDatabase) {
        datosLibro(sqLiteDatabase, new Libro("Castigo divino", "En Castigo divino, el amor y el sexo, la intriga política y el poder económico se dan cita para crear una de las novelas más complejas y fascinantes sobre la sociedad centroamericana.\n" +
                "\n" +
                "Una cadena de asesinatos por envenenamiento tiene lugar en la ciudad de León, Nicaragua, en los años treinta. El presunto asesino, un brillante abogado y poeta, también será una víctima más, cuando su historia particular alcance dimensiones colectivas, y el sentido ético sea trastocado en vísperas de la dictadura perpetrada desde Nicaragua hasta Guatemala.\n" +
                "\n" +
                "La escritura de Sergio Ramírez subyace la novela por entregas, el reportaje periodístico, el intricado lenguaje jurídico, las imágenes modernistas, además de representar uno de los más pulcros homenajes a la tradición novelística.\n", "libro1.jpg","Sergio Ramírez ","1988"));
        datosLibro(sqLiteDatabase, new Libro("El país de las mujeres ","El país de las mujeres. Es una divertida novela dirigida especialmente a las mujeres, en la que está reconocida escritora nicaragüense especula sobre cómo sería un país gobernado exclusivamente por mujeres. \n" +
                "\n" +
                "Las osadas integrantes del PIE, el Partido de la Izquierda Erótica, quienes ganaron las elecciones en Faguas, el país imaginario inventado por Belli en varias de sus obras, quieren utilizar todos los defectos y cualidades considerados femeninos para cambiar el rumbo de su país, de limpiarlo como si se tratara de una casa mal cuidada, de barrerlo hasta sacarle brillo. \n" +
                "\n" +
                "¿Lograrán la presidenta Viviana Sansón y sus ministras sobrellevar los ataques de sus enemigos y enemigas? ¿Será Faguas después de su administración un mejor país? ¿Viviana Sansón sobrevivirá al atentado del que fue víctima? Sin duda una poderosa novela que dará de qué hablar a mujeres y a hombres.\n", "libro2.jpg", "Gioconda Belli", "2010"));
        datosLibro(sqLiteDatabase, new Libro("La mujer habitada","La mujer habitada sumerge al lector en un mundo mágico y ferozmente vital, en el que la mujer, víctima tradicional de la dominación masculina, se rebela contra la secular inercia y participa de forma activa en acontecimientos que transforman la realidad. Partiendo de la dramática historia de Itzá, que por amor a Yarince muere luchado contra los invasores españoles, el relato nos conduce hasta Lavinia, joven arquitecta, moderna e independiente, que al terminar sus estudios en Europa ve su país con ojos diferentes. \n" +
                "\n" +
                "Mientras trabaja en un estudio de arquitectos, Lavinia conoce a Felipe, y la intensa pasión que surge entre ambos es el estímulo que la lleva a comprometerse en la lucha de liberación contra la dictadura de Somoza. Rebosante de un fuerte lirismo, La mujer habitada mantiene en vilo al lector hasta el desenlace final.\n", "libro3.jpg", "Gioconda Belli", "1988"));
        datosLibro(sqLiteDatabase, new Libro("Cantos de vida y esperanza", "Libro publicado en 1905, CANTOS DE VIDA Y ESPERANZA, los cisnes y otros poemas representa la cima y síntesis de la obra lírica de Rubén Darío (1867-1916). En esta obra canónica, el poeta nicaragüense reorientó una escritura que, sin abandonar los mundos de «Azul» y «Prosas profanas» da espacio a la irrupción impetuosa de lo personal en su poesía: sentimientos de culpa y también gozosos, pesares y temores, atracción por el eros y anhelo de espiritualidad se unen a reflexiones sobre la cultura, la historia y la defensa de lo americano y lo hispánico, amenazado en la confluencia de los siglos XIX y XX por poderosas fuerzas como Estados Unidos", "libro4.jpg", "Rubén Darío  ", "1905"));
        datosLibro(sqLiteDatabase, new Libro("Azul", "En esta obra fundamental para el desarrollo de la corriente modernista en el ámbito de las letras hispanas, Rubén Darío (1867-1916) aportó una nueva sensibilidad y una diferente concepción del arte, al tiempo que demostraba una extraordinaria capacidad para apropiarse y transformar en sustancia propia las influencias más variadas. Animada por una decidida voluntad de renovar la poesía castellana del momento, Azul…, que inició la renovación modernista que había de culminar en «Prosas profanas» (L 5325) y «Cantos de vida y esperanza» (L 5332), tuvo una rápida repercusión en los países de habla hispana y supuso un fortísimo estímulo para los escritores de la segunda generación del modernismo hispanoamericano.", "libro5.jpg", "Rubén Darío","1888"));
    }

    //Metodo que inserta los datos, a la base de datos
    public long datosLibro(SQLiteDatabase db, Libro libro) {
        return db.insert(
                LibrosContract.LibroEntry.TABLE_NAME,
                null,
                libro.toContentValues());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No hay operaciones
    }

    //Metodo para obtener todos los contactos
    public Cursor getAllLibros() {
        return getReadableDatabase()
                .query(
                        LibrosContract.LibroEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    //Metodo para obtener los contactos segun el id relacionado
    public Cursor getLibroById(String contactoId) {
        Cursor c = getReadableDatabase().query(
                LibrosContract.LibroEntry.TABLE_NAME,
                null,
                LibrosContract.LibroEntry.ID + " LIKE ?",
                new String[]{contactoId},
                null,
                null,
                null);
        return c;
    }
}
