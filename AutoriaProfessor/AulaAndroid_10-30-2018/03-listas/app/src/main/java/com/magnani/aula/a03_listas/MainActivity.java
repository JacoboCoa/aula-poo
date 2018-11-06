package com.magnani.aula.a03_listas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AvaliacaoAdaper adaptador;

    public static final int RC_ADICIONAR_AVALIACAO = 1312;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvListaAvaliacoes = findViewById(R.id.rvListaAvaliacoes);

        this.adaptador = new AvaliacaoAdaper();

        this.adaptador.listaAvaliacoes = AvaliacaoDao.getLista(this.getApplicationContext());

        rvListaAvaliacoes.setAdapter(this.adaptador);

        rvListaAvaliacoes.setLayoutManager( new LinearLayoutManager(this.getApplicationContext()));
    }

    public void onClickFAB(View v){
        Intent intencao = new Intent(this.getApplicationContext(), AdicionarAvaliacaoActivity.class);

        startActivityForResult(intencao, RC_ADICIONAR_AVALIACAO);


//
//        this.adaptador.notifyDataSetChanged();
    }

    public void atualizaDatasetLista(){
        this.adaptador.listaAvaliacoes = AvaliacaoDao.getLista(this.getApplicationContext());
        this.adaptador.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_ADICIONAR_AVALIACAO){
            //estou tratando o fechamento da activity AdicionarAvaliacaoActivity
            if(resultCode == 1){
                Toast.makeText(this.getApplicationContext(), "AÇÃO 1!!!!!", Toast.LENGTH_LONG).show();
                this.adaptador.notifyDataSetChanged();
            }else if (resultCode == 2){
                Toast.makeText(this.getApplicationContext(), "AÇÃO 2 -- -- - - - - - - ", Toast.LENGTH_LONG).show();
                this.adaptador.notifyDataSetChanged();
            }else if (resultCode == 0){
                Toast.makeText(this.getApplicationContext(), "BACK BUTTON (PROVÁVEL)...", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this.getApplicationContext(), "Retorno não tratado...", Toast.LENGTH_LONG).show();
            }
        }else{
            //veio de algum lugar obscuro...

        }

    }
}
