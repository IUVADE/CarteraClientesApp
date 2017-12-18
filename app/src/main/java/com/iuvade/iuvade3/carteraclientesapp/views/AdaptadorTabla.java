package com.iuvade.iuvade3.carteraclientesapp.views;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import com.iuvade.iuvade3.carteraclientesapp.R;

class AdaptadorTabla extends BaseAdapter {
    ArrayList<E_Articulos> itemList=new ArrayList<E_Articulos>();
    Context context;

    public AdaptadorTabla(Context c,ArrayList<E_Articulos>arrayArticulos){
        context =c;
        itemList = arrayArticulos;
    }

    @Override
    public int getCount() { return itemList.size(); }
    @Override
    public Object getItem(int position) { return itemList.get(position); }
    @Override
    public long getItemId(int position) { return position; }
    @Override
    public View getView(int position, View argl, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.activity_tablas, parent, false);
        TextView lblID = (TextView)itemView.findViewById(R.id.lblID);
        TextView lblConcepto = (TextView)itemView.findViewById(R.id.lblConcepto);
        TextView lblSubtotal = (TextView)itemView.findViewById(R.id.lblSubtotal);
        TextView lblTotal = (TextView)itemView.findViewById(R.id.lblTotal);
        lblID.setText(""+itemList.get(position).getId());
        lblConcepto.setText(itemList.get(position).getConcepto());
        lblSubtotal.setText(""+itemList.get(position).getSubtotal());
        lblTotal.setText(""+itemList.get(position).getTotal());
        if(position ==0)
        {
            itemView.setBackgroundColor(Color.argb(255,248,248,248));
        }
        else{
            itemView.setBackgroundColor(Color.argb(255, 255, 255, 255));
        }
        return itemView;
    }
}
