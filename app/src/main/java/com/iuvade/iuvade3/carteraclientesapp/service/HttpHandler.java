package com.iuvade.iuvade3.carteraclientesapp.service;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.iuvade.iuvade3.carteraclientesapp.model.ClientModel;
import com.iuvade.iuvade3.carteraclientesapp.views.adapter.ClientsAdapter;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.iuvade.iuvade3.carteraclientesapp.R;

import java.util.ArrayList;

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

    public void login(String url, Activity activity) {
        this.activity = activity;

        try {
            AsyncHttpClient client = new AsyncHttpClient();
            RequestParams params = new RequestParams();
//            params.put("username", user[0]);
//            params.put("password", user[1]);

            client.post(url, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//                    try {
//                        msg = getDataJson(new String(responseBody));
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    showMessage("FAILURE", error.getMessage());
                }
            });
        } catch (Exception e) {
            showMessage("ERROR JSON", e.getMessage());
        }
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
//                        msg = getDataJson(new String(responseBody));

//                        clients=responseBody;

                        clientsRecycler = HttpHandler.this.activity.findViewById(R.id.recyclerClientes);
                        clientsRecycler.setHasFixedSize(true);

                        LinearLayoutManager layoutManager = new LinearLayoutManager(HttpHandler.this.activity);
                        clientsRecycler.setLayoutManager(layoutManager);

                        clientsAdapter = new ClientsAdapter();
                        clientsRecycler.setAdapter(clientsAdapter);

//                        clientsAdapter.setDataSet();

                        showMessage("RESULT", msg);
                    } catch (Exception e) {
                        showMessage("ERROR", e.getMessage());
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    showMessage("FAILURE", error.getMessage());
                }

                @Override
                public void onRetry(int retryNo) {
                    showMessage("RETRY", Integer.toString(retryNo));
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

    public void showMessage(String titulo, String mensaje) {
        AlertDialog.Builder builder = new AlertDialog.Builder(HttpHandler.this.activity);
        builder.setTitle(titulo);
        builder.setMessage(mensaje);
        builder.create().show();
    }

//    public ArrayList<ClientModel> getDataJson(String response) throws JSONException {
//        JSONArray jsonArray = new JSONArray(response);
//        String texto = "Not found";
//        texto = jsonArray.getJSONObject(1).getString("per_com");
//        ArrayList<ClientModel> clients=response.b;
//
//        return texto;
//    }

}
