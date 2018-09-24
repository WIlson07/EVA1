package com.example.wilson.eva1_14_expectativa_de_vida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    EditText edtTxtYear;
    RadioGroup rdGrpRegion, rdGrpGenero;
    RadioButton rdBtnReg, rdBtnAm, rdBtnAs, rdBtnAf,
    rdBtnHo, rdBtnMu;
    TextView txtVwExp, txtVwDec;

    int[] arrayDifGen = {10, 9, 8, 7, 6, 4};

    int[][] arreglo = new int [][]{
            {75, 60, 45, 35}, //50s
            {75, 65, 50, 45}, //60's
            {80, 70, 65, 55}, //70s
            {80, 75, 65, 60}, //80s
            {85, 75, 60, 55}, //90s
            {90, 70, 65, 60} //00s
    };

    int ultRegion = 0, ultGenero = 0, globalYears, globalNac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        edtTxtYear = findViewById(R.id.edtTxtYear);

        rdGrpRegion = findViewById(R.id.rdGrpRegion);
        rdBtnReg = findViewById(R.id.rdBtnReg);
        rdBtnAm = findViewById(R.id.rdBtnAm);
        rdBtnAs = findViewById(R.id.rdBtnAs);
        rdBtnAf = findViewById(R.id.rdBtnAf);

        rdGrpGenero = findViewById(R.id.rdGrpGenero);
        rdBtnHo = findViewById(R.id.rdBtnHo);
        rdBtnMu = findViewById(R.id.rdBtnMu);

        txtVwExp = (TextView) findViewById(R.id.txtVwExp);
        txtVwDec = (TextView) findViewById(R.id.txtVwDec);

        edtTxtYear.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
                    calcularFecha(ultGenero, globalYears, ultRegion);
                    return true;
                }

                return false;
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int years = 0, region = ultRegion, genero = ultGenero;

        //Sacar la region
        if (checkedId == R.id.rdBtnReg){
            region = 0;
        } else if (checkedId == R.id.rdBtnAm) {
            region = 1;
        } else if (checkedId == R.id.rdBtnAs) {
            region = 2;
        } else if (checkedId == R.id.rdBtnAf) {
            region = 3;
        }

        //ara resolver cambios de region
        ultRegion = region;

        switch (checkedId){
            case R.id.rdBtnHo:
                genero = 0;
                break;
            case R.id.rdBtnMu:
                genero = 1;
                break;
        }

        //Para resolver cambios de region y valores globales
        ultGenero = genero;
        globalYears = years;

        calcularFecha(genero, years, region);
    }

    public void calcularFecha(int genero, int years, int region){
        int nac = Integer.parseInt(edtTxtYear.getText().toString());

        //Sacar la decada
        if ((1950 <= nac) && (nac <= 1959)) {
            years = 0;
        } else if ((1960 <= nac) && (nac <= 1969)) {
            years = 1;
        } else if ((1970 <= nac) && (nac <= 1979)) {
            years = 2;
        } else if ((1980 <= nac) && (nac <= 1989)) {
            years = 3;
        } else if ((1990 <= nac) && (nac <= 1999)) {
            years = 4;
        } else if ((2000 <= nac) && (nac <= 2010)) {
            years = 5;
        } else {
            Toast.makeText(this, "Asi no", Toast.LENGTH_SHORT).show();
        }

        globalNac = nac;

        //Funcion para sacar la expectativa de vida
        int expVida = genero == 0 ? arreglo[years][region] - arrayDifGen[years] : arreglo[years][region]
                + arrayDifGen[years];

        //Para fecha de deceso -5
        int fecDec = nac + (expVida -5);

        //Establecer textViews
        txtVwExp.setText("" + expVida);
        txtVwDec.setText("" + fecDec);
    }
}
