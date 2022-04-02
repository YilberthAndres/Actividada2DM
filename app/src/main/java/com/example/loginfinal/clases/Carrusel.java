package com.example.loginfinal.clases;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;


import com.example.loginfinal.Adactador;
import com.example.loginfinal.R;
import com.example.loginfinal.clases.SliderClass;


public class Carrusel extends AppCompatActivity {
    private ViewPager viewpager;
    private Adactador adactador;
    private LinearLayout liner;
    private Button btn, btn2;
    private String contenido[] = {"Hola1","HOLA1","Hola1","HOLA1"};
    private String titulo[] = {"1111","222","333","444"};
    private int imagen[] = {R.drawable.uno,R.drawable.ima,R.drawable.uno,R.drawable.ima};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrusel);

        load();

    }

    private void load(){
        adactador = new Adactador(getSupportFragmentManager());
        for(int i = 0; i < titulo.length; i++){
            adactador.addFragment(newInstance(titulo[i], contenido[i],imagen[i]));
        }
        viewpager.setAdapter(adactador);
    }

    private SliderClass newInstance(String title, String conten, int imag){
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("contenido", conten);
        bundle.putInt("Imagen", imag);

        SliderClass frameSlider = new SliderClass();
        frameSlider.setArguments(bundle);

        return frameSlider;
    }
}