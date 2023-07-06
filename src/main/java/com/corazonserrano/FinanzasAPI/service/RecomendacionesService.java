package com.corazonserrano.FinanzasAPI.service;

import com.corazonserrano.FinanzasAPI.model.Recomendaciones;
import com.corazonserrano.FinanzasAPI.repository.RecomendacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RecomendacionesService {
    private RecomendacionesRepository recomendacionesRepository;
    private static final int MAX_NUM_RECOMENDACIONES = 4;

    @Autowired
    public RecomendacionesService(RecomendacionesRepository recomendacionesRepository) {
        this.recomendacionesRepository = recomendacionesRepository;
    }

    public ArrayList<Recomendaciones> obtenerTodasLasRecomendaciones() {
        return (ArrayList<Recomendaciones>) recomendacionesRepository.findAll();
    }

    public Recomendaciones obtenerUltimaRecomendacionPorPresupuesto(Integer idPresupuesto) {
        Integer maxNumRecomendacion = recomendacionesRepository.findMaxNumRecomendacion(idPresupuesto);
        if (maxNumRecomendacion == null) {
            return null;
        }
        return recomendacionesRepository.findByidPresupuestoAndnumRecomendacion(idPresupuesto, maxNumRecomendacion);
    }

    public int getMaxNumRecomendacion(Integer idPresupuesto) {
        Integer maxNumRecomendacion = recomendacionesRepository.findMaxNumRecomendacion(idPresupuesto);
        if (maxNumRecomendacion == null) {
            return 0;
        } else if (maxNumRecomendacion >= MAX_NUM_RECOMENDACIONES) {
            return MAX_NUM_RECOMENDACIONES;
        } else {
            return maxNumRecomendacion;
        }
    }

   /* public Recomendaciones obtenerRecomendacion(Integer idPresupuesto, Integer numRecomendacion) {
        Recomendaciones recomendacion = (Recomendaciones) recomendacionesRepository.findByidPresupuestoAndnumRecomendacion(idPresupuesto, numRecomendacion);
        return recomendacion;
    }*/
}
