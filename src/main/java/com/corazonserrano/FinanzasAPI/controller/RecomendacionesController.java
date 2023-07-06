package com.corazonserrano.FinanzasAPI.controller;

import com.corazonserrano.FinanzasAPI.service.RecomendacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class RecomendacionesController {
    private RecomendacionesService recomendacionesService;

    @Autowired
    public RecomendacionesController(RecomendacionesService recomendacionesService) {
        this.recomendacionesService = recomendacionesService;
    }

    @GetMapping("/obtener-recomendacion")
    public String obtenerRecomendacion(@RequestParam("idPresupuesto") Integer idPresupuesto) {
        return recomendacionesService.obtenerRecomendacionDescripcion(idPresupuesto);
    }

}
