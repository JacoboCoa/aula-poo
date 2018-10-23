package jacobo.coa.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CirculoPasso1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo_passo1);
    }

    public void onClickResultado(View v){
        EditText etRaioCirculo = findViewById(R.id.etRaioCirculo);

        double raio = Double.parseDouble(etRaioCirculo.getText().toString());

        Intent intencaoAbrirCirculoResultado = new Intent(this.getApplicationContext(), CirculoResultado.class);

        intencaoAbrirCirculoResultado.putExtra("raio", raio);

        this.startActivity(intencaoAbrirCirculoResultado);
    }
}
