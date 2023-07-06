package com.corazonserrano.FinanzasAPI.repository;

import com.corazonserrano.FinanzasAPI.model.Operaciones;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface OperacionesRepository extends CrudRepository<Operaciones, String> {
    public abstract ArrayList<Operaciones> findByIngresos(String tipoie);


    /*@Query("SELECT u FROM operaciones u WHERE u.login = :login AND u.tipoie = :tipoie")
    Operaciones findByLoginAndTipoie(String login, String tipoie);
*/


    //@Query("SELECT o FROM Operaciones o WHERE o.idOperacion =:idOperacion")
    //Operaciones findByOperacionId(Integer idOperacion);



}
