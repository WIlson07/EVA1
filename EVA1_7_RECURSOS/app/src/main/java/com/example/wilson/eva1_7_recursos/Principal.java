package com.example.wilson.eva1_7_recursos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Principal extends AppCompatActivity {

    ImageView imgVwMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        imgVwMostrar = findViewById(R.id.imgVwMostrar);
        imgVwMostrar.setImageResource(R.drawable.elmo);
    }
}
