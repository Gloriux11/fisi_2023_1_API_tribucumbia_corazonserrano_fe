package com.corazonserrano.FinanzasAPI.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "presupuesto")
@Data
public class Presupuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)

    private Integer id;

    @Column(name = "login")
    private Integer login;

    @Column(name = "fechaInicio")
    private Date fechaInicio;

    @Column(name = "fechaFin")
    private Date fechaFin;

    @Column(name = "monto")
    private Double monto;

    public Presupuesto() {

    }

    public Presupuesto(Integer id, Integer login, Date fechaInicio, Date fechaFin, Double monto) {
        this.id = id;
        this.login = login;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.monto = monto;
    }

    public Integer getIdPresupuesto() {
        return id;
    }

    public void setIdPresupuesto(Integer id) {
        this.id = id;
    }

    public Integer getLogin() {
        return login;
    }

    public void setLogin(Integer login) {
        this.login = login;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

}
