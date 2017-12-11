package com.iuvade.iuvade3.carteraclientesapp.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.iuvade.iuvade3.carteraclientesapp.R;
import com.iuvade.iuvade3.carteraclientesapp.service.HttpHandler;

public class ListadoClientesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_clientes);

        getDataClient();
    }

    private void getDataClient() {
        HttpHandler handler = new HttpHandler();
        String url="http://192.168.1.45/sigem/init.php?tgs=php.facturacion.cliente.cliente.testRestServiceClient";
        //String url = "http://192.168.1.45/testRest/test.php";
        String url2 = "http://192.168.1.66:3030/api/patients/";
        String url3 = "http://192.168.1.33/odontosoft-php/api/patient_api.php?opt=all";
        handler.getDataClient(url, this);
    }
}
