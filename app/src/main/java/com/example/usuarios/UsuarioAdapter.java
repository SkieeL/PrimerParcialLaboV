package com.example.usuarios;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioViewHolder> {
    private List<UsuarioModel> usuarios;
    private MyOnItemClick listener;

    public UsuarioAdapter(List<UsuarioModel> usuarios, MyOnItemClick listener) {
        this.usuarios = usuarios;
        this.listener = listener;
    }

    public List<UsuarioModel> getUsuarios() {
        return this.usuarios;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        UsuarioViewHolder personaViewHolder = new UsuarioViewHolder(viewItemLayout, this.listener);

        return personaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        UsuarioModel persona = this.usuarios.get(position);

        holder.tvUsuario.setText(persona.getUsuario());
        holder.tvTipoUsuario.setText(persona.getTipoUsuario());
        holder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return this.usuarios.size();
    }
}
