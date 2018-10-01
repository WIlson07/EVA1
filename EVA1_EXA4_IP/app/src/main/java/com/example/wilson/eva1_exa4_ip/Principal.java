package com.example.wilson.eva1_exa4_ip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

public class Principal extends AppCompatActivity{



    String currentIP, currentMask;

    EditText edtTxtIP,
    edtTxtMask;

    TextView txtVwIP2, txtVwMask2, txtVwPrefix, txtVwNet;

    RadioGroup rdGrpIP;
    RadioButton rdBtnDec, rdBtnBin;

    Button btnBin, btnBorrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        edtTxtIP = findViewById(R.id.edtTxtIP);
        edtTxtMask = findViewById(R.id.edtTxtMask);

        txtVwIP2 = findViewById(R.id.txtVwIP2);
        txtVwMask2 = findViewById(R.id.txtVwMask2);
        txtVwPrefix = findViewById(R.id.txtVwPrefix);
        txtVwNet = findViewById(R.id.txtVwNet);

        rdGrpIP = findViewById(R.id.rdGrpIP);
        rdBtnDec = findViewById(R.id.rdBtnDec);
        rdBtnBin = findViewById(R.id.rdBtnBin);

        btnBin = findViewById(R.id.btnBin);
        btnBin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //netAddress();
                if (rdBtnDec.isChecked()) {
                    prefixDec();
                } else if (rdBtnBin.isChecked()){
                    prefixBin();
                }
            }
        });

        btnBorrar = findViewById(R.id.btnBorrar);
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearResults();
            }
        });

    }

    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case  R.id.rdBtnDec:
                if (checked)
                    convertDecimal();
                break;

            case R.id.rdBtnBin:
                if (checked)
                    convertBinary();
                break;
        }
    }

    public static int stringIPtoInt(String ip) throws Exception{
        String[] quad = ip.split("\\.", 4);
        if (quad.length != 4){
            throw new Exception();
        }

        int ip32bit =0;

        for(String value : quad){
            if (value.length() < 1){
                throw new Exception();
            }

            int octet;

            try{
                octet = Integer.parseInt(value);
            } catch (NumberFormatException e){
                throw new Exception();
            }

            if (octet > 255){
                throw new Exception();
            }

            ip32bit = ip32bit << 8;
            ip32bit = ip32bit | octet;
        }

        return ip32bit;
    }

    private void convertDecimal(){
        String decimalIP = edtTxtIP.getText().toString().trim();
        String decimalMask = edtTxtMask.getText().toString().trim();

        int ip32bit, mask32bit;

        try {
            ip32bit = stringIPtoInt(decimalIP);
            mask32bit = stringIPtoInt(decimalMask);
        } catch (Exception e) {
            Toast.makeText(this, R.string.err_bad_ip, Toast.LENGTH_SHORT).show();

            return;
        }

        currentIP = decimalIP;
        currentMask = decimalMask;
        String ip = convertIPIntDec2StringBinary(ip32bit);
        String mask = convertIPIntDec2StringBinary(mask32bit);

        txtVwIP2.setText(ip);
        txtVwMask2.setText(mask);
    }

    public static String convertIPIntDec2StringBinary(int intIP){
        String stringIP;
        stringIP = Integer.toBinaryString(intIP);
        int length = stringIP.length();
        if (length < 32){
            int prependZeros = 32 - length;
            for (int i=0; i<prependZeros; i++){
                stringIP = "0"+stringIP;
            }
        }

        String octet1 = stringIP.substring(0,8);
        String octet2 = stringIP.substring(8,16);
        String octet3 = stringIP.substring(16,24);
        String octet4 = stringIP.substring(24,32);


        stringIP = octet1 + "." + octet2 + "." + octet3 + "." + octet4;
        return stringIP;
    }



    private void convertBinary(){
        String currentBinary = edtTxtIP.getText().toString().trim();
        String currentBiMask = edtTxtMask.getText().toString().trim();

        if (currentBinary.length() < 32 || currentBiMask.length() < 32){
            Toast.makeText(this, R.string.err_bad_ip, Toast.LENGTH_SHORT).show();
        }

        try {
            String octet1b = currentBinary.substring(0,8);
            String octet2b = currentBinary.substring(9,17);
            String octet3b = currentBinary.substring(18,26);
            String octet4b = currentBinary.substring(27,35);

            String octet1c = currentBiMask.substring(0,8);
            String octet2c = currentBiMask.substring(9,17);
            String octet3c = currentBiMask.substring(18,26);
            String octet4c = currentBiMask.substring(27,35);

            long octet1i = Integer.parseInt(octet1b,2);
            long octet2i = Integer.parseInt(octet2b,2);
            long octet3i = Integer.parseInt(octet3b,2);
            long octet4i = Integer.parseInt(octet4b,2);

            long octet1j = Integer.parseInt(octet1c,2);
            long octet2j = Integer.parseInt(octet2c,2);
            long octet3j = Integer.parseInt(octet3c,2);
            long octet4j = Integer.parseInt(octet4c,2);
            currentIP = octet1i +"."+
                    octet2i +"."+
                    octet3i +"."+
                    octet4i;

            currentMask = octet1j +"."+
                    octet2j +"."+
                    octet3j +"."+
                    octet4j;
            txtVwIP2.setText(currentIP);
            txtVwMask2.setText(currentMask);
        } catch (NumberFormatException e){
            Toast.makeText(this, R.string.err_bad_ip, Toast.LENGTH_SHORT).show();
        } catch (StringIndexOutOfBoundsException e){
            Toast.makeText(this, R.string.err_bad_ip, Toast.LENGTH_SHORT).show();
        } catch (Exception e){
            Toast.makeText(this, R.string.err_bad_ip, Toast.LENGTH_SHORT).show();
        }
    }

    private void prefixDec () {
        String decimalMask = edtTxtMask.getText().toString().trim();

        int mask32bit;

       try{
           mask32bit = stringIPtoInt(decimalMask);
       }  catch (Exception e) {
           Toast.makeText(this, R.string.err_bad_ip, Toast.LENGTH_SHORT).show();

           return;
       }

        int prefix = Integer.bitCount(mask32bit);
       txtVwPrefix.setText("/"+prefix);
    }

    private void prefixBin(){
        String currentBiMask = edtTxtMask.getText().toString().trim();

        String octet1c = currentBiMask.substring(0,8);
        String octet2c = currentBiMask.substring(9,17);
        String octet3c = currentBiMask.substring(18,26);
        String octet4c = currentBiMask.substring(27,35);

        int octet1j = Integer.parseInt(octet1c,2);
        int octet2j = Integer.parseInt(octet2c,2);
        int octet3j = Integer.parseInt(octet3c,2);
        int octet4j = Integer.parseInt(octet4c,2);

        int oct1 = Integer.bitCount(octet1j);
        int oct2 = Integer.bitCount(octet2j);
        int oct3 = Integer.bitCount(octet3j);
        int oct4 = Integer.bitCount(octet4j);

        int prefix = oct1+oct2+oct3+oct4;

        txtVwPrefix.setText("/"+prefix);
    }

   /* private void netAddress(){

        String decimalIP = edtTxtIP.getText().toString().trim();
        String decimalMask = edtTxtMask.getText().toString().trim();

        int ip32bit, mask32bit;

        try {
            ip32bit = stringIPtoInt(decimalIP);
            mask32bit = stringIPtoInt(decimalMask);
        } catch (Exception e) {
            Toast.makeText(this, R.string.err_bad_ip, Toast.LENGTH_SHORT).show();

            return;
        }

        currentIP = decimalIP;
        currentMask = decimalMask;
        String ip = convertIPIntDec2StringBinary(ip32bit);
        String mask = convertIPIntDec2StringBinary(mask32bit);

        for (int i=0; i<ip.length(); i++){

        }

        txtVwNet.setText(netAdd);
    }*/

    private void clearResults(){
        edtTxtIP.setText("");
        edtTxtMask.setText("");
        txtVwIP2.setText("");
        txtVwMask2.setText("");
    }
}
