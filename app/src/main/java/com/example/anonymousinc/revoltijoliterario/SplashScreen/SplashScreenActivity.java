package com.example.anonymousinc.revoltijoliterario.SplashScreen;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.example.anonymousinc.revoltijoliterario.Intro.IntoActivity;
import com.example.anonymousinc.revoltijoliterario.Login.InicioLogin;
import com.example.anonymousinc.revoltijoliterario.R;

public class SplashScreenActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        window = getWindow();
        window.setStatusBarColor(Color.rgb(0,121,107));

        //Funcion que ejecuta una actividad en segundo plano
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                //Se inicia la segunda actividad
                Intent i = new Intent(SplashScreenActivity.this, IntoActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
