package com.example.usuarios;

import android.app.Activity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class UsuarioView {

    private Activity activity;
    private UsuarioModel usuarioModel;
    private EditText inputUsuario;
    private EditText inputClave;
    private EditText inputRepetirClave;
    private RadioGroup radioTipoUsuario;
    private Button btnGuardar;

    public UsuarioView(Activity activity, UsuarioModel usuarioModel, UsuarioController usuarioController) {
        this.activity = activity;
        this.usuarioModel = usuarioModel;

        this.inputUsuario = this.activity.findViewById(R.id.inputUsuario);
        this.inputClave = this.activity.findViewById(R.id.inputClave);
        this.inputRepetirClave = this.activity.findViewById(R.id.inputRepetirClave);
        this.radioTipoUsuario = this.activity.findViewById(R.id.radioTipoUsuario);
        this.btnGuardar = this.activity.findViewById(R.id.btnGuardar);

        this.btnGuardar.setOnClickListener(usuarioController);

        ActionBar actionBar = ((AppCompatActivity) this.activity).getSupportActionBar();
        actionBar.setTitle(R.string.editar_usuario);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public String getTextRepetirClave() {
        return this.inputRepetirClave.getText().toString();
    }

    public void escribirModeloEnPantalla() {
        this.inputUsuario.setText(usuarioModel.getUsuario());
        this.inputClave.setText(usuarioModel.getClave());
        this.inputRepetirClave.setText(usuarioModel.getClave());

        if ("Administrator".equals(usuarioModel.getTipoUsuario())) {
            this.radioTipoUsuario.check(R.id.radioAdmin);
        }
        else {
            this.radioTipoUsuario.check(R.id.radioUsuario);
        }
    }

    public void guardarDatosPantallaEnModelo() {
        int indexRadioButtonChecked = this.radioTipoUsuario.getCheckedRadioButtonId();
        RadioButton radioButtonChecked = this.activity.findViewById(indexRadioButtonChecked);

        this.usuarioModel.setUsuario(this.inputUsuario.getText().toString());
        this.usuarioModel.setClave(this.inputClave.getText().toString());

        // FIXME Esto está bien acá?
        try {
            this.usuarioModel.setTipoUsuario(radioButtonChecked.getText().toString());
        } catch (Exception e) {
            Log.d("ERROR", e.toString());
        }
    }

    public void mostrarMensaje(String texto) {
        Toast.makeText(this.activity, texto, Toast.LENGTH_LONG).show();
    }
}
