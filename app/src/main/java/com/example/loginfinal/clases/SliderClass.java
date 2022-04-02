package com.example.loginfinal.clases;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.loginfinal.R;

public class SliderClass extends Fragment {
    View view;
    ImageView image;
    TextView textView, textConten;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_carrusel, container, false);

        textView = view.findViewById(R.id.textI);
        textConten = view.findViewById(R.id.textC);
        RelativeLayout backgraund = view.findViewById(R.id.backg);
        if(getArguments() != null){
            textView.setText(getArguments().getString("title"));
            textConten.setText(getArguments().getString("contenido"));
            image.setImageResource(getArguments().getInt("imagen"));
        }
        return view;
    }
}
