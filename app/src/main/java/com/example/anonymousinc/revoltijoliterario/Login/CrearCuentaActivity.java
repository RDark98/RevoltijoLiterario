package com.example.anonymousinc.revoltijoliterario.Login;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.example.anonymousinc.revoltijoliterario.R;

public class CrearCuentaActivity extends AppCompatActivity {
    private TextInputLayout tilNombre;
    private TextInputLayout tilUser;
    private TextInputLayout tilPass;
    private TextInputLayout tilPassConfir;
    private TextInputLayout tilCorreo;
    private DatabaseHelper databaseHelper;
    private Usuario usere;
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);
        getSupportActionBar().setTitle("Crear Cuenta");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#009688")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        window = getWindow();
        window.setStatusBarColor(Color.rgb(0,121,107));

        databaseHelper = new DatabaseHelper(this);
        usere = new Usuario();

        // Referencias TILs
        tilNombre = (TextInputLayout) findViewById(R.id.til_nombre);
        tilUser = (TextInputLayout) findViewById(R.id.til_telefono);
        tilPass = (TextInputLayout) findViewById(R.id.til_pass);
        tilPassConfir = (TextInputLayout) findViewById(R.id.til_passconfir);
        tilCorreo = (TextInputLayout) findViewById(R.id.til_correo);

        Button botonAceptar = (Button)findViewById(R.id.boton_confirmar);
        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean field = false;
                String nombre = tilNombre.getEditText().getText().toString();
                String user = tilUser.getEditText().getText().toString();
                String pass = tilPass.getEditText().getText().toString();
                String passconfir = tilPassConfir.getEditText().getText().toString();
                String correo = tilCorreo.getEditText().getText().toString();

                if (TextUtils.isEmpty(nombre)) {
                    tilNombre.setError("Este campo es requerido");
                    field = true;
                }

                if (TextUtils.isEmpty(user)) {
                    tilUser.setError("Este campo es requerido");
                    field = true;
                }

                if (TextUtils.isEmpty(pass)) {
                    tilPass.setError("Este campor es requerido");
                    field = true;
                }

                if (TextUtils.isEmpty(passconfir)) {
                    tilPassConfir.setError("Este campo es requerido");
                    field = true;
                }

                if(TextUtils.isEmpty(correo)){
                    tilCorreo.setError("Este campo es requerido");
                    field = true;
                }

                // check if both password matches
                if(!pass.equals(passconfir))
                {
                    Toast.makeText(getApplicationContext(), "La contraseña no coincide", Toast.LENGTH_SHORT).show();
                    return;
                }
                if((!databaseHelper.checkUser(user))==true && field==false) {

                    // Save the Data in Database
                    usere.setName(nombre);
                    usere.setUser(user);
                    usere.setPassword(pass);
                    usere.setEmail(correo);

                    databaseHelper.addUser(usere);

                    Intent intent = new Intent(CrearCuentaActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    if((!databaseHelper.checkUser(user))==false && field==false){
                        // Snack Bar to show error message that record already exists
                        Snackbar.make(v, "Usuario existente", Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
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
