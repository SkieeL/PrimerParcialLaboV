package com.example.usuarios;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

public class UsuarioActivity extends AppCompatActivity {
    public static UsuarioModel usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        Bundle extras = super.getIntent().getExtras();
        UsuarioModel usuarioModel = (UsuarioModel) extras.getSerializable("usuario");
        UsuarioController usuarioController = new UsuarioController(usuarioModel, this);
        UsuarioView usuarioView = new UsuarioView(this, usuarioModel, usuarioController);
        usuarioController.setUsuarioView(usuarioView);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            UsuarioActivity.usuario = null;
            super.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}