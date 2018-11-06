package com.magnani.aula.a03_listas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AvaliacaoAdaper adaptador;

    public static final int RC_ADICIONAR_AVALIACAO = 1312;
    public static final int RC_MUDAR_PREFERENCIAS = 1212;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvListaAvaliacoes = findViewById(R.id.rvListaAvaliacoes);

        this.adaptador = new AvaliacaoAdaper();

        this.adaptador.listaAvaliacoes = AvaliacaoDao.getLista(this.getApplicationContext());

        rvListaAvaliacoes.setAdapter(this.adaptador);

        rvListaAvaliacoes.setLayoutManager( new LinearLayoutManager(this.getApplicationContext()));

        aplicarCorDeFundo();
    }

    public void onClickFAB(View v){
        Intent intencao = new Intent(this.getApplicationContext(), AdicionarAvaliacaoActivity.class);

        startActivityForResult(intencao, RC_ADICIONAR_AVALIACAO);

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
                atualizaDatasetLista();
            }else if (resultCode == 2){
                Toast.makeText(this.getApplicationContext(), "AÇÃO 2 -- -- - - - - - - ", Toast.LENGTH_LONG).show();
                atualizaDatasetLista();
            }else if (resultCode == 0){
                Toast.makeText(this.getApplicationContext(), "BACK BUTTON (PROVÁVEL)...", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this.getApplicationContext(), "Retorno não tratado...", Toast.LENGTH_LONG).show();
            }
        }else if(requestCode == RC_MUDAR_PREFERENCIAS){
            aplicarCorDeFundo();

        }

    }

    private void aplicarCorDeFundo(){
        SharedPreferences preferencias = getSharedPreferences("tela", MODE_PRIVATE);
        int cor = preferencias.getInt("cor", -1);
        if(cor != -1){
            View elementoPrincipal = findViewById(R.id.clPrincipal);
            elementoPrincipal.setBackgroundColor( cor );
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflador = new MenuInflater(this.getApplicationContext());
        inflador.inflate( R.menu.menu_principal, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuPreferencias){
            Intent abrirTelaPreferencias = new Intent(this.getApplicationContext(), PreferenciasActivity.class);
            startActivityForResult(abrirTelaPreferencias, RC_MUDAR_PREFERENCIAS);

        }else if (item.getItemId() == R.id.fecharApp){
            finish();
        }
        return true;
    }
}
