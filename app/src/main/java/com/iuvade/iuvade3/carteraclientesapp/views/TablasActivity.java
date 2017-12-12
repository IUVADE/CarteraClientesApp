package com.iuvade.iuvade3.carteraclientesapp.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

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
    }
}
