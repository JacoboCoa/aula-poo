package jacobo.coa.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class QuadradoPasso1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadrado_passo1);
    }

    public void onClickAvancar(View v){
        EditText etBaseQuadrado = findViewById(R.id.etBaseQuadrado);
        EditText etAlturaQuadrado = findViewById(R.id.etAlturaQuadrado);

        double base = Double.parseDouble(etBaseQuadrado.getText().toString());
        double altura = Double.parseDouble(etAlturaQuadrado.getText().toString());

        Intent intencaoAbrirQuadradoResultado = new Intent(this.getApplicationContext(), QuadradoResultado.class);

        intencaoAbrirQuadradoResultado.putExtra("base", base);
        intencaoAbrirQuadradoResultado.putExtra("altura", altura);

        this.startActivity(intencaoAbrirQuadradoResultado);
    }
}
