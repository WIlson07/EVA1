package com.example.wilson.eva1_5_otros_event;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Principal extends AppCompatActivity
    implements RadioGroup.OnCheckedChangeListener {



    RadioGroup rdGrpOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        rdGrpOpciones = findViewById(R.id.rdGrpOpciones);
        rdGrpOpciones.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int i) {
        String sMensa;

        switch(i){
            case R.id.btnTortas:
                sMensa = "Tortas";
                break;
            case R.id.btnChiles:
                sMensa = "Chiles Rellenos";
                break;
            case R.id.btnMontados:
                sMensa = "montados";
                break;
            case R.id.btnTortas:
                sMensa = "Tortas";
                break;
            default:
                sMensa = "Otra opcion";
        }

        Toast.makeText(this, sMensa, Toast.LENGTH_SHORT).show();

    }
}
