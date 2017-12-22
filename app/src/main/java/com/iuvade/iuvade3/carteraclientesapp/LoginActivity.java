package com.iuvade.iuvade3.carteraclientesapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.iuvade.iuvade3.carteraclientesapp.model.UserModel;
import com.iuvade.iuvade3.carteraclientesapp.service.HttpHandler;
import com.iuvade.iuvade3.carteraclientesapp.util.AccessUtil;
import com.iuvade.iuvade3.carteraclientesapp.views.FiltroClienteActivity;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    EditText txtUser;
    EditText txtPassword;

    public static ArrayList lista = new ArrayList();

    //se establece el boton para que pueda hacer la conexion a la clase Maps
    private Button boton;
    private static int REQUEST_CODE_FINE_GPS = 8889;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUser = findViewById(R.id.txtUser);
        txtPassword = findViewById(R.id.txtPassword);

        findViewById(R.id.boton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.boton:
                        try {
                            if (checkPermisos()) {
                                UserModel userModel = new UserModel();
                                userModel.setUser(txtUser.getText().toString());
                                userModel.setPass(txtPassword.getText().toString());
                                if (!userModel.getUser().equals("") && !userModel.getPass().equals("")) {
                                    HttpHandler handler = new HttpHandler();
                                    List list = handler.login(AccessUtil.URL_LOGIN, userModel, LoginActivity.this);
                                    if (list.size() > 0) {
                                        goToFiltros(userModel);
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Usuario o Password incorrectos.", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(getApplicationContext(), "Los campos no pueden estar vacios.", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                perdirPermisos();
                            }
                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                        break;
                }
            }
        });

        if (!checkPermisos()) {
            perdirPermisos();
        }
    }

    private void goToFiltros(UserModel u) {
        Intent inten = new Intent(LoginActivity.this, FiltroClienteActivity.class);
        inten.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(inten);
    }

    private boolean checkPermisos() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED;
    }

    private void perdirPermisos() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                REQUEST_CODE_FINE_GPS);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_FINE_GPS) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getApplicationContext(),
                        "Application will not run without location services!", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
