package com.corazonserrano.FinanzasAPI.repository;

import com.corazonserrano.FinanzasAPI.model.Operaciones;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OperacionesRepository extends CrudRepository<Operaciones, Integer> {

    List<Operaciones> findByTipoie(String tipoie);

}
