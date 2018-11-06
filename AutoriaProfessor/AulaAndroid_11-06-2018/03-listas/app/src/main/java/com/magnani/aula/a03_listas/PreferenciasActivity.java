package com.magnani.aula.a03_listas;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class PreferenciasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);
    }

    public void trocaCorPreferida(View v){
        RadioGroup rbCorPreferida = findViewById(R.id.rbCorPreferida);

        String corRGB = "#BABACA";

        if(rbCorPreferida.getCheckedRadioButtonId() == R.id.rbTelaCinza){
            corRGB = "#BABACA";
        }else if(rbCorPreferida.getCheckedRadioButtonId() == R.id.rbTelaAzul){
            corRGB = "#0000FF";
        }else if(rbCorPreferida.getCheckedRadioButtonId() == R.id.rbTelaVerde){
            corRGB = "#00FF00";
        }else if(rbCorPreferida.getCheckedRadioButtonId() == R.id.rbTelaVermelha){
            corRGB = "#FF0000";
        }

        int cor = Color.parseColor(corRGB);

        SharedPreferences preferencias = getSharedPreferences("tela", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putInt("cor", cor);
        editor.apply();

        //guardar isso
        setResult(1);
        finish();
    }
}
