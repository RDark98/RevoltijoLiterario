package com.example.anonymousinc.revoltijoliterario.Login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.example.anonymousinc.revoltijoliterario.MainActivity;
import com.example.anonymousinc.revoltijoliterario.R;

import static android.Manifest.permission.READ_CONTACTS;
import static com.example.anonymousinc.revoltijoliterario.Login.InicioLogin.acceso;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout mUser;
    private TextInputLayout mPass;
    private DatabaseHelper databaseHelper;
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        window = getWindow();
        window.setStatusBarColor(Color.rgb(69,90,100));

        mUser = (TextInputLayout) findViewById(R.id.til_user);
        mPass = (TextInputLayout) findViewById(R.id.til_telefono);

        databaseHelper = new DatabaseHelper(this);

        Button button = (Button) findViewById(R.id.boton_aceptar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mUser.getEditText().getText().toString();
                String pass = mPass.getEditText().getText().toString();

                if(TextUtils.isEmpty(user)){
                    mUser.setError("Este campo es requerido");
                }
                if(TextUtils.isEmpty(pass)){
                    mPass.setError("Este campo es requerido");
                }
                if(databaseHelper.checkUser(user, pass)){
                    acceso = 1;
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    if(!TextUtils.isEmpty(user)){
                        mUser.setError("Usuario incorrecto");
                    }
                    if(!TextUtils.isEmpty(pass)){
                        mPass.setError("Contraseña incorrecta");
                    }
                }

            }
        });
    }

    public void goCrearCuenta(View view){
        Intent intent = new Intent(this, CrearCuentaActivity.class);
        startActivity(intent);
    }
}

