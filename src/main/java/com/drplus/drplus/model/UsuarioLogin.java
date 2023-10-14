package com.drplus.drplus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="login")
public class UsuarioLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer idtipousuario;
    String usuario;
    String contrasenia;
    String nombre;
    String apellido;
    String direccion;
    String telefono;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getIdTipoUsuario() {
        return idtipousuario;
    }
    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idtipousuario = idTipoUsuario;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "UsuarioLogin [id=" + id + ", idTipoUsuario=" + idtipousuario + ", usuario=" + usuario + ", contrasenia="
                + contrasenia + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
                + ", telefono=" + telefono + "]";
    }

    

}
