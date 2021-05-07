package com.example.usuarios;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class UsuarioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private MyOnItemClick listener;
    private int position;
    TextView tvUsuario;
    TextView tvTipoUsuario;
    ImageButton btnModificar;

    // Al extender de RecyclerView.ViewHolder obligatoriamente, debe sobrescribir el
    // constructor recibiendo un parámetro View, que debe ser pasado a la clase padre
    // El "viewItemLayout" es la representación en memoria RAM del item_persona.xml
    public UsuarioViewHolder(View viewItemLayout, MyOnItemClick listener) {
        super(viewItemLayout);



        // Guarda el listener del evento onClick
        this.listener = listener;

        // Guarda los textViews que se encuentran en item_persona.xml en atributos para
        // no tener que recuperarlos cada vez en el "onBindViewHolder" del Adapter
        this.tvUsuario = viewItemLayout.findViewById(R.id.tvUsuario);
        this.tvTipoUsuario = viewItemLayout.findViewById(R.id.tvTipoUsuario);
        this.btnModificar = viewItemLayout.findViewById(R.id.btnModificar);

        this.btnModificar.setOnClickListener(this);
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public void onClick(View view) {
        listener.onItemClick(position);
    }
}
