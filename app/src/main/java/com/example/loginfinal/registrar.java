package com.example.loginfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginfinal.Utilidades.Utilidades;

public class registrar extends AppCompatActivity {


    Button btnIniciar, btnRegistro;
    EditText textoUsuario, textoClave, textoCorreo, textoConClave, textoTelefono, textoCedula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        btnRegistro = findViewById(R.id.RegistrarR);
        btnIniciar = findViewById(R.id.volverInicio);


        textoUsuario = findViewById(R.id.UserR);
        textoClave = findViewById(R.id.ContraR);
        textoCorreo = findViewById(R.id.CorreoR);
        textoConClave = findViewById(R.id.ConCOntraR);
        textoTelefono = findViewById(R.id.TelefonoR);

        EventosRegistro();
        irInicio();

        // ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios",null,1);

    }

    public void nuevoUsuario() {
        if (textoCorreo.getText().toString().equals("")) {
            Toast.makeText(this, "Debe escribir un Correo valido", Toast.LENGTH_LONG).show();
        } else if (textoUsuario.getText().toString().equals("")) {
            Toast.makeText(this, "Debe escribir un nombre de usuario", Toast.LENGTH_LONG).show();
        } else if (textoClave.getText().toString().equals("")) {
            Toast.makeText(this, "Debe escribir una Contraseña", Toast.LENGTH_LONG).show();

        } else if (textoConClave.getText().toString().equals("")) {
            Toast.makeText(this, "Debe escribir de nuevo la contraseña para confirmar", Toast.LENGTH_LONG).show();

        } else if (textoTelefono.getText().toString().equals("")) {
            Toast.makeText(this, "Debe escribir un numero de Telefono", Toast.LENGTH_LONG).show();

        } else if (textoClave.getText().toString().equals(textoConClave.getText().toString())) {
            Toast.makeText(this, "Todo Correcto...", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Las contraseñas son diferentes", Toast.LENGTH_LONG).show();
        }
    }

    public void inicioGo(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void irInicio(){
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inicioGo();
            }
        });
    }

    public void EventosRegistro() {
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nuevoUsuario();
                // RegistrarUsuario();
                // RegistrarUsuariosSQL();
            }
        });
    }

    public void RegistrarUsuariosSQL() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this);

        SQLiteDatabase db = conn.getWritableDatabase();
        String insert = "INSERT INTO " + Utilidades.TABLA_USUARIO
                + " ( " + Utilidades.CAMPO_ID + "," + Utilidades.CAMPO_CORREO
                + ", " + Utilidades.TABLA_USUARIO + ", " + Utilidades.CAMPO_TELEFONO
                + ", " + Utilidades.CAMPO_CLAVE + ")" + " VALUES ( " + textoCedula.getText().toString() + ", "
                + textoCorreo.getText().toString() + ", " + textoUsuario.getText().toString()
                + ", " + textoTelefono.getText().toString() + ", " + textoClave.getText().toString() + " )";
        db.close();
    }

    public void RegistrarUsuario() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this);

        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID, textoCedula.getText().toString());
        values.put(Utilidades.CAMPO_CORREO, textoCorreo.getText().toString());
        values.put(Utilidades.CAMPO_USUARIO, textoUsuario.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO, textoTelefono.getText().toString());
        values.put(Utilidades.CAMPO_CLAVE, textoClave.getText().toString());

        Long idResultado = db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID, values);

        Toast.makeText(this, "ID Registro: " + idResultado, Toast.LENGTH_LONG).show();
        db.close();
    }

}