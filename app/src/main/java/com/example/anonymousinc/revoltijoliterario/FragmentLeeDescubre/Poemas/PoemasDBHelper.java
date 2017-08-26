package com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Poemas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Anonymous.Inc on 04/07/2017.
 */

public class PoemasDBHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Poemas.db";

    public PoemasDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Se crea la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + PoemasContract.PoemaEntry.TABLE_NAME + " ("
                + PoemasContract.PoemaEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + PoemasContract.PoemaEntry.ID + " TEXT NOT NULL,"
                + PoemasContract.PoemaEntry.NOMBRE + " TEXT NOT NULL,"
                + PoemasContract.PoemaEntry.DETALLE + " TEXT NOT NULL,"
                + PoemasContract.PoemaEntry.IMAGEN + " TEXT,"
                + PoemasContract.PoemaEntry.DETALLE1 + " TEXT NOT NULL,"
                + "UNIQUE (" + PoemasContract.PoemaEntry.ID + "))");

        // Se insertan datos ficticios para prueba inicial
        poemasDatos(db);

    }

    //Metodo donde se establecen los datos para cada contacto
    private void poemasDatos(SQLiteDatabase sqLiteDatabase) {
        datosPoema(sqLiteDatabase, new Poema("Al perderte yo a ti", "Grandioso poema creado por Ernesto Cardenal, sacerdote nicaragüense, que les dedica estos versos a las personas que sufren un desamor.\n" +
                " \n" +
                "En esta composición cardenal narra una historia, en la cual, el hombre, sufre un desamor. Ante ese dolor, muestra un amor honesto y puro, que aun sufriendo la ruptura, es sincero ante todo y dice sentir mucho.\n" +
                "\n" +
                "A pesar de la trágica ruptura, reconoce que su amor es muy grande, y que nadie podrá quererla tanto como él lo hizo. Pero en esa desdicha, sabe que él podrá amar a otra mujer, tanto como la amo a ella.\n" +
                "\n" +
                "Este profundo poema abre una luz de esperanza, ante las adversidades que trae consigo la vida.\n", "poema.png", "Ernesto Cardenal"));
        datosPoema(sqLiteDatabase, new Poema("Canto de guerra de la cosas","Canto de guerra de las cosas, es uno de los testimonios más dramáticos del siglo xx. Es notable el paso de sus inicios poéticos llenos de humor y de un sentido jubiloso de la vida, a la visión descarnada y a la vez parturienta de este poema motivado por el vértice de dos muertes: la del mundo en la segunda guerra mundial, y la cercanía prematura de su propia muerte.", "poema.png", "Joaquín Pasos"));
        datosPoema(sqLiteDatabase, new Poema("Mia","El nombre de la amada, Mía, que para el poeta es su luz, su belleza, su pasión y su amor. El poeta está entregado al amor hacia esta mujer. Sin embargo, no sabe si es correspondido. Ha tenido una relación íntima con ella y para el poeta ha sido especial. Sin embargo, hay tristeza en ambos. El poeta siente que la separación está cerca.\n" +
                "En este poema el poeta es capaz de concentrar varios elementos de la poesía amorosa. Por un lado, los sentimientos profundos de él como hombre y cómo su amor es incondicional hacia ella. Por otro lado hay esa lucha interior con sus sentimientos porque siente que, en el fondo, no es correspondido.\n" +
                "\n" +
                "Sin embargo, entre ambos ha habido una relación. Parece que están en una etapa de crisis, de final y la separación entre ambos parece que va ser más pronto que tarde. Esto es algo de lo que parece que el poeta tiene la certeza de que ocurrirá y no puede hacer nada para evitarlo.\n" +
                "\n" +
                "En la última estrofa aparece un elemento nuevo que, no suele un aparecer en otros poemas. El poeta se abre al lector y muestra sus sentimientos poniendo encima de la mesa todo su deseo y conocemos que esperaba estar con la amada hasta los últimos días de su vida. Sin embargo, parece que esto no ocurrirá.\n" +
                "\n" +
                "Es por ello que hablamos de que el poema, por un lado nos habla de la vida y por otro lado nos habla del final, no de ésta, sino de una relación, del amor. Es por ello que el amor es el tema fundamental de estos versos. Se ve desde el punto de vista del poeta, que es el que está entregado a la mujer y, por otro lado, también vemos el punto de vista de la amada, que es más sutil y el que menos se toca, pero el más importante porque sabemos que va haber una separación entre ambos.\n" +
                "\n" +
                "También es importante destacar que no se nos describe a la amada físicamente y tampoco se nos dice qué es lo que piensa. Únicamente se hace hincapié en los sentimientos del poeta y en el sufrimiento interior del mismo al tener la certeza del fin de la relación que mantiene con ella. Es hermoso ver cómo se puede decir tanto en tan pocas palabras, en tan pocos versos.\n", "poema.png", "Rubén Darío"));
        datosPoema(sqLiteDatabase, new Poema("Canción de otoño en primavera", "El poema Canción de otoño en primavera, es uno de los poemas más famosos del célebre poeta nicaragüense Rubén Darío, máximo exponente del modernismo hispanoamericano. En él, con un tono general de añoranza, se refiere al tema de la pérdida de la juventud y el sentimiento de melancolía que produce.\n" +
                "\n" +
                "El poema, como tal, fue publicado en el poemario Cantos de vida y esperanza, de 1905, que es considerado no solo uno de los mejores libros del autor, sino una de las obras más logradas del modernismo hispanoamericano.\n" +
                "\n" +
                "El modernismo, corriente literaria de la cual Rubén Darío fue su más destacado cultor, se propuso renovar la literatura en lengua española, y se caracterizó por su perfección formal, un lenguaje preciosista, el empleo de imágenes de gran belleza y el gusto por lo exótico, entre otras cosas.\n", "poema.png", "Rubén Darío"));
        datosPoema(sqLiteDatabase, new Poema("La mañanita","Hermoso escrito de Ernesto cardenal, en el cual se describe de forma poética todas las hermosas riquezas naturales que posee Nicaragua, promoviendo de esta manera el amor por el país, además de hacernos saber lo afortunados que somos por haber nacido en una nación tan bella. \n" +
                " \n" +
                "En este poema predominan los lagos y lagunas, así como la presencia de varios símiles entre el cielo azul infinito y Nicaragua, ya que estamos rodeados de dos mares, muchos lagos y un cielo predominante y puro, También nos hace mención de uno de los volcanes más activo del país, como es el volcán Masaya.   \n" +
                " \n" +
                "Finalmente se hace una mención especial a la alegría de los pobladores del país al recitar el hermoso poema de Rubén Darío, “del trópico”, en forma de canción. ","poema.png","Ernesto Cardenal"));
        datosPoema(sqLiteDatabase, new Poema("Petición","Gioconda Belli, nos regala un poema totalmente romántico, donde describe una persona enamorada que necesita sentirse amada, segura, con ganas de volver a la vida en cada acto de amor. Después de sentirse muerta en vida, “como ciudad deshabitada” a la falta de una persona a quien amar. \n" +
                " \n" +
                "Además, nos recalca que las personas no nacieron para estar triste, la tristeza debe ser algo pasajero, necesario para lograr la felicidad plena, pero jamás debe habitar nuestros corazones por largo tiempo, porque cuando la tristeza es permanente también la vida misma se esfuma permanentemente. ","poema.png","Gioconda Belli"));
        datosPoema(sqLiteDatabase, new Poema("Como pesa el amor","Poema dedicado a las personas que se les acaba el amor, o no saben valorar todo el amor y cariño que reciben de las demás personas, recordándonos que las cosas no duran para siempre y cuando esas personas se den cuentan del amor que perdieron por no valorar ya no podrán hacer nada y entonces la soledad les pesara y aún más los rastros de que algún día recibieron amor quedara grabado en sus mentes y corazones como la peor de las torturas. \n" +
                " \n" +
                "La persona que da amor sin recibir podrá dar amor de nuevo, pero la persona que recibe sin dar, solo descubrirá y lamentará pronto que un amor no se recibe igual dos veces en la vida. ","poema.png","Gioconda Belli"));
        datosPoema(sqLiteDatabase, new Poema("Invocación a la sonrisa","Gioconda Belli nos presenta un poema corto con un romanticismo profundo en sus pocas líneas, el amor, la felicidad, la confianza, las promesas son algunas de las cosas que se abarca, por otra parte, se hace uso de símil con frutas para explicar que por amor se puede hacer todo. además de admirar distintos fenómenos naturales, sumergidos en la paz profunda del amor. ","poema.png","Gioconda Belli"));
        datosPoema(sqLiteDatabase, new Poema("Esto es amor","Esto es amor, no narra las tristezas que pasa una persona luego de haber sido dejada en el olvido por su pareja, las odiosea que debe superar para recuperar la felicidad, aunque esta felicidad no sea del todo completa debido al vacío que esa persona ha dejado. \n" +
                " \n" +
                "Nos presenta esos amores que marcan la vida, que causan un antes y un después en nuestra existencia, que enseñan con la misma intensidad la felicidad y la tristeza, la compañía y la soledad, el amor y la indiferencia. \n" +
                " \n" +
                "Y finalmente nos enseña que el amor con todas su maravilla solo se presenta en su total esplendor una vez en la vida, dejando a su paso rastros imborrables en forma de tristeza.","poema.png","Gioconda Belli"));
        datosPoema(sqLiteDatabase, new Poema("Canto de esperanza","Poema espectacular de Rubén Darío, que nos narra muchos acontecimientos catastróficos que ocurren día a día en nuestro mundo, debido a la maldad arraigada en el alma de los hombres, maldad ejemplificada con el nacimiento del anticristo. \n" +
                " \n" +
                "Ahora bien,  ¿Por qué se llama canto de esperanza? si empieza narrando cosas desalentadoras, por la razón que nos da la esperanza de librarnos de toda esa maldad en Jesucristo. \n" +
                "  \n" +
                "Esperar su regreso para que limpie toda la maldad del mundo, y mientras esperamos su venida cultivar el amor en nuestros corazones, así como él nos ha enseñado.","poema.png","Rubén Darío"));
    }

    //Metodo que inserta los datos, a la base de datos
    public long datosPoema(SQLiteDatabase db, Poema poema) {
        return db.insert(
                PoemasContract.PoemaEntry.TABLE_NAME,
                null,
                poema.toContentValues());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No hay operaciones
    }

    //Metodo para obtener todos los contactos
    public Cursor getAllPoemas() {
        return getReadableDatabase()
                .query(
                        PoemasContract.PoemaEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    //Metodo para obtener los contactos segun el id relacionado
    public Cursor getPoemaById(String poemaId) {
        Cursor c = getReadableDatabase().query(
                PoemasContract.PoemaEntry.TABLE_NAME,
                null,
                PoemasContract.PoemaEntry.ID + " LIKE ?",
                new String[]{poemaId},
                null,
                null,
                null);
        return c;
    }
}
