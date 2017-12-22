package com.iuvade.iuvade3.carteraclientesapp.service;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.iuvade.iuvade3.carteraclientesapp.model.ClientModel;
import com.iuvade.iuvade3.carteraclientesapp.model.UserModel;
import com.iuvade.iuvade3.carteraclientesapp.util.MessagesUtil;
import com.iuvade.iuvade3.carteraclientesapp.views.adapter.ClientsAdapter;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.iuvade.iuvade3.carteraclientesapp.R;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by theo on 04/12/17.
 */

public class HttpHandler {

    private String msg = "";
    private Activity activity;


    RecyclerView clientsRecycler;
    ClientsAdapter clientsAdapter;

    ArrayList<ClientModel> clients;

    public List login(String url, UserModel u, Activity activity) {
        this.activity = activity;

        try {
            AsyncHttpClient client = new AsyncHttpClient();
            RequestParams params = new RequestParams();
            params.put("user", u.getUser());
            params.put("pass", u.getPass());

            client.post(url, params, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    //HttpHandler.this.activity.lis = validateCredentials(new String(responseBody));
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    MessagesUtil.showMessage("FAILURE", error.getMessage(), HttpHandler.this.activity);
                }
            });
        } catch (Exception e) {
            MessagesUtil.showMessage("ERROR JSON", e.getMessage(), HttpHandler.this.activity);
            return null;
        }

        //return HttpHandler.this.lista;
        return null;
    }

    public void getDataClient(String url, final Activity activity) {
        this.activity = activity;

        try {
            AsyncHttpClient client = new AsyncHttpClient();
            //RequestParams params = new RequestParams();
            // params.put("username", user[0]);
            //params.put("password", user[1]);

            client.get(url, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    try {
                        clientsRecycler = HttpHandler.this.activity.findViewById(R.id.recyclerClientes);
                        clientsRecycler.setHasFixedSize(true);

                        GridLayoutManager layoutManager = new GridLayoutManager(HttpHandler.this.activity, 1);
                        clientsRecycler.setLayoutManager(layoutManager);

                        clientsAdapter = new ClientsAdapter();
                        clientsRecycler.setAdapter(clientsAdapter);

                        clientsAdapter.setDataSet(getDataJson(new String(responseBody)));
                    } catch (Exception e) {
                        MessagesUtil.showMessage("ERROR", e.getMessage(), HttpHandler.this.activity);
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    MessagesUtil.showMessage("FAILURE", error.getMessage(), HttpHandler.this.activity);
                }

                @Override
                public void onRetry(int retryNo) {
                    MessagesUtil.showMessage("RETRY", Integer.toString(retryNo), HttpHandler.this.activity);
                }
            });
        } catch (Exception e) {
            msg = "JSON_ERROR: " + e.getMessage();
            AlertDialog.Builder builder = new AlertDialog.Builder(HttpHandler.this.activity);
            builder.setTitle("Resultado de la peticion HTTP");
            builder.setMessage(msg);
            builder.create().show();
        }
    }

    public ArrayList validateCredentials(String response) {
        ArrayList l = new ArrayList();
        try {
            JSONObject jsonObject = new JSONObject(response);

            l.add(jsonObject.getString("success"));
            l.add(jsonObject.getString("usuario"));
        } catch (JSONException e) {
            MessagesUtil.showMessage("ERROR", e.getMessage(), HttpHandler.this.activity);
        }
        return l;
    }

    public ArrayList<ClientModel> getDataJson(String response) throws JSONException {
        JSONArray jsonArray = new JSONArray(response);
        ArrayList<ClientModel> clients = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            ClientModel clientModel = new ClientModel();
            clientModel.setCliIde(jsonArray.getJSONObject(i).getInt("cli_ide"));
            clientModel.setPerIde(jsonArray.getJSONObject(i).getInt("per_ide"));
            clientModel.setPerCom(jsonArray.getJSONObject(i).getString("per_com"));
            clientModel.setPerDir(jsonArray.getJSONObject(i).getString("per_dir"));
            clients.add(clientModel);
        }

        return clients;
    }

}
