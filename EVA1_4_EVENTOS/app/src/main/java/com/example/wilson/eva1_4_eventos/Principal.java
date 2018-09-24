package com.example.wilson.eva1_4_eventos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class   Principal extends AppCompatActivity /*Cremos un listener (objeto que busca un evento*/ implements View.OnClickListener{

    TextView txtVwMensa; // Este Objeto se vincula al widget
    Button btnInterfaz;
    Button btnClaseAnonima;
    Button btnPorClase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Buscamos el widget en el indice R y vinculamos
        txtVwMensa = findViewById(R.id.txtVwMensa);
        btnInterfaz = findViewById(R.id.btnInterfaz);
        btnPorClase = findViewById((R.id.btnPorClase));
        btnClaseAnonima = findViewById(R.id.btnClaseAnonima);


        btnInterfaz.setOnClickListener(this); //asignamos
        txtVwMensa.setText("Hola mundo cruel!!!");


        final Context cntApp = getApplicationContext();
        btnClaseAnonima.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(cntApp, "Evento por clase anonima", Toast.LENGTH_LONG).show();
            }
        });

        ClickListener miClickLis = new ClickListener();
        btnPorClase.setOnClickListener(miClickLis);
    }

    public void MiClick(View v){
        Toast.makeText(this,"Hola mundo cruel!!!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Quibo", Toast.LENGTH_SHORT).show();
    }

    
}
