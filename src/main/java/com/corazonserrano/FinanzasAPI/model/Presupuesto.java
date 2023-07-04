package com.corazonserrano.FinanzasAPI.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "presupuesto")
@Data
public class Presupuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPresupuesto", updatable = false, nullable = false)
    private Integer idPresupuesto;

    @Column(name = "login")
    private Integer login;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "monto")
    private Double monto;
}
