package com.corazonserrano.FinanzasAPI.repository;

import com.corazonserrano.FinanzasAPI.model.Operaciones;

import java.util.List;

import com.corazonserrano.FinanzasAPI.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OperacionesRepository extends CrudRepository<Operaciones, Integer> {
    //Listar todas las operaciones segun el tipo
    List<Operaciones> findByTipoie(String tipoie);



    @Query("SELECT o FROM Operaciones o WHERE o.usuario.idUsuario = :idUsuario AND o.tipoie = :tipoie")
    List<Operaciones> findByTipoieAndUsuarioId(@Param("idUsuario") Integer idUsuario, @Param("tipoie") String tipoie);

}

