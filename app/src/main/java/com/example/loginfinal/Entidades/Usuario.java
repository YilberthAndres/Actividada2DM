package com.example.loginfinal.Entidades;

public class Usuario {
    private Integer id;
    private String correo;
    private String usuario;
    private String telefono;
    private String clave;

    public Usuario(Integer id, String correo, String usuario, String telefono, String clave) {
        this.id = id;
        this.correo = correo;
        this.usuario = usuario;
        this.telefono = telefono;
        this.clave = clave;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
