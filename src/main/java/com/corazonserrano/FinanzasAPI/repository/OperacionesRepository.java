package com.corazonserrano.FinanzasAPI.repository;

import com.corazonserrano.FinanzasAPI.model.Operaciones;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OperacionesRepository extends CrudRepository<Operaciones, Integer> {
    @Query("SELECT u FROM Operaciones u WHERE u.login = :login AND u.tipoie = :tipoie")
    Operaciones findByLoginAndTipoie(String login, String tipoie);



    //@Query("SELECT o FROM Operaciones o WHERE o.idOperacion =:idOperacion")
    //Operaciones findByOperacionId(Integer idOperacion);



}
