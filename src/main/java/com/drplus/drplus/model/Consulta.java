package com.drplus.drplus.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "consulta")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer idusuariopac;
    Integer idusuariodoc;
    String titulo;
    String descripcion;
    String fecha;
    String precio;
    public Integer getId() {
        return id;
    }
    public Integer getIdusuariopac() {
        return idusuariopac;
    }
    public Integer getIdusuariodoc() {
        return idusuariodoc;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getFecha() {
        return fecha;
    }
    public String getPrecio() {
        return precio;
    }

    

}
