package com.corazonserrano.FinanzasAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "operaciones")
@Data
public class Operaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOperacion;
    private String login;
    private String nombre;
    private Date fechaRegistro;
    private String tipoie;
    private String categoria;
    private Float monto;
    private Date fechaReal;
    private Boolean futuro;

    public Integer getIdOperacion() {
        return idOperacion;
    }
    public Operaciones() {}

    public Operaciones(String login, String nombre, Date fechaRegistro, String tipoie, String categoria, Float monto,
                       Date fechaReal, Boolean futuro) {
        this.login = login;
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
        this.tipoie = tipoie;
        this.categoria = categoria;
        this.monto = monto;
        this.fechaReal = fechaReal;
        this.futuro = futuro;
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

    public String getTipoie() {
        return tipoie;
    }

    public void setTipoie(String tipoie) {
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



}
