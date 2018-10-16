package jacobo.coa.a04_geometria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AreasQuadradoPasso2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas_quadrado_passo2);
    }

    public void onClickCalcular(View v){
        EditText etLadoQuadrado = findViewById(R.id.etLadoQuadrado);

        double lado = Double.parseDouble(etLadoQuadrado.getText().toString());

        Intent intencaoAbrirAreasQuadradoResultado = new Intent(this.getApplicationContext(), AreasQuadradoResultado.class);

        intencaoAbrirAreasQuadradoResultado.putExtra("lado", lado);

        this.startActivity(intencaoAbrirAreasQuadradoResultado);
    }
}
