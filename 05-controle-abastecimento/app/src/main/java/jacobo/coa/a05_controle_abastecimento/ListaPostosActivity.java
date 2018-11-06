package jacobo.coa.a05_controle_abastecimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ListaPostosActivity extends AppCompatActivity {
    private final int RC_ADICIONAR_ABASTECIMENTO = 2018;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_postos2);
    }
    public void onClickFABAdicionar(View v){
        Intent intencaoAdicionarAbastecimento = new Intent(this.getApplicationContext(),AdicionarAbastecimentoActivity.class);
        startActivityForResult(intencaoAdicionarAbastecimento,RC_ADICIONAR_ABASTECIMENTO);
    }
}
