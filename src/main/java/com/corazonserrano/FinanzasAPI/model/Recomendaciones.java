package com.corazonserrano.FinanzasAPI.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "recomendaciones")
@Data
public class Recomendaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numRecomendacion", updatable = false, nullable = false)

    private Integer numRecomendacion;

    @Column(name = "idPresupuesto")
    private String idPresupuesto;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "recomendacionDescripcion")
    private String recomendacionDescripcion;

    public Recomendaciones(){

    }

    public Recomendaciones(String idPresupuesto, Date fecha, String recomendacionDescripcion){
        this.idPresupuesto = idPresupuesto;
        this.fecha = fecha;
        this.recomendacionDescripcion = recomendacionDescripcion;
    }

    public Integer getNumRecomendacion() {
        return numRecomendacion;
    }

    public void setNumRecomendacion(Integer numRecomendacion) {
        this.numRecomendacion = numRecomendacion;
    }

    public String getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(String idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
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
