package com.corazonserrano.FinanzasAPI.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;
}
