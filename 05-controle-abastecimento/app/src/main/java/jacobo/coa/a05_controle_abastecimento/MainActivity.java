package jacobo.coa.a05_controle_abastecimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvAutonomia;
    public int contKm;
    public int contLitros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this.tvAutonomia.setText();
    }
    public void onClickFABListaPostos(View v){
        Intent intencaoAbrirListaPostos = new Intent(this.getApplicationContext(),ListaPostosActivity.class);
        startActivity(intencaoAbrirListaPostos);
    }
    public void calculaAutonomia(){
    }
}
