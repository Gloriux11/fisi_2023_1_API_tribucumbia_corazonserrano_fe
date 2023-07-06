package com.corazonserrano.FinanzasAPI.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "recomendaciones")
public class Recomendaciones {

    @Id
    @Column(name = "id_presupuesto")
    private Integer idPresupuesto;

    @Id
    @Column(name = "num_recomendacion")
    private Integer numRecomendacion;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "recomendacion_descripcion")
    private String recomendacionDescripcion;

    // Constructor, getters y setters

    public Recomendaciones() {
    }

    public Recomendaciones(Integer idPresupuesto, Integer numRecomendacion, Date fecha, String recomendacionDescripcion) {
        this.idPresupuesto = idPresupuesto;
        this.numRecomendacion = numRecomendacion;
        this.fecha = fecha;
        this.recomendacionDescripcion = recomendacionDescripcion;
    }

    public Integer getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(Integer idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public Integer getNumRecomendacion() {
        return numRecomendacion;
    }

    public void setNumRecomendacion(Integer numRecomendacion) {
        this.numRecomendacion = numRecomendacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRecomendacionDescripcion() {
        return recomendacionDescripcion;
    }

    public void setRecomendacionDescripcion(String recomendacionDescripcion) {
        this.recomendacionDescripcion = recomendacionDescripcion;
    }
}
