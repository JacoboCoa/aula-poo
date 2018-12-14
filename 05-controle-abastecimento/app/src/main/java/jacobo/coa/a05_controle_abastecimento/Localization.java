package jacobo.coa.a05_controle_abastecimento;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Localization extends AppCompatActivity {

    private TextView tvLatitude, tvLongitude;
    private LocationManager gerenciadorLocalizacao;
    private LocationListener tratadorDadosGps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localization);

        this.tvLatitude = findViewById(R.id.tvLatitude);
        this.tvLongitude = findViewById(R.id.tvLongitude);

        this.tratadorDadosGps = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Localization.this.tvLatitude.setText(String.valueOf(location.getLatitude()));
                Localization.this.tvLongitude.setText(String.valueOf(location.getLongitude()));
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                Log.d("Log_GPS", "onStatusChanged");
            }

            @Override
            public void onProviderEnabled(String provider) {
                Log.d("Log_GPS","onProviderEnabled");
            }

            @Override
            public void onProviderDisabled(String provider) {
                Log.d("Log_GPS","onProviderDisabled");
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        inicializarGPS();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 99: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    inicializarGPS();
                }else {
                    Log.d("Log_GPS","Permissão Negada");
                }
                return;
            }
        }
    }

    private void inicializarGPS(){
        gerenciadorLocalizacao = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            this.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 99);

            return;
        }
        gerenciadorLocalizacao.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,tratadorDadosGps);
    }

    @Override
    protected void onPause() {
        super.onPause();
        gerenciadorLocalizacao.removeUpdates(this.tratadorDadosGps);
    }
}
