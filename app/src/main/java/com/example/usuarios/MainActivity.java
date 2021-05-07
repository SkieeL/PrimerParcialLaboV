package com.example.usuarios;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyOnItemClick {

    private List<UsuarioModel> usuarios;
    private UsuarioAdapter usuarioAdapter;
    private int itemSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.usuarios = new ArrayList<>();

        this.usuarios.add(new UsuarioModel("Usuario 1", "Clave 1", "Administrator"));
        this.usuarios.add(new UsuarioModel("Usuario 2", "Clave 2", "User"));
        this.usuarios.add(new UsuarioModel("Usuario 3", "Clave 3", "User"));
        this.usuarios.add(new UsuarioModel("Usuario 4", "Clave 4", "User"));
        this.usuarios.add(new UsuarioModel("Usuario 5", "Clave 5", "User"));
        this.usuarios.add(new UsuarioModel("Usuario 6", "Clave 6", "User"));
        this.usuarios.add(new UsuarioModel("Usuario 7", "Clave 7", "User"));
        this.usuarios.add(new UsuarioModel("Usuario 8", "Clave 8", "User"));
        this.usuarios.add(new UsuarioModel("Usuario 9", "Clave 9", "User"));
        this.usuarios.add(new UsuarioModel("Usuario 10", "Clave 10", "User"));

        this.usuarioAdapter = new UsuarioAdapter(usuarios, this);
        RecyclerView recyclerView = super.findViewById(R.id.rvUsuarios);
        recyclerView.setAdapter(usuarioAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onRestart() {
        if (UsuarioActivity.usuario != null) {
            List<UsuarioModel> usuarios = this.usuarioAdapter.getUsuarios();
            this.usuarios.set(this.itemSeleccionado, UsuarioActivity.usuario);
            this.usuarioAdapter.notifyItemChanged(this.itemSeleccionado);
        }

        super.onRestart();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            super.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, UsuarioActivity.class);
        intent.putExtra("usuario", this.usuarios.get(position));
        this.itemSeleccionado = position;

        startActivity(intent);
    }
}