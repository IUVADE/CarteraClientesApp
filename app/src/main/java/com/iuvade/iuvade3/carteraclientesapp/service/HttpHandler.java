package com.iuvade.iuvade3.carteraclientesapp.service;

import android.app.Activity;
import android.support.v7.app.AlertDialog;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by theo on 04/12/17.
 */

public class HttpHandler {

    private String msg = "";
    private Activity activity;

    public void post(String url, Activity activity, String[] user) {
        this.activity = activity;

        try {
            AsyncHttpClient client = new AsyncHttpClient();
            RequestParams params = new RequestParams();
            params.put("username", user[0]);
            params.put("password", user[1]);

            client.post(url, params, new AsyncHttpResponseHandler() {
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

    public String getDataJson(String response) throws JSONException {
        JSONObject jsonObject = new JSONObject(response);
        String texto = "";
        texto = jsonObject.getString("nom_ape");

        return texto;
    }
}
