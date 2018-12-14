package jacobo.coa.a05_controle_abastecimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class ListaPostosActivity extends AppCompatActivity {

    private final int RC_ADICIONAR_ABASTECIMENTO = 2018;
    private AbastecimentoAdapter adaptador;
    double contKm;
    double contLitros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_postos2);

        RecyclerView rvListadeAbastecimentos = findViewById(R.id.rvListaAbastecimentos);

        this.adaptador = new AbastecimentoAdapter();

        this.adaptador.listaAbastecimentos =AbastecimentoDAO.getLista(this.getApplicationContext());

        rvListadeAbastecimentos.setAdapter(this.adaptador);

        rvListadeAbastecimentos.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
    }
    public void onClickFABAdicionar(View v){
        Intent intencaoAdicionarAbastecimento = new Intent(this.getApplicationContext(),AdicionarAbastecimentoActivity.class);
        startActivityForResult(intencaoAdicionarAbastecimento,RC_ADICIONAR_ABASTECIMENTO);
    }

    public double calcAutonomia (){
        double autonomia=0;
        double kmAtual;
        double kmAnt;
        for (int i=0; i< this.adaptador.getItemCount();i++){
            if (i == 0){
                contLitros = Double.parseDouble(this.adaptador.listaAbastecimentos.get(i).getLitrosAbastecidos());
            }else {
                kmAnt = Double.parseDouble(this.adaptador.listaAbastecimentos.get(i - 1).getKmAtual());
                kmAtual = Double.parseDouble(this.adaptador.listaAbastecimentos.get(i).getKmAtual());
                contKm += kmAtual - kmAnt;
                contLitros += Double.parseDouble(this.adaptador.listaAbastecimentos.get(i).getLitrosAbastecidos());
                autonomia = contKm / (contLitros - Double.parseDouble(this.adaptador.listaAbastecimentos.get(i).getLitrosAbastecidos()));
            }
        }
        return autonomia;
    }

    public void onClickFABConsumo (View v){
        Intent i = new Intent();
        i.putExtra("Consumo",Double.toString(calcAutonomia()));
        setResult(RESULT_OK,i);
        finish();
    }

    public void onClickFABLocalization (View v){
        Intent intencaoAbrirLocalization = new Intent(this.getApplicationContext(),Localization.class);
        startActivity(intencaoAbrirLocalization);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == RC_ADICIONAR_ABASTECIMENTO){
            //Tratamento do Fechamento da Activity
            if(resultCode == 1){
                Toast.makeText(this.getApplicationContext(), "AÇÃO 1", Toast.LENGTH_LONG).show();
                this.adaptador.notifyDataSetChanged();
            }else if (resultCode == 2){
                Toast.makeText(this.getApplicationContext(), "AÇÃO 2", Toast.LENGTH_LONG).show();
                this.adaptador.notifyDataSetChanged();
            }else if (resultCode == 0){
                Toast.makeText(this.getApplicationContext(), "BACK BUTTON (PROVÁVEL)...", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this.getApplicationContext(), "Retorno não tratado...", Toast.LENGTH_LONG).show();
            }
        }else{
            //Veio do Além...
        }
    }
}
