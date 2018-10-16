package jacobo.coa.a04_geometria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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

    public void onClickAreas(View v){
        Intent intencaoAbrirTelaAreas = new Intent(this.getApplicationContext(),AreasPasso1.class);
        this.startActivity(intencaoAbrirTelaAreas);
    }

}
