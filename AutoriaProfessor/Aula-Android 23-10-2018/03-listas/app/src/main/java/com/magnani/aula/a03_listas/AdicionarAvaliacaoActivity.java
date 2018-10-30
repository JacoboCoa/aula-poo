package com.magnani.aula.a03_listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AdicionarAvaliacaoActivity extends AppCompatActivity {

    public void onClickAcao1(View v){
        EditText etConteudo = findViewById(R.id.etConteudo);
        EditText etDisciplina = findViewById(R.id.etDisciplina);
        EditText etData = findViewById(R.id.etData);
        RadioGroup rgMedia = findViewById(R.id.rgMedia);

        //criando avaliação com dados aleatórios
        Avaliacao av = new Avaliacao();

        av.setConteudo( etConteudo.getText().toString() );
        av.setData(etData.getText().toString());
        av.setDisciplina(etDisciplina.getText().toString());

        RadioButton rbSelecionado = findViewById( rgMedia.getCheckedRadioButtonId() );
        av.setMedia(rbSelecionado.getText().toString());


        //salvando a avaliação através do DAO
        boolean sucessoAoSalvar = AvaliacaoDao.salvar(this.getApplicationContext(), av);

        if(sucessoAoSalvar){
            setResult(1);
            finish();
        }else{
            Toast.makeText(this.getApplicationContext(), "Erro ao salvar", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_avaliacao);
    }

}
