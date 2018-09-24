package com.example.wilson.eva1_14_cafe;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    RadioGroup rdGrpCafe;
    RadioButton rdBtnAm;
    RadioButton rdBtnCa;
    RadioButton rdBtnEx;
    EditText edtTxtCantidad;
    CheckBox chkBxAzucar;
    CheckBox chkBxCrema;
    TextView txtVwDetalles;
    Button btnTotal;
    int total, extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        rdGrpCafe = findViewById(R.id.rdGrpCafe);
        rdBtnAm = findViewById(R.id.rdBtnAm);
        rdBtnCa = findViewById(R.id.rdBtnCa);
        rdBtnEx = findViewById(R.id.rdBtnEx);
        edtTxtCantidad = findViewById(R.id.edtTxtCantidad);
        chkBxAzucar = findViewById(R.id.chkBxAzucar);
        chkBxCrema = findViewById(R.id.chkBxCrema);
        txtVwDetalles = findViewById(R.id.txtVwDetalles);
        btnTotal = findViewById(R.id.btnTotal);


        rdGrpCafe.setOnCheckedChangeListener(this);
        btnTotal.setOnClickListener(this);
    }




    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int i) {
        if (i == R.id.rdBtnAm){
            this.total = 20;
        } else if (i == R.id.rdBtnCa){
            total = 48;
        } else if (i == R.id.rdBtnEx){
            total = 30;
        }


    }

    @Override
    public void onClick(View v) {
        int cantidad = Integer.parseInt(edtTxtCantidad.getText().toString());
        total *= cantidad;

        if (chkBxAzucar.isChecked()){
            extras += 1;
        }

        if (chkBxCrema.isChecked()){
            extras += 1;
        }

        extras *= cantidad;
        total += extras;

        Toast.makeText(this,"$" + total, Toast.LENGTH_SHORT).show();

        rdGrpCafe.clearCheck();
        total = 0;
        extras = 0;
    }
}
