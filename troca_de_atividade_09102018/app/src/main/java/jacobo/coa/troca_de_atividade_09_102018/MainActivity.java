package jacobo.coa.troca_de_atividade_09_102018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause(){   //Sobreescrever o onPause da classe Pai
        super.onPause();
        Log.d("Callback_LCA", "Método onpause da mainactivity");
    }

    @Override
    protected void onResume(){   //Sobreescrever o onPause da classe Pai
        super.onResume();
        Log.d("Callback_LCA", "Método onresume da mainactivity");
    }

    public void onClickIMC(View v){
        //Toast.makeText(this, "IMC", Toast.LENGTH_SHORT).show();
        Intent intencaoAbrirTelaIMC = new Intent(this.getApplicationContext(), IMCPasso1Activity.class);
        this.startActivity(intencaoAbrirTelaIMC);


    }
    public void onClickGCB(View v){
        Toast.makeText(this, "GCB", Toast.LENGTH_SHORT).show();
        Log.d("ACAO_USUARIO","O usuário clicou no botão GCB");

    }
}
