package com.example.wilson.eva1_15_2daparte_login;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class Principal extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    EditText edtTxtNombre, edtTxtApellido, edtTxtEdad, edtTxtOrg, edtTxtCorreo;
    RadioGroup rGrpSexo;
    RadioButton rBtnHombre, rBtnMujer;
    Button btnAgregar;

    String sexoGlobal = "Indefindo";
    boolean match = false;
    ArrayList<Datos> listaDatos = new ArrayList<Datos>();

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_principal);
            vincularWidgets();
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_principal_land);
            vincularWidgets();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int display_mode = getResources().getConfiguration().orientation;
        if (display_mode == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_principal);
            vincularWidgets();
        } else {
            setContentView(R.layout.activity_principal_land);
            vincularWidgets();
        }
    }

    public void vincularWidgets() {
        edtTxtNombre = findViewById(R.id.edtTxtNombre);
        edtTxtApellido =  findViewById(R.id.edtTxtApellido);
        edtTxtEdad =  findViewById(R.id.edtTxtEdad);
        edtTxtOrg = findViewById(R.id.edtTxtOrg);
        edtTxtCorreo =  findViewById(R.id.edtTxtCorreo);
        rGrpSexo =  findViewById(R.id.rGrpSexo);
        rBtnHombre =  findViewById(R.id.rBtnHombre);
        rBtnMujer =  findViewById(R.id.rBtnMujer);
        btnAgregar =  findViewById(R.id.btnAgregar);
        rGrpSexo.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int i) {
        if (i == R.id.rBtnHombre) {
            sexoGlobal = "Hombre";
        } else if (i == R.id.rBtnMujer) {
            sexoGlobal = "Mujer";
        } else {
            sexoGlobal = "Indefinido";
        }
    }

    public void guardarDatos(View v) {

        String nombreG = edtTxtNombre.getText().toString(),
                apellidoG = edtTxtApellido.getText().toString(),
                orgG = edtTxtOrg.getText().toString(),
                correoG = edtTxtCorreo.getText().toString(),
                sexoG = sexoGlobal;

        int edadG;
        String editTextEdad = edtTxtEdad.getText().toString();
        if (TextUtils.isEmpty(editTextEdad)) {
            edadG = 0;
        } else {
            edadG = Integer.parseInt(editTextEdad);
        }

        for (Datos datos : listaDatos) {
            String string = datos.toString();

            if (match == false) {
                match = string.contains(correoG);
            } else {
                match = true;
            }

        }

        if (isValidEmail(correoG) == true) {
            if (match == false) {
                listaDatos.add (new Datos(nombreG, apellidoG, orgG, correoG, sexoG, edadG));
                Toast.makeText(this, "Cantidad de registros guardados: " + listaDatos.size(), Toast.LENGTH_SHORT).show();
                reiniciarCaptura();
            } else {
                Toast.makeText(this, "Correo ya registrado, ingresar otro", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Cantidad de registros guardados: " + listaDatos.size(), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Correo no valido, ejemplo correo@servidor.dominio", Toast.LENGTH_SHORT).show();
        }
    }

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    private void reiniciarCaptura() {
        edtTxtNombre.setText("");
        edtTxtApellido.setText("");
        edtTxtOrg.setText("");
        edtTxtCorreo.setText("");
        rGrpSexo.clearCheck();
        edtTxtEdad.setText("");
    }
}

class Datos {
    String nombre, apellido, org, correo, sexo;
    int edad;

    Datos(String nombre, String apellido, String org, String correo, String sexo, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.org = org;
        this.correo = correo;
        this.sexo = sexo;
        this.edad = edad;
    }


}
