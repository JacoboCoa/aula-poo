package jacobo.coa.a04_geometria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AreasPasso1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas_passo1);
    }

    public void onClickQuadrado(View v){
        Intent intencaoClicarQuadrado = new Intent(this.getApplicationContext(),AreasQuadradoPasso2.class);
        this.startActivity(intencaoClicarQuadrado);
    }
}
