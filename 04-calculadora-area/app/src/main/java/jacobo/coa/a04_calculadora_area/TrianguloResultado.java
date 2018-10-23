package jacobo.coa.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class TrianguloResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo_resultado);

        double base = this.getIntent().getDoubleExtra("base", -1);
        double altura = this.getIntent().getDoubleExtra("altura", -1);
        double areaTriangulo = (base * altura)/2;

        TextView tvTrianguloResultado = findViewById(R.id.tvTrianguloResultado);
        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(1);
        tvTrianguloResultado.setText("Área: " + nf.format(areaTriangulo) + "cm²");
    }

    public void onClickComecarNovamenteTriangulo(View v){
        Intent intencaoComecarNovamenteTriangulo = new Intent(this.getApplicationContext(), MainActivity.class);
        this.startActivity(intencaoComecarNovamenteTriangulo);
    }
}
