package jacobo.coa.a05_controle_abastecimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickFABListaPostos(View v){
        Intent intencaoAbrirListaPostos = new Intent(this.getApplicationContext(),ListaPostosActivity.class);
        startActivity(intencaoAbrirListaPostos);
    }
}
