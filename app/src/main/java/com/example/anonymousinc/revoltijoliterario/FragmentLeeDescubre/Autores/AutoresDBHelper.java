package com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Autores;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Anonymous.Inc on 04/07/2017.
 */

public class AutoresDBHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Autores.db";

    private AutoresDBHelper autoresDBHelper;
    private SQLiteDatabase mDb;

    public AutoresDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Se crea la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + AutoresContract.AutorEntry.TABLE_NAME + " ("
                + AutoresContract.AutorEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + AutoresContract.AutorEntry.ID + " TEXT NOT NULL,"
                + AutoresContract.AutorEntry.NOMBRE + " TEXT NOT NULL,"
                + AutoresContract.AutorEntry.DETALLE + " TEXT NOT NULL,"
                + AutoresContract.AutorEntry.IMAGEN + " TEXT,"
                + AutoresContract.AutorEntry.DETALLE1 + " TEXT NOT NULL,"
                + AutoresContract.AutorEntry.DETALLE2 + " TEXT NOT NULL,"
                + AutoresContract.AutorEntry.DETALLE3 + " TEXT NOT NULL,"
                + "UNIQUE (" + AutoresContract.AutorEntry.ID + "))");

        // Se insertan datos ficticios para prueba inicial
        autoresDatos(db);

    }

    //Metodo donde se establecen los datos para cada contacto
    private void autoresDatos(SQLiteDatabase sqLiteDatabase) {
        datosAutor(sqLiteDatabase, new Autor("Rubén Darío", "Su verdadero nombre fue Félix Rubén García Sarmiento. Nació el 18 de enero de 1867 en Metapa (Nicaragua). Fue hijo de Manuel García y Rosa Sarmiento. Fue educado por los jesuitas. A los doce años publicó sus primeros versos. \n" +
                "\n" +
                "En 1881 se estableció en Managua y se dedicó al periodismo. En 1883 consiguió empleo en la Biblioteca Nacional. En 1886 viajó a Chile donde publicó su primer libro de poemas, \"Abrojo\". En 1888 publicó \"Azul\", el libro fundamental del movimiento modernista. \n" +
                "\n" +
                "En 1892 viajó a España, donde frecuentó a importantes escritores e intelectuales como José Zorrilla y Marcelino Menéndez Pelayo. En 1893 viajó a Argentina donde conoció a Bartolomé Mitre y Leopoldo Lugones. En 1898 regresó a España y trabó amistad con Juan Ramón Jiménez, Ramón del Valle-Inclán y Antonio Machado.\n" +
                "\n" +
                "Siguió viajando por varios países de Europa y América ejerciendo el periodismo y la diplomacia, hasta que regresó a Nicaragua en 1916. Se instaló en la ciudad de León y aquí falleció de una dolencia pulmonar el 6 de febrero de 1916.\n", "ruben.png", "Metapa, Matagalpa","1867 - 1916","Poeta y Escritor"));
        datosAutor(sqLiteDatabase, new Autor("Gioconda Belli","Gioconda Belli, nace en Managua el 9 de diciembre de 1498. es una poeta, novelista y activista nicaragüense. Su obra literaria se caracteriza por su compromiso político y por rescatar y ahondar en el universo femenino, reivindicando el papel de las mujeres en la sociedad y en la construcción de la cultura. En 1972, con su primer libro Sobre la grama, revoluciona la poesía centroamericana al abordar sin tapujos el cuerpo y la sexualidad femenina. \n" +
                "\n" +
                "Su padre, Humberto Belli, era empresario, y su madre, Gloria Pereira, fue fundadora del Teatro Experimental de Managua. Belli cursó su primaria en el Colegio de La Asunción en Managua y la secundaria en el Real Colegio de Santa Isabel en Madrid, España, en 1965. Tras obtener un diploma en Publicidad y Periodismo en Filadelfia, Estados Unidos, regresó a Managua.\n" +
                "\n" +
                "En 1967 contrajo matrimonio. Su primera hija, Marian, nació en 1969 seguida por Melissa en 1973. De su segundo matrimonio nació Camilo en 1978. Se casó por tercera vez en 1987 de cuya unión nace Adriana en 1993. Desde 1990, alterna su tiempo entre los Estados Unidos y Nicaragua.\n" +
                "\n"+
                "Durante la dictadura somocista, Gioconda Belli es perseguida y se exilió en México y Costa Rica, hasta que, con el triunfo de la Revolución Sandinista en 1979, vuelve a Nicaragua, donde desempeña diversos cargos en el nuevo gobierno hasta su renuncia en 1994.\n", "belli.png", "Managua", "1948 - Actualidad", "Poetiza y Escritora"));
        datosAutor(sqLiteDatabase, new Autor("Pablo Antonio Cuadra","Pablo Antonio Cuadra Cardenal, más conocido como Pablo Antonio Cuadra, por lo cual se le solía llamar \"PAC\". Fue hijo del jurista, estadista, historiador, canciller y diplomático nicaragüense Carlos Cuadra Pasos (1879-1964) y de la señora Mercedes Cardenal Arguello. Se casó con Adilia Bendaña Ramírez, con quien compartió su vida hasta fallecer.\n" +
                "\n"+
                "Históricamente, su familia ha estado ligada a la política y a la poesía de Nicaragua. Evidencia de esto último son su tío abuelo Vicente Cuadra, quien fue presidente de Nicaragua (1871-1875); y sus primos: Joaquín Pasos Arguello, poeta y dramaturgo, y Ernesto Cardenal, poeta, escritor, escultor, religioso y político, y Ministro de Cultura durante el gobierno sandinista (1984-1990).\n" +
                "\n"+
                "En 1931 PAC, junto con José Coronel Urtecho, Joaquín Pasos y otros escritores como Manolo Cuadra y Luis Alberto Cabrales, funda en Granada el movimiento literario denominado \"Vanguardia\", que procuraba innovar o liberar la cantidad de reglas y estamentos que ya estaban establecidos por los movimientos anteriores, por lo que su única regla era no respetar ninguna regla.\n" +
                "\n"+
                "PAC se opuso a la intervención de los Estados Unidos en Nicaragua, y apoyó al guerrillero Augusto Cesar Sandino a inicio de la década de los 1930; y también se opuso a la dinastía de los Somoza. Su compromiso político y social con su pueblo, lo llevó más tarde a abogar de manera franca y directa por los pobres de Nicaragua, razón por la cual fue brevemente encarcelado por el régimen de Somoza en 1956 y por muchos años se autoimpuso un exilio en México, España y Costa Rica Muchos años más tarde, también criticó al gobierno del Frente Sandinista de Liberación Nacional por comprometer la independencia cultural de Nicaragua y se exilió en Austin, Texas. \n" +
                "\n"+
                "Estudió derecho en la Universidad de Oriente y Mediodía de Granada, Nicaragua. En 1939 viajó por primera vez a España, visitó Cádiz, Sevilla, Santander y estuvo varias semanas en Madrid, a finales de ese año regresa a Nicaragua.\n" +
                "\n"+
                "El 26 de junio de 1945, Pablo Antonio Cuadra ingresa en la Academia Nicaragüense de la Lengua (que precisamente había fundado su padre en 1928, siendo Canciller de Nicaragua), con un discurso titulado \"Introducción del pensamiento vivo de Rubén Darío\". Fue director de esta Academia desde 1964 hasta su muerte.\n" +
                "\n"+
                "Vuelve a España en 1946, como parte de la delegación oficial de Nicaragua al XIX Congreso Mundial de Pax Romana. En esa asamblea, se constituye el Instituto Cultural Iberoamericano (presidido por el propio Pablo Antonio Cuadra), que sería la base para la creación del Instituto de Cultura Hispánica unos meses más tarde; en la actualidad Agencia Española de Cooperación Internacional para el Desarrollo. Nuevamente viaja a España en 1948.\n" +
                "\n"+
                "A partir de 1964 comenzó a publicar en el diario \"La Prensa\" de Nicaragua sus \"Escritos A Máquina\", en los que desde una perspectiva política y filosófica, comentó sobre la agitada historia de su natal Nicaragua. Llega a ser codirector de este diario en 1954 junto con su primo Pedro Joaquín Chamorro Cardenal, quien fuera asesinado por la dictadura somocista el 10 de enero de 1978.\n" +
                "\n"+
                "En 1960 funda la revista centroamericana de cultura \"El pez y la serpiente\" y funge como director de ésta durante más de cuarenta años.\n" +
                "\n"+
                "En 1988 formó parte del jurado que concedió en España el Premio Cervantes a María Zambrano. En octubre del mismo año, se presentó en el Palacio Nacional de la Cultura de Caracas, Venezuela una recopilación de la poesía religiosa de PAC: \"Libro De Horas\", ocasión en la que él declaró a la prensa: \"América sólo puede encontrar y realizar a plenitud su propia identidad si logra, con los elementos de su propia historia, realizar la síntesis entre cultura y fe\".\n" +
                "\n"+
                "En 1991 obtuvo el doctorado honoris causa del Instituto Centroamericano de Administración de Empresas (INCAE).\n" +
                "\n"+
                "En 1993 es nombrado Rector de la Universidad Católica (ÚNICA), conservando simultáneamente el cargo de Director del diario \"La Prensa\", que abandona en 1999. En 1995 la Universidad Francisco Marroquín le otorgó un doctorado honoris causa En 1999 obtuvo el doctorado honoris causa de la Universidad Thomas More de Nicaragua y en el 2001 el de la Universidad Americana de Managua (UAM).\n" +
                "\n"+
                "El 2 de enero de 2002, fallece a causa de un paro respiratorio tras una prolongada enfermedad.     Fue sepultado en Granada, ciudad donde vivió por muchos años, el 3 de enero de 2002.\n", "cuadra.png", "Managua", "1912 - 2002", "Poeta y Escritor"));
        datosAutor(sqLiteDatabase, new Autor("Sergio Ramírez", "Sergio Ramírez Mercado. (Masatepe, Masaya, 5 de agosto de 1942). Escritor, periodista, político y abogado nicaragüense, fue vicepresidente de Nicaragua durante los años 1985-1990.\n" +
                "\n"+
                "En 1959 ingresa en la Facultad de Derecho de la Universidad Nacional Autónoma de León y un año después funda la revista experimental literaria «Ventana», encabezando el movimiento literario del mismo nombre junto a Fernando Gordillo. En 1964 se gradúa como doctor en Derecho, recibiendo la Medalla de Oro como mejor estudiante de su promoción. En 1968 y 1976 es elegido secretario general de la Confederación de Universidades Centroamericanas (CSUCA), con sede en Costa Rica.\n" +
                "\n"+
                "Sergio Ramírez inicia su carrera literaria como escritor de cuentos: «El estudiante» (1960) y tres años después publica una recopilación de «Cuentos». En 1970 aparece su primera novela, «Tiempo de fulgor», alternando, hasta hoy día, la narrativa con el ensayo y el periodismo.\n" +
                "\n"+
                "En Nicaragua, en 1977, encabeza el grupo opositor de «Los Doce» integrado por intelectuales, empresarios, sacerdotes y dirigentes civiles, en apoyo del Frente Sandinista de Liberación Nacional (FSLN) en lucha contra el régimen del presidente nicaragüense Somoza. Dos años después forma parte del gobierno de Nicaragua junto al político Daniel Ortega, retirándose de la política en 1996 para dedicarse a la literatura.\n" +
                "\n"+
                "Como editor, funda en 1978 la Editorial Universitaria Centroamericana (EDUCA) en San José (Costa Rica) y en 1982 la editorial Nueva Nicaragua. Desde 1999 da clases en diferentes universidades de EE.UU., México, Perú, España y Chile.\n" +
                "\n"+
                "Un año después de su graduación empieza a colaborar en prensa, dirigiendo publicaciones como «Carátula» y «El libro azul», del Centro Nicaragüense de Escritores. Como periodista ha trabajado en distintos medios centroamericanos de Guatemala, Panamá, Honduras, El Salvador y Costa Rica, así como en otros países de América del Sur, como Chile, Argentina, Venezuela, Bolivia, etc. En España publica el blog El Boomeran, dentro del diario «El País». \n" +
                "\n"+
                "La universidad de Princeton custodia una colección de manuscritos de sus escritos, correspondencia personal, literaria y política, papeles y documentos relacionados con la carrera política de Sergio Ramírez y de la historia política de Nicaragua, así como fotografías y material gráfico e impreso.\n" +
                "\n"+
                "Su obra ha sido traducida a más de 20 idiomas.\n" +
                "\n"+
                "En 2014 es nombrado vocal del patronato del Instituto Cervantes, en representación de las letras y la cultura latinoamericanas. \n", "ramirez.png", "Masatepe, Masaya","1942 - Actualidad", "Escritor y Periodista"));
        datosAutor(sqLiteDatabase, new Autor("Ernesto Cardenal", "Poeta, escritor y religioso nicaragüense, Ernesto Cardenal nació en Granada el 20 de enero de 1925. Miembro destacado de la teología de la liberación, su obra poética está considerada fundamental para la literatura hispanoamericana del siglo XX.\n" +
                "\n" +
                "Formado en Nicaragua y más tarde en México y Europa, luchó contra Anastasio Somoza en la Revolución de Abril nicaragüense tras lo que se ordenaría sacerdote. Años después publicaría El evangelio de Solentiname, obra clave en su trayectoria dentro de la teología de la liberación.\n" +
                "\n" +
                "Tras la revolución sandinista, Cardenal ocupó el puesto de ministro de cultura durante varios años, lo que, junto a su postura diferente a la del vaticano, lo apartó del aparato oficial de la iglesia católica.\n" +
                "\n" +
                "De entre su obra habría que destacar poemarios como Epigramas, Con Walker en Nicaragua, El telescopio en la noche oscura, o Pasajero de tránsito. Propuesto en varias ocasiones al Premio Nobel, ha obtenido además diversos premios y honores, como el Premio Iberoamericano Pablo Neruda y el Premio Reina Sofía de Poesía en 2012.\n", "cardenal.png", "Granada", "1925 - Actualidad", "Poeta y Escritor"));
        datosAutor(sqLiteDatabase, new Autor("Manolo Cuadra", "Manolo Cuadra nació en Malacatoya, Granada el 9 de agosto de 1907, fue el quinto hijo del Matrimonio Cuadra Vega, siendo sus hermanos en orden de nacimiento: Julia, Luciano, Abelardo, María, Mercedes, Ramiro, José y Gilberto.\n" +
                "\n"+
                "Desde su nacimiento hasta 1915 cuando ingresa a estudiar con los Salesianos vivió con su familia en la ciudad de Granada y en el puerto de San Juan del Sur.\n" +
                "\n"+
                "Un 10 de enero de 1920 muere su madre Josefa María Vega Fornos, afectada por la tuberculosis.\n" +
                "\n"+
                "En 1922 regresa a vivir con su familia que se ha trasladado a Masaya y durante dos años (1922-1924) trabajó con su padre en la oficina de telégrafos de la ciudad de Masaya. En 1925 se une temporalmente a \"La Constabularia\" durante la Segunda República Conservadora pero luego regresa a ayudar a su padre.\n" +
                "\n"+
                "En 1927 empieza a publicar sus escritos en periódicos locales. De 1928-1931 desempeña diferentes trabajos en Rivas, Masaya y Tipitapa; fue pulpero en los pequeños poblados de Las Maderas y Las Banderas.\n" +
                "\n"+
                "En noviembre de 1931 regresa a Managua y en 1932 nuevamente se enlista al ejército constabulario, futura Guardia Nacional de Nicaragua, como operador de radio.2 Es enviado a Quilalí, en Las Segovias, enfrentando a los campesinos que apoyaban la lucha del General Sandino. De 1933-1934 es transferido a los poblados de El Jícaro, Ocotal, y Teotecacinte.\n" +
                "\n"+
                "Abandona las filas de la Guardia Nacional en 1935 y se dedica al periodismo. Sin embargo, pronto cae preso por su participación en la sublevación de oficiales contra Anastasio Somoza García, Jefe Director G.N., y es enviado a la cárcel de \"La Veintiuno\" por haber colaborado con su hermano el Teniente G.N. Abelardo Cuadra Vega. Su hermano es procesado y condenado a muerte, perdonándosele después la pena.\n" +
                "\n"+
                "En 1936 se halla en Tipitapa, escribiendo la selección de narraciones cortas \"Contra Sandino en la Montaña\". Somoza tiene otros planes, lo acusa de comunista y en febrero de 1937 lo destierra a la Isla Little Corn Island, en el Mar Caribe. Regresa a Managua en noviembre. En este año publica su diario del exilio Itinerario de Little Corn Island (Managua, Editorial Novedades).\n" +
                "\n"+
                "En julio de 1939 sale hacia Costa Rica y trabaja, entre otros empleos, como peón en las bananeras de la United Fruit Co. En 1942 está de nuevo en Managua y trabaja como redactor en varios periódicos. Publica el libro de relatos \"Contra Sandino en la montaña\" (Managua, Editorial Nuevos Horizontes). En 1943 está de nuevo en la cárcel y en 1944 en Masaya con la ciudad por cárcel. En 1945 publica \"Almidón\" como caricatura y retrato del país (Managua, Editorial Nuevos Horizontes). Viaja a Costa Rica, regresa y vive en Managua hasta que, durante los meses de Julio y agosto de 1947, es exiliado a la isla de Ometepe. así dejando de ser libre de su patria por simple adquisición administrativa de las elecciones culturales de Nicaragua En 1950 viaja a Nueva York; en 1951 es desterrado a El Salvador y a su regreso a Managua se dedica al periodismo. En 1952 viaja a Europa. En 1955 publica \"Tres amores\" (Managua, Editorial Krumen) y en agosto, es desterrado a Costa Rica. En Abril hospeda a Carlos Fonseca. En julio de 1957 regresa a Managua, y muere de cáncer el 14 de noviembre de 1957.\n", "manolo.png", "Malacatoya, Granada ", "1907 - 1957", "Escritor"));
        datosAutor(sqLiteDatabase, new Autor("Joaquín Pasos", "Nació en Granada el 14 de mayo de 1914, se formó en el Colegio Centroamérica hasta bachillerarse. Anteriormente había estudiado parte de la primaria en el centro escolar de una apreciable y recordada profesora de la ciudad, a la que dedicaría —años más tarde— su poema ocasional La era de la Carmela Noguera. Por consiguiente, la presencia granadina —con el muelle de su puerto lacustre y el kiosko de su Parque Colón, las niñas estudiando piano a las diez de la mañana y los cocoteros, a medianoche, temblando bajo la luna— se halla presente en sus inicios poéticos.\n" +
                "\n" +
                "Un poeta precoz, que escribía poesía con facilidad desde niño, y que llegó a resumir, según el criterio de Manolo Cuadra, las dos tendencias fundamentales en que se debatía en el mundo la poesía de vanguardia: la claridad y el hermetismo —las dos hemisferios que constituían, a la vez., su propia naturaleza— un doble don que conservó hasta su muy temprana muerte. Fue también un estupendo humorista, y sus ataques a la dictadura de Somoza en La Semana Cómica y Los Lunes de la Nueva Prensa lo llevaron no pocas veces a la cárcel.\n" +
                "\n" +
                "1932 fue el año de su floración vanguardista, rica en vivencias literarias. Algunos lo toman muy en serio, como Pedro J. Cuadra Ch., director de El Diario Nicaragüense, quien le dedica unas glosas de sus artículos combativos en un pequeño libro: Puntos de literatura.\n" +
                "\n" +
                "De 1933 a 1934, mientras colabora en Suplemento, La Reacción y La Voz de Oriente, estudia Derecho en su ciudad natal.\n" +
                "\n" +
                "En 1935 se trasladó a Managua para proseguir su carrera. Labora y colabora en varias revistas: Ópera bufa 1938, Centro, Los Lunes de la Nueva Prensa (donde tiene a su cargo las sesiones fijas “Laboratorio” y “Manicomio”).\n" +
                "\n" +
                "Termina su quinto curso de Derecho en la Universidad Central, pero no se preocupa por obtener el título. Viaja por avión a San José de Costa Rica en busca del libro Todo puede suceder de George y Helen Papashvily. Su familia le arregla sus cosas personales en casa de una novia, con la que nunca contrae matrimonio; en cambio, tiene un hijo con otra.\n" +
                "\n" +
                "Había dejado corregidas las pruebas de una selección poética Breve suma (Managua, Editorial Nuevos Horizontes). Y un traductor de poesía francesa y japonesa, china y africana; un cuentista (su cuento El ángel pobre debe figurar en todas las antologías centroamericanas), un ensayista, un humorista y un poeta excelente había desaparecido.\n" +
                "\n" +
                "En 1943, a la edad de 29 años, fueron escogidas las muestras de su inagotable madurez poética para representar al Movimiento Nicaragüense de Vanguardia y Post-vanguardia, del que había sido su más alegre miembro y benjamín. Pero su poesía no era poesía de juventud sino juventud hecha poesía, dotada como nadie para la invención admirable y el fino humor.\n" +
                "\n" +
                "Su grandeza está en el poder que tiene de convertir el lenguaje poético en un lenguaje común, o viceversa, dentro de una transparencia que se vuelve mágica; o como escribe Ernesto Cardenal, purificó en sus poemas el lenguaje de su pueblo/ en el que un día se escribirán los tratados de comercio/ la Constitución, las cartas de amor, y los decretos...Su poema Canto de guerra de las cosas, escrito en las postrimerías de la Segunda Guerra Mundial, es uno de los grandes momentos de nuestra literatura.\n" +
                "\n" +
                "Sus poesías sólo fueron recogidos muy parcialmente después de su muerte en Breve Suma (1947), un cuaderno publicado por la Editorial Nuevos Horizontes en Managua; pero la primer antología importante de su obra, seleccionada por Ernesto Cardenal, apareció en México en 1962 bajo el título Poemas de un joven.\n" +
                "\n" +
                "Los poemas fueron agrupados de acuerdo al plan que Joaquín había diseñado para su obra inédita: Poemas de un joven que no ha viajado nunca (que incluía sus poemas sobre países que nunca visitó, pues prácticamente no salió de Nicaragua); Poemas de un joven que no ha amado nunca (que incluía sus poesías de amor); Poemas de un joven que no sabe inglés (que incluía sus poemas en esa lengua, que aprendió sin maestro desde niño); y además, Misterio indio, sus poemas de temática indígena.\n" +
                "\n" +
                "Dentro de su evolución creadora, se distinguen dos fases: la adolescente, que abarca de 1928 a 1935, gestada entre los catorce y veintiún años de edad; y la juvenil propiamente dicha, a partir del último año. A la primera fase pertenecen canciones inspiradas en modelos alemanes e ingleses, y especialmente españoles.\n" +
                "\n" +
                "La dipsomanía le hostiga, prepara su agonía; y el 20 de enero de 1947, cuatro meses antes de cumplir los 33 años, se le acaba la vida.\n", "pasos.png", "Granada", "1914 - 1947", "Poeta y Escritor"));
    }

    //Metodo que inserta los datos, a la base de datos
    public long datosAutor(SQLiteDatabase db, Autor autor) {
        return db.insert(
                AutoresContract.AutorEntry.TABLE_NAME,
                null,
                autor.toContentValues());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No hay operaciones
    }

    //Metodo para obtener todos los contactos
    public Cursor getAllAutores() {
        return getReadableDatabase()
                .query(
                        AutoresContract.AutorEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    //Metodo para obtener los contactos segun el id relacionado
    public Cursor getAutorById(String autorId) {
        Cursor c = getReadableDatabase().query(
                AutoresContract.AutorEntry.TABLE_NAME,
                null,
                AutoresContract.AutorEntry.ID + " LIKE ?",
                new String[]{autorId},
                null,
                null,
                null);
        return c;
    }
}
