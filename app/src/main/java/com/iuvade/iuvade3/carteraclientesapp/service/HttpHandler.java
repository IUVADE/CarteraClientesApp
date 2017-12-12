package com.iuvade.iuvade3.carteraclientesapp.service;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by theo on 04/12/17.
 */

public class HttpHandler {

    private String msg = "";
    private Activity activity;

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
                    try {
                        msg = getDataJson(new String(responseBody));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
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

    public void getDataClient(String url, Activity activity) {
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
                        msg = getDataJson(new String(responseBody));
                        showMessage("RESULT", msg);
                    } catch (JSONException e) {
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

    public String getDataJson(String response) throws JSONException {
        JSONArray jsonArray = new JSONArray(response);
        String texto = "Not found";
        texto = jsonArray.getJSONObject(1).getString("per_com");

        return texto;


    }

}
