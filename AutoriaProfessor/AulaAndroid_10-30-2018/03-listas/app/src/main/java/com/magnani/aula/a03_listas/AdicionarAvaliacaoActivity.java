package com.magnani.aula.a03_listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AdicionarAvaliacaoActivity extends AppCompatActivity {

    private EditText etConteudo;
    private EditText etDisciplina;
    private EditText etData;
    private RadioGroup rgMedia;
    private Avaliacao avaliacaoApresentadaNoFormulario;


    public void onClickAcao1(View v){

        this.avaliacaoApresentadaNoFormulario.setConteudo( this.etConteudo.getText().toString() );
        this.avaliacaoApresentadaNoFormulario.setData(this.etData.getText().toString());
        this.avaliacaoApresentadaNoFormulario.setDisciplina(this.etDisciplina.getText().toString());

        RadioButton rbSelecionado = findViewById( this.rgMedia.getCheckedRadioButtonId() );
        this.avaliacaoApresentadaNoFormulario.setMedia(rbSelecionado.getText().toString());


        //salvando a avaliação através do DAO
        boolean sucessoAoSalvar = AvaliacaoDao.salvar(this.getApplicationContext(), this.avaliacaoApresentadaNoFormulario);

        if(sucessoAoSalvar){
            setResult(1);
            finish();
        }else{
            Toast.makeText(this.getApplicationContext(), "Erro ao salvar", Toast.LENGTH_SHORT).show();
        }

    }



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_avaliacao);

        this.etConteudo = findViewById(R.id.etConteudo);
        this.etDisciplina = findViewById(R.id.etDisciplina);
        this.etData = findViewById(R.id.etData);
        this.rgMedia = findViewById(R.id.rgMedia);


        this.avaliacaoApresentadaNoFormulario = (Avaliacao) getIntent().getSerializableExtra("avaliacao");

        if(this.avaliacaoApresentadaNoFormulario != null){
            this.etConteudo.setText(this.avaliacaoApresentadaNoFormulario.getConteudo());
            this.etDisciplina.setText(this.avaliacaoApresentadaNoFormulario.getDisciplina());
            this.etData.setText(this.avaliacaoApresentadaNoFormulario.getData());

            if(this.avaliacaoApresentadaNoFormulario.getMedia().equals("M1")){
                ((RadioButton) findViewById(R.id.rbM1)).setChecked(true);
            }else if(this.avaliacaoApresentadaNoFormulario.getMedia().equals("M2")){
                ((RadioButton) findViewById(R.id.rbM2)).setChecked(true);
            }else if(this.avaliacaoApresentadaNoFormulario.getMedia().equals("M3")){
                ((RadioButton) findViewById(R.id.rbM3)).setChecked(true);
            }
        }else{
            this.avaliacaoApresentadaNoFormulario = new Avaliacao();
        }


    }

}
