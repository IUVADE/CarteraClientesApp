package com.iuvade.iuvade3.carteraclientesapp.views.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iuvade.iuvade3.carteraclientesapp.R;
import com.iuvade.iuvade3.carteraclientesapp.model.ClientModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by theo on 15/12/17.
 */

public class ClientsAdapter extends RecyclerView.Adapter<ClientsAdapter.ViewHolder> {

    private ArrayList<ClientModel> dataSet;

    public ClientsAdapter() {
    }

    public void setDataSet(ArrayList<ClientModel> dataSet) {
        this.dataSet = dataSet;

        // Actualiza el RecyclerView del view activity_listado_clientes.xml
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data_client, parent, false);
        return new ViewHolder(view);
    }

    //    Enlaza la data con los componentes visuales
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtNomApe.setText(holder.txtNomApe.getText() + dataSet.get(position).getPerCom());
        holder.txtPerDir.setText(holder.txtPerDir.getText() + dataSet.get(position).getPerDir());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    //    Esta clase se encarga de obtener los componentes del view data_client
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtNomApe;
        public TextView txtPerDir;

        public ViewHolder(View v) {
            super(v);

            txtNomApe = v.findViewById(R.id.txtNomApe);
            txtPerDir = v.findViewById(R.id.txtPerDir);
        }
    }
}
