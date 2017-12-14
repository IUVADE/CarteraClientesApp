package com.iuvade.iuvade3.carteraclientesapp.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.iuvade.iuvade3.carteraclientesapp.R;

import java.util.ArrayList;

public class TablasActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<E_Articulos>arrayArticulos;
    AdaptadorTabla adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablas);

        listView = (ListView) findViewById(R.id.list);
        arrayArticulos = new ArrayList<E_Articulos>();

        arrayArticulos = new ArrayList<E_Articulos>();
        E_Articulos articulos=new E_Articulos(1,"silla",2740.77,"Silla Ejecutiva",300.22);
        arrayArticulos.add(articulos);
        articulos=new E_Articulos(1,"silla",2740.77,"Silla Ejecutiva",300.22);
        arrayArticulos.add(articulos);
        articulos=new E_Articulos(2,"regulador",22740.77,"Regulador Voltage",600.22);
        arrayArticulos.add(articulos);
        articulos=new E_Articulos(3,"celular",740.77,"Celular Alcatel",5400.22);
        arrayArticulos.add(articulos);
        articulos=new E_Articulos(4,"cargador",40.77,"Cargador Alcatel",300.42);
        arrayArticulos.add(articulos);
        articulos=new E_Articulos(5,"tv",20.77,"tv 22",33400.22);
        arrayArticulos.add(articulos);
        articulos=new E_Articulos(6,"ipad",240.77,"IPAD 2",33300.22);
        arrayArticulos.add(articulos);

        adapter = new AdaptadorTabla(getApplicationContext(),arrayArticulos);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View item, int position, long id) {
                Toast.makeText(getApplicationContext(), arrayArticulos.get(position).getDescripcion(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
