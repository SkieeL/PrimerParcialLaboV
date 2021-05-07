package com.example.usuarios;

import java.io.Serializable;
import java.util.Objects;

public class UsuarioModel implements Serializable {
    private String usuario;
    private String clave;
    private String tipoUsuario;

    public UsuarioModel() { }

    public UsuarioModel(String usuario, String clave, String tipoUsuario) {
        this.usuario = usuario;
        this.clave = clave;
        this.tipoUsuario = tipoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        else if (o.getClass().equals(this.getClass())) {
            UsuarioModel u = (UsuarioModel) o;

            if (this.usuario.equals(u.usuario) && this.clave.equals(u.clave) && this.tipoUsuario.equals(u.tipoUsuario)) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        final int primo = 23;
        int retorno = 0;

        retorno = primo * this.usuario.hashCode();
        retorno += this.clave.hashCode();
        retorno += this.tipoUsuario.hashCode();

        return retorno;
    }

    @Override
    public String toString() {
        return this.usuario.concat(" - ").concat(this.clave).concat(" - ").concat(this.tipoUsuario);
    }
}
