package jacobo.coa.a05_controle_abastecimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvAutonomia;
    public final int RC_LISTA_ABASTECIMENTO = 1111;
    private String consumo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvAutonomia = findViewById(R.id.tvAutonomia);
    }
    public void onClickFABListaPostos(View v){
        Intent intencaoAbrirListaPostos = new Intent(this.getApplicationContext(),ListaPostosActivity.class);
        startActivityForResult(intencaoAbrirListaPostos,RC_LISTA_ABASTECIMENTO);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == RC_LISTA_ABASTECIMENTO){
            //Tratamento do fechamento da Activity
            if (resultCode == RESULT_OK){
                consumo = data.getStringExtra("Consumo");
                tvAutonomia.setText(consumo);
            }
            if (resultCode == 0){
                Toast.makeText(this.getApplicationContext(), "BACK BUTTON", Toast.LENGTH_LONG).show();
            }
        }
    }
}
