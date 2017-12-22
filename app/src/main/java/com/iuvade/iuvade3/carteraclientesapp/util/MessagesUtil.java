package com.iuvade.iuvade3.carteraclientesapp.util;

import android.app.Activity;
import android.support.v7.app.AlertDialog;

import com.iuvade.iuvade3.carteraclientesapp.service.HttpHandler;

/**
 * Created by Iuvade on 22/12/2017.
 */

public class MessagesUtil {

    public static void showMessage(String titulo, String mensaje, Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(titulo);
        builder.setMessage(mensaje);
        builder.create().show();
    }
}
