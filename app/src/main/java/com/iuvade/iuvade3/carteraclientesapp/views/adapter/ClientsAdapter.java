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
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView view = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data_client, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(dataSet.get(position).getPerCom());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(TextView tv) {
            super(tv);
            textView = tv;
        }
    }
}
