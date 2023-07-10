package com.corazonserrano.FinanzasAPI.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "Operaciones")
@Data
public class Operaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idOperacion")
    private Integer idOperacion;
    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", foreignKey = @ForeignKey(name = "fk_usuario_id"))
    private Usuario usuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fechaRegistro")
    private Date fechaRegistro;
    @Column(name = "tipoie")
    private String tipoie;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "monto")
    private Float monto;
    @Column(name = "fechaReal")
    private Date fechaReal;
    @Column(name = "futuro")
    private Boolean futuro;


    public Operaciones() {}

    public Operaciones(Usuario usuario, String nombre, Date fechaRegistro, String tipoie, String categoria, Float monto,
                       Date fechaReal, Boolean futuro) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
        this.tipoie = tipoie;
        this.categoria = categoria;
        this.monto = monto;
        this.fechaReal = fechaReal;
        this.futuro = futuro;
    }

    public Integer getIdOperacion() {
        return idOperacion;
    }
    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
