package jacobo.coa.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TrianguloPasso1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo_passo1);
    }

    public void onClickAvancar(View v){
        EditText etBaseTriangulo = findViewById(R.id.etBaseTriangulo);
        EditText etAlturaTriangulo = findViewById(R.id.etAlturaTriangulo);

        double base = Double.parseDouble(etBaseTriangulo.getText().toString());
        double altura = Double.parseDouble(etAlturaTriangulo.getText().toString());

        Intent intencaoAbrirTrianguloResultado = new Intent(this.getApplicationContext(), TrianguloResultado.class);

        intencaoAbrirTrianguloResultado.putExtra("base", base);
        intencaoAbrirTrianguloResultado.putExtra("altura", altura);

        this.startActivity(intencaoAbrirTrianguloResultado);
    }
}
