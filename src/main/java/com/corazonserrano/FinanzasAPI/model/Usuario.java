package com.corazonserrano.FinanzasAPI.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUsuario", updatable = false, nullable = false)
    private Integer idUsuario;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;
/*
    @OneToMany(mappedBy = "usuario")
    private List<Presupuesto> presupuestoList = new ArrayList<>();*/

    public Usuario() {

    }

    public Usuario(Integer idUsuario, String userName, String password) {
        this.idUsuario = idUsuario;
        this.userName = userName;
        this.password = password;
    }


    public Integer getIdUsuario() {
        return idUsuario;
    }


    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


}


