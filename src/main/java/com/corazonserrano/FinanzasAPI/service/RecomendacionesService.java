package com.corazonserrano.FinanzasAPI.service;

import com.corazonserrano.FinanzasAPI.model.Recomendaciones;
import com.corazonserrano.FinanzasAPI.repository.RecomendacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RecomendacionesService {
    private RecomendacionesRepository recomendacionesRepository;

    @Autowired
    public RecomendacionesService(RecomendacionesRepository recomendacionesRepository) {
        this.recomendacionesRepository = recomendacionesRepository;
    }

    public String obtenerRecomendacionDescripcion(Integer idPresupuesto) {
        Recomendaciones recomendacion = recomendacionesRepository.findFirstByidPresupuestoOrderByNumRecomendacionDesc(idPresupuesto);
        if (recomendacion != null) {
            return recomendacion.getRecomendacionDescripcion();
        }
        return null;
    }
}
