package com.corazonserrano.FinanzasAPI.repository;

import com.corazonserrano.FinanzasAPI.model.Presupuesto;

import com.corazonserrano.FinanzasAPI.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface PresupuestoRepository extends CrudRepository<Presupuesto, Integer> {
/*
FERNANDO
    @Query("SELECT o FROM Presupuesto o WHERE o.idPresupuesto =(select max(idPresupuesto) FROM Presupuesto) AND o.idUsuario.idUsuario = :idUsuario")
    Presupuesto findByIdPresupuestoAndIdUsuario(@Param("idUsuario") Integer idUsuario);
*/
    @Query("SELECT o FROM Presupuesto o WHERE o.fechaInicio =(select max(fechaInicio) FROM Presupuesto WHERE idUsuario=o.idUsuario) AND o.idUsuario.idUsuario = :idUsuario")
    Presupuesto findByIdPresupuestoAndIdUsuario(@Param("idUsuario") Integer idUsuario);

}