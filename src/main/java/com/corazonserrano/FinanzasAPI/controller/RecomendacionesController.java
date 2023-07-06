package com.corazonserrano.FinanzasAPI.controller;


import com.corazonserrano.FinanzasAPI.model.Recomendaciones;
import com.corazonserrano.FinanzasAPI.service.RecomendacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/recomendaciones")
public class RecomendacionesController {
    @Autowired
    RecomendacionesService recomendacionesService;
    Integer idPresupuesto;
    Integer numRecomendacion;

    @GetMapping()
    public Recomendaciones obtenerRecomendaciones(){
        return recomendacionesService.obtenerRecomendacion(idPresupuesto, numRecomendacion);
    }

}
