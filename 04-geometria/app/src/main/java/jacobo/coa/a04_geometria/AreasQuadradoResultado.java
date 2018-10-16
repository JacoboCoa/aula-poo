package jacobo.coa.a04_geometria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class AreasQuadradoResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas_quadrado_resultado);

        double lado = this.getIntent().getDoubleExtra("lado", -1);
        double areaQuadrado = Math.pow(lado, 2);

        TextView tvResultadoAreaQuadrado = findViewById(R.id.tvResultadoAreaQuadrado);
        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(1);
        tvResultadoAreaQuadrado.setText(nf.format(areaQuadrado));
    }
}
