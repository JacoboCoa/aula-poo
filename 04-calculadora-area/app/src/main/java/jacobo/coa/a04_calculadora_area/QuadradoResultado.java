package jacobo.coa.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class QuadradoResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadrado_resultado);

        double base = this.getIntent().getDoubleExtra("base",-1);
        double altura = this.getIntent().getDoubleExtra("altura", -1);
        double areaQuadrado = base * altura;

        TextView tvQuadradoResultado = findViewById(R.id.tvQuadradoResultado);
        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(1);
        tvQuadradoResultado.setText("Área: " + nf.format(areaQuadrado) + "cm²");
    }
    public void onClickComecarNovamenteQuadrado (View v){
        Intent intencaoComecarNovamenteQuadrado = new Intent(this.getApplicationContext(),MainActivity.class);
        this.startActivity(intencaoComecarNovamenteQuadrado);
    }
}
