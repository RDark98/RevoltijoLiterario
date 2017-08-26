package com.example.anonymousinc.revoltijoliterario.Login;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.example.anonymousinc.revoltijoliterario.MainActivity;
import com.example.anonymousinc.revoltijoliterario.R;

public class InicioLogin extends AppCompatActivity {
    public static int acceso = 0;
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_login);

        window = getWindow();
        window.setStatusBarColor(Color.rgb(33,33,33));

        Button buttonLogin = (Button) findViewById(R.id.button_login);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acceso = 1;
                Intent intent = new Intent(InicioLogin.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button buttonApp = (Button) findViewById(R.id.button_app);
        buttonApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acceso = 0;
                Intent intent = new Intent(InicioLogin.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
