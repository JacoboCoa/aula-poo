package jacobo.coa.a05_controle_abastecimento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AdicionarAbastecimentoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public void onClickSalvar(View v){
        EditText etKmAtual = findViewById(R.id.etKmAtual);
        EditText etLitrosAbastecidos = findViewById(R.id.etLitrosAbastecidos);
        EditText etDataAbastecimento = findViewById(R.id.etDataAbastecimento);
        Spinner spinnerPosto = (Spinner) findViewById(R.id.spinnerPosto);

//        TextView textView = (TextView) spinnerPosto.getSelectedView();
//        String resultSpinner = textView.getText().toString();

        Abastecimento abastecimento = new Abastecimento();

        abastecimento.setKmAtual(etKmAtual.getText().toString());
        abastecimento.setLitrosAbastecidos(etLitrosAbastecidos.getText().toString());
        abastecimento.setDataAbastecimento(etDataAbastecimento.getText().toString());
        abastecimento.setPosto(spinnerPosto.getSelectedItem().toString());            //is it work?

        //Salvar através do DAO...
        boolean sucessoAoSalvar = AbastecimentoDAO.salvar(this.getApplicationContext(),abastecimento);

        if(sucessoAoSalvar){
            setResult(1);
            finish();
        }else{
            Toast.makeText(this.getApplicationContext(), "Erro ao salvar", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_abastecimento);

        Spinner spinner = findViewById(R.id.spinnerPosto);
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this.getApplicationContext(), R.array.GasStation, android.R.layout.simple_spinner_item);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptador);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String texto = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), texto, Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
