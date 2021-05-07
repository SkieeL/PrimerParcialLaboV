package com.example.usuarios;

import android.app.Activity;
import android.util.Log;
import android.view.View;

public class UsuarioController implements View.OnClickListener {
    private UsuarioModel usuarioModel;
    private UsuarioView usuarioView;
    private Activity activity;

    public UsuarioController(UsuarioModel usuarioModel, Activity activity) {
        this.usuarioModel = usuarioModel;
        this.activity = activity;
    }

    public void setUsuarioView(UsuarioView usuarioView) {
        this.usuarioView = usuarioView;
        this.usuarioView.escribirModeloEnPantalla();
    }

    private boolean validarCarga() {
        String confirmarClave = this.usuarioView.getTextRepetirClave();

        if (!this.usuarioModel.getUsuario().isEmpty() && !this.usuarioModel.getClave().isEmpty() && this.usuarioModel.getUsuario() != null
                && this.usuarioModel.getClave() != null && this.usuarioModel.getUsuario().length() >= 3 && this.usuarioModel.getClave().equals(confirmarClave)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnGuardar) {
            this.usuarioView.guardarDatosPantallaEnModelo();

            if (this.validarCarga()) {
                this.usuarioView.mostrarMensaje(this.activity.getString(R.string.guardado));
                UsuarioActivity.usuario = this.usuarioModel;
                this.activity.finish();
            }
            else {
                Log.d("ERROR", usuarioModel.toString());
                Log.d("ERROR", this.activity.getString(R.string.datos_incorrectos));
                this.usuarioView.mostrarMensaje(this.activity.getString(R.string.datos_incorrectos));
                UsuarioActivity.usuario = null;
            }
        }
    }
}
