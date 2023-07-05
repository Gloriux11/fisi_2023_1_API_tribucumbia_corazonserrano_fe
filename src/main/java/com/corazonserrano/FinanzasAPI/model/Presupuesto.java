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
    @Column(name = "idPresupuesto", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "login")
    private Integer login;

    @Column(name = "fechaInicio")
    private Date fechaInicio;

    @Column(name = "fechaFin")
    private Date fechaFin;

    @Column(name = "monto")
    private Double monto;
}
