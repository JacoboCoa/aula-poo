package jacobo.coa.a03_calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fazCalculo(View clicado){
        EditText letraA = findViewById(R.id.etA);
        EditText letraB = findViewById(R.id.etB);
        EditText letraC = findViewById(R.id.etC);
        TextView x1 = findViewById(R.id.tvResultado1);
        TextView x2 = findViewById(R.id.tvResultado2);

        String leitura_A = letraA.getText().toString();
        String leitura_B = letraB.getText().toString();
        String leitura_C = letraC.getText().toString();

        if (leitura_A.equals("") || leitura_B.equals("") || leitura_C.equals("")){
            letraA.setError("Informe o valor de A");
            letraB.setError("Informe o valor de B");
            letraC.setError("Informe o valor de C");
            return;
        }

        try{
            double letraA_Double = Double.parseDouble(leitura_A);
            double letraB_Double = Double.parseDouble(leitura_B);
            double letraC_Double = Double.parseDouble(leitura_C);

            double resultado_x1 = ((letraB_Double * (-1)) + Math.sqrt(Math.pow(letraB_Double, 2) -
                    (4 * letraA_Double * letraC_Double)))/(2*letraA_Double);
            double resultado_x2 = ((letraB_Double * (-1)) - Math.sqrt(Math.pow(letraB_Double, 2) -
                    (4 * letraA_Double * letraC_Double)))/(2*letraA_Double);

            x1.setText("X': " + resultado_x1);
            x2.setText("X'': " + resultado_x2);
        }catch (Exception e){
            Toast mensagemErro = Toast.makeText(this, "Não Funcionou", Toast.LENGTH_LONG);
            mensagemErro.show();
        }
    }
}
