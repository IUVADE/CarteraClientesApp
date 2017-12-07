package com.iuvade.iuvade3.carteraclientesapp.views;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.iuvade.iuvade3.carteraclientesapp.service.HttpHandler;
import com.iuvade.iuvade3.carteraclientesapp.views.MapsActivity;
import com.iuvade.iuvade3.carteraclientesapp.R;

public class FiltroClienteActivity extends AppCompatActivity {

    private Button btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro_cliente);

        btnBuscar = findViewById(R.id.btnBuscar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                getDataClient();
                Intent intentMaps = new Intent(FiltroClienteActivity.this, ListadoClientesActivity.class);
                startActivity(intentMaps);
            }
        });
    }

    private void getDataClient() {
        HttpHandler handler = new HttpHandler();
        //String url="http://192.168.1.45/sigem/init.php?tgs=php.facturacion.cliente.cliente.testRestServiceClient";
        String url = "http://192.168.1.45/testRest/test.php";
        String url2 = "http://192.168.1.66:3030/api/patients/";
        String url3 = "http://192.168.1.35/odontosoft-php/api/patient_api.php?opt=all";
        handler.getDataClient(url3, this);
    }
}
