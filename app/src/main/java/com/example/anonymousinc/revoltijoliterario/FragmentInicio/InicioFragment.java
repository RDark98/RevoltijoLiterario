package com.example.anonymousinc.revoltijoliterario.FragmentInicio;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.anonymousinc.revoltijoliterario.R;

import java.util.ArrayList;
import java.util.HashMap;

public class InicioFragment extends Fragment {
    private SliderLayout mDemoSlider;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        mDemoSlider = (SliderLayout) view.findViewById(R.id.slider);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("150 Aniversario de Rubén Darío",R.drawable.ruben);
        file_maps.put("Las 100 de PAC",R.drawable.pac);
        file_maps.put("Ramírez con Edmundo Paz Soldán en la Feria Internacional del Libro de Miami, noviembre de 2011",R.drawable.feria);
        file_maps.put("Gioconda Belli, Feria del libro de Leipzig 2016",R.drawable.febelli);
        file_maps.put("Taller de Creación Literaria 2017",R.drawable.evento1);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getContext());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                        @Override
                        public void onSliderClick(BaseSliderView slider) {

                        }
                    });

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(new ViewPagerEx.SimpleOnPageChangeListener());

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvinicio);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        InicioAdapterRecyclerView frasesAdapterRecyclerView = new InicioAdapterRecyclerView(buidFrases(), R.layout.cardview_inicio, getActivity());
        recyclerView.setAdapter(frasesAdapterRecyclerView);

        return view;
    }

    public void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    public ArrayList<Modelo_Inicio> buidFrases(){
        ArrayList<Modelo_Inicio> persons = new ArrayList<>();
        persons.add(new Modelo_Inicio("Conozca dos libros sobre cuentos de terror fantástico y dramas", R.drawable.noticia1,"Los escritores Roberto Berríos y Maynor Cruz presentarán sus libros de dramas y suspensos en el Centro Cultural Guanuca, en Matagalpa\n"+
                "\n"+ "La piel de la lluvia es un libro de cuentos y poesía del psicólogo  Roberto Berríos que  descubre hechos de la vida real, del amor, del terror fantástico, filosofía y la muerte.\n" +
                "\n"+
                "Parte de sus  relatos tienen enfoques psicológicos, como los titulados Pediofobia, (temor a los muñecos), El entierro de mi padre (duelo), La piel de la lluvia (regreso a la infancia), entre otros, explica el escritor.\n" +
                "\n"+
                "Su ensayo La Cegua ganó el IV certamen literario María Teresa Sánchez 2016."));
        persons.add(new Modelo_Inicio("Feria del Libro de Panamá festejará Cien años de soledad", R.drawable.noticia2,"Esta celebración del medio siglo de la novela insignia iniciará el 15 de agosto y serán seis días de numerosas actividades en el Centro de Convenciones Atlapa\n"+
                "\n"+
                "Escritores celebrarán los cincuenta años de la novela Cien años de soledad, de Gabriel García Márquez, editada por primera vez el 30 de mayo de 1967, así lo anunció Orit Btesh, presidenta de la Cámara Panameña del Libro (Capali) y directora de la Feria Internacional de Libro (FIL) de Panamá. Colombia estará como invitada.\n" +
                "\n"+
                "Esta celebración del medio siglo de la novela iniciará el 15 de agosto y serán seis días de numerosas actividades en el Centro de Convenciones Atlapa, en la capital, con el lema Habitar en la Ciudad de los Libros, dijo Btesh.\n" +
                "\n"+
                "La celebración al medio siglo de esta obra será también “un tributo al aporte periodístico y literario del hijo de Aracataca”, pueblo donde nació el Premio Nobel de Literatura 1982."));
        persons.add(new Modelo_Inicio("Jinotepino ganó premio de literatura", R.drawable.noticia3,"El libro del poeta Páez no se ha publicado y ya recibió galardón\n"+
                "\n"+
                "El poeta y escritor jinotepino Vicente Páez Rodríguez ganó el XXI Premio Centroamericano de Literatura Rogelio Sinán, con el poemario Zona Puerca.\n" +
                "\n" +
                "En el concurso, promovido por la Universidad Tecnológica de Panamá (UTP), este año participaron 52 propuestas, entre las que destacó la del jinotepino.\n" +
                "\n" +
                "En ediciones anteriores, el novelista nicaragüense Arquímedes González y el guatemalteco Franz Galich también resultaron ganadores de dicho concurso que nació en 1996 y que es considerado por algunos escritores como el más importante de la región centroamericana.\n" +
                "\n" +
                "Vicente Páez, de 54 años, es uno de los menores de ocho hermanos, incluyendo al ya fallecido y también escritor Gustavo Adolfo Páez.\n" +
                "\n" +
                "“Nosotros comenzamos a ver la literatura como algo propio y algo en que nos podíamos dedicar. Mi hermano publicó dos libros de poesía en el Centro Nicaragüense de Escritores y libro que él leía me lo prestaba”, dijo don Vicente.\n" +
                "\n" +
                "A la edad de 14 años, este señor de cabellera media blanca, contextura delgada y ojos claros, cuenta que se tomó más en serio el hábito de la lectura y que a los 17 ya tenía sus primeros poemas, los que años más tarde fueron publicados en los suplementos Ventana, Nuevo Amanecer Cultural, La Prensa Literaria y otros."));
        persons.add(new Modelo_Inicio("Nicaragua reunirá a 90 narradores de 19 países en Centroamérica Cuenta", R.drawable.noticia4,"Al menos 90 intelectuales de Centroamérica y Europa participarán en el quinto encuentro de narradores centroamericanos, un evento promovido por el escritor nicaragüense Sergio Ramírez.\n" +
                "\n" +
                "El V encuentro de narradores “Centroamérica Cuenta” reunirá en Nicaragua a 90 autores consagrados y emergentes de 19 países de Latinoamérica y Europa, que compartirán reflexiones sobre migración, diáspora y diversidad bajo el lema: “Nosotros los otros”, según su comité organizador.\n" +
                "\n" +
                "El evento, convocado por la revista cultural regional Carátula, tiene como fin crear un espacio de reflexión sobre la identidad y la realidad centroamericana a partir de la literatura."));
        return persons;
    }
}
