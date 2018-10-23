package jacobo.coa.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CirculoResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo_resultado);

        double raio = this.getIntent().getDoubleExtra("raio", -1);
        double areaCirculo = Math.PI * Math.pow(raio,2);

        TextView tvCirculoResultado = findViewById(R.id.tvCirculoResultado);
        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(1);
        tvCirculoResultado.setText("Área: " + nf.format(areaCirculo) + "cm²");
    }

    public void onClickComecarNovamenteCirculo(View v){
        Intent intencaoComecarNovamenteCirculo = new Intent(this.getApplicationContext(), MainActivity.class);
        this.startActivity(intencaoComecarNovamenteCirculo);
    }
}
