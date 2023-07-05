package com.corazonserrano.FinanzasAPI.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "operaciones")
public class Operaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOperacion;
    private String login;
    private String nombre;
    
    public Integer getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public char getTipoie() {
        return tipoie;
    }

    public void setTipoie(char tipoie) {
        this.tipoie = tipoie;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Date getFechaReal() {
        return fechaReal;
    }

    public void setFechaReal(Date fechaReal) {
        this.fechaReal = fechaReal;
    }

    public Boolean getFuturo() {
        return futuro;
    }

    public void setFuturo(Boolean futuro) {
        this.futuro = futuro;
    }

    private Date fechaRegistro;
    private char tipoie;
    private String categoria;
    private Float monto;
    private Date fechaReal;
    private Boolean futuro;

}
