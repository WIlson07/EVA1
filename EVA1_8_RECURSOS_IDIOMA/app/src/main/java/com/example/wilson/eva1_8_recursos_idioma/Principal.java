package com.example.wilson.eva1_8_recursos_idioma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Principal extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    RadioGroup rdGrpIdiomas;
    RadioButton rdBtnEs, rdBtnEn;
    TextView txtVwNombre;
    EditText edtTxtNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        rdGrpIdiomas = findViewById(R.id.rdGrpIdioma);
        rdBtnEs = findViewById(R.id.rdBtnEs);
        rdBtnEn = findViewById(R.id.rdBtnEn);
        txtVwNombre = findViewById(R.id.txtVwNombre);
        edtTxtNombre = findViewById(R.id.edtTxtNombre);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int i) {
        if (i == R.id.rdBtnEs){
            rdBtnEs.setText(R.string.rd_espa_es);
            rdBtnEn.setText(R.string.rd_ingles_es);
            txtVwNombre.setText(R.string.tv_nombre_es);
            edtTxtNombre.setHint(R.string.et_nombre_es);
        } else {
            rdBtnEs.setText(R.string.rd_espa_en);
            rdBtnEn.setText(R.string.rd_ingles_en);
            txtVwNombre.setText(R.string.tv_nombre_en);
            edtTxtNombre.setHint(R.string.et_nombre_en);
        }
    }
}
