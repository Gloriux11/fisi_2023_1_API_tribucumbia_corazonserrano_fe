package com.corazonserrano.FinanzasAPI.repository;

import com.corazonserrano.FinanzasAPI.model.Recomendaciones;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RecomendacionesRepository extends CrudRepository<Recomendaciones, Integer> {
    Recomendaciones findFirstByidPresupuestoOrderByNumRecomendacionDesc(Integer idPresupuesto);
}
