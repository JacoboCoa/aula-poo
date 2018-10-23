package jacobo.coa.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAvancar(View v){
        RadioGroup rgForma = findViewById(R.id.rgForma);

        if (rgForma.getCheckedRadioButtonId() == R.id.rbQuadrado) {
            Intent intencaoAbrirQuadradoPasso1 = new Intent(this.getApplicationContext(), QuadradoPasso1.class);
            this.startActivity(intencaoAbrirQuadradoPasso1);
        }else{
            if (rgForma.getCheckedRadioButtonId() == R.id.rbTriangulo){
                Intent intencaoAbrirTrianguloPasso1 = new Intent(this.getApplicationContext(), TrianguloPasso1.class);
                this.startActivity(intencaoAbrirTrianguloPasso1);
            }else{
                if (rgForma.getCheckedRadioButtonId() == R.id.rbCirculo){
                    Intent intencaoAbrirCirculoPasso1 = new Intent(this.getApplicationContext(),CirculoPasso1.class);
                    this.startActivity(intencaoAbrirCirculoPasso1);
                }
            }
        }

    }
}
