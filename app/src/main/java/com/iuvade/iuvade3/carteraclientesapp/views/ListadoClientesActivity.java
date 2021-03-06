package com.iuvade.iuvade3.carteraclientesapp.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.iuvade.iuvade3.carteraclientesapp.R;
import com.iuvade.iuvade3.carteraclientesapp.service.HttpHandler;
import com.iuvade.iuvade3.carteraclientesapp.util.AccessUtil;
import com.iuvade.iuvade3.carteraclientesapp.views.adapter.ClientsAdapter;

import java.util.ResourceBundle;

public class ListadoClientesActivity extends AppCompatActivity {

//    RecyclerView clientsRecycler;
//    ClientsAdapter clientsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_clientes);

//        clientsRecycler = findViewById(R.id.recyclerClientes);
//        clientsRecycler.setHasFixedSize(true);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        clientsRecycler.setLayoutManager(layoutManager);
//
//        clientsAdapter = new ClientsAdapter();
//        clientsRecycler.setAdapter(clientsAdapter);

        getDataClient();
    }

    private void getDataClient() {
        HttpHandler handler = new HttpHandler();
        String url = AccessUtil.URL;
        handler.getDataClient(url, this);
    }
}
