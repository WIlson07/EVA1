package com.example.wilson.eva1_6_listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Principal extends AppCompatActivity implements ListView.OnItemClickListener{

    ListView lstVwDatos;
    TextView txtVwMostrar;
    final String[] sResta = {"Wendy's",
            "McDonald's",
            "BurgerKing",
            "Cabus",
            "Rino's",
            "Smokehouse",
            "Chilli's",
            "Buffalo Wild Wings",
            "Little Caesar's",
            "Domino's",
            "Pizza Hut",
            "Pepperoncinos",
            "IHOP"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtVwMostrar = findViewById(R.id.txtVwMostrar);
        lstVwDatos = findViewById(R.id.lstVwDatos);

        //Necesitamos asignar un adaptador
        //Es un intermediario para el origen de datos

        lstVwDatos.setAdapter(
                new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                sResta)
        );
        lstVwDatos.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        txtVwMostrar.setText(sResta[i]);
    }
}
