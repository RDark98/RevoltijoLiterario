package com.example.anonymousinc.revoltijoliterario;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.example.anonymousinc.revoltijoliterario.FragmentBiblioteca.BibliotecaFragment;
import com.example.anonymousinc.revoltijoliterario.FragmentGaleria.GaleriaFragment;
import com.example.anonymousinc.revoltijoliterario.FragmentInicio.InicioFragment;
import com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.LeeDescubreFragment;
import com.example.anonymousinc.revoltijoliterario.Login.LoginActivity;
import com.example.anonymousinc.revoltijoliterario.Login.PerfilActivity;
import com.example.anonymousinc.revoltijoliterario.Opciones.AcercaDeActivity;
import com.example.anonymousinc.revoltijoliterario.Opciones.AyudaActivity;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import static com.example.anonymousinc.revoltijoliterario.Login.InicioLogin.acceso;

public class MainActivity extends AppCompatActivity {
    private Window window;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#009688")));

        window = getWindow();
        window.setStatusBarColor(Color.rgb(0,121,107));

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setDefaultTab(R.id.tab_inicio);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_inicio) {
                    InicioFragment inicioFragment = new InicioFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer, inicioFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .addToBackStack(null).commit();
                }else if (tabId == R.id.tab_leedescubre) {
                    LeeDescubreFragment leeDescubreFragment = new LeeDescubreFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer, leeDescubreFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .addToBackStack(null).commit();
                }else if (tabId == R.id.tab_galeria) {
                    GaleriaFragment galeriaFragment = new GaleriaFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer, galeriaFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .addToBackStack(null).commit();
                }else if (tabId == R.id.tab_biblioteca) {
                    BibliotecaFragment bibliotecaFragment = new BibliotecaFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer, bibliotecaFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .addToBackStack(null).commit();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_perfil:
                if(acceso == 0){
                    Intent intent1 = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent1);
                }else if(acceso == 1){
                    Intent intent2 = new Intent(MainActivity.this, PerfilActivity.class);
                    startActivity(intent2);
                }
                return true;
            case R.id.action_ayuda:
                Intent intent3 = new Intent(MainActivity.this, AyudaActivity.class);
                startActivity(intent3);
                return true;
            case R.id.action_acercade:
                Intent intent4 = new Intent(MainActivity.this, AcercaDeActivity.class);
                startActivity(intent4);
                return true;
            case R.id.action_salir:
                finishAffinity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
