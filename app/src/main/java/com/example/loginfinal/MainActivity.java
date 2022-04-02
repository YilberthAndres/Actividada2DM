package com.example.loginfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginfinal.clases.Registro;

public class MainActivity extends AppCompatActivity {
    Button btnIniciar, btnRegistro;
    EditText textoUsuario, textoClave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciar = findViewById(R.id.Iniciar);
        btnRegistro = findViewById(R.id.Registro);
        textoUsuario = findViewById(R.id.CorreoR);
        textoClave = findViewById(R.id.Contra);

        EventosIniciar();
        irRegistro();

    }


    public void siguiente(){
        if(textoUsuario.getText().toString().equals("")){
            Toast.makeText(this, "Debe escribir un nombre de usuario", Toast.LENGTH_LONG).show();
        }else if(textoClave.getText().toString().equals("")){
            Toast.makeText(this, "Debe escribir una Contraseña", Toast.LENGTH_LONG).show();

        }else if((textoUsuario.getText().toString().equals("admin")) && (textoClave.getText().toString().equals("admin"))){
                Intent intent = new Intent(this, home.class);
                startActivity(intent);
                finish();
            }else {
            Toast.makeText(this, "Usuario no valido", Toast.LENGTH_LONG).show();
        }
    }

    public void registroGo(){
        Intent intent = new Intent(this, registrar.class);
        startActivity(intent);
        finish();
    }
    public void irRegistro(){
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registroGo();
            }
        });
    }
   public void conexion(){
       ConexionSQLiteHelper conn = new ConexionSQLiteHelper(MainActivity.this);
       SQLiteDatabase db = conn.getWritableDatabase();


       if(db != null){
           //Toast.makeText(MainActivity.this, "Conexion correcta", Toast.LENGTH_LONG).show();
       }else{
           Toast.makeText(this, "Eror conexion", Toast.LENGTH_LONG).show();
       }
   }

    public void EventosIniciar(){
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siguiente();
                conexion();
            }


        });
    }
}