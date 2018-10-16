package jacobo.coa.troca_de_atividade_09_102018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GCBPasso1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcbpasso1);
    }

    public void onClickAvancar(View v){
        EditText etAltura = findViewById(R.id.etAltura);
        EditText etPeso = findViewById(R.id.etPeso);
        EditText etIdade = findViewById(R.id.etIdade);
        RadioGroup rgSexo = findViewById(R.id.rgSexo);
        Intent intencaoAbrirGCBResultado = new Intent(this.getApplicationContext(), GCBResultadoActivity.class);
        try{
            GastoCaloricoBasal objetoGCB = new GastoCaloricoBasal();
            //forma didática
            String alturaDigitada = etAltura.getText().toString();
            double alturaEmDouble = Double.parseDouble( alturaDigitada );
            objetoGCB.setAltura( alturaEmDouble );
            //forma preguiçosa
            objetoGCB.setPeso( Double.parseDouble( etPeso.getText().toString() ) );
            objetoGCB.setIdade( Integer.parseInt( etIdade.getText().toString() ) );
            //forma didática
            RadioButton rbSexoM = findViewById(R.id.rbSexoM);
            RadioButton rbSexoF = findViewById(R.id.rbSexoF);
            if(rbSexoM.isChecked()){
                objetoGCB.setSexo( 'M' );
            }
            if(rbSexoF.isChecked()){
                objetoGCB.setSexo( 'F' );
            }
            //forma preguiçosa
            if(rgSexo.getCheckedRadioButtonId() == R.id.rbSexoM){
                objetoGCB.setSexo( 'M' );
            }else{
                objetoGCB.setSexo( 'F' );
            }
            intencaoAbrirGCBResultado.putExtra("objeto", objetoGCB);
            this.startActivity(intencaoAbrirGCBResultado);
        }catch (Exception e){
            Toast.makeText(this.getApplicationContext(), "Erro", Toast.LENGTH_LONG).show();
        }
    }
}
