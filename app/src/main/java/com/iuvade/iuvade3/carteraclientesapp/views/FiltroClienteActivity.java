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
                //getDataClient();
                Intent intentMaps = new Intent(FiltroClienteActivity.this, ListadoClientesActivity.class);
                startActivity(intentMaps);
            }
        });
    }
}
