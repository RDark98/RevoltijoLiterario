package com.example.anonymousinc.revoltijoliterario.Login;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.anonymousinc.revoltijoliterario.MainActivity;
import com.example.anonymousinc.revoltijoliterario.R;

import static com.example.anonymousinc.revoltijoliterario.Login.DatabaseHelper.correo;
import static com.example.anonymousinc.revoltijoliterario.Login.DatabaseHelper.name;
import static com.example.anonymousinc.revoltijoliterario.Login.InicioLogin.acceso;

public class PerfilActivity extends AppCompatActivity {
    private TextView mtextView1;
    private TextView mtextView2;
    private ImageView avatarImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        showToolbar("Perfil", true);

        mtextView1 = (TextView) findViewById(R.id.name);
        mtextView2 = (TextView) findViewById(R.id.email);
        avatarImage = (ImageView) findViewById(R.id.imagePerfil);

        mtextView1.setText(name);
        mtextView2.setText(correo);
        avatarImage.setImageResource(R.drawable.perfilaccount);

        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fabsalir);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acceso = 0;
                Intent intent = new Intent(PerfilActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    //Metodo que muestra el toolbar
    public void showToolbar(String titulo, boolean boton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(titulo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(boton);
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
