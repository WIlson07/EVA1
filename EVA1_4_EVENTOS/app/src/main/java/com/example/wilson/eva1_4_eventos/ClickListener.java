package com.example.wilson.eva1_4_eventos;

import android.util.Log;
import android.view.View;

public class ClickListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        Log.wtf("Desde clase", "Evento click");
    }
}
